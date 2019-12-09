package org.tuliu.land.transfer.tuliutransfercloudparent.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn2;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn2Criteria;

@Repository
public interface TestLcn2Mapper {
    int countByExample(TestLcn2Criteria example);

    int deleteByExample(TestLcn2Criteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestLcn2 record);

    int insertSelective(TestLcn2 record);

    List<TestLcn2> selectByExample(TestLcn2Criteria example);

    TestLcn2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestLcn2 record, @Param("example") TestLcn2Criteria example);

    int updateByExample(@Param("record") TestLcn2 record, @Param("example") TestLcn2Criteria example);

    int updateByPrimaryKeySelective(TestLcn2 record);

    int updateByPrimaryKey(TestLcn2 record);
}
