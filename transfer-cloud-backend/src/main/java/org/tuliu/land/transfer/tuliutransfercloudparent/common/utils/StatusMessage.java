package org.tuliu.land.transfer.tuliutransfercloudparent.common.utils;

public class StatusMessage {

    public static int NUM_200 = 200;// 请求成功
    public static int NUM_201 = 201;// 入参为空
    public static int NUM_203 = 203;// 数据记录不存在
    public static int NUM_208 = 208;// 后台异常
    /**3开头状态码为业务相关**/
    public static int NUM_301 = 301;//模型编码已被占用

    private String status; // 状态码

    private String msg;// 状态码说明

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getMsg () {
        return msg;
    }

    public void setMsg (String msg) {
        this.msg = msg;
    }

    public enum Status {
                        CODE_200 (String.valueOf (NUM_200), NUM_200), // 请求成功
                        CODE_201 (String.valueOf (NUM_201), NUM_201), // 入参为空
                        CODE_203 (String.valueOf (NUM_203), NUM_203), // 数据记录不存在,如找回密码时，输入手机号不存在
                        CODE_208 (String.valueOf (NUM_208), NUM_208), // 后台异常
                        CODE_301(String.valueOf(NUM_301),NUM_301);
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private Status (String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 普通方法
        public static String getName (int index) {
            for (Status c : Status.values ()) {
                if (c.getIndex () == index) {
                    return c.name;
                }
            }
            return null;
        }

        // get set 方法
        public String getName () {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        public int getIndex () {
            return index;
        }

        public void setIndex (int index) {
            this.index = index;
        }
    }

    public enum Message {
                         MSG_200 ("SUCCESS", NUM_200), // 请求成功
                         MSG_201 ("请求参数不能为空", NUM_201), // 入参为空
                         MSG_203 ("数据记录不存在", NUM_203), // 数据记录不存在
                         MSG_208 ("系统错误,请联系管理员", NUM_208),// 系统异常
                         MSG_301 ("模型编码已被占用",NUM_301);//模型编码已被占用
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private Message (String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 普通方法
        public static String getName (int index) {
            for (Message c : Message.values ()) {
                if (c.getIndex () == index) {
                    return c.name;
                }
            }
            return null;
        }

        // get set 方法
        public String getName () {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        public int getIndex () {
            return index;
        }

        public void setIndex (int index) {
            this.index = index;
        }
    }

}
