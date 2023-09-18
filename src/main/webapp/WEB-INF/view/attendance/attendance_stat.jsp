<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: uBeom
  Date: 2023-09-17
  Time: 오후 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mega - attendance-stat</title>
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/header.css">
    <link rel="stylesheet" href="../../../css/footer.css">
    <link rel="stylesheet" href="../../../css/attendance-stat.css">
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<div class="AttendanceStatWrapper">
    <main class="MainWrapper">
        <nav class="nav">
            <h2 class="title">출결관리</h2>
            <button type="button" class="btn">단위기간 설정</button>
        </nav>
        <section class="content">
            <ul class="tab-list">
                <li class="tab-item">
                    <h3 class="tab-title title-disabled">인원</h3>
                </li>
                <li class="tab-item">
                    <h3 class="tab-title title-active">통계</h3>
                </li>
            </ul>
            <ul class="table-header-list">
                <li class="table-header-item table-header-item-name">이름</li>
                <li class="table-header-item">
                    8/16
                    <p>월</p>
                </li>
                <li class="table-header-item">
                    8/17
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/18
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/19
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/20
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/21
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/22
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/23
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/24
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/25
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/26
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/27
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/28
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/29
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/30
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    8/31
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/1
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/2
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/3
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/5
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/6
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/7
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/8
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/9
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/10
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/11
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/12
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/13
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/14
                    <p>화</p>
                </li>
                <li class="table-header-item">
                    9/15
                    <p>화</p>
                </li>
                <li class="table-header-item table-header-item-info">출석</li>
                <li class="table-header-item">지각</li>
                <li class="table-header-item">조퇴</li>
                <li class="table-header-item">공결</li>
                <li class="table-header-item">결석</li>
            </ul>
            <div class="attendance-table-wrapper">
                <table class="attendance-table">
                    <tr class="attendance-table-row">
                        <c:set var="searchKey" value="김유범" />
                        <c:forEach var="attendanceInfo" items="${attendanceInfos[searchKey]}">
                            <td class="attendance-table-col">${attendanceInfo.date}</td>
                            <td class="attendance-table-col">${attendanceInfo.status}</td>
                        </c:forEach>
<%--                        <td class="attendance-table-col attendance-table-col-absent">${attendance.status}</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
<%--                        <td class="attendance-table-col">출석</td>--%>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            황정민
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            왕찬현
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            박소희
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            전진우
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            옥승철
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            김기찬
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            송정희
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            김경욱
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            이수민
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                    <tr class="attendance-table-row">
                        <td class="attendance-table-col attendance-table-col-name">
                            김동욱
                        </td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col">출석</td>
                        <td class="attendance-table-col attendance-table-col-result">
                            20
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                        <td class="attendance-table-col attendance-table-col-result">
                            0
                        </td>
                    </tr>
                </table>
            </div>
        </section>
    </main>
</div>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
<script>
  const tableHeaderList = document.querySelector('.table-header-list');
  const attendanceTableWrapper = document.querySelector(
      '.attendance-table-wrapper'
  );

  tableHeaderList.addEventListener('scroll', () => {
    attendanceTableWrapper.scrollLeft = tableHeaderList.scrollLeft;
  });

  attendanceTableWrapper.addEventListener('scroll', () => {
    tableHeaderList.scrollLeft = attendanceTableWrapper.scrollLeft;
  });
</script>
</body>
</html>
