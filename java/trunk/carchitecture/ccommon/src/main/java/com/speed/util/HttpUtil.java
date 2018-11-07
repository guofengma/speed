package com.speed.util;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @Title: HttpUtil.java
* @Package com.speed.util
* @Description: http工具类
* @author chenwenhao 
* @date 2017-1-18 下午5:08:08
 */
public class HttpUtil {
	
	private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	/**
	 * 创建HttpClient
	 */
	public static CloseableHttpClient createHttpClient() {
		return HttpClientBuilder.create().build();
	}
	
	/**
	 * 关闭HttpClient
	 */
	public static void closeHttpClient(CloseableHttpClient httpClient){
		if(httpClient!=null){
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 直接发一个doget请求，不做任何处理（目前用于网站页面url的刷新，防止session过期）
	 */
	public static int doGetForHttpStatus(String url , Map<String,String> headers){
		CloseableHttpClient  httpClient = createHttpClient();
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig  = RequestConfig.custom().setConnectTimeout(5000).build();
		httpGet.setConfig(requestConfig);
		if(headers!=null && !headers.isEmpty()){
			for(String key : headers.keySet()){
				httpGet.addHeader(key, headers.get(key));
			}
		}
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			return httpResponse.getStatusLine().getStatusCode();
		} catch (Exception e) {
			log.error("[doGetForHttpStatus] method Exception : ",e);
		}finally{
			closeHttpClient(httpClient); 
		}
		return 0;
	}
	
	/**
	 * 处理get请求
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String doGet(String url , Map<String,String> headers) throws Exception{
		CloseableHttpClient  httpClient = createHttpClient();
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig  = RequestConfig
				.custom()
				.setSocketTimeout(5000)
				.setConnectTimeout(5000)
				.setCircularRedirectsAllowed(true)   //指定重定向为true
				.build();
		httpGet.setConfig(requestConfig);
		if(headers!=null && !headers.isEmpty()){
			for(String key : headers.keySet()){
				httpGet.addHeader(key, headers.get(key));
			}
		}
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if(httpResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK){	//成功响应码为200
				HttpEntity httpEntity = httpResponse.getEntity();
				if(httpEntity.getContentEncoding()!=null){
					String contentEncodingValue = httpEntity.getContentEncoding().getValue();
					if("gzip".equals(contentEncodingValue)){
						httpEntity = new GzipDecompressingEntity(httpEntity);
					}else if("deflate".equalsIgnoreCase(contentEncodingValue)){
						httpEntity = new DeflateDecompressingEntity(httpEntity);
					}
				}
				String charset = getContentCharSet(httpEntity);
				return EntityUtils.toString(httpEntity,charset);
			}else{
				HttpEntity httpEntity = httpResponse.getEntity();
				if(httpEntity.getContentEncoding()!=null){
					String contentEncodingValue = httpEntity.getContentEncoding().getValue();
					if("gzip".equals(contentEncodingValue)){
						httpEntity = new GzipDecompressingEntity(httpEntity);
					}else if("deflate".equalsIgnoreCase(contentEncodingValue)){
						httpEntity = new DeflateDecompressingEntity(httpEntity);
					}
				}
				String charset = getContentCharSet(httpEntity);
				String errorResponseBody =  EntityUtils.toString(httpEntity,charset);
				log.info("doget error : Status:{} , responseBody:{}",httpResponse.getStatusLine().getStatusCode(),errorResponseBody);
				return null;
			}
		} finally{
			closeHttpClient(httpClient); 
		}
	}
	
	
	/**
	 * 设置httpClient的链接超时时间,设置5秒内没有访问成功，则报超时异常
	 * 如果在规定时间内能访问到url，则返回true，否则会爆超时异常，此时返回false
	 * 
	 * 超时设置参考：http://www.open-open.com/lib/view/open1383751765321.html
	 */
	public static boolean visitUrl(String url, Map<String,String> headers){
		boolean boo = true;
		CloseableHttpClient httpClient = createHttpClient();
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig  = RequestConfig.custom().setConnectTimeout(5000).build();
		httpGet.setConfig(requestConfig);
		if(headers!=null && !headers.isEmpty()){
			for(String key : headers.keySet()){
				httpGet.addHeader(key, headers.get(key));
			}
		}
		try {
			httpClient.execute(httpGet);
		} catch (Exception e) {
			boo = false;
			log.error("[visitUrl] method Exception :",e);
		}finally{
			closeHttpClient(httpClient); 
		}
		return boo;
	}
	
	
	public static String getContentCharSet(final HttpEntity entity)  
	        throws ParseException {  
	  
	        if (entity == null) {  
	            throw new IllegalArgumentException("HTTP entity may not be null");  
	        }  
	        String charset = "utf-8";  
	        if (entity.getContentType() != null) {   
	            HeaderElement values[] = entity.getContentType().getElements();  
	            if (values.length > 0) {  
	                NameValuePair param = values[0].getParameterByName("charset");  
	                if (param != null) {  
	                    charset = param.getValue();  
	                }  
	            }  
	        }  
	        return charset;  
	    }  
	

}