package com.song.mysite.controller;

import com.song.mysite.model.User;
import com.song.mysite.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/1/2 0002.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController  {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public int addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/list")
    public Object findAllUser(@RequestParam(name="pageNum",required = false,defaultValue = "1")int pageNum,@RequestParam(name="pageSize",required = false,defaultValue = "10")int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}
