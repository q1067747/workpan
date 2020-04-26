package com.watchcrack.service.impl;

import com.hebtu.entity.Major;
import com.hebtu.service.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @ClassName MajorServiceImpl
* @Description (Major)表服务实现类
* @author makejava
* @date 2020-04-18 17:05:30
* @Version 1.0
**/
@Service
public class MajorServiceImpl extends BaseService implements MajorService {

   /**
    * @Description 添加Major
    * @author makejava
    * @date 2020-04-18 17:05:30
    * @param major 实例对象
    * @return 是否成功
    */
   @Override
   public boolean insert(Major major) {
       if(majorMapper.insert(major) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 删除Major
    * @author makejava
    * @date 2020-04-18 17:05:30
    * @param majorId 主键
    * @return 是否成功
    */
   @Override
   public boolean deleteById(Integer majorId) {
       if(majorMapper.deleteById(majorId) == 1){
           return true;
       }
       return false;
   }

   /**
    * @Description 查询单条数据
    * @author makejava
    * @date 2020-04-18 17:05:30
    * @param majorId 主键
    * @return 实例对象
    */
   @Override
   public Major queryById(Integer majorId) {
       return majorMapper.queryById(majorId);
   }

   /**
    * @Description 查询全部数据
    * @author makejava
    * @date 2020-04-18 17:05:30
    * 分页使用MyBatis的插件实现
    * @return 对象列表
    */
   /**
    * @Description 实体作为筛选条件查询数据
    * @author makejava
    * @date 2020-04-18 17:05:30
    * @param major 实例对象
    * @return 对象列表
    */

   /**
    * @Description 修改数据，哪个属性不为空就修改哪个属性
    * @author makejava
    * @date 2020-04-18 17:05:30
    * @param major 实例对象
    * @return 是否成功
    */
   @Override
   public boolean update(Major major) {
       if(majorMapper.update(major) == 1){
           return true;
       }
       return false;
   }

    @Override
    public List<Major> queryAll() {
        return majorMapper.queryAll();
    }

    @Override
    public List<Major> queryBycollegeId(Integer collegeId) {
        return majorMapper.queryBycollegeId(collegeId);
    }

}