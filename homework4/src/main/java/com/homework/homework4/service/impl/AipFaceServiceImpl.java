package com.homework.homework4.service.impl;

import com.baidu.aip.face.AipFace;
import com.homework.homework4.service.AipFaceService;
import org.springframework.stereotype.Service;

/**
 * @author zhengheng7913
 */
@Service
public class AipFaceServiceImpl implements AipFaceService {
    private static final String APP_ID = "22820216";
    private static final String API_KEY = "FrYAWfp41R0vAtrAwmuXNVYv";
    private static final String SECRET_KEY = "UM4stZfcgZUBEF9noj6iwcgRYX9KzlGR";

    private AipFace aipFace;

    public AipFaceServiceImpl(){
        aipFace = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        aipFace.setConnectionTimeoutInMillis(2000);
        aipFace.setSocketTimeoutInMillis(60000);
    }

    @Override
    public AipFace getAipFace() {
        return aipFace;
    }
}
