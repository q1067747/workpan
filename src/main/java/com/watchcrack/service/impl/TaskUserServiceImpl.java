package com.watchcrack.service.impl;


import com.hebtu.entity.TaskUser;
import com.hebtu.service.TaskUserService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @ClassName TaskUserServiceImpl
* @Description (TaskUser)表服务实现类
* @author makejava
* @date 2020-04-20 15:45:11
* @Version 1.0
**/
@Service("taskUserService")
public class TaskUserServiceImpl extends BaseService implements TaskUserService {


   /**
    * @Description 添加TaskUser
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param taskUser 实例对象
    * @return 是否成功
    */
   @Override
   public boolean insert(TaskUser taskUser) {
       if(taskUserMapper.insert(taskUser) == 1){
           return true;
       }
       return false;
   }

    @Override
    public List<TaskUser> queryByUAT(Integer userId, Integer taskId) {
        return taskUserMapper.queryByUAT(userId,taskId);
    }

    /**
    * @Description 删除TaskUser
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @return 是否成功
    */
   @Override
   public boolean deleteKong(Integer taskId,Integer userId) {
       if(taskUserMapper.deleteKong(taskId,userId) == 1){
           return true;
       }
       return false;
   }

    @Override
    public boolean deleteByTaskId(Integer taskId) {
        if(taskUserMapper.deleteByTaskId(taskId) > 0){
            return true;
        }
        return false;
    }

    /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-20 15:45:11
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   @Override
   public List<TaskUser> queryAll() {
       return taskUserMapper.queryAll();
   }

   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param taskUser 实例对象
    * @return 对象列表
    */
   @Override
   public List<TaskUser> queryAll(TaskUser taskUser) {
       return taskUserMapper.queryAll(taskUser);
   }

   /**
    * @Description 修改数据，哪个属性不为空就修改哪个属性
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param taskUser 实例对象
    * @return 是否成功
    */
   @Override
   public boolean update(TaskUser taskUser) {
       if(taskUserMapper.update(taskUser) == 1){
           return true;
       }
       return false;
   }

    @Override
    public List<TaskUser> queryByTaskId(Integer taskId) {
        return taskUserMapper.queryByTaskId(taskId);
    }

    @Override
    public List<TaskUser> queryByUserId(Integer userId) {
        return taskUserMapper.queryByUserId(userId);
    }

}