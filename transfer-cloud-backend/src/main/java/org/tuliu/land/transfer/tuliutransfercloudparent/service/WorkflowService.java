package org.tuliu.land.transfer.tuliutransfercloudparent.service;

import org.apache.poi.ss.formula.functions.T;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.RestAPIResult;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.exception.BusinessException;

/**
 * @Title: WorkflowService
 * @Description: 工作流相关服务接口
 * @author: xz
 * @date 2019/12/4 0004 08:58
 */
public interface WorkflowService {

    /**
     * 提交审批
     * @param userId
     * @param orderId
     */
    RestAPIResult<T> submitApprove(String userId, String orderId) throws BusinessException;

    /**
     * 测试分布式事务
     * @return
     */
    RestAPIResult<T> testDistributeTransaction();

}
