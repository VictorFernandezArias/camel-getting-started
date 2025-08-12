package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {
    @Override
    public void configure() {
        restConfiguration().component("platform-http").bindingMode(RestBindingMode.json);

        rest("/users")
            .post()
                .type(User.class)
                .to("direct:storeUser");

        from("direct:storeUser")
            .marshal().json(JsonLibrary.Jackson)
            .to("file:/tmp/users?fileName=user-${date:now:yyyyMMddHHmmssSSS}.json")
            .setBody(simple("Usuario almacenado"));
    }
}
