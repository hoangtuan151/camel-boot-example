package com.example.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRouteConfig extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:starting.point").to("direct:ending.point");
        from("direct:starting.point2").to("direct:ending.point2");
        from("direct:starting.point3").to("direct:ending.point2").to("direct:ending.point3");
    }

}
