package com.okccc.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.okccc.mpdemo.entity.User;
import com.okccc.mpdemo.mapper.UserMapper;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    // 查询操作
    @Test
    public void select() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    // 复杂查询
    @Test
    public void selectQuery() {
        // 创建QueryWrapper对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 设置查询条件
        queryWrapper.gt("age", 19);
        queryWrapper.between("age", 18, 25);
        queryWrapper.like("name", "tom");
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 3");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    // 插入操作
    @Test
    public void insert() {
        var user = new User();
        user.setName("sky");
        user.setAge(23);
        user.setEmail("bbb@qq.com");
        userMapper.insert(user);
        System.out.println(user);
    }

    // 乐观锁更新操作
    @Test
    public void update() {
        // 先查询
        User user = userMapper.selectById(1);
        // 再修改
        user.setAge(20);
        userMapper.updateById(user);
    }

    // 分页查询
    @Test
    public void page() {
        // 创建Page对象
        Page<User> page = new Page<>(2, 10);
        // 调用mp的分页查询方法,查询的数据都封装在Page对象里面
        userMapper.selectPage(page, null);
        // 通过Page对象获取分页数据
        System.out.println(page.getCurrent());   // 当前页数
        System.out.println(page.getRecords());   // 每页数据的list集合
        System.out.println(page.getSize());      // 每页显示记录数
        System.out.println(page.getTotal());     // 总记录数
        System.out.println(page.getPages());     // 总页数
        System.out.println(page.hasNext());      // 是否有下一页
        System.out.println(page.hasPrevious());  // 是否有上一页
    }

    // 删除操作
    @Test
    public void delete() {
        userMapper.deleteById(5L);
//        userMapper.deleteBatchIds(Arrays.asList(1,2,3));
    }

}
