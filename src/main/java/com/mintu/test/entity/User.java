package com.mintu.test.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "test_user")
public class User {

    @Id
    private Long id;

    private String account;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;

}
