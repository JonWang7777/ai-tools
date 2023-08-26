package com.future.coolcoder.aitools.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.util.*;

/**
 * @author Jon
 * @Description TODO
 * @ClassName GptRequest
 * @data 2023/8/24 14:18
 * @Version 1.0
 */
@Data
@ToString
public class GptRequest {

    private String model;

    @JSONField(defaultValue = "messages")
    private List<GptRequestMessages> messages;

}
