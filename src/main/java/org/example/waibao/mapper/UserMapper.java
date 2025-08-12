package org.example.waibao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.waibao.pojo.User;

@Mapper
public interface UserMapper {
    Boolean registerNewUser(User user);
    User login(String username, String password);
}
