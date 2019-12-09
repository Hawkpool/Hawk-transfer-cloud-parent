package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn2;
import org.tuliu.land.transfer.tuliutransfercloudparent.mapper.TestLcn2Mapper;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.BussinessA;

/**
 * @author sandy
 * @title: BussinessAImpl
 * @projectName transfer-cloud-parent
 * @description: TODO
 * @date 2019/11/28 0028下午 3:22
 */
@Service
public class BussinessAImpl implements BussinessA {

    Logger logger = LoggerFactory.getLogger(BussinessAImpl.class);

    @Autowired
    TestLcn2Mapper testLcn2Mapper;

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    public void testA(TestLcn2 testLcn2) throws Exception {
        System.out.println("test A ");
        logger.info("test A ");
        testLcn2Mapper.insertSelective(testLcn2);
        throw new Exception();
    }
}
