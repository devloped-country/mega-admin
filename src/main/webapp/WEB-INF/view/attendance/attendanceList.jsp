<!-- <%-- Created by IntelliJ IDEA. User: user Date: 2023-09-14 Time: 오후 1:47 To
change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<!DOCTYPE html>
<html class="hide-scrollbar">
<head>
    <title>출결관리</title>
    <link rel="stylesheet" href="../../../style/reset.css"/>
    <link rel="stylesheet" href="../../../style/header.css"/>
    <link rel="stylesheet" href="../../../style/footer.css"/>
    <link rel="stylesheet" href="../../../style/attendance.css"/>
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<div class="body-wrapper">
    <div>
        <div>
            <div class="top-bar">
                <h1 id="title">출결관리</h1>
                <div class="top-bar-right">
                    <div class="search-bar">
                        <img id="search-img" src="../../../images/search.svg">
                        <input
                                type="text"
                                id="keyword"
                                placeholder="회원명을 입력해주세요"
                        />
                    </div>
                    <input type="button" id="search-button" onclick="getKeyword()" value="조회"/>
                    <button type="button" id="open-modal">단위기간 설정</button>
                </div>
            </div>
        </div>
    </div>
    <div id="modal-wrapper">
        <div class="modal-back"></div>
        <div class="modal-content">
            <form method="post" action="/attendance/setDuration.do">
                <div>
                    <h2>단위기간 설정</h2>
                    <p class="ex-text">
                        ex) 15일은 5월 16일부터 6월 15일까지 기간을 조회합니다.
                    </p>
                </div>
                <div class="get-date">
                    <p>날짜<a class="star">*</a></p>
                    <div>
                        <input
                                type="text"
                                id="insert-date"
                                name="getDuration"
                                placeholder="ex) 15"
                        />
                        <span id="getError"></span>
                        <div class="modal-button">
                            <button type="button" id="close-modal">취소</button>
                            <button type="submit" class="update-modal">확인</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="content-wrapper">
        <div class="select-bar">
            <button type="button" id="select-personnel">인원</button>
            <button type="button" id="select-statics" onclick="location.href='/attendance/attendanceStat.do'">통계
            </button>
        </div>
        <div class="table-bar-2">
            <div class="tale-bar-2-item">순번</div>
            <div class="tale-bar-2-item">이름</div>
            <div class="tale-bar-2-item">전화번호</div>
            <div class="tale-bar-2-item">이메일</div>
        </div>
        <div class="table-wrapper">
            <div>
                <table>
                    <c:set var="page" value="${ (param.page == null ) ? 1 : param.page }"/>
                    <c:set var="index" value="${ (page - 1) * 9 + index + 1 }"></c:set>
                    <c:forEach var="attendanceDTO" items="${ attendanceList }">
                        <tr class="table-content"
                            onclick="location.href='/attendance/attendanceDetail.do?email=${ attendanceDTO.email }&page=1'">
                            <td>${ index }</td>
                            <td>${ attendanceDTO.name }</td>
                            <td>${ attendanceDTO.phone }</td>
                            <td>${ attendanceDTO.email }</td>
                        </tr>
                        <c:set var="index" value="${ index + 1 }"></c:set>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="page-wrapper">
            <c:choose>
                <c:when test="${keyword == null}">
                    <c:set var="page" value="${ ( param.page == null ) ? 1 : param.page }"/>
                    <c:set var="startNum" value="${ page - (page - 1) % 5 }"/>
                    <c:set var="endNum" value="${ endNum }"/>
                    <c:set var="currentPageBlock" value="${ currentPageBlock }"/>
                    <%-- 첫 블록 --%>
                    <div>
                        <c:if test="${ startNum >= 6 }">
                            <a href="?page=1"><img src="../../../images/angle-double-small-left.svg" alt="처음 페이지로"></a>
                        </c:if>
                    </div>
                    <%-- 이전 블록 --%>
                    <div>
                        <c:if test="${ startNum - 1 > 0 }">
                            <a href="?page=${ startNum - 1 }"><img src="../../../images/angle-small-left.svg" alt="이전"></a>
                        </c:if>
                    </div>
                    <%-- 블록 번호 --%>
                    <ul class="page-number">
                        <c:if test="${ currentPageBlock + 4 <= endNum }">
                            <c:forEach var="i" begin="0" end="4">
                                <li><a class="${page == (startNum + i) ? "page-number-button-on" : ""}"
                                       href="?page=${ startNum + i }">${ startNum + i }</a></li>
                            </c:forEach>
                        </c:if>
                        <c:if test="${ currentPageBlock + 4 > endNum && endNum != 0 }">
                            <c:forEach var="i" begin="0" end="${ endNum - currentPageBlock }">
                                <li><a class="${page == (startNum + i) ? "page-number-button-on" : ""}"
                                       href="?page=${ startNum + i }">${ startNum + i }</a></li>
                            </c:forEach>
                        </c:if>
                    </ul>
                    <%-- 다음 블록 --%>
                    <div>
                        <c:if test="${ startNum + 4 < endNum }">
                            <a href="?page=${ startNum + 5 }"><img src="../../../images/angle-small-right.svg" alt="다음"></a>
                        </c:if>
                    </div>
                    <%-- 마지막 블록 --%>
                    <div>
                        <c:if test="${ startNum + 4 < endNum }">
                            <a href="?page=${ endNum }"><img src="../../../images/angle-double-small-right.svg"
                                                             alt=" 마지막 페이지로"></a>
                        </c:if>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:set var="page" value="${ (param.page == null ) ? 1 : param.page }"/>
                    <c:set var="startNum" value="${ page - (page - 1) % 5 }"/>
                    <c:set var="endNum" value="${ endNum }"/>
                    <c:set var="currentPageBlock" value="${ currentPageBlock }"/>
                    <%-- 첫 블록 --%>
                    <div>
                        <c:if test="${ startNum >= 6 }">
                            <a href="?keyword=${ keyword }&page=1"><img
                                    src="../../../images/angle-double-small-left.svg" alt="처음 페이지로"></a>
                        </c:if>
                    </div>
                    <%-- 이전 블록 --%>
                    <div>
                        <c:if test="${ startNum - 1 > 0 }">
                            <a href="?keyword=${ keyword }&page=${ startNum - 1 }"><img
                                    src="../../../images/angle-small-left.svg" alt="이전"></a>
                        </c:if>
                    </div>
                    <%-- 블록 번호 --%>
                    <ul class="page-number">
                        <c:if test="${ currentPageBlock + 4 <= endNum }">
                            <c:forEach var="i" begin="0" end="4">
                                <li><a class="${page == (startNum + i) ? "page-number-button-on" : ""}"
                                       href="?keyword=${ keyword }&page=${ startNum + i }">${ startNum + i }</a></li>
                            </c:forEach>
                        </c:if>
                        <c:if test="${ currentPageBlock + 4 > endNum && endNum != 0 }">
                            <c:forEach var="i" begin="0" end="${ endNum - currentPageBlock }">
                                <li><a class="${page == (startNum + i) ? "page-number-button-on" : ""}"
                                       href="?keyword=${ keyword }&page=${ startNum + i }">${ startNum + i }</a></li>
                            </c:forEach>
                        </c:if>
                    </ul>
                    <%-- 다음 블록 --%>
                    <div>
                        <c:if test="${ startNum + 4 < endNum }">
                            <a href="?keyword=${ keyword }&page=${ startNum + 5 }"><img
                                    src="../../../images/angle-small-right.svg" alt="다음"></a>
                        </c:if>
                    </div>
                    <%-- 마지막 블록 --%>
                    <div>
                        <c:if test="${ startNum + 4 < endNum }">
                            <a href="?keyword=${ keyword }&page=${ endNum }"><img
                                    src="../../../images/angle-double-small-right.svg" alt=" 마지막 페이지로"></a>
                        </c:if>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</div>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
<script>
    document.getElementById("open-modal").onclick = function () {
        document.getElementById("modal-wrapper").style.display = "block";
    };
    document.getElementById("close-modal").onclick = function () {
        document.getElementById("modal-wrapper").style.display = "none";
    };

    function getKeyword() {
        let keyword = document.getElementById("keyword").value;
        location.href = '/attendance/attendance.do?keyword=' + keyword + '&page=1';
    };

    function validDuration(inputDuration) {
        const seeWarning = document.getElementById("getError");

        if (isNaN(inputDuration.value)) {
            seeWarning.textContent = "단위기간을 입력해주세요.";
        } else {
            seeWarning.textContent = "";
        }

    }
</script>
</body>
</html>