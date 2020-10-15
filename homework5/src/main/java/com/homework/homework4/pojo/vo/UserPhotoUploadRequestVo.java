package com.homework.homework4.pojo.vo;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author zhengheng7913
 */
public class UserPhotoUploadRequestVo {

    @NotEmpty(message = "token不能为空")
    private String token;

    @NotNull(message = "必须上传一个图片")
    private MultipartFile file;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "UserPhotoUploadRequestVo{" +
                "token='" + token + '\'' +
                ", file=" + file +
                '}';
    }
}
