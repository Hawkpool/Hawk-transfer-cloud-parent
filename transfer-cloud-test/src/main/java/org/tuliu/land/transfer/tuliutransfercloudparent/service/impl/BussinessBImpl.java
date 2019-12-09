package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.BussinessA;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.BussinessB;

/**
 * @author sandy
 * @title: BussinessAImpl
 * @projectName transfer-cloud-parent
 * @description: TODO
 * @date 2019/11/28 0028下午 3:22
 */
@Service
public class BussinessBImpl implements BussinessB {

    Logger logger = LoggerFactory.getLogger(BussinessBImpl.class);

    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    @Override
    public void testB() {
        System.out.println("test bbb");
    }
}
