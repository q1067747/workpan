package com.watchcrack.service.impl;

import com.hebtu.entity.College;
import com.hebtu.service.CollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @ClassName CollegeServiceImpl
* @Description (College)表服务实现类
* @author makejava
* @date 2020-04-18 17:09:57
* @Version 1.0
**/
@Service
public class CollegeServiceImpl extends BaseService implements CollegeService {



   /**
    * @Description 添加College
    * @author makejava
    * @date 2020-04-18 17:09:57
    * @param college 实例对象
    * @return 是否成功
    */
   @Override
   public boolean insert(College college) {
       if(collegeMapper.insert(college) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 删除College
    * @author makejava
    * @date 2020-04-18 17:09:57
    * @param collegeId 主键
    * @return 是否成功
    */
   @Override
   public boolean deleteById(Integer collegeId) {
       if(collegeMapper.deleteById(collegeId) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 查询单条数据
    * @author makejava
    * @date 2020-04-18 17:09:57
    * @param collegeId 主键
    * @return 实例对象
    */
   @Override
   public College queryById(Integer collegeId) {
       return collegeMapper.queryById(collegeId);
   }

   /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-18 17:09:57
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   @Override
   public List<College> queryAll() {
       return collegeMapper.queryAll();
   }

   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-18 17:09:57
    * @param college 实例对象
    * @return 对象列表
    */


}