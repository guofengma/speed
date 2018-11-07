package com.speed.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.speed.model.Entity.Pagination;
/**
 * 消息推送
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/message")
public class MessageController {
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(){
		return "message/push";
	}
	@RequestMapping(value="/testlist",method=RequestMethod.GET)
	public String list1(){
		return "message/testInterface";
	}
	@RequestMapping(value="/videolist",method=RequestMethod.GET)
	public String list2(){
		return "message/videoAdd";
	}
	@RequestMapping(value="/playlist",method=RequestMethod.GET)
	public String list3(){
		return "message/videoplayer";
	}
	@RequestMapping(value="/updlist",method=RequestMethod.GET)
	public String list4(){
		return "message/videoUpdate";
	}
}
