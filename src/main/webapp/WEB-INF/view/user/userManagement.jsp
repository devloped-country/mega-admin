<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>


<html>
<head>
    <title>Mega - User</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
    <link rel="stylesheet" href="../../../style/user.css">
</head>
<body>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<div class="all">
    <div class="UserWrapper">

        <div class="main">
            <div class="nav">
                <h1 class="title">회원 관리</h1>
            </div>
            <ul class="header-row">
                <li class="header-col header-col1">연번</li>
                <li class="header-col header-col2">이메일</li>
                <li class="header-col header-col3">이름</li>
                <li class="header-col header-col4">전화번호</li>
                <li class="header-col header-col5">가입유무</li>
                <li class="header-col header-col6"></li>

                <li class="header-col header-col7"></li>

            </ul>
            <div class="content">
                <table class="table">

                    <c:forEach var="user" items="${userList}" varStatus="loop">
                        <%--        //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★--%>

                        <tr class="content-row">
                                <%--            //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★--%>
                            <form method="post" action="/user/userapprove.do?page=${page}">
                                <td class="content-col list-col1">
                                    <p>${loop.index + 1}</p>
                                </td>
                                <td class="content-col list-col2">${user.email}</td>
                                <td class="content-col list-col3">${user.name }</td>
                                <td class="content-col list-col4">${user.phone }</td>
                                <td class="content-col list-col5">
                                    <c:choose>
                                        <c:when test="${user.user_status == 1}">
                                            미가입
                                        </c:when>
                                        <c:when test="${user.user_status == 2}">
                                            가입
                                        </c:when>
                                    </c:choose></td>
                                <td class="content-col list-col6">

                                    <c:if test="${ user.user_status  == 1}">
                                        <button type="submit" class="openModalBtn1" data-status="${user.user_status}">가입
                                            승인
                                        </button>
                                        <input type="hidden" name="OK" value="${user.email }"/>
                                        <%--                    후에 가입승인되었습니다 문구만--%>
                                    </c:if>
                                    <c:if test="${ user.user_status  != 1}">
                                        <button type="button" class="closeBtn">가입 승인
                                        </button>
                                        <input type="hidden" name="OK" value="${user.email }"/>
                                        <%--                    후에 가입승인되었습니다 문구만--%>
                                    </c:if>
                                </td>
                            </form>
                                <%--            여길누르면 모달창이 따야함 바로 삭제되면안되고!!--%>
                            <td class="content-col list-col7">
                                <button type="submit" class="openModalBtn2" data-email="${user.email}">회원 탈퇴</button>
                                <input type="hidden" name="NO" value="${user.email }"/>
                                    <%--                    이건 모달창에서 '확인' 누르면 요청보내주도록--%>
                            </td>
                        </tr>


                    </c:forEach>
                </table>
            </div>
            <div class="page-wrapper">


                <ul class="page-number">
                    <li class="nextBtn1"><a href="${action}?page=${paging.firstPage}"><img
                            src="../../../images/angle-double-small-left.svg"
                            alt="처음 페이지로"></a></li>
                    <li class="nextBtn2" ><a href="${action}?page=${paging.prevPage}"><img src="../../../images/angle-small-left.svg"
                                                                         alt="이전"></a>
                    </li>
                    <c:forEach begin="${paging.beginPage}" end="${paging.endPage}" step="1" var="index">
                        <c:choose>
                            <c:when test="${paging.page==index}">
                                <li class="current-page">${index}</li>
                            </c:when>
                            <c:otherwise>
                                <div class="page-num">
                                    <li><a class="${page == index ? "page-number-button-on" : ""}"
                                           href="${action}?page=${index}">${index}</a></li>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li class="nextBtn3"><a href="${action}?page=${paging.nextPage}"><img src="../../../images/angle-small-right.svg"
                                                                         alt="다음"></a>
                    </li>
                    <li class="nextBtn4"><a href="${action}?page=${paging.lastPage}"><img
                            src="../../../images/angle-double-small-right.svg"
                            alt=" 마지막 페이지로"></a></li>
                </ul>

                <c:if test="${paging.next}">
                    <a href="${action}?page=${paging.nextPage}">next</a>
                </c:if>
            </div>
        </div>

    </div>

</div>

<div class="modal2">
    <div class="modal-content2">
        <div class="modal-content2-area1">
            <h2 class="modal-content2-title">회원 탈퇴</h2>
            <p class="modal-content2-info">해당 회원을 탈퇴처리 하시겠습니까?</p>
        </div>
        <div class="modal-content2-area2">
            <button type='submit' class="cancelButton2">취소</button>
            <form method="post" action="/user/deleteuser.do?page=${page}">
                <td>
                    <button type="submit" id="openModalBtn2">확인</button>
                    <input type="hidden" name="NO" value="${user.email}"/>
                </td>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/layout/footer.jsp" %>

<script>


    // 모달창2 열기
    const openModalBtn2 = document.querySelectorAll(".openModalBtn2");
    const modal2 = document.querySelector(".modal2");
    const cancelButton2 = document.querySelector(".cancelButton2");

    openModalBtn2.forEach((button) => {
        button.addEventListener("click", () => {
            //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
            const email = button.getAttribute("data-email"); // 사용자의 이메일 가져오기
            const emailInput = modal2.querySelector('input[name="NO"]'); // 숨겨진 입력 필드 선택
            emailInput.value = email; // 이메일 값을 숨겨진 입력 필드에 할당
            modal2.style.display = "flex";
        });
    });
    // 모달창2 닫기
    cancelButton2.addEventListener("click", () => {
        modal2.style.display = "none";
    });


    function btnActive() {
        const buttons = document.querySelectorAll('.openModalBtn1'); // 모든 '가입 승인' 버튼을 가져옵니다.

        buttons.forEach(button => {
            const userStatus = button.getAttribute("data-status"); // 버튼의 data-user_status 속성을 가져옵니다.

            if (userStatus === '2') { // userStatus가 문자열로 설정되어 있으므로 문자열로 비교합니다.
                button.disabled = true; // user_status가 2이면 버튼을 비활성화합니다.
            } else {
                button.disabled = false; // 그 외의 경우에는 버튼을 활성화합니다.
            }
        });
    }


    function getUserStatus() {

        //승인 (name=OK 버튼) 의 활성,비활성여부----------------------------------

        function btnDisabled() {
            const target = document.getElementById('target_btn');
            target.disabled = true;
        }

    }


</script>
</body>
</html>
