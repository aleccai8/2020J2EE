package com.homework.homework4.server;

import com.alibaba.fastjson.JSON;
import com.homework.homework4.pojo.po.Person;
import com.homework.homework4.service.PersonService;
import com.homework.homework4.service.SearchService;
import com.homework.homework4.utils.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengheng7913
 */

@ServerEndpoint("/chat/{token}")
@Component
public class ChatServer {

    SearchService searchService;

    PersonService personService;

    private static final Map<String,ChatServer> ONLINE_CHAT_USER_MAP = new HashMap<>();

    private Session session;

    private Person person;

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        this.searchService = SpringUtil.getBean(SearchService.class);
        this.personService = SpringUtil.getBean(PersonService.class);
        Map<String,Object> map = new HashMap<>();
        this.session = session;
        Map<String,String> tokens = personService.getPersonToken();
        String id = tokens.get(token);
        if(id == null){
            map.put("message","请先登录");
            session.getBasicRemote().sendText(JSON.toJSONString(map));
            session.close();
        }else{
            map.put("message","登录成功");
            List<String> onlineList = new LinkedList<>();
            for (Map.Entry<String, ChatServer> entry : ONLINE_CHAT_USER_MAP.entrySet()) {
                onlineList.add(entry.getValue().person.getName());
            }
            map.put("在线用户",onlineList);
            person = searchService.findPerson("id",id).get(0);
            ONLINE_CHAT_USER_MAP.put(person.getName(),this);
            session.getBasicRemote().sendText(JSON.toJSONString(map));
        }

    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isNotBlank(message)){
            try{
                Map messageMap = JSON.parseObject(message,Map.class);
                String to = (String)messageMap.get("to");
                String toMessage = (String)messageMap.get("data");
                ChatServer toChatServer = ONLINE_CHAT_USER_MAP.get(to);
                if(toChatServer == null){
                    map.put("message","目标用户未找到");
                    session.getBasicRemote().sendText(JSON.toJSONString(map));
                }else{
                    map.put("message","收到信息");
                    map.put("data",toMessage);
                    toChatServer.session.getBasicRemote().sendText(JSON.toJSONString(map));
                }
            }catch (JSONException jsonException){
                map.put("message","输入的JSON不合法");
                session.getBasicRemote().sendText(JSON.toJSONString(map));
            }
        }

    }

    @OnClose
    public void onClose(){
        ONLINE_CHAT_USER_MAP.entrySet().removeIf(value->value.getValue()==this);
    }



}
