package com.future.coolcoder.aitools.controller;

import com.alibaba.fastjson.JSON;
import com.future.coolcoder.aitools.entity.GptResponse;
import com.future.coolcoder.aitools.entity.UserRequest;
import com.future.coolcoder.aitools.service.ChatGptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Jon
 * @Description chatgpt 相关接口 controller
 * @ClassName GptController
 * @data 2023/8/24 13:31
 * @Version 1.0
 */
@Slf4j
@RestController("chatgpt")
public class GptController {

    @Autowired
    private ChatGptService chatGptService;

    @PostMapping(value = "askOnce")
    public GptResponse askOne(@RequestBody UserRequest userRequest) throws IOException {
        log.info("JSON.toJSONString(userRequest) = " + JSON.toJSONString(userRequest));
        return chatGptService.askOnceByPost(userRequest);
    }

    @PostMapping(value = "askOnceByStream")
    public GptResponse askOnceByStream(@RequestBody UserRequest userRequest) throws IOException {
        return chatGptService.askOnceByPost(userRequest);
    }

    @PostMapping(value = "askByStream")
    public GptResponse askByStream(@RequestBody UserRequest userRequest) throws IOException {
        return chatGptService.askOnceByPost(userRequest);
    }

}
