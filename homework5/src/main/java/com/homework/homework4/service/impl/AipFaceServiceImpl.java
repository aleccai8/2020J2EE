package com.homework.homework4.service.impl;

import com.baidu.aip.face.AipFace;
import com.homework.homework4.service.AipFaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengheng7913
 */
@Service
public class AipFaceServiceImpl implements AipFaceService {
    @Value("${APP_ID}")
    private String appId;
    @Value("${API_KEY}")
    private String apiKey;
    @Value("${SECRET_KEY}")
    private String secretKey;

    private AipFace aipFace;

    private final Lock lock = new ReentrantLock();

    @Override
    public AipFace getAipFace() throws InterruptedException {
        if(aipFace == null){
            lock.lockInterruptibly();
            try{
                if(aipFace == null){
                    aipFace = new AipFace(appId, apiKey, secretKey);
                    aipFace.setConnectionTimeoutInMillis(2000);
                    aipFace.setSocketTimeoutInMillis(60000);
                }
            }finally {
                lock.unlock();
            }
        }
        return aipFace;
    }
}
