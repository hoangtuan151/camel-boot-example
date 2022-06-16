package com.example.api;

import com.example.api.model.GetMessageReqModel;
import com.example.api.model.GetMessageRespModel;
import com.example.route.DemoCamelRoute2;
import com.example.route.DemoCamelRoute3;
import com.example.service.DemoService;
import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoApi {

    @Autowired
    private DemoService demoService;

    @GetMapping("/msg1")
    @ResponseStatus(HttpStatus.OK)
    public GetMessageRespModel getMessage(String name, Integer age) {
        // we directly use service layer
        var obj = demoService.doSomething(name, age);
        return obj;
    }

    // # ----------------------------------------------------------------------------

    @Autowired
    private CamelContext camelContext;

    @GetMapping("/msg2")
    @ResponseStatus(HttpStatus.OK)
    public String getMessage2(String name, Integer age) {
        // we use service via Camel
        var req = GetMessageReqModel.builder().name(name).age(age).build();
        var template = camelContext.createProducerTemplate();
        var obj = template.requestBody("direct:starting.point", req, String.class);
        return obj;
    }

    // # ----------------------------------------------------------------------------

    @Produce("direct:starting.point2")
    private DemoCamelRoute2 camelService2;

    @GetMapping("/msg3")
    @ResponseStatus(HttpStatus.OK)
    public GetMessageRespModel getMessage3(String name, Integer age) {
        // we hide ProducerTemplate via @Produce annotation
        var req = GetMessageReqModel.builder().name(name).age(age).build();
        return camelService2.doAction(req);
    }

    // # ----------------------------------------------------------------------------

    @Produce("direct:starting.point3")
    private DemoCamelRoute3 camelService3;

    @GetMapping("/msg4")
    @ResponseStatus(HttpStatus.OK)
    public Integer getMessage4(String name, Integer age) {
        // we use chain of routes
        var req = GetMessageReqModel.builder().name(name).age(age).build();
        return camelService3.doAction(req);
    }
}
