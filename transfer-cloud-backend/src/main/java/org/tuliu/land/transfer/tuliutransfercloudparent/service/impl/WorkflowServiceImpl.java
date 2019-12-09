package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.RestAPIResult;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.biz.LeaveOrder;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.exception.BusinessException;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.WorkflowFeignService;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.WorkflowService;

/**
 * @Title: WorkflowServiceImpl
 * @Description: 工作流相关服务实现
 * @author: xz
 * @date 2019/12/4 0004 08:59
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private WorkflowFeignService workflowFeignService;

    @Autowired
    private LeaveOrderMapper leaveOrderMapper;

    @Override
    public RestAPIResult<T> submitApprove(String userId, String orderId) throws BusinessException {
        LeaveOrder leaveOrder = leaveOrderMapper.selectByPrimaryKey(orderId);
        if(leaveOrder == null) throw new BusinessException("该业务订单不存在");
        String workflowId = leaveOrder.getWorkflowId();
        return workflowFeignService.submitApprove(userId, workflowId, orderId);
    }

    @LcnTransaction
    @Transactional
    @Override
    public RestAPIResult<T> testDistributeTransaction() {
        //本地事务
        LeaveOrder leaveOrder = leaveOrderMapper.selectByPrimaryKey("1000001");
        leaveOrder.setCreateBy("11111");
        leaveOrderMapper.updateByPrimaryKeySelective(leaveOrder);
        //远程事务
        //return new RestAPIResult<>();
        return workflowFeignService.testDistributeTransaction();
    }

}
