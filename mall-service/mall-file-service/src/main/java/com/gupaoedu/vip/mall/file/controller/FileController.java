package com.gupaoedu.vip.mall.file.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.file.ceph.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author ErenPC
 * @version 1.0
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileHandler fileHandler;

    @Value("${cephurl}")
    public String cephurl;

    @PostMapping("/upload")
    public RespResult upload(MultipartFile file) throws IOException {
        fileHandler.upload(file.getOriginalFilename(), file.getBytes());
        return RespResult.ok(cephurl + file.getOriginalFilename());
    }

    @PostMapping("/download/{fileName}")
    public void download(@PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException {
        byte[] download = fileHandler.download(fileName);
        response.getOutputStream().write(download);
    }
}
