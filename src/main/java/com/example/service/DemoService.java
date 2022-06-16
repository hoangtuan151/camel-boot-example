package com.example.service;

import com.example.api.model.GetMessageRespModel;

public interface DemoService {
    GetMessageRespModel doSomething(String name, Integer age);
}
