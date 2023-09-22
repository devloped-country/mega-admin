package com.mega.biz.user.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserStatusDTO {
    private int id; // ==> 회원상태 아이디  1 / 2
    private int status; // ==> 상태 0=미가입 / 1= 가입
}