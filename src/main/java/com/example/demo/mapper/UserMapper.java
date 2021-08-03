package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> viewUser();
    User login(@Param("username") String username, @Param("password") String password);
    void setUser(String userid);
    void setRoot(String userid);

    int insertUserInfo(User user);
    String findUserNameByUserName(String username);
}
