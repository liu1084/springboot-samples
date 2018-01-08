package com.jim.ajax.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
@ConfigurationProperties(prefix = "file.upload")
public class IndexController {
    private String maxSize;
    private String uploadPath;

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @GetMapping
    public String index() {
        return "file.html";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> index(@Valid @RequestParam("file") MultipartFile file) {
        long fileSize = file.getSize();
        ResponseEntity responseEntity = null;
        String fileName = file.getOriginalFilename();
        String path = Paths.get(uploadPath, fileName).toString();
        if (fileSize > Long.parseLong(maxSize)) {
            responseEntity = new ResponseEntity<>("file is bigger than max", HttpStatus.BAD_REQUEST);
            return responseEntity;
        }

        File uploadFile = new File(path);
        if (!uploadFile.exists()) {
            try {
                uploadFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path)))
        ) {
            bufferedOutputStream.write(file.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
