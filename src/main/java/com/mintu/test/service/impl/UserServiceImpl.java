package com.mintu.test.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.mintu.test.dao.UserRepository;
import com.mintu.test.encoder.PasswordEncoder;
import com.mintu.test.entity.User;
import com.mintu.test.exception.AccountExistedException;
import com.mintu.test.exception.AccountNotExistException;
import com.mintu.test.exception.OriginPasswordIncorrectException;
import com.mintu.test.exception.PasswordIncorrectException;
import com.mintu.test.service.UserService;
import com.mintu.test.vo.PasswordVO;
import com.mintu.test.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Snowflake snowflake;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void add(User user) {
        User user1 = userRepository.getUserByAccount(user.getAccount());
        if (user1 != null){
            throw new AccountExistedException();
        }
        user.setId(snowflake.nextId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User login(UserVO userVO) {
        User user = userRepository.getUserByAccount(userVO.getAccount());
        if (user == null){
            throw new AccountNotExistException();
        }
        if (!(passwordEncoder.matches(userVO.getPassword(),user.getPassword()))){
            throw new PasswordIncorrectException();
        }
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public void updatePassword(PasswordVO passwordVO) {
        if (!(passwordEncoder.matches(passwordVO.getOldPW(), passwordVO.getUser().getPassword()))){
            throw new OriginPasswordIncorrectException();
        }
        User user = passwordVO.getUser();
        user.setPassword(passwordEncoder.encode(passwordVO.getNewPW()));
        userRepository.save(user);
    }

}
