<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mega - Curriculum</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/curriculum/notice.css" type="text/css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
</head>
<body>
    <%@ include file="/WEB-INF/layout/header.jsp" %>
    <form action="/curriculum/deleteCurriculum.do" method="post" class="notice-form">
        <div class="NoticeWrapper">
            <div class="nav">
                <h1 class="title">커리큘럼</h1>
                <ul class="menu-list">
                    <li class="menu-item">
                        <button type="button" class="menu-btn"
                            onclick="location.href='/curriculum/createCurriculumForm.do'">과목 추가
                        </button>
                    </li>
                    <li class="menu-item">
                        <button class="menu-btn notice-update-btn" type="button" value="update"
                        onclick="if(validateCheckboxForUpdate()) sendUpdateRequest();">
                        과목 수정</button>

                    </li>

                    <li class="menu-item">
                        <button class="menu-btn notice-remove-btn" type="button">과목 삭제</button>
                    </li>
                </ul>

            </div>
            <div class="notice-table-header">
                <div class="notice-table-header-row">
                    <div class="notice-table-header-col notice-table-header-col-num">
                        <div class="notice-table-header-cell notice-table-header-num">
                            순번
                        </div>
                    </div>
                    <div class="notice-table-header-col notice-table-header-col-title">
                        <div class="notice-table-header-cell notice-table-header-title">
                            교과목명
                        </div>
                    </div>
                    <div class="notice-table-header-col notice-table-header-col-detail">
                        <div class="notice-table-header-cell notice-table-header-detail">
                            상세교과내용
                        </div>
                    </div>
                    <div class="notice-table-header-col notice-table-header-col-time">
                        <div class="notice-table-header-cell notice-table-header-time">
                            시간
                        </div>
                    </div>
                    <div class="notice-table-header-col notice-table-header-col-period">
                        <div class="notice-table-header-cell notice-table-header-period">
                            기간
                        </div>
                    </div>
                    <div class="notice-table-header-col notice-table-header-col-selection">
                        <div class="notice-table-header-cell notice-table-header-selection">
                            선택
                        </div>
                    </div>
                </div>
            </div>
            <div class="content">
                <table class="notice-table">
                    <tbody class="notice-table-body">

                        <c:forEach var="curriculum" items="${curriculumList}" varStatus="status1">
                            <c:forEach var="detail" items="${curriculum.detailSubjectDTOList}" varStatus="status2">
                                <tr class="notice-table-body-row">

                                    <c:if test="${status2.index == 0}">
                                        <td class="notice-table-body-col notice-table-body-col-num"
                                            rowspan="${fn:length(curriculum.detailSubjectDTOList)}">
                                            <div class="notice-table-body-cell notice-table-body-num">
                                                ${status1.count}
                                            </div>
                                        </td>
                                        <td class="notice-table-body-col notice-table-body-col-title"
                                            rowspan="${fn:length(curriculum.detailSubjectDTOList)}">
                                            <div class="notice-table-body-cell notice-table-body-title">
                                                ${curriculum.subject}
                                            </div>
                                        </td>
                                    </c:if>


                                    <td class="notice-table-body-col notice-table-body-col-detail">
                                        <div class="notice-table-body-cell notice-table-body-detail">
                                            ${detail.content}
                                        </div>
                                    </td>

                                    <c:if test="${status2.index == 0}">
                                        <td class="notice-table-body-col notice-table-body-col-time"
                                            rowspan="${fn:length(curriculum.detailSubjectDTOList)}">
                                            <div class="notice-table-body-cell notice-table-body-time">
                                                ${curriculum.time}h
                                            </div>
                                        </td>
                                        <td class="notice-table-body-col notice-table-body-col-period"
                                            rowspan="${fn:length(curriculum.detailSubjectDTOList)}">
                                            <div class="notice-table-body-cell notice-table-body-period">
                                                ${curriculum.startDate} ~ ${curriculum.endDate}
                                            </div>
                                        </td>


                                        <td class="notice-table-body-col notice-table-body-col-selection"
                                            rowspan="${fn:length(curriculum.detailSubjectDTOList)}"
                                            onclick="event.stopPropagation()">
                                            <div class="notice-table-body-cell notice-table-body-selection">
                                                <input type="checkbox" name="curriculumId" value="${curriculum.id}"
                                                    class="notice-table-body-selection-checkbox"
                                                    id="#checkbox-${curriculum.id}" />
                                                <label class="notice-table-body-selection-label"
                                                    for="#checkbox-${curriculum.id}"></label>
                                            </div>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="NoticeModal">
            <div class="backdrop">
                <div class="modal-wrapper">
                    <div class="modal-desc-wrapper">
                        <h2 class="modal-title">교과목 삭제</h2>
                        <p class="modal-desc">교과목을 삭제하시겠어요?</p>
                    </div>
                    <div class="modal-btn-wrapper">
                        <button class="modal-btn modal-btn-confirm" type="submit">확인</button>
                        <button class="modal-btn modal-btn-cancel" type="button">취소</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <%@ include file="/WEB-INF/layout/footer.jsp" %>
    <script>

        function sendUpdateRequest() {

            let form = document.createElement("form");
            form.method = "GET";  // GET 방식 설정
            form.action = "/curriculum/updateCurriculumForm.do";  // action 설정

            const checkedCheckboxes = Array.from(document.querySelectorAll('.notice-table-body-selection-checkbox'))
                .filter(checkbox => checkbox.checked);


            checkedCheckboxes.forEach((checkbox, index) => {
                let hiddenField = document.createElement("input");
                hiddenField.type = "hidden";
                hiddenField.name = "curriculumId";
                hiddenField.value = checkbox.value;
                form.appendChild(hiddenField);
            });

            document.body.appendChild(form);
            form.submit();
        }

        function validateCheckboxForUpdate() {
            const checkedCheckboxes = Array.from(document.querySelectorAll('.notice-table-body-selection-checkbox'))
                .filter(checkbox => checkbox.checked);

            if (checkedCheckboxes.length === 0) {
                return false;
            }

            return true;
        }



        document.querySelector('.menu-item .menu-btn.notice-remove-btn').addEventListener("click", () => {
            const filteredCheckboxes = Array.from(
                document.querySelectorAll('.notice-table-body-selection-checkbox')).filter(
                    (e) => e.checked
                )

            console.log(filteredCheckboxes.length);

            if (!filteredCheckboxes.length) {
                return;
            }

            document.querySelector(".NoticeModal .backdrop").classList.add("active");
        });

        document.querySelector(
            '.backdrop .modal-wrapper .modal-btn-wrapper .modal-btn.modal-btn-cancel').addEventListener(
                "click", () => {
                    document.querySelector(".backdrop").classList.remove("active");
                });
    </script>
</body>

</html>