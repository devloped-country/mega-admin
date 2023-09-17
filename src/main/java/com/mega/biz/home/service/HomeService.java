package com.mega.biz.home.service;

import com.mega.biz.home.model.dao.HomeDAO;
import com.mega.biz.home.model.dto.HomeDTO;
import com.mega.biz.home.model.dto.NoticeDTO;
import java.util.ArrayList;

public class HomeService {
  HomeDAO dao = new HomeDAO();

  public HomeDTO countAttendanceInfo() {
    HomeDTO dto = new HomeDTO();

    dto.setAttendance(dao.selectAttendanceCount().getAttendance());
    dto.setUnAttendance(dao.selectUnAttendanceCount().getUnAttendance());

    return dto;
  }

  public ArrayList<NoticeDTO> loadRecentNotice() {
    return dao.selectRecentNotice();
  }
}
