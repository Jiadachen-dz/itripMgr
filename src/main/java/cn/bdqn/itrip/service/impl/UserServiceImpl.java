package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.UserMapper;
import cn.bdqn.itrip.pojo.User;
import cn.bdqn.itrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User login(String userCode,String password) {
        return userMapper.login(userCode,password);
    }


    @Override
    public int register(String userCode, String nickname, String password) {
        return userMapper.register(userCode,nickname,password);
    }
}
