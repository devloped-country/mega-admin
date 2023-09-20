<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<%@ include file="/WEB-INF/layout/header.jsp" %>

<html>
<head>
    <title>Mega - USER</title>
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/header.css">
    <link rel="stylesheet" href="../../../css/footer.css">
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
    <link rel="stylesheet" type="text/css" href="../../../css/user.css">

    <%--    <link rel="stylesheet" href="../../../css/user.css" type="text/css">--%>

</head>
<body>

<div class="UserWrapper">
    <div class="nav">
        <h1 class="title">회원 관리</h1>
    </div>
    <div class="main">
        <table class="table">
            <div class="header">
                <tr class="header-row">
                    <th class="header-col1" width="100">연번</th>
                    <th class="header-col" width="100">이메일</th>
                    <th class="header-col" width="150">이름</th>
                    <th class="header-col" width="150">phone</th>
                    <th class="header-col" width="150">가입유무</th>
                    <th class="header-col" width="150"></th>
                    <th class="header-col7" width="150"></th>
                </tr>
            </div>

            <div class="content">
                <c:forEach var="user" items="${userList}" varStatus="loop">
                    <%--        //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★--%>

                    <tr class="content-row">
                            <%--            //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★--%>
                                                    <form method="post" action="/user/userapprove.do">
                        <td class="content-col">
                            <p>${loop.index + 1}</p>
                        </td>
                        <td class="content-col">${user.email}</td>
                        <td class="content-col">${user.name }</td>
                        <td class="content-col">${user.phone }</td>
                        <td class="content-col">
                            <c:choose>
                                <c:when test="${user.user_status == 1}">
                                    미가입
                                </c:when>
                                <c:when test="${user.user_status == 2}">
                                    가입
                                </c:when>
                            </c:choose></td>
                        <td class="content-col">
                            <button type="submit" class="openModalBtn1" data-status="${user.user_status}" >가입 승인</button>
                            <input type="hidden" name="OK" value="${user.email }"/>
                                <%--                    후에 가입승인되었습니다 문구만--%>
                        </td>
                                                    </form>
                            <%--            여길누르면 모달창이 따야함 바로 삭제되면안되고!!--%>
                        <td class="content-col">
                            <button type="submit" class="openModalBtn2" data-email="${user.email}">회원 탈퇴</button>
                            <input type="hidden" name="NO" value="${user.email }"/>
                                <%--                    이건 모달창에서 '확인' 누르면 요청보내주도록--%>
                        </td>
                    </tr>
                    <%--        const userStatus = ${user.user_status};--%>
                    <%--        const data-eamil = ${user.email};--%>

                </c:forEach>
            </div>
        </table>
    </div>
</div>

        <%--<div id="modal1" style="display: none;" >--%>
        <%--    <div class="modal-content">--%>
        <%--        <h2>모달 제목</h2>--%>
        <%--        <p>모달 내용을 여기에 추가하세요.</p>--%>
        <%--        <input type='button' value='확인' id="confirmButton1"/>--%>
        <%--        <input type='button' value='취소' id="cancelButton1"/>--%>
        <%--    </div>--%>
        <%--</div>--%>

        <div class="modal2">
            <div class="modal-content2">
                <div class="modal-content2-area1">
                    <h2 class="modal-content2-title">회원 탈퇴</h2>
                    <p class="modal-content2-info">해당 회원을 탈퇴처리 하시겠습니까?.</p>
                </div>
                <div class="modal-content2-area2">
                    <form method="post" action="/user/deleteuser.do">
                        <td>
                            <button type="submit" id="openModalBtn2">확인</button>
                            <input type="hidden" name="NO" value="${user.email}"/>
                        </td>
                    </form>
                    <%--        <input type='button' value='취소' id="cancelButton1"/>--%>
                    <button type='button' class="cancelButton2">취소</button>

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
                        modal2.style.display = "block";
                    });
                });
                // 모달창2 닫기
                cancelButton2.addEventListener("click", () => {
                    modal2.style.display = "none";
                });

                //승인 (name=OK 버튼) 의 활성,비활성여부----------------------------------
                // function btnActive() {
                //     const userStatus = button.getAttribute("data-user_status"); // getUserStatus는 사용자 상태를 가져오는 함수로 가정합니다.
                //     const target = document.getElementById('openModalBtn1');
                //
                //     if (userStatus === 1) {
                //         target.disabled = false;
                //     } else if (userStatus === 2) {
                //         target.disabled = true;
                //     }
                //

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


//모달1창에서 확인버튼 누를시 ->
                        function approveUser() {
                            //회원승인하는 userapprove.do 이런쪽으로 가게만듬
                        }

                }


            </script>
</body>
</html>
<%--페이지네이션----------------------------------------------------%>
<%--const pageGroup = 1--%>
<%--const pageCount = 5--%>
<%--const totalPage = 11--%>

<%--let lastNumber = pageGroup * pageCount // 5--%>
<%--if (lastNumber > totalPage) {--%>
<%--    lastNumber = totalPage--%>
<%--}--%>
<%--let firstNumber = lastNumber - (pageCount - 1) // 1--%>

<%--const next = lastNumber + 1 // 6--%>
<%--const prev = firstNumber - 1 // 0--%>

<%--// 1~5만큼 페이지네이션 그려줌--%>
<%--for (let i = firstNumber; i <= lastNumber; i++) {--%>
<%--    html += `<button class="pageNumber" id="page_${i}">${i}</button>`--%>
<%--}--%>
<%--const pageGroup = 3--%>
<%--const pageCount = 5--%>
<%--const totalPage = 11--%>

<%--let lastNumber = pageGroup * pageCount // 15--%>
<%--if (lastNumber > totalPage) {--%>
<%--    lastNumber = totalPage // 11--%>
<%--}--%>
<%--let firstNumber = lastNumber - (pageCount - 1) // 7--%>

<%--const next = lastNumber + 1 // 12--%>
<%--const prev = firstNumber - 1 // 6--%>

<%--    &lt;%&ndash;페이지네이션--------------------------------------------------&ndash;%&gt;--%>
<%--    &lt;%&ndash;const pageGroup = 1&ndash;%&gt;--%>
<%--    &lt;%&ndash;const pageCount = 5&ndash;%&gt;--%>
<%--    &lt;%&ndash;const totalPage = 11&ndash;%&gt;--%>

<%--    &lt;%&ndash;let lastNumber = pageGroup * pageCount // 5&ndash;%&gt;--%>
<%--    &lt;%&ndash;if (lastNumber > totalPage) {&ndash;%&gt;--%>
<%--    &lt;%&ndash;    lastNumber = totalPage&ndash;%&gt;--%>
<%--    &lt;%&ndash;}&ndash;%&gt;--%>
<%--    &lt;%&ndash;let firstNumber = lastNumber - (pageCount - 1) // 1&ndash;%&gt;--%>

<%--    &lt;%&ndash;const next = lastNumber + 1 // 6&ndash;%&gt;--%>
<%--    &lt;%&ndash;const prev = firstNumber - 1 // 0&ndash;%&gt;--%>

<%--    &lt;%&ndash;// 1~5만큼 페이지네이션 그려줌&ndash;%&gt;--%>
<%--    &lt;%&ndash;for (let i = firstNumber; i <= lastNumber; i++) {&ndash;%&gt;--%>
<%--    &lt;%&ndash;    html += `<button class="pageNumber" id="page_${i}">${i}</button>`&ndash;%&gt;--%>
<%--    &lt;%&ndash;}&ndash;%&gt;--%>
<%--    &lt;%&ndash;const pageGroup = 3&ndash;%&gt;--%>
<%--    &lt;%&ndash;const pageCount = 5&ndash;%&gt;--%>
<%--    &lt;%&ndash;const totalPage = 11&ndash;%&gt;--%>

<%--    &lt;%&ndash;let lastNumber = pageGroup * pageCount // 15&ndash;%&gt;--%>
<%--    &lt;%&ndash;if (lastNumber > totalPage) {&ndash;%&gt;--%>
<%--    &lt;%&ndash;    lastNumber = totalPage // 11&ndash;%&gt;--%>
<%--    &lt;%&ndash;}&ndash;%&gt;--%>
<%--    &lt;%&ndash;let firstNumber = lastNumber - (pageCount - 1) // 7&ndash;%&gt;--%>

<%--    &lt;%&ndash;const next = lastNumber + 1 // 12&ndash;%&gt;--%>
<%--    &lt;%&ndash;const prev = firstNumber - 1 // 6&ndash;%&gt;--%>

<%--</script>--%>


<%--<%@ include file="/WEB-INF/layout/footer.jsp" %>--%>


<%--&lt;%&ndash;&lt;%&ndash;-----------------------------------------------------------------------------------------&ndash;%&gt;&ndash;%&gt;--%>