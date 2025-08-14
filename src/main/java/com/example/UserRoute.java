package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
            .component("platform-http")
            .bindingMode(RestBindingMode.json);

        rest("/users")
            .post()
                .consumes("application/json")
                .produces("application/json")
                .type(User.class)      
                .outType(User.class)   
                .to("direct:storeUser");

        from("direct:storeUser")
            .routeId("Camel Route")
            .marshal().json(JsonLibrary.Jackson) 
            .log("${body}")
            .unmarshal().json(JsonLibrary.Jackson, User.class)            
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
    }
}
