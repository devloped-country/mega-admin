package com.mega.biz.user.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
//
    private String email;
    private String password;
    private String name;
    private String phone;
    private int user_status; //회원상태아이디 1/2

}