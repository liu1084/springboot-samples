package com.jim.io.base.outputstream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileWriteDemo {
    public static void main(String[] args) {
        File file = new File("/tmp/test.log");
        List<String> originString = Arrays.asList("1", "2");
        try(FileWriter fileWriter = new FileWriter(file)){
            originString.forEach(str -> {
                try {
                    fileWriter.write(str + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
