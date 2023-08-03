package com.mintu.test.service;


import com.mintu.test.entity.User;
import com.mintu.test.vo.PasswordVO;
import com.mintu.test.vo.UserVO;

public interface UserService {

    void add(User user);

    void update(User user);

    User login(UserVO userVO);

    User getById(Long id);

    void updatePassword(PasswordVO passwordVO);
}
