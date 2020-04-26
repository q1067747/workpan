package com.watchcrack.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (College)实体类
 *
 * @author makejava
 * @since 2020-04-20 15:43:42
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class College implements Serializable {
    private static final long serialVersionUID = -42134811058590455L;
    /**
    * 学院ID
    */
    private Integer collegeId;
    /**
    * 学院名称
    */
    private String collegeName;

}