package com.future.coolcoder.aitools.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Jon
 * @Description chatgpt配置
 * @ClassName ChatGptConfig
 * @data 2023/8/26 10:29
 * @Version 1.0
 */
@Configuration
@Slf4j
public class ChatGptConfig {

    @Value("${chatgpt.api.key}")
    private String chatGptApiKey;

    /**
     * 随机获取一个chatgpt的api key
     * @return
     */
    public String getChatGptApiKeyByRandom(){
        List<String> apiKeys = Arrays.asList(chatGptApiKey.split(","));
        if (apiKeys.isEmpty()){
            log.error("Don't find valid chatgpt api key!");
            return "";
        }
        // 从0到列表长度随机生成一个整数
        Random random = new Random();
        int randomIndex = random.nextInt(apiKeys.size());
        return apiKeys.get(randomIndex);
    }
}
