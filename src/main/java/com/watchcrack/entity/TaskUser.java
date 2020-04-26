package com.watchcrack.entity;

import java.io.Serializable;

import lombok.*;

/**
 * (TaskUser)实体类
 *
 * @author makejava
 * @since 2020-04-20 15:46:11
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TaskUser implements Serializable {
    private static final long serialVersionUID = -73283841184782819L;
    /**
    * 作业ID
    */
    private Integer taskId;
    /**
    * 主人ID
    */
    private Integer userId;
    /**
    * 文件ID
    */
    private Integer myFileId;

}