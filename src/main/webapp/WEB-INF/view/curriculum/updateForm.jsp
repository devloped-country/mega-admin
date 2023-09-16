<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>

<html>

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>커리큘럼</title>
  <link />
  <link rel="stylesheet" href="../../../css/reset.css">
  <link rel="stylesheet" href="../../../css/curriculum/updateCurriculum.css" type="text/css">
  <link rel="stylesheet" href="../../../css/header.css">
  <link rel="stylesheet" href="../../../css/footer.css">
</head>

<body>
  <div class="CreateNoticeWrapper">
    <div class="nav">
      <h1 class="title">커리큘럼😜-update</h1>
    </div>
    <form action="updateCurriculum.do" method="post" class="create-form">
      <div class="content">
        <h2>과목 추가</h2>
        <h3>과목 정보를 입력해 주세요</h3>
        <div class="content-header">
          <div class="content-header-right">
            <input type="hidden" name="curriculumId" value="${curriculum.id}"/>
            <label>교과목명 <input type="text" class="notice-title" name="subject" placeholder="과목을 입력해주세요."
                maxlength="50" value="${curriculum.subject}" autofocus /></label>
          </div>
        </div>

        <div class="content-header">
          <div class="content-header-right">
            <label>시간 <input type="text" class="notice-title" name="time" placeholder="시간을 입력해주세요."
                maxlength="50" value="${curriculum.time}" autofocus /></label>
          </div>
          <div class="content-header-right">
            <label>기간 <input type="date" max="2023-12-31" min="2023-05-25" name="startDate"
                value="${curriculum.startDate}" /></label>
          </div>
          <div class="content-header-right">
            <label> ~ <input type="date" max="2023-12-31" min="2023-05-25" name="endDate"
                value="${curriculum.endDate}" /></label>
          </div>
        </div>

        <p>상세 교과 내용🚩</p>

        <c:forEach var="detail" items="${curriculum.detailSubjectDTOList}" varStatus="status">
          <div class="content-header">
            <div class="content-header-right">
              <input type="hidden" name="detailId" value="${detail.id}"/>
              <input type="text" class="notice-title" name="detail" placeholder="상세교과내용을 입력해주세요."
                maxlength="50" value="${detail.content}" autofocus />
              <input type="button" value="제거🚩" onclick="remove_inputbox(this.closest('.content-header'), '${detail.id}')">
            </div>
          </div>
        </c:forEach>

        <!-- hidden inputs to keep track of removed detail.ids -->
        <div id="removedDetailsContainer">
        </div>

        <!-- 새로운 input 추가 -->
        <div id="additionalInputContainer">
        </div>

        <div class="content-footer">
          <div>
            <button type="button" class="content-btn" onclick="add_inputbox()">
              상세 교과 내용 추가
            </button>
          </div>

          <button type="button" class="content-btn" onclick="history.back()">
            취소
          </button>
          <button type="submit" class="content-btn">수정</button>
        </div>
      </div>
    </form>
  </div>


  <script>
    function add_inputbox() {
      const newDiv = document.createElement("div");
      newDiv.className = "content-header";

      const newLabel = document.createElement("div");
      newLabel.className = "content-header-right";

      const newInput = document.createElement("input");
      newInput.type = "text";
      newInput.className = "notice-title";
      newInput.name = "addDetail";
      newInput.placeholder = "상세교과내용을 입력해주세요.";
      newInput.maxLength = "50";

      const newButton = document.createElement("input");
      newButton.type = "button";
      newButton.value = "제거";
      newButton.onclick = function () { remove_inputbox(newDiv); };

      newLabel.appendChild(newInput);
      newLabel.appendChild(newButton);
      newDiv.appendChild(newLabel);

      const container = document.getElementById("additionalInputContainer");
      container.appendChild(newDiv);
    }

    function remove_inputbox(divElement, detailId) {
      if (detailId) {
        const hiddenInput = document.createElement("input");
        hiddenInput.type = "hidden";
        hiddenInput.name = "removedDetails";
        hiddenInput.value = detailId;

        const container = document.getElementById("removedDetailsContainer");
        container.appendChild(hiddenInput);
      }
      divElement.remove();
    }
  </script>



  </body>

</html>


<%@ include file="/WEB-INF/layout/footer.jsp" %>