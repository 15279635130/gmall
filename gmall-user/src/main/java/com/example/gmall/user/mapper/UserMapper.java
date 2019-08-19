package com.example.gmall.user.mapper;

import com.example.gmall.user.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    List<UmsMember> selectAllUsers();
}
