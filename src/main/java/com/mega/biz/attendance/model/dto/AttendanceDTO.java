package com.mega.biz.attendance.model.dto;

import lombok.*;

import java.util.Date;

@Data
public class AttendanceDTO {

    // user table
    private String email;
    private String password;
    private String name;
    private String phone;

    // attendance table
    private int id;
    private String attendance_stat;
    private Date date;
    private String start_date;
    private String end_date;
    private String reason;
    private int attendance_duration;

    private String start_month;
    private String end_month;

}