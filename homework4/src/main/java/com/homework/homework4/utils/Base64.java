package com.homework.homework4.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhengheng7913
 */
public class Base64 {
    public static String pictureEncode(MultipartFile file) throws IOException {
        InputStream inputStream =file.getInputStream();
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        return java.util.Base64.getEncoder().encodeToString(data);
    }
}
