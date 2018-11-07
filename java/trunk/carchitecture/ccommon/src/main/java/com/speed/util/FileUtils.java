package com.speed.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
	/**AccessKey*//*
	public static String accessKey;
	*//**SecretKey*//*
	public static String secretKey;
	*//**七牛存储空间*//*
	public static String bucket;
	*//**七牛访问域名*//*
	private static String qiniu_fileDomain;*/
	
	
	@Value("#{qiniu_accessKey}")
	private static String accessKey = "BbDaiXO53_ae08m2BdExHysrLvTNbgEz-YaryJYa";
	@Value("#{qiniu_secretKey}")
	private static String secretKey = "FbP4r2DIu3EcD_Ch_D5gV8lZqIB1DGFwF4YTdoWC";
	@Value("#{qiniu_bucket}")
	private static String bucket = "speed";

	@Value("#{qiniu_fileDomain}")
	private static String qiniu_fileDomain = "http://p59lzutcg.bkt.clouddn.com/";
	
	
	public static FileUtils fileUtils;
	private static String upToken;
	private static UploadManager uploadManager;
	private static OkHttpClient client;
	private static Auth auth;
	private static BucketManager bucketManager;
	static {
		//从配置文件读取属性
		/*if (PropertyUtil.getProperty("project.switch").equals("product")){
			accessKey = PropertyUtil.getProperty("qiniu.accessKey");
			secretKey = PropertyUtil.getProperty("qiniu.secretKey");
			bucket= PropertyUtil.getProperty("qiniu.bucketname");
			qiniu_fileDomain = PropertyUtil.getProperty("qiniu.fileDomain");
		}else {
			accessKey = PropertyUtil.getProperty("test.qiniu.accessKey");
			secretKey = PropertyUtil.getProperty("test.qiniu.secretKey");
			bucket= PropertyUtil.getProperty("test.qiniu.bucketname");
			qiniu_fileDomain = PropertyUtil.getProperty("test.qiniu.fileDomain");
			
			accessKey = "Kh1FCphm4WPFmCUTYSEKkZYLpr4Ogx6H-8e3pxJu";
			secretKey = "KxntpUwIHqHbM3pvcINZbN1cwVEu_G3FVeQdvI4n";
			bucket= "lander";
			qiniu_fileDomain = "http://ohr35pxo3.bkt.clouddn.com/";
		}*/

		//初始化
		fileUtils = new FileUtils();
		 auth =  Auth.create(accessKey, secretKey);
		Configuration cfg = new Configuration(Zone.zone2());
		uploadManager = new UploadManager(cfg);
		client = new OkHttpClient();
		bucketManager = new BucketManager(auth, cfg);
	}
	
	/**
	 * 根据key获取图片Url
	 * @param key 图片key
	 * @return 图片url
	 */
	public static String getFileUrl(String key) {
		return qiniu_fileDomain + key;
	}

	
	/**
	 * 上传文件
	 * @return bytes 文件字节
	 */
	public static String uploadFileBytes(MultipartFile file) throws IOException {
			StringMap putPolicy = new StringMap();
			upToken = auth.uploadToken(bucket,null,7200,putPolicy);
			Response response = uploadManager.put(file.getBytes(), UUID.randomUUID().toString(), upToken);
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),
					DefaultPutRet.class);
			return putRet.key;
	}



	/**
	 * 删除文件
	 * 
	 * @param key
	 *            文件key
	 * @return
	 */
	public static boolean deleteFile(String key) {
			try {
				Response res = bucketManager.delete(bucket, key);
				if (res.statusCode == 200){
					return true;
				}else {
					return false;
				}
			} catch (QiniuException e) {
				return false;
			}
	
	}
	

}
