package com.github.lwaytogo.redis;

import com.github.lwaytogo.redis.impl.RedisServiceImpl;

public class RedisMain {

	private static RedisService redis= new RedisServiceImpl();
	
	public static void main(String[] args) {
		
		redis.set("a", "1");
		System.out.println("a:" + redis.get("a"));
		redis.del("a");
		System.out.println("a:" + redis.get("a"));
		
		
	}
}
