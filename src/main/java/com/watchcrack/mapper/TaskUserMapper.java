package com.watchcrack.mapper;

import com.hebtu.entity.TaskUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @InterfaceName TaskUserDao
* @Description (TaskUser)表数据库访问层
* @author makejava
* @date 2020-04-20 15:47:48
* @Version 1.0
**/
@Mapper
public interface TaskUserMapper {

   /**
    * @Description 添加TaskUser
    * @author makejava
    * @date 2020-04-20 15:47:48
    * @param taskUser 实例对象
    * @return 影响行数
    */
   int insert(TaskUser taskUser);

   /**
    * @Description 删除TaskUser
    * @author makejava
    * @date 2020-04-20 15:47:48
    * @param
    * @return 影响行数
    */
   int deleteKong(Integer taskId, Integer userId);
   int deleteByTaskId(Integer taskId);

   /**
    * @Description 查询单条数据
    * @author makejava
    * @date 2020-04-20 15:47:48
    * @param
    * @return 实例对象
    */
   List<TaskUser> queryByTaskId(Integer taskId);



   List<TaskUser> queryByUserId(Integer userId);
   /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-20 15:47:48
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   List<TaskUser> queryAll();
   List<TaskUser> queryByUAT(Integer UserId, Integer TaskId);
   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-20 15:47:48
    * @param taskUser 实例对象
    * @return 对象列表
    */
   List<TaskUser> queryAll(TaskUser taskUser);

   /**
    * @Description 修改TaskUser
    * @author makejava
    * @date 2020-04-20 15:47:48
    * @param 根据taskUser的主键修改数据
    * @return 影响行数
    */
   int update(TaskUser taskUser);

}