package com.okccc.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * Author: okccc
 * Date: 2021/4/21 下午1:56
 * Desc: 
 */

@Data  // lombok可以简化实体类,会自动实现属性的get/set方法以及构造器等一系列方法,可通过Structure查看
public class User {

    // 设置主键生成策略
    // AUTO 自增长 | UUID 随机字符串,不好排序 | None 不设置
    // ID_WORKER      mybatis-plus自带策略,生成19位值,适用于Long类型的id
    // ID_WORKER_STR  mybatis-plus自带策略,生成19位值,适用于String类型的id
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    // 添加自动填充属性的注解
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
