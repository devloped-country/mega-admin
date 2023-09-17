package com.mega.biz.attendance.service;

import com.mega.biz.attendance.model.AttendanceDAO;
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

}
