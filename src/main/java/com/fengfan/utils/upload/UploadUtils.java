package com.fengfan.utils.upload;

import com.fengfan.user.pojo.FilePojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller("/upload")
public class UploadUtils {
    @RequestMapping("/Img")
    @ResponseBody
    public String uploadImg(MultipartFile file, HttpServletRequest request) {
        try {
            System.out.println("单个文件");
            System.out.println(file);
            System.out.println("文件名为:" + file.getName());
            System.out.println("文件原名称为:" + file.getOriginalFilename());
            File patchily = new File("");
            System.out.println("绝对路径:" + patchily.getAbsolutePath());
            System.out.println("绝对路径:" + patchily.getCanonicalPath());
            System.out.println("路径:" + patchily.getPath());
//            if (patchily.exists()) {
//                patchily.mkdir();
//            }

            FileOutputStream outputStream = new FileOutputStream(patchily.getPath() + "\\" + file.getOriginalFilename());
            InputStream in = file.getInputStream();
            int b = 0;
            //读取文件
            while ((b = in.read()) != -1) {
                outputStream.write(b);
            }
            outputStream.flush(); //关闭流
            in.close();
            outputStream.close();
            return "success";
        } catch (IOException io) {
            System.out.println("IO流Exception" + io);
        } catch (Exception e) {
            System.out.println("出现错误Exception" + e);
        }
        return "error";
    }

    /**
     * base64转图片
     *
     * @param imgStr base64码
     */
    @RequestMapping("/SaveImg")
    @ResponseBody
    public String SaveImg(@RequestBody List<FilePojo> list) {

//        System.out.println(imgStr + "-------" + list + "------" + Arraylist);
        /*
        BufferedImage image = null;
        byte[] imageByte = null;
        try {
            imageByte = DatatypeConverter.parseBase64Binary(imgStr);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(new ByteArrayInputStream(imageByte));
            bis.close();
            File outputfile = new File("d:\\sealImg.jpg");
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        return "{\"name\":\"value\"}";

    }


}
