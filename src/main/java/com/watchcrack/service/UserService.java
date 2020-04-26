package com.watchcrack.service;

import com.hebtu.entity.User;

import java.util.List;


/**
 * @InterfaceName UserService
 * @Description (User)表服务接口
 * @author makejava
 * @date 2020-04-18 16:28:30
 * @Version 1.0
 **/
public interface UserService {

    /**
     * @Description 添加User
     * @author makejava
     * @date 2020-04-18 16:28:30
     * @param user 实例对象
     * @return 是否成功
     */
    boolean insert(User user);

    /**
     * @Description 删除User
     * @author makejava
     * @date 2020-04-18 16:28:30
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * @Description 查询单条数据
     * @author makejava
     * @date 2020-04-18 16:28:30
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    User queryByStudentId(String studentId);

    List<Integer> queryByGrade(String grade, Integer majorId);
    /**
     * @Description 查询全部数据
     * @author makejava
     * @date 2020-04-18 16:28:30
     * 分页使用MyBatis的插件实现G
     * @return 对象列表
     */
    List<User> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @author makejava
     * @date 2020-04-18 16:28:30
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author makejava
     * @date 2020-04-18 16:28:30
     * @param user 实例对象
     * @return 是否成功
     */
    boolean update(User user);

}