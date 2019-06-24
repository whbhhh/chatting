package com.whb.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 企业表
 */
@Entity
@Data
@Table(name = "tb_enterprise")
public class Enterprise {
    @Id
    private String id;
    private String name; //企业名称
    private String summary;//企业简介
    private String address;//企业地址
    private String labels;//企业标签，用逗号分隔
    private String coordinate;//企业位置坐标  经度 维度
    private String ishot;//是否热门  0:非热门 1：热门
    private String logo;
    private Integer jobcount;//职位数
    private String url;
}
