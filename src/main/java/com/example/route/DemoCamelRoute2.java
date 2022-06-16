package com.example.route;

import com.example.api.model.GetMessageReqModel;
import com.example.api.model.GetMessageRespModel;

public interface DemoCamelRoute2 {
    GetMessageRespModel doAction(GetMessageReqModel request);
}
