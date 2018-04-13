package com.jim.shell.command;
import com.jim.shell.service.StreamConsumer;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

@ShellComponent
public class ListDirectoryCommand {
    @ShellMethod("List directories and file of the PATH")
    public void ls(String directoryName) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        File file = new File(directoryName);
        assert file.exists() : "directory is not exist";

        processBuilder.directory(new File(directoryName));
        Process process = processBuilder.command("sh", "-c", "ls -la").start();
        StreamConsumer consumer = new StreamConsumer(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(consumer);
        int code = process.waitFor();
        assert code == 0 : "`ls -la` has a exception";
    }
}