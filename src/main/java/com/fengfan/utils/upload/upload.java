package com.fengfan.utils.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller("/upload")
public class upload {
    @RequestMapping("/Img")
    public String uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("filegather") MultipartFile[] filegather) {
        System.out.println("单个文件");
        System.out.println(file);
        for (int i = 0; i < filegather.length; i++) {
            System.out.println("多个文件");
            System.out.println(filegather[i]);
        }
        return "";
    }
}
