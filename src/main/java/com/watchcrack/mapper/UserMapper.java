package com.watchcrack.mapper;

import com.hebtu.entity.User;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName: MyFileMapper
 * @Description: 与用户相关的数据库操作
 * @author: ylj
 * @date 2020/1/26 21:55
 * @Version: 1.0
 **/
@Mapper
public interface UserMapper {

    /**
     * @Description 添加User
     * @author ylj
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);
    
    /**
     * @Description 删除User
     * @author ylj
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

    /**
     * @Description 通过ID查询单条数据
     * @author ylj
     * @date 2020-02-25 17:19:31
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * @Description 通过studentID查询单条数据
     * @author ylj
     * @param StudentId
     * @return
     */
    User getUserByStudentId(String StudentId);

    /**
     * @Description 查询所有
     * @return 对象列表
     */
    List<User> queryAll();

    /**
     * @Description 实体作为筛选条件查询数据
     * @author ylj
     * @date 2020-02-25 17:19:31
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * @Description 修改User
     * @author ylj
     * @date 2020-02-25 17:19:31
     * @return 影响行数
     */
    int update(User user);


    @Select("select user_id from user where substring(student_id,1,4) = #{grade} AND CHAR_LENGTH(student_id)=10 AND major_id=#{majorId}")
    List<Integer> queryByGrade(String grade, Integer majorId);

}