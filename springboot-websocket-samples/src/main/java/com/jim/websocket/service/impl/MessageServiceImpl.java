package com.jim.websocket.service.impl;

import com.jim.websocket.service.IMessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Author: Jim
 * Date: 2018/8/7:下午5:46
 * Description:
 */

@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public List<Integer> getCharacters() {
        List<Integer> chars = new Random()
                .ints(50, 125, 255)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        return chars;
    }
}
