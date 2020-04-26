package com.watchcrack.service;

import com.hebtu.entity.Major;

import java.util.List;


/**
 * @InterfaceName MajorService
 * @Description (Major)表服务接口
 * @author makejava
 * @date 2020-04-18 17:05:30
 * @Version 1.0
 **/
public interface MajorService {

    /**
     * @Description 添加Major
     * @author makejava
     * @date 2020-04-18 17:05:30
     * @param major 实例对象
     * @return 是否成功
     */
    boolean insert(Major major);

    /**
     * @Description 删除Major
     * @author makejava
     * @date 2020-04-18 17:05:30
     * @param majorId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer majorId);

    /**
     * @Description 查询单条数据
     * @author makejava
     * @date 2020-04-18 17:05:30
     * @param majorId 主键
     * @return 实例对象
     */
    Major queryById(Integer majorId);

    /**
     * @Description 查询全部数据
     * @author makejava
     * @date 2020-04-18 17:05:30
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */

    /**
     * @Description 修改数据，哪个属性不为空就修改哪个属性
     * @author makejava
     * @date 2020-04-18 17:05:30
     * @param major 实例对象
     * @return 是否成功
     */
    boolean update(Major major);

    List<Major> queryAll();
    List<Major> queryBycollegeId(Integer collegeId);

}