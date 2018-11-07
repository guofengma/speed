package com.speed.back.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.speed.model.Entity;
import com.speed.model.Entity.MaterialCriteria;
import com.speed.model.Entity.MaterialImageCriteria;
import com.speed.model.Entity.Pagination;
import com.speed.model.MateriaType;
import com.speed.model.Material;
import com.speed.model.MaterialImage;
import com.speed.service.MateriaTypeService;
import com.speed.service.MaterialImageService;
import com.speed.service.MaterialService;
import com.speed.util.ErrorCode;
import com.speed.util.FileUtils;
import com.speed.util.JsonResult;
/**
 * 获取素材库信息
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/material")
public class MaterialController {
	@Autowired
	private MateriaTypeService materiaTypeService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private MaterialImageService imageService;
	/**
	 * 获取素材内容列表
	 * @param request
	 * @param typeId
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Integer typeId,Pagination pagination){
		//根据该类型素材库信息,分页
		MaterialCriteria criteria=new MaterialCriteria();
		criteria.setTypeId(Entity.Value.eq(typeId));
		Pagination list=materialService.selectPage(criteria, pagination);			
		//获取素材信息集合
		List<Material> covers=(List<Material>)list.getRows();		
		List urlsList=new ArrayList();						
		for(int i=0;i<covers.size();i++){
			MaterialImageCriteria imageCriteria=new MaterialImageCriteria();
			imageCriteria.setMaterialId(Entity.Value.eq(covers.get(i).getId()));
			List<MaterialImage> images=imageService.selectList(imageCriteria);			
			if(images.size()>0){
				//String[] urls=FileUploadUtil.getFileUrls(picture.getPicurl());
				String urls=FileUtils.getFileUrl(images.get(0).getImageKey());
				urlsList.add(urls);			
			}			
		}
		for(int k=0;k<urlsList.size();k++){
			System.out.println("ueljihe:"+urlsList.get(k));
		}
		//Protype protype=protypeService.selectOne(typeId);
		MateriaType materiaType=materiaTypeService.selectOne(typeId);
		request.setAttribute("urls", urlsList);
		request.setAttribute("protype", materiaType);
		request.setAttribute("pagination", list);
		request.setAttribute("typeId", typeId);
		if(typeId!=null&&typeId==4){
			return "material/listNoImg";
		}
		return "material/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request,Integer typeId){
		request.setAttribute("typeId", typeId);	
		//跳转到晒单页面
		if(typeId!=null&&typeId==4){
			return "material/viewNoImg";
		}		
		return "material/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(Material cover){	
		JsonResult result=new JsonResult();
		if(cover!=null&&cover.getId()==null){
			Integer addRum=materialService.save(cover);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=materialService.update(cover);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		Material cover=materialService.selectOne(id);
		request.setAttribute("bean", cover);	
		request.setAttribute("typeId", cover.getTypeId());
		//跳转到晒单页面
		if(cover!=null&&cover.getTypeId()==4){
			return "material/viewNoImg";
		}	
		return "material/view";
	}
	/**
	 * 删除封面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(HttpServletRequest request,Integer id){
		JsonResult result=new JsonResult();
		Material cover=materialService.selectOne(id);
		MaterialImageCriteria imageCriteria=new MaterialImageCriteria();
		imageCriteria.setMaterialId(Entity.Value.eq(cover.getId()));
		List<MaterialImage> images=imageService.selectList(imageCriteria);			
		for(int i=0;i<images.size();i++){
			//删除七牛文件
			FileUtils.deleteFile(images.get(i).getImageKey());	
			//删除数据库图片
			imageService.delete(images.get(i).getId());
		}
		/*if(images.size()>0){
			//删除七牛文件
			FileUtils.deleteFile(images.get(0).getImageKey());	
			//删除数据库图片
			imageService.delete(images.get(0).getId());
		}*/			
		//删除素材信息
		Integer delNum=materialService.delete(id);	
		result.setData(cover.getTypeId());
		if(delNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 上传图片和信息
	 * @param file
	 * @param cover
	 * @return
	 */
	@RequestMapping(value="/saveDo",method=RequestMethod.POST)
	public @ResponseBody JsonResult saveDo(@RequestParam(value="file",required=false) MultipartFile file,Material material){
		return materialService.saveDo(material, file);
	}
}
