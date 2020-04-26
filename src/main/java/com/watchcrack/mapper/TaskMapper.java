package com.watchcrack.mapper;

import com.hebtu.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @InterfaceName TaskDao
* @Description (Task)表数据库访问层
* @author makejava
* @date 2020-04-20 15:47:52
* @Version 1.0
**/
@Mapper
public interface TaskMapper {

   /**
    * @Description 添加Task
    * @author makejava
    * @date 2020-04-20 15:47:52
    * @param task 实例对象
    * @return 影响行数
    */
   int insert(Task task);

   /**
    * @Description 删除Task
    * @author makejava
    * @date 2020-04-20 15:47:52
    * @param taskId 主键
    * @return 影响行数
    */
   int deleteById(Integer taskId);

   /**
    * @Description 根据taskID查询
    * @author makejava
    * @date 2020-04-20 15:47:52
    * @param taskId 主键
    * @return 实例对象
    */
   Task queryByTaskId(Integer taskId);
   /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-20 15:47:52
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   List<Task> queryAll();

   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-20 15:47:52
    * @param task 实例对象
    * @return 对象列表
    */
   List<Task> queryAll(Task task);

   /**
    * @Description 修改Task
    * @author makejava
    * @date 2020-04-20 15:47:52
    * @param 根据task的主键修改数据
    * @return 影响行数
    */
   int update(Task task);

}