package com.speed.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;


import com.speed.dao.MaterialDao;
import com.speed.dao.MaterialImageDao;
import com.speed.model.Entity;
import com.speed.model.Material;
import com.speed.model.MaterialImage;
import com.speed.model.Entity.MaterialImageCriteria;
import com.speed.service.MaterialImageService;
import com.speed.service.MaterialService;
import com.speed.util.ErrorCode;
import com.speed.util.FileUtils;
import com.speed.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MaterialServiceImpl extends BaseServiceImpl<Integer, Material> implements MaterialService {
	
	@Autowired
	private MaterialDao dao;
	@Autowired
	private MaterialImageDao imageDao;
	public JsonResult saveDo(Material material,MultipartFile file){
		JsonResult result=new JsonResult();
		//id为空,添加
		if(material.getId()==null){
			material.setCreateDate(new Date());
			Integer upRow=dao.save(material);
			if(upRow==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			if(file!=null){
				String imageKey="";
				try {					
					imageKey=FileUtils.uploadFileBytes(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MaterialImage picture=new MaterialImage();				
				picture.setMaterialId(material.getId());
				picture.setImageKey(imageKey);
				String url=FileUtils.getFileUrl(imageKey);
				picture.setImageUrl(url);
				picture.setCreateTime(new Date());
				Integer addNum=imageDao.save(picture);
				if(addNum==null){
					result.addErrorCode(ErrorCode.SYS_ERR);
					return result;
				}						
			}			
			return result;
		}		
		//修改时，传入图片时才更改，不传照片则不更改	
		if(file!=null){
			MaterialImageCriteria imageCriteria=new MaterialImageCriteria();
			imageCriteria.setMaterialId(Entity.Value.eq(material.getId()));
			List<MaterialImage> images=imageDao.selectList(imageCriteria);			
			String imageKey="";
			try {
				imageKey = FileUtils.uploadFileBytes(file);
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(images.size()>0){
					//删除原图片的七牛
					FileUtils.deleteFile(images.get(0).getImageKey());
					//更换新的图片
					images.get(0).setImageKey(imageKey);
					String url=FileUtils.getFileUrl(imageKey);
					images.get(0).setImageUrl(url);
					imageDao.update(images.get(0));
				}				
		}						
		Integer upPnum=dao.update(material);
		if(upPnum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;				
	}

}