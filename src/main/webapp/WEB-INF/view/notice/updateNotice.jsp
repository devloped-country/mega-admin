<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/notice/updateNotice.css" type="text/css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">

</head>
<body>
<div class="UpdateNoticeWrapper">
    <div class="nav">
        <h1 class="title">공지사항</h1>
        <ul class="menu-list">
            <li class="menu-item">
                <button type="button" class="menu-btn notice-regi-btn"
                    onclick="location.href='/notice/getNoticeList.do'">목록
                </button>
            </li>
        </ul>
    </div>
    <form action="/notice/updateNotice.do" method="post" class="update-form">
        <div class="content">
            <div class="content-header">
            <input type="hidden" name="noticeId" value="${noticeId}">
                <div class="tag">
                    <div class="tag-btn-box">
                        <button type="button" class="tag-btn" >선택</button>
                        <img src="../../images/angle-small-down.svg" alt="태그 선택"/>
                    </div>
                    <ul class="tag-list">
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="1"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 1}">checked</c:if>
                                />훈련비</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="2"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 2}">checked</c:if>
                                />시험</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="3"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 3}">checked</c:if>
                                />BIPA행사관련</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="4"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 4}">checked</c:if>
                                />BIPA전달사항</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="5"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 5}">checked</c:if>
                                />BIPA채용공지</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="6"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 6}">checked</c:if>
                                />세미나</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="7"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 7}">checked</c:if>
                                />긴급</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label">
                                <input
                                        type="radio"
                                        name="tag"
                                        value="8"
                                        class="tag-radio"
                                        <c:if test="${selectedTagId == 8}">checked</c:if>
                                />기타</label
                            >
                        </li>
                    </ul>
                </div>
                <div class="content-header-right">
                    <input
                            type="text"
                            class="notice-title"
                            name="title"
                            maxlength="50"
                            autofocus
                            value="${noticeTitle}"
                    />
                </div>
            </div>
            <div class="content-body">
                <textarea
                        name="content"
                        class="notice-content"
                        wrap="on"
                >${noticeContent}</textarea>
            </div>
            <div class="content-footer">
                <button
                        type="button"
                        class="content-btn"
                        onclick="location.href='/notice/noticeDetail.do?id=${noticeId}'"
                >
                    취소
                </button>
                <button type="submit" class="content-btn" id="updateButton">수정</button>
            </div>
        </div>
    </form>
</div>

<div class="UpdateNoticeModal">
    <div class="backdrop">
        <div class="modal-wrapper">
            <div class="modal-desc-wrapper">
                <h2 class="modal-title">태그 설정</h2>
                <p class="modal-desc">태그를 선택해주세요.</p>
            </div>
            <div class="modal-btn-wrapper">
                <button class="modal-btn modal-btn-confirm" onclick="hideModal()">확인</button>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const tagRadios = document.querySelectorAll('.tag-radio');
        const updateButton = document.querySelector('#updateButton');
        const tagBtnBox = document.querySelector(".tag-btn-box");
        const tagList = document.querySelector(".tag-list");
        const tagBtn = document.querySelector('.tag-btn');
        const noticeTitleInput = document.querySelector('.notice-title');
        const noticeContentInput = document.querySelector('.notice-content');

        for (const radio of tagRadios) {
                if (radio.checked) {
                    const label = radio.closest('.tag-item').querySelector('.tag-label');
                    const labelText = label.textContent.trim();
                    tagBtn.textContent = labelText;
                    break;
                }
            }

    // 라디오 버튼 클릭 시 해당 value에 해당하는 값을 보여줌
    document.querySelector(".tag-list").addEventListener("click", ({ target }) => {
        const selectedTag = target.value;
        if (selectedTag === "1") {
            updateTagValue("훈련비");
        } else if (selectedTag === "2") {
            updateTagValue("시험");
        } else if (selectedTag === "3") {
            updateTagValue("BIPA행사관련");
        } else if (selectedTag === "4") {
            updateTagValue("BIPA전달사항");
        } else if (selectedTag === "5") {
            updateTagValue("BIPA채용공지");
        } else if (selectedTag === "6") {
            updateTagValue("세미나");
        } else if (selectedTag === "7") {
            updateTagValue("긴급");
        } else if (selectedTag === "8") {
            updateTagValue("기타");
        }
    });

    // 수정 버튼 클릭 이벤트 처리
    updateButton.addEventListener('click', (e) => {
        // 폼 유효성 검사
        const noticeTitle = document.querySelector('.notice-title').value.trim();
        const noticeContent = document.querySelector('.notice-content').value.trim();

        if (noticeTitle === '') {
            showModal('제목 설정', '제목을 선택해주세요.');
            e.preventDefault();
        } else if (noticeContent === '') {
            showModal('내용 설정', '내용을 선택해주세요.');
            e.preventDefault();
        } else {
            hideModal();
        }

        // 수정 버튼을 클릭했을 때 데이터를 가져오는 Ajax 요청
        const formData = new FormData(document.querySelector('.update-form'));
        formData.append('id', ${notice2.id}); // 게시물의 ID를 전달

        fetch('/notice/updateNoticeController.do', {
            method: 'POST',
            body: formData,
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // 수정이 성공하면 공지사항 상세 페이지로 이동
                window.location.href = `/notice/noticeDetail.do?id=${notice2.id}`;
            } else {
                // 실패 시 메시지 처리 등을 할 수 있음
                console.error('Update failed:', data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });

    // 선택한 값을 업데이트하는 함수
        function updateTagValue(value) {
            const tagBtn = document.querySelector(".tag-btn");
            tagBtn.textContent = value;
            tagList.classList.remove("active");
        }

        // 태그 선택 버튼 클릭 시 드롭다운 열기/닫기
        tagBtnBox.addEventListener("click", () => {
            tagList.classList.toggle("active");
        });

        function showModal(title, description) {
            const modalTitle = document.querySelector(".modal-title");
            const modalDesc = document.querySelector(".modal-desc");

            modalTitle.textContent = title;
            modalDesc.textContent = description;

            document.querySelector(".UpdateNoticeModal").style.display = "block";
        }

        // 모달 확인 버튼 클릭 이벤트 처리
        const modalConfirmButton = document.querySelector(".modal-btn-confirm");
        modalConfirmButton.addEventListener("click", hideModal);

        // 모달 창을 숨기는 함수
        function hideModal() {
            document.querySelector(".UpdateNoticeModal").style.display = "none";
        }
    });
</script>
</body>
</html>
