package com.future.coolcoder.aitools.service;

import com.future.coolcoder.aitools.entity.GptResponse;
import com.future.coolcoder.aitools.entity.UserRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Jon
 * @Description chatgpt service
 * @ClassName ChatGptService
 * @data 2023/8/26 14:57
 * @Version 1.0
 */
@Service
public interface ChatGptService {

    /**
     *
     * @return
     */
    GptResponse askOnceByPost(UserRequest userRequest) throws IOException;

}
