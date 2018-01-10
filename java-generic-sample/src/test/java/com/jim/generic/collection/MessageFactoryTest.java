package com.jim.generic.collection;

import com.jim.generic.factory.Communication;
import com.jim.generic.factory.MessageFactory;
import com.jim.generic.factory.TextMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MessageFactoryTest {

    @Test
    public Communication make() throws InstantiationException, IllegalAccessException {
        TextMessage textMessage = MessageFactory.make(TextMessage.class);
        Assert.assertEquals(textMessage.getClass(), TextMessage.class);
        return textMessage;
    }
}
