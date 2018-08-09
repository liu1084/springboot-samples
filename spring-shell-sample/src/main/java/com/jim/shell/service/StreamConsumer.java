package com.jim.shell.service;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

@Data
public class StreamConsumer implements Runnable {
    private Consumer<String> consumer;
    private InputStream inputStream;

    public StreamConsumer(InputStream inputStream, Consumer<String> consumer){
        this.consumer = consumer;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
    }
}
