/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.dal.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 类BaseDao.java的实现描述：DAO基类
 * 
 * <pre>
 * T    实体类型
 * C    条件类型
 * </pre>
 * 
 * @author mmy 2014年5月1日 上午5:45:36
 */
public interface BaseDao<T, C> {

    /**
     * 插入记录
     * 
     * @param t
     */
    public void create(T t);

    /**
     * 修改记录
     * 
     * @param t
     */
    public int update(T t);

    /**
     * 删除记录
     * 
     * @param id
     */
    public int delete(Long id);

    /**
     * 通过ID获取记录
     * 
     * @param id
     * @return
     */
    public T get(Long id);

    /**
     * 获取所有结果
     * 
     * @return
     * @author J 2013-9-16 上午2:32:22
     */
    public List<T> getAll();

    /**
     * 获取结果集合
     * 
     * @param param 条件
     * @param pageIndex 页码
     * @param pageSize 每页大小
     * @return
     */
    public List<T> findByCondition(@Param("param") C param, @Param("pageIndex") int pageIndex,
                                   @Param("pageSize") int pageSize);

    /**
     * 获取总行数
     * 
     * @param param 条件
     * @return
     */
    public int countByCondition(@Param("param") C param);
}