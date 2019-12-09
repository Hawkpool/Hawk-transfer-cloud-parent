package org.tuliu.land.transfer.tuliutransfercloudparent.mapper.biz;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn3;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn3Criteria;

@Repository
public interface TestLcn3Mapper {
    int countByExample(TestLcn3Criteria example);

    int deleteByExample(TestLcn3Criteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestLcn3 record);

    int insertSelective(TestLcn3 record);

    List<TestLcn3> selectByExample(TestLcn3Criteria example);

    TestLcn3 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestLcn3 record, @Param("example") TestLcn3Criteria example);

    int updateByExample(@Param("record") TestLcn3 record, @Param("example") TestLcn3Criteria example);

    int updateByPrimaryKeySelective(TestLcn3 record);

    int updateByPrimaryKey(TestLcn3 record);
}
