package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class MainApp {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new RouteBuilder() {
            @Override
            public void configure() {
                from("timer:pokemon?repeatCount=1")
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to("https://pokeapi.co/api/v2/pokemon/ditto")
                    .to("file:output?fileName=pokemon.json");
            }
        });
        main.run(args);
    }
}
