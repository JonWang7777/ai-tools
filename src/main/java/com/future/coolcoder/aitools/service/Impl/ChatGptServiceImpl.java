package com.future.coolcoder.aitools.service.Impl;

import com.alibaba.fastjson.JSON;
import com.future.coolcoder.aitools.config.ChatGptConfig;
import com.future.coolcoder.aitools.entity.GptRequest;
import com.future.coolcoder.aitools.entity.GptRequestMessages;
import com.future.coolcoder.aitools.entity.GptResponse;
import com.future.coolcoder.aitools.entity.UserRequest;
import com.future.coolcoder.aitools.service.ChatGptService;
import com.future.coolcoder.aitools.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jon
 * @Description chatgpt service impl
 * @ClassName ChatGptService
 * @data 2023/8/26 14:57
 * @Version 1.0
 */

@Service
@Slf4j
public class ChatGptServiceImpl implements ChatGptService {

    @Autowired
    private ChatGptConfig chatGptConfig;

    @Override
    public GptResponse askOnceByPost(UserRequest userRequest) throws IOException {
        // 构建请求headers
        String chatGptApiKey = chatGptConfig.getChatGptApiKeyByRandom();
        HashMap<String, String> header = new HashMap<>();
        String BearerParam = "Bearer " + chatGptApiKey;
        header.put("Authorization", BearerParam);

        // 构建request body
        GptRequest gptRequest = new GptRequest();
        gptRequest.setModel("gpt-3.5-turbo");
        GptRequestMessages gptRequestMessages = new GptRequestMessages();
        gptRequestMessages.setContent(userRequest.getContent());
        gptRequestMessages.setRole("user");
        List<GptRequestMessages> messagesList = new ArrayList<>();
        messagesList.add(gptRequestMessages);
        gptRequest.setMessages(messagesList);
        log.info("gptRequest = " + gptRequest);

        // send request
        String askGptResult = HttpUtils.doPost("https://api.openai.com/v1/chat/completions", JSON.toJSONString(gptRequest), "json", header);
        log.info("askGptResult = " + askGptResult);
        GptResponse gptResponse = GptResponse.fromJson(askGptResult);
        return gptResponse;
    }
}
