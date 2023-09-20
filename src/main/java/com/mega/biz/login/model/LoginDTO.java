package com.mega.biz.login.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {

    private String account;
    private String password;
    private String name;
    private String salt;
}
