package com.watchcrack.mapper;

import com.hebtu.entity.College;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeMapper {
    int insert(College college);
    int deleteById(Integer collegeId);
    College queryById(Integer collegeId);
    List<College> queryAllByLimit();
    List<College> queryAll();

}
