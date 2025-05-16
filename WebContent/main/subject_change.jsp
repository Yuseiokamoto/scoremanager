<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="bean.Subject" %>
<%@ include file="../tool/header.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>科目情報変更</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        html, body { height: 100%; font-family: sans-serif; }

        #wrap {
            min-height: 100%;
            display: flex;
            flex-direction: column;
        }

        #content {
            flex: 1;
            display: flex;
            width: 100%;
        }

        #right {
            flex: 1;
            padding: 10px;
        }

        #subheader {
            padding: 1rem;
            background-color: gainsboro;
            border-radius: 5px;
            width: 95%;
        }

        #subtitle {
            padding: 0.5rem;
        }

        form {
            margin-top: 2rem;
            width: 500px;
        }

        label {
            display: block;
            margin-top: 1.5rem;
            font-weight: bold;
        }

        .readonly-text {
            margin-top: 0.5rem;
            font-size: 1rem;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 0.5rem;
            margin-top: 0.3rem;
            font-size: 1rem;
        }

        .error {
            color: red;
            font-size: 0.9rem;
            margin-top: 0.3rem;
        }

        .button-group {
            margin-top: 1.5rem;
        }

        input[type="submit"], .back-button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 0.5rem 1.5rem;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 1rem;
            text-decoration: none;
        }

        .back-button {
            background-color: transparent;
            color: #007bff;
            border: none;
            text-decoration: underline;
        }

    </style>
</head>
<body>

<%
    Subject subject = (Subject) request.getAttribute("subject");
    String errorMessage = (String) request.getAttribute("errorMessage");

    if (subject == null) {
        subject = new Subject();
    }
%>

<div id="wrap">
    <div id="content">
        <%@ include file="../tool/sidebar.jsp" %>

        <div id="right">
            <div id="subheader">
                <div id="subtitle">
                    <h3>科目情報変更</h3>
                </div>
            </div>

            <!-- エラーメッセージ表示 -->
            <% if (errorMessage != null) { %>
                <div class="error"><%= errorMessage %></div>
            <% } %>

            <form action="/kadai/scoremanager/main/Subject" method="post">
                <!-- 科目コード（変更不可） -->
                <label>科目コード</label>
                <div class="readonly-text"><%= subject.getCd() %></div>
                <input type="hidden" name="code" value="<%= subject.getCd() %>">

                <!-- 科目名 -->
                <label>科目名</label>
                <input type="text" name="name" maxlength="20"
                       placeholder="科目名を入力してください"
                       value="<%= subject.getName() %>" required>

                <div class="button-group">
                    <input type="submit" value="変更">
                    <br>
                    <a href="subject_list.jsp" class="back-button">戻る</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="../tool/footer.jsp" %>
</body>
</html>
