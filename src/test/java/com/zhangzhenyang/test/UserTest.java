package com.zhangzhenyang.test;

import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhangzhenyang.beans.User;
import com.zhangzhenyang.utils.TimeRandomUtil;
import com.zhangzhenyang.utils.UserRandomUtil;
@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class UserTest {

	@Resource
	private RedisTemplate redisTemplate;
	
	@Test
	public void userTest(){
		//获取当前时间
		long time1 = System.currentTimeMillis();
		
//		String类型
//		ValueOperations opsForValue = redisTemplate.opsForValue();
		
//		hash类型
		BoundHashOperations boundHashOps = redisTemplate.boundHashOps("user_hash");
		
		for (int i = 1; i <= 50000; i++) {
			User user = new User();
			//id
			user.setUid(i);
			//名字
			user.setUname(UserRandomUtil.getChineseName());
			//性别
			user.setSex(getSex());
			//手机号
			user.setPhone(getPhone());
			//邮箱
			user.setEmail(UserRandomUtil.getEmail());
			//生日
			user.setBirthday(TimeRandomUtil.randomDate("1949-01-01 00:00:00", "2001-01-01 00:00:00"));
//			System.out.println(user);
			
			//jdk   /json
//			opsForValue.set(i+"", user);
			
			//hash
			boundHashOps.put(i+"", user.toString());
		}
		long time2 = System.currentTimeMillis();
		long time = time2 - time1;
//		System.out.println("序列化方式是：jdk    耗时："+time);
//		System.out.println("序列化方式是：json    耗时："+time);
		System.out.println("序列化方式是：hash    耗时："+time);
	}
	
	
	public static String getSex(){
		return new Random().nextBoolean()?"男":"女";
	}
	
	public static String getPhone(){
		String phone = "";
		for (int i = 0; i <= 9; i++) {
			int int1 = new Random().nextInt(10);
			phone = phone + int1;
		}
		return "13"+phone;
	}
}
