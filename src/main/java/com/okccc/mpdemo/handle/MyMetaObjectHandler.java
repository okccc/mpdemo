package com.okccc.mpdemo.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: okccc
 * Date: 2021/4/22 下午2:30
 * Desc: 元数据对象处理器接口
 */

@Component  // 表示交给spring管理
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 使用mp进行insert操作时会执行该方法
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
    }

    // 使用mp进行update操作时会执行该方法
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("update_time", new Date(), metaObject);
    }
}
