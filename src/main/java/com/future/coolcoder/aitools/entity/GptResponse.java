package com.future.coolcoder.aitools.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Jon
 * @Description TODO
 * @ClassName GptResponse
 * @data 2023/8/24 14:18
 * @Version 1.0
 */
@Data
@ToString
public class GptResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;

    public static GptResponse fromJson(String json) {
        return JSON.parseObject(json, GptResponse.class);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}

@Data
class Choice {
    private int index;
    private String message;
    private String role;
    private String content;
    private String finishReason;

}

@Data
class Usage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;

}

