<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-14
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
<head>
    <title>출결관리상세</title>
    <link rel="stylesheet" href="../../../css/reset.css" />
    <link rel="stylesheet" href="../../../css/header.css" />
    <link rel="stylesheet" href="../../../css/footer.css" />
    <link rel="stylesheet" href="../../../css/attendance.css" />
</head>
<body>
<div class="body-wrapper">
    <div>
        <div>
            <div class="top-bar">
                <h1 id="title">출결관리상세</h1>
                <%-- 달력 --%>
                <button type="button" id="go-list" onclick="history.back()">목록</button>
            </div>
        </div>
    </div>
    <div id="modal-wrapper">
        <div class="modal-back"></div>
        <div class="modal-content">
            <div>
                <h2>출결 관리 설정</h2>
                <p class="ex-text">
                    출결 관리를 설정해주세요.
                </p>
            </div>
            <div>
                <div>
                    <p>출결<a class="star">*</a></p>
                    <select class="modal-attendance-stat">
                        <option value="미출결">미출결</option>
                        <option value="출결">출결</option>
                        <option value="지각">지각</option>
                        <option value="조퇴">조퇴</option>
                        <option value="결석">결석</option>
                        <option value="공가">공가</option>
                        <option value="병가">병가</option>
                    </select>
                </div>
                <div>
                    <p>이름<a class="star">*</a></p>
                    <input type="text" class="modal-name" readonly>
                </div>
                <div>
                    <p>이메일<a class="star">*</a></p>
                    <input type="text" class="modal-email" readonly>
                </div>
                <div>
                    <p>입실시간<a class="star">*</a></p>
                    <input type="text" class="modal-start-date">
                </div>
                <div>
                    <p>퇴실시간<a class="star">*</a></p>
                    <input type="text" class="modal-end-date">
                </div>
                <div>
                    <p>이유<a class="star">*</a></p>
                    <input type="text" class="modal-reason">
                </div>
            </div>
            <div>
                <div class="modal-button">
                    <form method="post">
                        <button class="close-modal">취소</button>
                        <input type="submit" class="update-modal" value="수정" />
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="content-wrapper">
        <div class="table-wrapper">
            <div>
                <table>
                    <tr class="table-bar">
                        <th>연번</th>
                        <th>이름</th>
                        <th>이메일</th>
                        <th>일시</th>
                        <th>출결</th>
                        <th>입실 시간</th>
                        <th>퇴실 시간</th>
                        <th>이유</th>
                        <th></th>
                    </tr>
                    <c:set var="page" value="${ (param.page == null ) ? 1 : param.page }" />
                    <c:set var="index" value="${ (page - 1) * 9 + index + 1 }"></c:set>
                    <c:forEach var="attendanceDTO" items="${ detailList }">
                        <tr class="table-content table-row-${page}${index}">
                            <td>${ index }</td>
                            <td class="table-col-name">${ attendanceDTO.name }</td>
                            <td class="table-col-email">${ attendanceDTO.email }</td>
                            <td class="table-col-date">${ attendanceDTO.date }</td>
                            <td class="table-col-attendance-stat">${ attendanceDTO.attendance_stat }</td>
                            <td class="table-col-start-time">${ attendanceDTO.start_date }</td>
                            <td class="table-col-end-time">${ attendanceDTO.end_date }</td>
                            <td class="table-col-reason">${ attendanceDTO.reason }</td>
                            <td><button type="button" id="open-modal">출결 관리</button></td>
                        </tr>
                        <c:set var="index" value="${ index + 1 }"></c:set>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="page-wrapper">
                <div>
                    <c:set var="page" value="${ (param.page == null ) ? 1 : param.page }" />
                    <c:set var="startNum" value="${ page - (page - 1) % 5 }"/>
                    <c:set var="endNum" value="${ endNum }"/>
                    <c:set var="currentPageBlock" value="${ currentPageBlock }" />
                    <%-- 첫 블록 --%>
                    <div>
                        <c:if test="${ startNum >= 6 }">
                            <a href="?email=${ eamil }&page=1"><img src="../../../images/angle-double-small-left.svg" alt="처음 페이지로"></a>
                        </c:if>
                    </div>
                    <%-- 이전 블록 --%>
                    <div>
                        <c:if test="${ startNum - 1 > 0 }">
                            <a href="?email=${ email }&page=${ startNum - 1 }"><img src="../../../images/angle-small-left.svg" alt="이전"></a>
                        </c:if>
                    </div>
                    <%-- 블록 번호 --%>
                    <ul class="page-number">
                        <c:if test="${ currentPageBlock + 4 <= endNum }">
                            <c:forEach var="i" begin="0" end="4">
                                <li><a href="?email=${ email }&page=${ startNum + i }">${ startNum + i }</a></li>
                            </c:forEach>
                        </c:if>
                        <c:if test="${ currentPageBlock + 4 > endNum }">
                            <c:forEach var="i" begin="0" end="${ currentPageBlock - startNum }">
                                <li><a href="?email=${ email }&page=${ startNum + i }">${ startNum + i }</a></li>
                            </c:forEach>
                        </c:if>
                    </ul>
                    <%-- 다음 블록 --%>
                    <div>
                        <c:if test="${ startNum + 4 < endNum }">
                            <a href="?email=${ email }&page=${ startNum + 5 }"><img src="../../../images/angle-small-right.svg" alt="다음"></a>
                        </c:if>
                    </div>
                    <%-- 마지막 블록 --%>
                    <div>
                        <c:if test="${ startNum + 4 < endNum }">
                            <a href="?email=${ email }&page=${ endNum }"><img src="../../../images/angle-double-small-right.svg" alt=" 마지막 페이지로"></a>
                        </c:if>
                    </div>
                </div>
        </div>
    </div>
</div>
</div>
<script>
    document.getElementById("open-modal").onclick = function ({target}) {
        document.getElementById("modal-wrapper").style.display = "block";

        const email = target.parentNode.parentNode.querySelector(".table-col-email").textContent
        document.querySelector(".modal-email").value = email;

        const name = target.parentNode.parentNode.querySelector(".table-col-name").textContent
        document.querySelector(".modal-name").value = name;

        const reason = target.parentNode.parentNode.querySelector(".table-col-reason").textContent
        document.querySelector(".modal-reason").value = reason;

        const startDate = target.parentNode.parentNode.querySelector(".table-col-date").textContent + " " + target.parentNode.parentNode.querySelector(".table-col-start-time").textContent
        document.querySelector(".modal-start-date").value = startDate;

        const endDate = target.parentNode.parentNode.querySelector(".table-col-date").textContent + " " + target.parentNode.parentNode.querySelector(".table-col-end-time").textContent
        document.querySelector(".modal-end-date").value = endDate;

        const attendanceStat = target.parentNode.parentNode.querySelector(".table-col-attendance-stat").textContent
        document.querySelector(".modal-attendance-stat").value = attendanceStat;

        console.log(target.parentNode.parentNode.querySelector(".table-col-attendance-stat").textContent)

    };
    document.getElementById("close-modal").onclick = function () {
        document.getElementById("modal-wrapper").style.display = "none";
    };


</script>
</body>
</html>