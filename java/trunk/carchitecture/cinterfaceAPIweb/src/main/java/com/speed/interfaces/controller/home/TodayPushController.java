package com.speed.interfaces.controller.home;

import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Hale
 * @Description:今日推送
 * @Date:2018/2/8 10:12
 */
@RequestMapping("/todayPush")
@Controller
public class TodayPushController {

    @RequestMapping("/selectToDayPush")
    @ResponseBody
    public JsonResult selectToDayPush(){
        JsonResult jsonResult = new JsonResult();

        return jsonResult;
    }

    @RequestMapping("/share")
    @ResponseBody
    public JsonResult share(Integer id, MultipartFile [] files){
        JsonResult jsonResult = new JsonResult();
        if (id == null || files.length == 0){
            jsonResult.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
            return jsonResult;
        }
        //TODO 分享
        jsonResult.getMessage().add(new ErrorCode(100001,"分享成功！"));
        return jsonResult;
    }



}
