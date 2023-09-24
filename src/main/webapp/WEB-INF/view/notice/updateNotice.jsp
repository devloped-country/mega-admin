<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/notice/detailNotice.css" type="text/css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">

</head>
<body>
<div class="CreateNoticeWrapper">
    <div class="nav">
        <h1 class="title">공지사항</h1>
    </div>
    <form action="/notice/updateNotice.do" method="post" class="create-form">
        <div class="content">
            <div class="content-header">
            <input type="hidden" name="noticeId" value="${noticeId}">
                <div class="tag">
                    <div class="tag-btn-box">
                        <button type="button" class="tag-btn">선택</button>
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
                <button type="submit" id="updateButton">수정</button>
            </div>
        </div>
    </form>
</div>
<script>
          document.addEventListener('DOMContentLoaded', () => {
                  const selectedTagId = ${notice.tagId};
                  const tagRadios = document.querySelectorAll('.tag-radio');

                  tagRadios.forEach((radio) => {
                      if (radio.value === selectedTagId.toString()) {
                          radio.checked = true;
                      }
                  });
              });

                  document.querySelector(".tag-list").addEventListener("click", ({ target }) => {
                      document.querySelector('.tag-btn').textContent = target.value;
                      document.querySelector(".tag-list").classList.remove("active");
                      document.querySelector(".tag-btn").style.color = '#000';
                  });

                  document.querySelector(".CreateNoticeWrapper .create-form").addEventListener("submit", (e) => {
                      if (document.querySelector('.tag-btn').textContent === '선택') {
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
              document.querySelector('#updateButton').addEventListener('click', () => {
                              // 수정 버튼을 클릭했을 때 데이터를 가져오는 Ajax 요청
                              const formData = new FormData(document.querySelector('.create-form'));
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

          </script>
          </body>
          </html>
