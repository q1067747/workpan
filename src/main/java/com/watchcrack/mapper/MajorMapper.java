package com.watchcrack.mapper;

import com.hebtu.entity.Major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorMapper {
    int insert(Major major);
    int deleteById(Integer majorId);
    Major queryById(Integer majorId);
    List<Major> queryBycollegeId(Integer collegeId);
    int update(Major major);
    @Select("select * from major")
    List<Major> queryAll();
}

