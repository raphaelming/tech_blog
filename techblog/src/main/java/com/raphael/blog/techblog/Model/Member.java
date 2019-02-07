package com.raphael.blog.techblog.Model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "member")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "email")
    private String email;
    @Column(name = "introduce")
    private String introduce;


    public Member() {

    }

    public Member(String userId, String password, String username, String nickname, String email, String introduce) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.introduce = introduce;
    }




}
