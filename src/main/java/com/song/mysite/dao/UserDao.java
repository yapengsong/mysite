package com.song.mysite.dao;

import com.song.mysite.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/1/2 0002.
 */

@Mapper
@Repository
public interface UserDao {
    @Options(useGeneratedKeys =true,keyProperty = "userId")
    @Insert("insert into user(username,password,phone) values(#{username},#{password},#{phone})")
    int insert(User user);

    @Select("select * from user ")
    List<User> findUsers();
}
