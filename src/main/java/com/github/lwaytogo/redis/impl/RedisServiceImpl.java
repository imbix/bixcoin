package com.github.lwaytogo.redis.impl;

import com.github.lwaytogo.redis.RedisClient;
import com.github.lwaytogo.redis.RedisService;

import redis.clients.jedis.ShardedJedis;

public class RedisServiceImpl implements RedisService{

	private static ShardedJedis redis = RedisClient.getInstance();	
	
	@Override
	public void set(String key, String value) {
		redis.set(key, value);
	}

	@Override
	public String get(String key) {
		String value = redis.get(key);
		System.out.println("redis.get:" + key);
		System.out.println("redis.get:" + value);
		return value;
	}

	@Override
	public void del(String key) {
		redis.del(key);
	}
	
	

}
