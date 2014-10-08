/*
 * Copyright 2014 Jwsz.net All right reserved. This software is the
 * confidential and proprietary information of Jwsz.net ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Jwsz.net.
 */
package com.codestudio.dorm.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 类Functions.java的实现描述：功能菜单
 * 
 * @author J 2014-5-17 下午6:18:10
 */
public class Functions implements Serializable {

    private static final long serialVersionUID = -6686631064514421616L;

    private Long              id;
    private Long              parentId;                                 // 父功能
    private String            text;                                     // 功能名称
    private boolean           isLeaf;                                   // 是否叶子节点
    private String            url;                                      // URL地址
    private String            remark;                                   // 备注
    private Integer           orderNum;                                 // 排序号
    private boolean           enable;                                   // 是否启用
    private Date              createDate;                               // 创建时间
    private Date              updateDate;                               // 修改时间

    public Long getId() {
        return id;
    }

    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Functions [id=" + id + ", parentId=" + parentId + ", text=" + text + ", isLeaf=" + isLeaf + ", url="
               + url + ", remark=" + remark + ", orderNum=" + orderNum + ", enable=" + enable + ", createDate="
               + createDate + ", updateDate=" + updateDate + "]";
    }

}
