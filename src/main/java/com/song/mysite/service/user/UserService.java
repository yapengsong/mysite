package com.song.mysite.service.user;

import com.github.pagehelper.PageHelper;
import com.song.mysite.dao.UserDao;
import com.song.mysite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/1/2 0002.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public int saveUser(User user){
        return userDao.insert(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAllUser(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return  userDao.findUsers();
    }
}
