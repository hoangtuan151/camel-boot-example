package com.example.service;

import com.example.api.model.GetMessageReqModel;
import com.example.api.model.GetMessageRespModel;
import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public GetMessageRespModel doSomething(String name, Integer age) {
        return GetMessageRespModel.builder().name(name).age(age).build();
    }

    @Consume("direct:ending.point")
    public String action(GetMessageReqModel request) {
        return "[" + request.getName() + ", " + request.getAge() + "]";
    }

    @Consume("direct:ending.point2")
    public GetMessageRespModel action2(GetMessageReqModel request) {
        var name = request.getName();
        var age = request.getAge();
        return GetMessageRespModel.builder().name(name).age(age).build();
    }

    @Consume("direct:ending.point3")
    public Integer action3(GetMessageRespModel request) {
        return request.getAge();
    }
}
