package com.jim.generic.factory;

import java.util.HashMap;
import java.util.Map;

public class MessageFactory {
    private static final Map<
            Class<? extends ICommunication>, Class<? extends Communication>>
            IMPLEMENTATIONS = new HashMap<>();

    static {
        IMPLEMENTATIONS.put(IVoiceMessage.class, VoiceMessage.class);
        IMPLEMENTATIONS.put(ITextMessage.class, TextMessage.class);
    }

    public static <T extends Communication> T make(Class<T> type)
            throws IllegalAccessException, InstantiationException {
        T message = (T)IMPLEMENTATIONS.get(type).newInstance();
        return message;
    }
}
