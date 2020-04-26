package com.watchcrack.service.impl;

import com.hebtu.entity.Task;
import com.hebtu.service.TaskService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @ClassName TaskServiceImpl
* @Description (Task)表服务实现类
* @author makejava
* @date 2020-04-20 15:45:11
* @Version 1.0
**/
@Service("taskService")
public class TaskServiceImpl extends BaseService implements TaskService {

   /**
    * @Description 添加Task
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param task 实例对象
    * @return 是否成功
    */
   @Override
   public boolean insert(Task task) {
       if(taskMapper.insert(task) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 删除Task
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param taskId 主键
    * @return 是否成功
    */
   @Override
   public boolean deleteById(Integer taskId) {
       if(taskMapper.deleteById(taskId) == 1){
           return true;
       }
       return false;
   }

    /**
     * @param taskId 主键
     * @return 实例对象
     * @Description 查询多条数据
     * @author makejava
     * @date 2020-04-20 15:45:11
     */
    @Override
    public Task queryByTaskId(Integer taskId) {
        return taskMapper.queryByTaskId(taskId);
    }

    /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-20 15:45:11
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   @Override
   public List<Task> queryAll() {
       return taskMapper.queryAll();
   }

   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param task 实例对象
    * @return 对象列表
    */
   @Override
   public List<Task> queryAll(Task task) {
       return taskMapper.queryAll(task);
   }

   /**
    * @Description 修改数据，哪个属性不为空就修改哪个属性
    * @author makejava
    * @date 2020-04-20 15:45:11
    * @param task 实例对象
    * @return 是否成功
    */
   @Override
   public boolean update(Task task) {
       if(taskMapper.update(task) == 1){
           return true;
       }
       return false;
   }

}