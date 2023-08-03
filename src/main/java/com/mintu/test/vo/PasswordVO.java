package com.mintu.test.vo;

import com.mintu.test.entity.User;
import lombok.Data;

@Data
public class PasswordVO {
    private User user;
    private String oldPW;
    private String newPW;
}
