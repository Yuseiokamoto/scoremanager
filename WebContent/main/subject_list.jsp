<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, bean.Subject" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score Management</title>
<style>
  * { margin: 0; padding: 0; }
  html, body { height: 100%; }
  #wrap { min-height: 100%; display: flex; flex-direction: column; }
  #subtitle { padding: 0.5rem; }
  #subheader {
    padding: 1rem;
    background-color: gainsboro;
    border-radius: 5px;
    display: inline-block;
    width: 95%;
  }
  #right { flex: 1; padding: 10px; }
  #content { flex: 1; display: flex; width: 100%; }
  .register-link {
    display: block;
    text-align: right;
    margin-top: 1rem;
    margin-right: 5px;
  }
  table {
    width: 95%;
    border-collapse: collapse;
    margin-top: 1rem;
    margin-left: 5px;
  }
  th, td {
    border: 1px solid #aaa;
    padding: 8px;
    text-align: left;
  }
  th { background-color: #eee; }
  tr:hover { background-color: #f1f1f1; }
  .edit-link { text-decoration: none; color: blue; }
</style>
</head>
<body>

<div id="wrap">
  <%@ include file="../tool/header.jsp" %>
  <div id="content">
    <%@ include file="../tool/sidebar.jsp" %>
    <div id="right">
      <div id="subheader">
        <div id="subtitle">
          <h3>科目管理</h3>
        </div>
      </div>
      <a href="subject_update.jsp" class="register-link">新規登録</a>

      <!-- 一覧テーブル -->
      <table>
        <tr>
          <th>科目コード</th>
          <th>科目名</th>
        </tr>

        <c:forEach var="subject" items="${subject_list}">
          <tr>
            <td>${subject.cd}</td>

            <td>${subject.name}</td>
            <td>
              <a href="subject_update?code=${subject.cd}" class="edit-link">編集</a>
            </td>
          </tr>
        </c:forEach>
        <tr><td>${subject.getCd()}</td></tr>
      </table>
    </div>
  </div>
</div>

<%@ include file="../tool/footer.jsp" %>

</body>
</html>
