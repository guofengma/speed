package com.speed.back.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.ehcache.util.SetAsList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.speed.model.Entity;
import com.speed.model.Entity.MaterialImageCriteria;
import com.speed.model.Entity.Pagination;
import com.speed.model.MaterialImage;
import com.speed.service.MaterialImageService;
import com.speed.util.ErrorCode;
import com.speed.util.FileUtils;
import com.speed.util.JsonResult;
/**
 * 根据素材获取图片
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/materialImage")
public class MaterialImageController {
	@Autowired
	private MaterialImageService materialImageService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Integer mId,Pagination pagination){
		//根据条件查询，获取图片
		MaterialImageCriteria imageCriteria=new MaterialImageCriteria();
		imageCriteria.setMaterialId(Entity.Value.eq(mId));
		Pagination list=materialImageService.selectPage(imageCriteria, pagination);
		request.setAttribute("pagination", list);
		request.setAttribute("mId", mId);
		return "material/imgList";
	}
	/**
	 * 调到添加图片页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer mId){	
		request.setAttribute("foid", mId);
		return "material/viewImg";
	}
	/**
	 * 修改或者添加图片
	 * @param indexpro
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(MaterialImage typePic,Integer mId,MultipartFile file){	
		JsonResult result=new JsonResult();
		result.setData(mId);
		if(typePic!=null&&typePic.getId()==null){
			//上传图片
			String key="";			
			try {
				key = FileUtils.uploadFileBytes(file);		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				result.addErrorCode(ErrorCode.RUNTIME_EXCEPTION_HANDLER);
				return result;
			}					
			typePic.setMaterialId(mId);
			typePic.setImageKey(key);
			String url=FileUtils.getFileUrl(key);
			typePic.setImageUrl(url);
			typePic.setCreateTime(new Date());
			Integer addRum=materialImageService.save(typePic);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}		
		MaterialImage pic=materialImageService.selectOne(typePic.getId());
		//删除7牛的图片
		FileUtils.deleteFile(pic.getImageKey());
		//上传图片		
		String key="";
		try {
			key = FileUtils.uploadFileBytes(file);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result.addErrorCode(ErrorCode.RUNTIME_EXCEPTION_HANDLER);
			return result;
		}	
		pic.setImageKey(key);
		String url=FileUtils.getFileUrl(key);
		pic.setImageUrl(url);
		Integer upNum=materialImageService.update(pic);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}		
		return result;
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		MaterialImage typePic=materialImageService.selectOne(id);
		request.setAttribute("bean", typePic);		
		request.setAttribute("foid", typePic.getMaterialId());
		return "material/viewImg";
	}
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();		
		MaterialImage typePic=materialImageService.selectOne(id);		
		result.setData(typePic.getMaterialId());
		//删除七牛的文件
		FileUtils.deleteFile(typePic.getImageKey());			
		Integer num=materialImageService.delete(id);			
		if(num==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
