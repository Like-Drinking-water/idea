package com.huanleichen.idea.service.redis.service;

public interface RedisService {
    /**
     * @param key
     * @param value
     * @param seconds 超时时间
     */
    void put(String key, String value, long seconds);

    String get(String key);
}
