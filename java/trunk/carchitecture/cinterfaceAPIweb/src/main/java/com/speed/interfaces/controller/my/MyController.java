package com.speed.interfaces.controller.my;

import com.speed.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/my")
@Controller
public class MyController {

    @RequestMapping("/selectOrderInfo")
    @ResponseBody
    public JsonResult selectOrderInfo(){
        JsonResult jsonResult = new JsonResult();
        //TODO
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("willPay",12);
        map.put("willSend",16);
        map.put("willReceive",19);
        jsonResult.setData(map);
        return jsonResult;
    }

    @RequestMapping("/selectShopInfo")
    @ResponseBody
    public JsonResult selectShopInfo(){
        JsonResult jsonResult = new JsonResult();
        //TODO
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("product",100);
        map.put("client",50);
        map.put("order",1000);
        jsonResult.setData(map);
        return jsonResult;
    }

    @RequestMapping("/selectServiceInfo")
    @ResponseBody
    public JsonResult selectServiceInfo(){
        JsonResult jsonResult = new JsonResult();
        //TODO
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("servicePhone","400 168 2727");
        jsonResult.setData(map);
        return jsonResult;
    }
}
