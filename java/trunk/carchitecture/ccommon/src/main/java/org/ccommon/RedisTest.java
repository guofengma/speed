//package org.ccommon;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.speed.util.Redis;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml"})
//public class RedisTest {
//
//	@Autowired
//	private Redis redis;
//	
//	@Test
//	public void test() throws InterruptedException{
//		String key = "product_0";
//		redis.set(key, 10);
//		
//		for(int i=0;i<20;i++){
//			Thread.sleep(10);
//			new Thread(new ThreadTest(key)).start();
//		}
////		redis.secKill(key);
////		redis.secKill(key);
//		
//		Thread.sleep(5000);
//		
//		Integer value = redis.getInteger(key);
//		System.out.println( "value ="+value);
//		
//	}
//	
//	class ThreadTest implements Runnable{
//		String key;
//		private ThreadTest(String key) {
//			super();
//			this.key = key;
//		}
//
//		@Override
//		public void run() {
//			redis.secKill(key);
//		}
//		
//	}
//}
