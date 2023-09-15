<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>


  <html>

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>공지사항</title>
    <link />
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/curriculum/createNotice.css" type="text/css">
    <link rel="stylesheet" href="../../../css/header.css">
    <link rel="stylesheet" href="../../../css/footer.css">
    <script>
      // document.addEventListener("DOMContentLoaded", () => {
      //   document.querySelector(".tag-btn-box").addEventListener("click", () => {
      //     document.querySelector(".tag-list").classList.toggle("active");
      //   });

      //   document.querySelector(".tag-list").addEventListener("click", ({target}) => {
      //     document.querySelector('.tag-btn').textContent = target.value;
      //     document.querySelector(".tag-list").classList.remove("active");
      //     document.querySelector(".tag-btn").style.color = '#000';
      //   });

      //   document.querySelector(".CreateNoticeWrapper .create-form").addEventListener("submit", (e) => {
      //     if(document.querySelector('.tag-btn').textContent === '선택') {
      //       e.preventDefault();
      //       document.querySelector('.CreateNoticeModal .backdrop').classList.add("active");
      //       document.querySelector('.CreateNoticeModal .backdrop .modal-title').textContent = "태그 선택";
      //       document.querySelector('.CreateNoticeModal .backdrop .modal-desc').textContent = "태그를 선택해주세요.";
      //       return false;
      //     } else if (document.querySelector('.notice-title').value === '') {
      //       e.preventDefault();
      //       document.querySelector('.CreateNoticeModal .backdrop').classList.add("active");
      //       document.querySelector('.CreateNoticeModal .backdrop .modal-title').textContent = "제목 입력";
      //       document.querySelector('.CreateNoticeModal .backdrop .modal-desc').textContent = "제목을 입력해주세요.";
      //       return false;
      //     } else if (document.querySelector('.notice-content').value === '') {
      //       e.preventDefault();
      //       document.querySelector('.CreateNoticeModal .backdrop').classList.add("active");
      //       document.querySelector('.CreateNoticeModal .backdrop .modal-title').textContent = "내용 입력";
      //       document.querySelector('.CreateNoticeModal .backdrop .modal-desc').textContent = "내용을 입력해주세요.";
      //       return false;
      //     }
      //   });

      //   document.querySelector(".CreateNoticeModal .backdrop .modal-btn-confirm").addEventListener("click", () => {
      //     document.querySelector('.CreateNoticeModal .backdrop').classList.remove("active");
      //   })










      // document.querySelector(".notice-content").addEventListener("input", ({currentTarget}) => {
      //   if(currentTarget.scrollHeight >= 600) {
      //     return;
      //   }
      //
      //   currentTarget.style.height = 'auto';
      //   currentTarget.style.height = currentTarget.scrollHeight + 'px';
      // })
      // })
    </script>
  </head>

  <body>
    <div class="CreateNoticeWrapper">
      <div class="nav">
        <h1 class="title">커리큘럼😜</h1>
      </div>
      <form action="createCurriculum.do" method="post" class="create-form">
        <div class="content">
          <h2>과목 추가</h2>
          <h3>과목 정보를 입력해 주세요</h3>
          <div class="content-header">
            <div class="content-header-right">
              교과목명 <input type="text" class="notice-title" name="subject" placeholder="과목을 입력해주세요." maxlength="50"
                autofocus />
            </div>
          </div>

          <div class="content-header">
            <div class="content-header-right">
              시간 <input type="text" class="notice-title" name="time" placeholder="시간을 입력해주세요." maxlength="50"
                autofocus />
            </div>
            <div class="content-header-right">
              기간 <input type="date" max="2023-12-31" min="2023-05-25" name="startDate" />
            </div>
            <div class="content-header-right">
              ~ <input type="date" max="2023-12-31" min="2023-05-25" name="endDate" />
            </div>
          </div>

          상세 교과 내용
          <div class="content-header">
            <div class="content-header-right">
              시간 <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50"
                autofocus />
            </div>
          </div>
          <div class="content-header">
            <div class="content-header-right">
              시간 <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50"
                autofocus />
            </div>
          </div>
          <div class="content-header">
            <div class="content-header-right">
              시간 <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요." maxlength="50"
                autofocus />
            </div>
          </div>

          <!-- <div class="content-body">
                    <textarea name="content" class="notice-content" placeholder="공지사항을 입력해주세요." wrap="on"></textarea>
                  </div> -->
          <div class="content-footer">
            <button type="button" class="content-btn" onclick="history.back()">
              취소
            </button>
            <button type="submit" class="content-btn">추가</button>
          </div>
        </div>
      </form>
    </div>

  </body>

  </html>


<%@ include file="/WEB-INF/layout/footer.jsp" %>