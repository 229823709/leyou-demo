package com.leyou.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadService {

    // 支持的文件类型
    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    //MultipartFile Spring mvc 文件上传类
    public String upload(MultipartFile multipartFile) {


        try {
            String fileType = multipartFile.getContentType(); // 获取文件类型
            if (!suffixes.contains(fileType)) {
                log.error("上传失败，文件类型不匹配:{}", fileType);
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(multipartFile.getInputStream());
            if (image == null) {
                log.info("上传失败，文件内容不符合要求");
                return null;
            }
            // 2、保存图片
            // 2.1、生成保存目录
            File dir = new File("D:\\heima\\upload");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 2.2、保存图片
            multipartFile.transferTo(new File(dir, multipartFile.getOriginalFilename()));

            // 2.3、拼接图片地址
            String url = "http://image.leyou.com/upload/" + multipartFile.getOriginalFilename();

            return url;
        } catch (Exception e) {

            return  null;
        }
    }

}
