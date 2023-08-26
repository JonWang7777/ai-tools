package com.future.coolcoder.aitools.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jon
 * @Description TODO
 * @ClassName GptRequestMessages
 * @data 2023/8/24 14:20
 * @Version 1.0
 */
@Data
@ToString
public class GptRequestMessages {

    private String role;
    private String content;
}
