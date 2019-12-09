package org.tuliu.land.transfer.tuliutransfercloudparent.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiModel(value="org.tuliu.form.common.utils.ResultMessage")
public class ResultMessage<T extends Object> implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String DATA_TYPE_JSON = "json";
    public static final String DATA_TYPE_CIPHER = "cipher";

    @ApiModelProperty(value="状态码")
    private String code = StatusMessage.Status.CODE_200.getName();
    @ApiModelProperty(value="状态信息")
    private String msg = StatusMessage.Message.MSG_200.getName();
    private PageParameter pagination;
    private Long timestamp;
    private String domain;
    private String dataType = DATA_TYPE_JSON;
    private T data;
    private Map<String, Object> attributes = new HashMap<String, Object>();

    public ResultMessage()
    {
    }
    public ResultMessage(String code,String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public ResultMessage(int enumIndex){
        this.code = StatusMessage.Status.getName(enumIndex);
        this.msg = StatusMessage.Message.getName(enumIndex);
    }
    public ResultMessage(T data)
    {
        this(null, data);
    }

    public ResultMessage(PageParameter pagination, T data)
    {
        this.pagination = pagination;
        this.data = data;

        if (data instanceof List)
        {
            List<?> list = (List<?>) data;
            if (pagination != null)
            {
                pagination.setPageCount(list.size());
            }
        }
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public void setStatusMessage(int enumIndex){
        this.code = StatusMessage.Status.getName(enumIndex);
        this.msg = StatusMessage.Message.getName(enumIndex);
    }

    public String getDataType()
    {
        return dataType;
    }

    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setData(T data,PageParameter pagination)
    {
        this.data = data;
        this.pagination = pagination;
    }

    public PageParameter getPagination()
    {
        return pagination;
    }

    public void setPagination(PageParameter pagination)
    {
        this.pagination = pagination;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Long timestamp)
    {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getAttributes()
    {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes)
    {
        this.attributes = attributes;
    }

    @JsonIgnore
    public String getDomain()
    {
        return domain;
    }
    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
