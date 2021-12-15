package com.example.logging.log4j2.cv2.hacker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/hello")
    public String hello() throws IOException {
        File file = ResourceUtils.getFile("classpath:EvilHackerHandler.class");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] b = new byte[1024];
        fileOutputStream.write(b);
        return  new String(b);
    }

}
