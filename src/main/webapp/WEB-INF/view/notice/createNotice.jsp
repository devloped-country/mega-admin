<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/notice/createNotice.css" type="text/css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
    <script>
      document.addEventListener("DOMContentLoaded", () => {
        document.querySelector(".tag-btn-box").addEventListener("click", () => {
          document.querySelector(".tag-list").classList.toggle("active");
        });

        function updateTagValue(value) {
                document.querySelector('.tag-btn').textContent = value;
                document.querySelector(".tag-list").classList.remove("active");
                document.querySelector(".tag-btn").style.color = '#000';
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

        document.querySelector(".CreateNoticeWrapper .create-form").addEventListener("submit", (e) => {
          if(document.querySelector('.tag-btn').textContent === '선택') {
            e.preventDefault();
            document.querySelector('.CreateNoticeModal .backdrop').classList.add("active");
            document.querySelector('.CreateNoticeModal .backdrop .modal-title').textContent = "태그 선택";
            document.querySelector('.CreateNoticeModal .backdrop .modal-desc').textContent = "태그를 선택해주세요.";
            return false;
          } else if (document.querySelector('.notice-title').value === '') {
            e.preventDefault();
            document.querySelector('.CreateNoticeModal .backdrop').classList.add("active");
            document.querySelector('.CreateNoticeModal .backdrop .modal-title').textContent = "제목 입력";
            document.querySelector('.CreateNoticeModal .backdrop .modal-desc').textContent = "제목을 입력해주세요.";
            return false;
          } else if (document.querySelector('.notice-content').value === '') {
            e.preventDefault();
            document.querySelector('.CreateNoticeModal .backdrop').classList.add("active");
            document.querySelector('.CreateNoticeModal .backdrop .modal-title').textContent = "내용 입력";
            document.querySelector('.CreateNoticeModal .backdrop .modal-desc').textContent = "내용을 입력해주세요.";
            return false;
          }
        });

        document.querySelector(".CreateNoticeModal .backdrop .modal-btn-confirm").addEventListener("click", () => {
          document.querySelector('.CreateNoticeModal .backdrop').classList.remove("active");
        })
      })

    </script>
</head>
<body>
<div class="CreateNoticeWrapper">
    <div class="nav">
        <h1 class="title">공지사항</h1>
    </div>
    <form action="/notice/createNotice.do" method="post" class="create-form">
        <div class="content">
            <div class="content-header">
                <div class="tag">
                    <div class="tag-btn-box">
                        <button type="button" class="tag-btn">선택</button>
                        <img src="../../images/angle-small-down.svg" alt="태그 선택"/>
                    </div>
                    <ul class="tag-list">
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="1"
                                    class="tag-radio"
                            />훈련비</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="2"
                                    class="tag-radio"
                            />시험</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="3"
                                    class="tag-radio"
                            />BIPA행사관련</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="4"
                                    class="tag-radio"
                            />BIPA전달사항</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="5"
                                    class="tag-radio"
                            />BIPA채용공지</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="6"
                                    class="tag-radio"
                            />세미나</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="7"
                                    class="tag-radio"
                            />긴급</label
                            >
                        </li>
                        <li class="tag-item">
                            <label class="tag-label"
                            ><input
                                    type="radio"
                                    name="tag"
                                    value="8"
                                    class="tag-radio"
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
                            placeholder="제목을 입력해주세요."
                            maxlength="50"
                            autofocus
                    />
                </div>
            </div>
            <div class="content-body">
            <textarea
                    name="content"
                    class="notice-content"
                    placeholder="공지사항을 입력해주세요."
                    wrap="on"
            ></textarea>
            </div>
            <div class="content-footer">
                <button
                        type="button"
                        class="content-btn"
                        onclick="history.back()"
                >
                    취소
                </button>
                <button type="submit" class="content-btn">등록</button>
            </div>
        </div>
    </form>
</div>

<div class="CreateNoticeModal">
    <div class="backdrop">
        <div class="modal-wrapper">
            <div class="modal-desc-wrapper">
                <h2 class="modal-title">태그 설정</h2>
                <p class="modal-desc">태그를 선택해주세요.</p>
            </div>
            <div class="modal-btn-wrapper">
                <button class="modal-btn modal-btn-confirm">확인</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@ include file="/WEB-INF/layout/footer.jsp" %>