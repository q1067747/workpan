package com.watchcrack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-18 16:28:30
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 548949001047789522L;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 密码
    */
    private byte[] pwd;
    /**
    * 学号
    */
    private String studentId;
    /**
    * 姓名
    */
    private String userName;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 学院ID
    */
    private Integer collegeId;
    /**
    * 专业ID
    */
    private Integer majorId;
    /**
    * 用户组
    */
    private Integer groupId;
    /**
    * 文件仓库ID
    */
    private Integer fileStoreId;
    /**
    * 注册时间
    */
    private Date registerTime;



    public String getGrade()
    {
        return studentId.toString().substring(0,4);
    }



}