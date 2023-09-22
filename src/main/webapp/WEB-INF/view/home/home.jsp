<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>Mega - Home</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
    <link rel="stylesheet" href="../../../style/home.css">
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<div class="HomeWrapper">
    <main class="MainWrapper">
        <nav class="nav">
            <h2 class="title">${name} 님 안녕하세요 👋🏼</h2>
        </nav>
        <section class="content">
            <section class="attendance">
                <h3 class="attendance-title">출결정보</h3>
                <ul class="attendance-list">
                    <li class="attendance-item">
                        <h4 class="attendance-item-title">출결자</h4>
                        <p class="attendance-item-desc">${attendance.attendance}명</p>
                    </li>
                    <li class="attendance-item">
                        <h4 class="attendance-item-title">미출결자</h4>
                        <p class="attendance-item-desc">${attendance.unAttendance}명</p>
                    </li>
                </ul>
            </section>
            <section class="notice">
                <ul class="notice-tab-list">
                    <li class="notice-tab-item">공지사항</li>
                </ul>
                <div class="notice-content">
                    <ul class="notice-list">
                        <c:forEach var="notice" items="${notices}">
                            <li class="notice-item">
                                <h4 class="notice-title">
                                    <c:choose>
                                        <c:when test="${notice.tag == 1}">[훈련비]</c:when>
                                        <c:when test="${notice.tag == 2}">[시험]</c:when>
                                        <c:when test="${notice.tag == 3}">[BIPA행사관련]</c:when>
                                        <c:when test="${notice.tag == 4}">[BIPA전달사항]</c:when>
                                        <c:when test="${notice.tag == 5}">[BIPA채용공지]</c:when>
                                        <c:when test="${notice.tag == 6}">[세미나]</c:when>
                                        <c:when test="${notice.tag == 7}">[긴급]</c:when>
                                        <c:otherwise>[기타]</c:otherwise>
                                    </c:choose>
                                        ${notice.title}</h4>
                                <div class="notice-info">
                                    <p class="notice-author">${notice.author}</p>
                                    <p class="notice-date">${notice.created_date}</p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
        </section>
    </main>
</div>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>