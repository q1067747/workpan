package com.watchcrack.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.*;

/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2020-04-20 15:43:42
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = -11226357127728094L;
    /**
    * 作业ID
    */
    private Integer taskId;
    /**
    * 作业名称
    */
    private String taskName;
    /**
    * 设置作业用户
    */
    private String createUserName;
    /**
     * 设置作业用户ID
     */
    private Integer createUserId;
    /**
    * 作业备注
    */
    private String notice;
    /**
    * 截止时间
    */
    private Date deadTime;

}