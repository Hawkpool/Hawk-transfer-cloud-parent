package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn1;
import org.tuliu.land.transfer.tuliutransfercloudparent.mapper.biz.TestLcn1Mapper;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.TestLcnFeignService;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.TestLcnLocalService;

@Service
public class TestLcnLocalServiceImpl implements TestLcnLocalService {
    @Autowired
    TestLcnFeignService testLcnFeignService;
    @Autowired

    TestLcn1Mapper testLcn1Mapper;

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    public String testLcn(String a1,String b1,String c1) throws Exception {
        TestLcn1 testLcn1 = new TestLcn1();
        testLcn1.setA1(a1);
        testLcn1.setB1(b1);
        testLcn1.setC1(c1);

        testLcnFeignService.testLcn(a1,b1,c1);
        testLcn1Mapper.insertSelective(testLcn1);

        return "aaa";
    }
}
