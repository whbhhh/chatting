package com.whb.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 招聘信息表
 */
@Data
@Entity
@Table(name = "tb_recruit")
public class Recruit {

    private String id;
    @ApiModelProperty("招聘职位")
    private String jobname;
    @ApiModelProperty("薪资范围")
    private String salary;
    @ApiModelProperty("经验要求")
    private String condition;
    @ApiModelProperty("学历要求")
    private String education;
    @ApiModelProperty("任职方式")
    private String type;
    @ApiModelProperty("办公地址")
    private String address;
    @ApiModelProperty("企业ID")
    private String eid;
    @ApiModelProperty("发布日期")
    private Date createTime;
    @ApiModelProperty("状态 0：关闭 1：开启 2：推荐")
    private String state;
    @ApiModelProperty("原网址")
    private String url;
    @ApiModelProperty("标签")
    private String label;
    @ApiModelProperty("职位描述")
    private String content1;
    @ApiModelProperty("职位要求")
    private String content2;
}
