package com.homework.homework4.pojo.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhengheng7913
 */
public class DeletePersonRequestVo {
    @NotEmpty(message = "学工/教工号不能为空")
    private String id;

    @NotEmpty(message = "token不能为空")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
