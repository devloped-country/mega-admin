package com.mega.biz.attendance.service;

import com.mega.biz.attendance.model.dao.AttendanceDAO;
import com.mega.biz.attendance.model.dto.AttendanceDTO;
import com.mega.biz.attendance.model.dto.PageDTO;

import java.util.List;

public class AttendanceService {

    private final AttendanceDAO dao = new AttendanceDAO();

    public List<AttendanceDTO> getAttendanceList(PageDTO pageDTO) { return dao.getAttendanceList(pageDTO); }

    public List<AttendanceDTO> getSearchList(String keyword, PageDTO pageDTO) { return dao.getSearchList(keyword, pageDTO); }

    public int getTotalUser(String keyword) { return dao.getTotalUser(keyword); }

    public int getAttendanceCount(String email) { return dao.getAttendanceCount(email); };

    public List<AttendanceDTO> getDetailList(String email, PageDTO pageDTO) { return dao.getDetailList(email, pageDTO); }

    public AttendanceDTO updateAttendance(AttendanceDTO attendanceDTO) { return dao.updateAttendance(attendanceDTO); }

    public List<AttendanceDTO> getDateList(String email, String startMonth, String endMonth, PageDTO pageDTO) { return dao.getDateList(email, startMonth, endMonth, pageDTO); }

    public int getDuration() { return dao.getDuration(); }

    public int getDateCount(String email, String startMonth, String endMonth) { return dao.getDateCount(email, startMonth, endMonth); }

    public int updateDuration(int duration) { return dao.updateDuration(duration); }
}
