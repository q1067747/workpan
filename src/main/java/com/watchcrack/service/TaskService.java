package com.watchcrack.service;

import com.hebtu.entity.Task;
import java.util.List;

/**
 * @InterfaceName TaskService
 * @Description (Task)表服务接口
 * @author makejava
 * @date 2020-04-20 15:45:11
 * @Version 1.0
 **/
public interface TaskService {

    /**
     * @Description 添加Task
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param task 实例对象
     * @return 是否成功
     */
    boolean insert(Task task);

    /**
     * @Description 删除Task
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param taskId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer taskId);

    /**
     * @Description 查询多条数据
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param taskId 主键
     * @return 实例对象
     */
    Task queryByTaskId(Integer taskId);
    /**
     * @Description 查询全部数据
     * @author makejava
     * @date 2020-04-20 15:45:11
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<Task> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param task 实例对象
     * @return 对象列表
     */
    List<Task> queryAll(Task task);

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author makejava
     * @date 2020-04-20 15:45:11
     * @param task 实例对象
     * @return 是否成功
     */
    boolean update(Task task);

}