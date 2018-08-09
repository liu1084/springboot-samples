package com.jim.shell.service.impl;
import com.jim.shell.service.ITranslationService;
import org.springframework.stereotype.Service;

@Service
public class TranslationService implements ITranslationService {
    @Override
    public String translate(String text, String from, String to) {
        return "I don't known~!";
    }
}
