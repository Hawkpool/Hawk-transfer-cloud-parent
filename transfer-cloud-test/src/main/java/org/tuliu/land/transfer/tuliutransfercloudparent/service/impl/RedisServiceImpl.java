package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.tuliu.land.transfer.tuliutransfercloudparent.constants.RedisConstant;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.RedisService;

/**
 * @author Hawk
 */
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /** 根据key删除 */
    @Override
    public void delete (String key) {
        redisTemplate.delete (key);
    }

    /** 获取缓存键值对值 */
    @Override
    @SuppressWarnings ("unchecked")
    public <T> T getValue (String key, Class <T> clazz) {
        Object value = redisTemplate.opsForValue ().get (key);
        return (T) value;
    }

    /** 设置redis键值对(默认超时时间1小时) */
    @Override
    public void setValue (String key, Object value) {
        redisTemplate.opsForValue ().set (key, value, RedisConstant.REDIS_TIME_HOUR, RedisConstant.REDIS_TIME_UNIT);
    }

    /** 设置redis键值对， 带超时时间(时间单位：秒) */
    @Override
    public void setValue (String key, Object value, Long timeout) {
        redisTemplate.opsForValue ().set (key, value, timeout, RedisConstant.REDIS_TIME_UNIT);
    }
}
