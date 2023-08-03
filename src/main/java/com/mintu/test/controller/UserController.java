package com.mintu.test.controller;

import com.mintu.test.entity.User;
import com.mintu.test.response.ResponseResult;
import com.mintu.test.service.UserService;
import com.mintu.test.vo.PasswordVO;
import com.mintu.test.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult<User> login(@RequestBody UserVO userVO, HttpSession session){
        User user = userService.login(userVO);
        session.setAttribute("user", user);
        return ResponseResult.success(user);
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody User user){
        userService.add(user);
        return ResponseResult.success();
    }

    @PostMapping("/update")
    public ResponseResult update(@RequestBody User user,HttpSession session){
        User user1 = (User) session.getAttribute("user");
        user.setId(user1.getId());
        userService.update(user);
        return ResponseResult.success();
    }

    @RequestMapping("/logout")
    public ResponseResult logout(HttpSession session){
        session.removeAttribute("user");
        return ResponseResult.success();
    }

    @RequestMapping("/get")
    public ResponseResult<User> get(HttpSession session){
        User user = (User) session.getAttribute("user");
        return ResponseResult.success(user);
    }


    @RequestMapping("/updatePassword")
    public ResponseResult<Void> updatePassword(@RequestBody PasswordVO passwordVO, HttpSession session){
        User user = (User) session.getAttribute("user");
        passwordVO.setUser(user);
        userService.updatePassword(passwordVO);
        return ResponseResult.success();
    }


}
