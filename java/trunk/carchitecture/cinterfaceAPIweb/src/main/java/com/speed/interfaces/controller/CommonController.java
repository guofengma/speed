package com.speed.interfaces.controller;

import com.speed.util.CommonUtil;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import com.speed.util.RegexUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@RequestMapping("/common")
@Controller
public class CommonController {


    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public JsonResult sendVerifyCode(final HttpSession session, String phone, Integer type){
        JsonResult jsonResult = new JsonResult();
        if (type == null || phone == null){
            jsonResult.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
            return jsonResult;
        }
        if (!RegexUtils.checkPhone(phone)){
            jsonResult.addErrorCode(new ErrorCode(100003,"手机号格式错误"));
            return jsonResult;
        }
        //生成验证码
        String code = CommonUtil.createRandomNumeric(6);
        Timer timer = new Timer();
        session.setAttribute("code",code);
        session.setAttribute("phone",phone);
        session.setAttribute("timer",timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                session.setAttribute("code",null);
                session.setAttribute("phone",null);
                session.setAttribute("timer",null);
            }
        }, 1000 * 60 * 15);
        jsonResult.getMessage().add(new ErrorCode(100001,"发送成功。验证码："+code));
        return jsonResult;
    }
}
