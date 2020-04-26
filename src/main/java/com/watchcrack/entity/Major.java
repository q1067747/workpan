package com.watchcrack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Major)实体类
 *
 * @author makejava
 * @since 2020-04-18 16:28:30
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Major implements Serializable {
    private static final long serialVersionUID = -57135887705658205L;
    /**
    * 专业ID
    */
    private Integer majorId;
    /**
    * 学院ID
    */
    private Integer collegeId;
    /**
    * 专业名称
    */
    private String majorName;

}