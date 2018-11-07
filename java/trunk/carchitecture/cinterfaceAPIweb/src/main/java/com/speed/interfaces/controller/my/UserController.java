package com.speed.interfaces.controller.my;

import com.speed.model.User;
import com.speed.service.UserService;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import com.speed.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public JsonResult getUserInfo(HttpSession session){
        JsonResult jsonResult = new JsonResult();
        User user = (User) session.getAttribute("user");
        jsonResult.setData(user);
        return jsonResult;
    }

    @RequestMapping("/updateNickName")
    @ResponseBody
    public JsonResult updateNickName(HttpSession session,String nickName){
        JsonResult jsonResult = new JsonResult();
        if (StringUtil.isBlank(nickName)){
            jsonResult.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
            return jsonResult;
        }
        User user = (User) session.getAttribute("user");
        user.setNickName(nickName);
        try {
            userService.update(user);
            jsonResult.getMessage().add(new ErrorCode(100001,"更新成功!"));
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.addErrorCode(new ErrorCode(100002,"更新失败!"));
        } finally {
            return jsonResult;
        }

    }

    @RequestMapping("/updateHeadshot")
    @ResponseBody
    public JsonResult updateHeadshot(HttpSession session, MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        if (file == null){
            jsonResult.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
            return jsonResult;
        }
        //TODO 保存图片
        return jsonResult;
    }



}
