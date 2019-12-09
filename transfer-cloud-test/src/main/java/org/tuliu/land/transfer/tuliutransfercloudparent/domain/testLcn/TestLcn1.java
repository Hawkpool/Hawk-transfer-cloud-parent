package org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn1")
@Data
public class TestLcn1 {
    @ApiModelProperty(value="id主键")
    private Integer id;

    @ApiModelProperty(value="a1")
    private String a1;

    @ApiModelProperty(value="b1")
    private String b1;

    @ApiModelProperty(value="c1")
    private String c1;
}