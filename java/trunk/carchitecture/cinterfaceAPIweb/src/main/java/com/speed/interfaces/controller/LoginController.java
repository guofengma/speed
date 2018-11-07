package com.speed.interfaces.controller;

import com.speed.exception.CommonException;
import com.speed.model.User;
import com.speed.service.UserService;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import com.speed.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(HttpSession session,String phone, String password){
        JsonResult jsonResult = new JsonResult();
        if (StringUtil.isBlank(phone) || StringUtil.isBlank(password)){
            jsonResult.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
            return jsonResult;
        }
        try {
            User user = userService.login(phone, password);
            session.setAttribute("user",user);
            jsonResult.getMessage().add(new ErrorCode(100001,"登录成功"));
        } catch (CommonException e) {
            jsonResult.addErrorCode(new ErrorCode(100002,e.getMessage()));
        } catch (Exception e){
            e.printStackTrace();
            jsonResult.addErrorCode(ErrorCode.SYS_ERR);
        }
        return jsonResult;
    }


}
