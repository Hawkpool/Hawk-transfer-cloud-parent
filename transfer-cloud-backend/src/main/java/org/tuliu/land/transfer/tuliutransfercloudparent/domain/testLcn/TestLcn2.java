package org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn2")
@Data
public class TestLcn2 {
    @ApiModelProperty(value="id")
    private Integer id;

    @ApiModelProperty(value="a2")
    private String a2;

    @ApiModelProperty(value="b2")
    private String b2;

    @ApiModelProperty(value="c2")
    private String c2;
}