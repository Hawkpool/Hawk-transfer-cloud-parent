package org.tuliu.land.transfer.tuliutransfercloudparent.service;

public interface RedisService {
    /* 获取缓存键值对值 */
    public <T> T getValue(String key, Class<T> clazz);

    /** 设置redis键值对(默认超时时间1小时) */
    public void setValue(String key, Object value);

    /** 设置redis键值对， 带超时时间(时间单位：秒) */
    public void setValue(String key, Object value, Long timeout);

    /** 根据key删除 */
    public void delete(String key);
}
