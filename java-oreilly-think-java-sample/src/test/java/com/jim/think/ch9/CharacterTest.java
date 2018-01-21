package com.jim.think.ch9;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Test
@Slf4j
public class CharacterTest {

    @Test
    public void testUnicode(){
        for (int i = 913; i < 938; i++){
            log.debug(String.valueOf((char)i));
        }
    }


    @Test
    public void testStringImmutable(){
        String name = "click on this button";
        log.debug(name.toUpperCase());
        char bh = '\u4e00';

        char eh = '\u9fa5';
        //log.debug(String.valueOf(bh) + String.valueOf(eh));

        int count = 0;
        for (int i = bh; i <= eh; i++){
            log.debug(String.valueOf((char)i));
            count++;
        }

        log.debug(String.valueOf(count));
    }


}
