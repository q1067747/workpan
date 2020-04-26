package com.watchcrack.service;

import com.hebtu.entity.TaskUser;
import com.hebtu.mapper.TaskUserMapper;

import java.util.List;

/**
 * @InterfaceName TaskUserService
 * @Description (TaskUser)表服务接口
 * @author makejava
 * @date 2020-04-20 15:45:11
 * @Version 1.0
 **/
public interface TaskUserService {

    /**
     * @Description 添加TaskUser
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param taskUser 实例对象
     * @return 是否成功
     */
    boolean insert(TaskUser taskUser);
    List<TaskUser> queryByUAT(Integer userId, Integer taskId);
    /**
     * @Description 删除TaskUser
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param  主键
     * @return 是否成功
     */
    boolean deleteKong(Integer taskId, Integer userId);

    boolean deleteByTaskId(Integer taskId);

    /**
     * @Description 查询全部数据
     * @author makejava
     * @date 2020-04-20 15:45:11
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<TaskUser> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param taskUser 实例对象
     * @return 对象列表
     */
    List<TaskUser> queryAll(TaskUser taskUser);

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param taskUser 实例对象
     * @return 是否成功
     */
    boolean update(TaskUser taskUser);

    List<TaskUser> queryByTaskId(Integer taskId);
    List<TaskUser> queryByUserId(Integer userId);

}