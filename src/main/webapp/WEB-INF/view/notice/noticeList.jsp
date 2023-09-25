<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<%@ include file="/WEB-INF/layout/header.jsp" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../../../style/reset.css">
    <link rel="stylesheet" href="../../../style/notice/notice.css" type="text/css">
    <link rel="stylesheet" href="../../../style/header.css">
    <link rel="stylesheet" href="../../../style/footer.css">
</head>
<body>
<div class="NoticeWrapper">
        <div class="nav">
            <h1 class="title">공지사항</h1>
            <ul class="menu-list">
                <li class="menu-item">
                    <button type="button" class="menu-btn notice-regi-btn"
                            onclick="location.href='/notice/createNoticeForm.do'">공지사항 등록
                    </button>
                </li>
            </ul>

        </div>
        <div class="notice-table-header">
            <div class="notice-table-header-row">
                <div class="notice-table-header-col notice-table-header-col-num">
                    <div class="notice-table-header-cell notice-table-header-num">
                        연번
                    </div>
                </div>
                <div class="notice-table-header-col notice-table-header-col-tag">
                    <div class="notice-table-header-cell notice-table-header-tag">
                        태그
                    </div>
                </div>
                <div class="notice-table-header-col notice-table-header-col-title">
                    <div class="notice-table-header-cell notice-table-header-title">
                        제목
                    </div>
                </div>
                <div class="notice-table-header-col notice-table-header-col-content">
                    <div class="notice-table-header-cell notice-table-header-content">
                        내용
                    </div>
                </div>
                <div class="notice-table-header-col notice-table-header-col-author">
                    <div class="notice-table-header-cell notice-table-header-author">
                        작성자
                    </div>
                </div>
                <div class="notice-table-header-col notice-table-header-col-date">
                    <div class="notice-table-header-cell notice-table-header-date">
                        일시
                    </div>
                </div>
            </div>
        </div>

        <div class="content">
           <table class="notice-table">
              <tbody class="notice-table-body">
                 <c:set var="idx" value="0"/>
                     <c:set var="page" value="${ (param.page == null ) ? 1 : param.page }" />
                     <c:set var="index" value="${ (page - 1) * 10 + index + 1 }"></c:set>
                         <c:forEach items="${noticeList}" var="notice">
                             <tr class="notice-table-body-row" onclick="location.href='/notice/noticeDetail.do?id=${notice.id}'">
                                <td class="notice-table-body-col notice-table-body-col-num">
                                    <div class="notice-table-body-cell notice-table-body-num">
                                        ${index}
                                    </div>
                                  </td>
                                  <td class="notice-table-body-col notice-table-body-col-tag">
                                      <div class="notice-table-body-cell notice-table-body-tag">
                                        <c:choose>
                                            <c:when test="${notice.tagId == 1}">
                                                훈련비
                                            </c:when>
                                            <c:when test="${notice.tagId == 2}">
                                                시험
                                            </c:when>
                                             <c:when test="${notice.tagId == 3}">
                                                 BIPA행사관련
                                             </c:when>
                                            <c:when test="${notice.tagId == 4}">
                                                BIPA전달사항
                                            </c:when>
                                            <c:when test="${notice.tagId == 5}">
                                                BIPA채용공지
                                            </c:when>
                                            <c:when test="${notice.tagId == 6}">
                                                세미나
                                            </c:when>
                                            <c:when test="${notice.tagId == 7}">
                                                긴급
                                            </c:when>
                                            <c:when test="${notice.tagId == 8}">
                                                기타
                                            </c:when>
                                        </c:choose>
                                      </div>
                                  </td>
                                  <td class="notice-table-body-col notice-table-body-col-title">
                                      <div class="notice-table-body-cell notice-table-body-title">
                                         ${notice.title}
                                      </div>
                                  </td>
                                  <td class="notice-table-body-col notice-table-body-col-content">
                                      <div class="notice-table-body-cell notice-table-body-content">
                                          ${notice.content}
                                      </div>
                                  </td>
                                  <td class="notice-table-body-col notice-table-body-col-author">
                                      <div class="notice-table-body-cell notice-table-body-author">
                                          ${notice.author} 매니저님
                                      </div>
                                  </td>
                                  <td class="notice-table-body-col notice-table-body-col-date">
                                      <div class="notice-table-body-cell notice-table-body-date">
                                          <c:if test="${not empty notice.createdDate}">
                                            <fmt:formatDate value="${notice.createdDate}" pattern="yyyy-MM-dd HH:mm" />
                                          </c:if>
                                      </div>
                                  </td>
                             </tr>
                        <c:set var="index" value="${ index + 1 }"></c:set>
                     </c:forEach>
              </tbody>
           </table>
        </div>

        <div class="pagination-wrapper">
            <div class="pagination">
                <c:set var="page" value="${ ( param.page == null ) ? 1 : param.page }" />
                <c:set var="startNum" value="${ page - (page - 1) % 5 }"/>
                <c:set var="endNum" value="${ endNum }"/>
                <c:set var="currentPageBlock" value="${ currentPageBlock }" />

                <div>
                   <c:if test="${ startNum >= 6 }">
                      <a href="?page=1"><img src="../../../images/angle-double-small-left.svg" alt="처음 페이지로"></a>
                   </c:if>
                </div>
                <div>
                  <c:if test="${ startNum - 1 > 0 }">
                    <a href="?page=${ startNum - 1 }"><img src="../../../images/angle-small-left.svg" alt="이전"></a>
                  </c:if>
                </div>
                <ul class="page-number">
                  <c:if test="${ currentPageBlock + 4 <= endNum }">
                    <c:forEach var="i" begin="0" end="4">
                      <li><a class="${page == (startNum + i) ? "page-number-button-on" : ""}" href="?page=${ startNum + i }">${ startNum + i }</a></li>
                    </c:forEach>
                  </c:if>
                  <c:if test="${ currentPageBlock + 4 > endNum && endNum != 0 }">
                    <c:forEach var="i" begin="0" end="${ endNum - currentPageBlock }">
                      <li><a class="${page == (startNum + i) ? "page-number-button-on" : ""}" href="?page=${ startNum + i }">${ startNum + i }</a></li>
                    </c:forEach>
                  </c:if>
                </ul>

                <div>
                  <c:if test="${ startNum + 4 < endNum }">
                    <a href="?page=${ startNum + 5 }"><img src="../../../images/angle-small-right.svg" alt="다음"></a>
                  </c:if>
                </div>
                <%-- 마지막 블록 --%>
                <div>
                  <c:if test="${ startNum + 4 < endNum }">
                    <a href="?page=${ endNum }"><img src="../../../images/angle-double-small-right.svg" alt=" 마지막 페이지로"></a>
                  </c:if>
                </div>
            </div>
        </div>
</body>


</html>

<%@ include file="/WEB-INF/layout/footer.jsp" %>