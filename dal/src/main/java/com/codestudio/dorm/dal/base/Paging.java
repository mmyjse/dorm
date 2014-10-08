/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.dal.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类Paging.java的实现描述：分页
 * 
 * @author mmy 2014年5月1日 上午5:49:01
 */
public class Paging<E> implements Serializable {

    private static final long serialVersionUID     = -8137142208245970433L;

    private static final int  DEFAULT_DB_PAGE_SIZE = 10;

    /**
     * 查询的开始记录数
     */
    private Integer           start                = 0;

    /**
     * 当前的页码
     */
    private Integer           pageIndex            = 0;

    /**
     * 每页记录数
     */
    private Integer           pageSize             = 10;

    /**
     * 总的页码
     */
    private Integer           pageCount            = 0;

    /**
     * 记录总数
     */
    private Integer           totalCount           = 0;

    /**
     * 数据内容
     */
    private List<E>           datas;

    public Paging(){

    }

    public Paging(Integer start, Integer pageSize){
        this.start = start;
        this.pageSize = pageSize;
    }

    /**
     * 内存分页
     * 
     * @param list 包含所有记录的列表
     * @param pageIndex 页码
     * @param pageSize 每页大小
     */
    public Paging(Integer pageIndex, Integer pageSize, List<E> list){
        if (list == null || list.size() == 0) {
            this.setDatas(new ArrayList<E>(0));
            this.setStart(0);
        } else {
            // 默认分页
            if (pageIndex == null || pageIndex < 0) {
                pageIndex = 0;
            }
            if (pageSize == null || pageSize <= 0) {
                pageSize = 10;
            }

            int totalCount = list.size();
            int pageCount = 0;
            if (totalCount % pageSize == 0) {
                pageCount = totalCount / pageSize;
            } else {
                pageCount = (totalCount / pageSize) + 1;
            }

            if (pageIndex + 1 > pageCount) {
                pageIndex = pageCount - 1;
            }

            this.setPageIndex(pageIndex);
            this.setPageSize(pageSize);
            this.setPageCount(pageCount);
            this.setTotalCount(totalCount);
            this.setStart(pageIndex * pageSize);
            List<E> subList = new ArrayList<E>(
                                               list.subList(pageIndex * pageSize,
                                                            (pageIndex + 1) * pageSize > totalCount ? totalCount : (pageIndex + 1)
                                                                                                                   * pageSize));
            this.setDatas(subList);
        }
    }

    /**
     * 数据库分页
     * 
     * @param datas
     * @param start
     * @param pageSize
     * @param totalCount
     */
    public Paging(List<E> datas, Integer start, Integer pageSize, Integer totalCount){
        super();
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }

        int pageCount = 0;
        if (totalCount % pageSize == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = (totalCount / pageSize) + 1;
        }
        this.start = start;
        this.pageIndex = (start / pageSize) + 1;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
        this.datas = datas;
    }

    public static Integer getStartIndex(Integer currentPage, Integer pageSize) {
        if (currentPage == null) {
            currentPage = 1;
        } else {
            currentPage = currentPage + 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAULT_DB_PAGE_SIZE;
        }
        Integer start = (currentPage - 1) * pageSize;
        return start;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> datas) {
        this.datas = datas;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Paging [start=" + start + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", pageCount="
               + pageCount + ", totalCount=" + totalCount + ", datas=" + datas + "]";
    }

}
