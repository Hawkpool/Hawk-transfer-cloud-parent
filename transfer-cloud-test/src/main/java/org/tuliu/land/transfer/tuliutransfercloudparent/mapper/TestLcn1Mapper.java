package org.tuliu.land.transfer.tuliutransfercloudparent.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn1;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn1Criteria;

@Repository
public interface TestLcn1Mapper {
    int countByExample(TestLcn1Criteria example);

    int deleteByExample(TestLcn1Criteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestLcn1 record);

    int insertSelective(TestLcn1 record);

    List<TestLcn1> selectByExample(TestLcn1Criteria example);

    TestLcn1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestLcn1 record, @Param("example") TestLcn1Criteria example);

    int updateByExample(@Param("record") TestLcn1 record, @Param("example") TestLcn1Criteria example);

    int updateByPrimaryKeySelective(TestLcn1 record);

    int updateByPrimaryKey(TestLcn1 record);
}
