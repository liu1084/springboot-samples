package com.jim.shell.command;
import com.jim.shell.service.ITranslationService;
import com.jim.shell.service.impl.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

@ShellComponent
public class TranslationCommands {
    private ITranslationService service;

    @Autowired
    public TranslationCommands(TranslationService service) {
        this.service = service;
    }

    @ShellMethod
    public String translate(
            @ShellOption String text,
            @ShellOption(defaultValue = "en") String from,
            @ShellOption(defaultValue = "sch") String to
    ) {
        return service.translate(text, from, to);
    }
}
