package com.jim.generic.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Communication implements ICommunication {
    @Override
    public void speak() {
        log.debug("speak");
    }
}
