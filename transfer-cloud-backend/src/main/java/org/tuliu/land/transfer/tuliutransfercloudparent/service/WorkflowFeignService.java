package org.tuliu.land.transfer.tuliutransfercloudparent.service;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.RestAPIResult;

/**
 * @Title: WorkflowFeignService
 * @Description: 工作流feign服务接口
 * @author: xz
 * @date 2019/11/29 0029 10:15
 */
@FeignClient(value = "microservice-transfer-workflow")
public interface WorkflowFeignService {

    /**
     * 保存工作流流程
     * @param userId
     * @param bizType
     * @param param1
     * @param param2
     * @param name
     * @param json
     * @return 流程ID
     */
    @PostMapping(value="/api/workflow/save")
    RestAPIResult<T> saveWorkflow(
            @RequestParam("userId") String userId,
            @RequestParam("tid") String tid,
            @RequestParam("bizType") Integer bizType,
            @RequestParam("param1") String param1,
            @RequestParam("param2") String param2,
            @RequestParam("name") String name,
            @RequestParam("json") String json
    );

    /**
     * 启用/禁用流程
     * @param userId
     * @param tid
     * @param enableFlag
     * @return
     */
    @PostMapping(value="/api/workflow/updateEnableFlag")
    RestAPIResult<T> updateEnableFlag(
            @RequestParam("userId") String userId,
            @RequestParam("tid") String tid,
            @RequestParam("enableFlag") Integer enableFlag
    );

    /**
     * 提交审批
     * @param userId
     * @param workflowId
     * @param orderId
     * @return
     */
    @PostMapping(value="/api/workflow/submitApprove")
    RestAPIResult<T> submitApprove(
            @RequestParam("userId") String userId,
            @RequestParam("workflowId") String workflowId,
            @RequestParam("orderId") String orderId
    );

    /**
     * 审批通过
     * @param userId
     * @param orderId
     * @return
     */
    @PostMapping(value="/api/workflow/passApprove")
    RestAPIResult<T> passApprove(
            @RequestParam("userId") String userId,
            @RequestParam("orderId") String orderId
    );

    /**
     * 审批驳回
     * @param userId
     * @param orderId
     * @param workflowItemId
     * @return
     */
    @PostMapping(value="/api/workflow/rejectApprove")
    RestAPIResult<T> rejectApprove(
            @RequestParam("userId") String userId,
            @RequestParam("orderId") String orderId,
            @RequestParam("workflowItemId") String workflowItemId
    );

    @PostMapping(value="/api/workflow/testDistributeTransaction")
    RestAPIResult<T> testDistributeTransaction();

}
