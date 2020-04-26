package com.watchcrack.service;

import com.hebtu.entity.College;
import java.util.List;

/**
 * @InterfaceName CollegeService
 * @Description (College)表服务接口
 * @author makejava
 * @date 2020-04-18 17:09:57
 * @Version 1.0
 **/
public interface CollegeService {

    /**
     * @Description 添加College
     * @author makejava
     * @date 2020-04-18 17:09:57
     * @param college 实例对象
     * @return 是否成功
     */
    boolean insert(College college);

    /**
     * @Description 删除College
     * @author makejava
     * @date 2020-04-18 17:09:57
     * @param collegeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer collegeId);

    /**
     * @Description 查询单条数据
     * @author makejava
     * @date 2020-04-18 17:09:57
     * @param collegeId 主键
     * @return 实例对象
     */
    College queryById(Integer collegeId);

    /**
     * @Description 查询全部数据
     * @author makejava
     * @date 2020-04-18 17:09:57
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<College> queryAll();


}