package org.tuliu.land.transfer.tuliutransfercloudparent.constants;

import java.util.concurrent.TimeUnit;

public class RedisConstant {
    /** redis 统一前缀 */
    public static String REDIS_PREFIX = "JSPXCMS_";

    public static String REDIS_VIEW_CONTRACT = "JSPXCMS_CONTRACT";

    public static String REDIS_VIEW_PRESENT = "JSPXCMS_PRESENT";


    /** redis 失效时间单位 */
    public static TimeUnit REDIS_TIME_UNIT = TimeUnit.SECONDS;

    /** redis 失效时间1天 */
    public static Long REDIS_TIME_DAY = Long.valueOf(24 * 3600);

    /** redis 失效时间1小时 */
    public static Long REDIS_TIME_HOUR = Long.valueOf(3600);
}
