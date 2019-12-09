package org.tuliu.land.transfer.tuliutransfercloudparent.domain.constant;

public class BusinessConstant {

    /**
     * 数据状态
     */
    public static final int DELETED = 0;
    public static final int NORMAL = 1;

    /**
     * 流程启用标识
     */
    public static class WorkflowEnableFlag {
        public static final int SAVED = 0; //暂存
        public static final int ENABLED = 1; //启用
        public static final int DISABLED = 2; //禁用
    }

    /**
     * 流程节点属性
     */
    public static class WorkflowItemProp {
        public static final String START = "start";
        public static final String START_NAME = "提交审核";
        public static final String END_NAME = "结束审核";
        public static final String END = "end";
    }

    /**
     * 流程节点待办事项类型
     */
    public static class WorkflowItemTodoType{
        public static final int DOC = 1; //资料上传
        public static final int FORM = 2; //表单填写
    }

    public static class ApproverObjType {
        public static final String USER = "1"; //指定人处理
        public static final String ROLE = "2"; //指定角色处理
        public static final String CREATOR = "3"; //创建人处理
    }

}
