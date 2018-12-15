package cc.fj.service.pp.impl;

import cc.fj.model.publicnumber.ResTextMessage;
import cc.fj.service.pp.PublicNumberService;
import cc.fj.util.WeChatMessageUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2015/12/26.
 */
@Service
public class PublicNumberServiceImpl implements PublicNumberService {

    private static final Logger logger =Logger.getLogger(PublicNumberServiceImpl.class);

    @Override
    public String process(HttpServletRequest request) {
        try {
            String responseMsg="Happy New Year!";
            Map<String,String> map= WeChatMessageUtils.parseXml(request);
            String ToUserName=map.get("ToUserName");
            String FromUserName=map.get("FromUserName");
            String CreateTime=map.get("CreateTime");
            String MsgType=map.get("MsgType");
            String Content=map.get("Content");
            String MsgId=map.get("MsgId");
            System.out.println("\nreceive from client:");
            logger.info("ToUserName:" + ToUserName);
            logger.info("FromUserName:"+FromUserName);
            logger.info("CreateTime:"+CreateTime);
            logger.info("MsgType:"+MsgType);
            logger.info("Content:"+Content);
            logger.info("MsgId:"+MsgId);
            System.out.println("\nend........................................");

            if(WeChatMessageUtils.REQ_MESSAGE_TYPE_TEXT.equals(MsgType)) {

                ResTextMessage resTextMessage = new ResTextMessage();
                resTextMessage.setToUserName(FromUserName);
                resTextMessage.setFromUserName(ToUserName);
                resTextMessage.setCreateTime(new Date().getTime());
                resTextMessage.setMsgType(WeChatMessageUtils.REQ_MESSAGE_TYPE_TEXT);
                resTextMessage.setContent(Content);

                responseMsg = WeChatMessageUtils.textMessageToXml(resTextMessage);
            }else if(WeChatMessageUtils.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)){
                String Event=map.get("Event");
                if(WeChatMessageUtils.EVENT_TYPE_SUBSCRIBE.equals(Event)){
                    ResTextMessage resTextMessage = new ResTextMessage();
                    resTextMessage.setToUserName(FromUserName);
                    resTextMessage.setFromUserName(ToUserName);
                    resTextMessage.setCreateTime(new Date().getTime());
                    resTextMessage.setMsgType(WeChatMessageUtils.REQ_MESSAGE_TYPE_TEXT);
                    Content="Welcome to subscribe me!";
                    resTextMessage.setContent(Content);
                    responseMsg = WeChatMessageUtils.textMessageToXml(resTextMessage);
                    logger.debug("subscript");
                    logger.debug(resTextMessage);
                }else if(WeChatMessageUtils.EVENT_TYPE_UNSUBSCRIBE.equals(Event)){
                    ResTextMessage resTextMessage = new ResTextMessage();
                    resTextMessage.setToUserName(FromUserName);
                    resTextMessage.setFromUserName(ToUserName);
                    resTextMessage.setCreateTime(new Date().getTime());
                    resTextMessage.setMsgType(WeChatMessageUtils.REQ_MESSAGE_TYPE_TEXT);
                    Content="Good Bye!";
                    resTextMessage.setContent(Content);
                    responseMsg = WeChatMessageUtils.textMessageToXml(resTextMessage);
                }
            }

            return responseMsg;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
