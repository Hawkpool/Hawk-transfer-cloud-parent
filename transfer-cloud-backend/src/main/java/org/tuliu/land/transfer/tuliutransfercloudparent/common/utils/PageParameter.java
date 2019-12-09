package org.tuliu.land.transfer.tuliutransfercloudparent.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页参数类
 *
 */
@ApiModel(value="org.tuliu.form.common.utils.PageParameter")
@ToString
public class PageParameter implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int DEFAULT_CURRENT_PAGE = 1;
    public static final int DEFAULT_APP_PAGE_SIZE = 10;

    @ApiModelProperty("每页显示条数")
    private int pageSize;
    @ApiModelProperty("当前页码值")
    private int pageNumber;
    private int prePage;
    @ApiModelProperty("下一页页码值")
    private int nextPage;
    @ApiModelProperty("最大页码数")
    private int maxPageNumber;
    @ApiModelProperty("总条数")
    private int totalCount;


    @ApiModelProperty("总页码")
    private int pageCount;

    private List<?> list;

    public PageParameter() {
        this.pageNumber = DEFAULT_CURRENT_PAGE;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    /**
     * @param currentPage
     * @param pageSize
     */
    public PageParameter(int currentPage, int pageSize) {
        if (currentPage > 0) {
            this.pageNumber = currentPage;
        } else {
            this.pageNumber = DEFAULT_CURRENT_PAGE;
        }
        if (pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }

    }

    /**
     * @param currentPage
     * @param pageSize
     */
    public PageParameter(Integer currentPage, Integer pageSize) {
        if (currentPage != null && currentPage > 0) {
            this.pageNumber = currentPage;
        } else {
            this.pageNumber = DEFAULT_CURRENT_PAGE;
        }
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }

    }

    // app请求专用
    public PageParameter(String pageStart, String pageSize, String source) {

        if (StringUtils.isEmpty(pageSize)) {
            this.pageSize = DEFAULT_APP_PAGE_SIZE;
        } else {
            this.pageSize = Integer.parseInt(pageSize);
        }
        if (StringUtils.isEmpty(pageStart)) {
            this.pageNumber = 1;
        } else {
            this.pageNumber = Integer.parseInt(pageStart) / this.pageSize + 1;
        }
    }

    public PageParameter(String currentPage, String pageSize) {
        this.pageNumber = currentPage == null ? DEFAULT_CURRENT_PAGE : Integer.parseInt(currentPage);
        this.pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : Integer.parseInt(pageSize);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getMaxPageNumber() {
        return maxPageNumber;
    }

    public void setMaxPageNumber(int maxPageNumber) {
        this.maxPageNumber = maxPageNumber;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("pageSize : ").append(pageSize).append(", ");
        sb.append("currentPage : ").append(pageNumber).append(", ");
        sb.append("prePage : ").append(prePage).append(", ");
        sb.append("nextPage : ").append(nextPage).append(", ");
        sb.append("totalPage : ").append(maxPageNumber).append(", ");
        sb.append("totalCount : ").append(totalCount);

        return sb.toString();
    }
}
