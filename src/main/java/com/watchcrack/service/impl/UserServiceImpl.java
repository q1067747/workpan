package com.watchcrack.service.impl;

import com.hebtu.entity.User;
import com.hebtu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @ClassName UserServiceImpl
* @Description (User)表服务实现类
* @author makejava
* @date 2020-04-18 16:28:30
* @Version 1.0
**/
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {


   /**
    * @Description 添加User
    * @author makejava
    * @date 2020-04-18 16:28:30
    * @param user 实例对象
    * @return 是否成功
    */
   @Override
   public boolean insert(User user) {
       if(userMapper.insert(user) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 删除User
    * @author makejava
    * @date 2020-04-18 16:28:30
    * @param userId 主键
    * @return 是否成功
    */
   @Override
   public boolean deleteById(Integer userId) {
       if(userMapper.deleteById(userId) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 查询单条数据
    * @author makejava
    * @date 2020-04-18 16:28:30
    * @param userId 主键
    * @return 实例对象
    */
   @Override
   public User queryById(Integer userId) {
       return userMapper.queryById(userId);
   }

    @Override
    public User queryByStudentId(String studentId) {
        return userMapper.getUserByStudentId(studentId);
    }

    @Override
    public List<Integer> queryByGrade(String grade,Integer majorId) {
        return  userMapper.queryByGrade(grade,majorId);
    }

    /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-18 16:28:30
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   @Override
   public List<User> queryAll() {
       return userMapper.queryAll();
   }

   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-18 16:28:30
    * @param user 实例对象
    * @return 对象列表
    */
   @Override
   public List<User> queryAll(User user) {
       return userMapper.queryAll(user);
   }

   /**
    * @Description 修改数据，哪个属性不为空就修改哪个属性
    * @author makejava
    * @date 2020-04-18 16:28:30
    * @param user 实例对象
    * @return 是否成功
    */
   @Override
   public boolean update(User user) {
       if(userMapper.update(user) == 1){
           return true;
       }
       return false;
   }

}