package com.feilonkji.www.service.impl;

import com.feilonkji.www.dao.UserMapper;
import com.feilonkji.www.entity.User;
import com.feilonkji.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @title: UserService
 * @Description:
 * @Author zr
 * @Date:2020/9/25 9:57
 * @Version 1.8
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int regist(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User login(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userMapper.selectOne(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        return userMapper.selectOne(user);
    }

    @Override
    public User findByPhone(String phone) {
        return null;
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }


    @Override
    public void deleteByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        userMapper.delete(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     *
     * Description: 根据用户id查用户数据
     * @param id 用户id
     * @return com.feilonkji.www.entity.User
     * @throws
     * @date 2020/9/25
     */
    public User findById(String id){
        Long uid = Long.parseLong(id);
        User user = new User();
        user.setId(uid);
        return userMapper.selectOne(user);
    }
}
