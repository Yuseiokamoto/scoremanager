<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="bean.Subject" %>
<%@ include file="../tool/header.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>科目情報登録</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }

        html, body {
            height: 100%;
            font-family: sans-serif;
        }

        #wrap {
            min-height: 100%;
            display: flex;
            flex-direction: column;
        }

        #subtitle {
            padding: 0.5rem;
        }

        #subheader {
            padding: 1rem;
            background-color: gainsboro;
            border-radius: 5px;
            display: inline-block;
            width: 95%;
        }

        #right {
            flex: 1;
            padding: 10px;
        }

        #content {
            flex: 1;
            display: flex;
            width: 100%;
        }

        form {
            margin-top: 2rem;
            width: 500px;
        }

        label {
            display: block;
            margin-top: 1rem;
        }

        input[type="text"] {
            width: 100%;
            padding: 0.5rem;
            margin-top: 0.3rem;
            font-size: 1rem;
        }

        input[type="submit"] {
            margin-top: 1.5rem;
            background-color: #007bff;
            color: white;
            border: none;
            padding: 0.5rem 1.5rem;
            border-radius: 5px;
            cursor: pointer;
        }

        a {
            margin-left: 1rem;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>

<%
    Subject subject = (Subject) request.getAttribute("subject");
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
                    <h3>科目情報登録</h3>
                </div>
            </div>

            <form action="/scoremanager/main/subject_update" method="post">
                <label>科目コード<br>
                    <input type="text" name="code" maxlength="3"
                           placeholder="科目コードを入力してください"
                           value="<%= subject.getCd() != null ? subject.getCd() : "" %>" required>
                </label>

                <label>科目名<br>
                    <input type="text" name="name" maxlength="20"
                           placeholder="科目名を入力してください"
                           value="<%= subject.getName() != null ? subject.getName() : "" %>" required>
                </label>

                <input type="submit" value="登録">
                <br>
                <a href="subject_list.jsp" class="back-button">戻る</a>
            </form>
        </div>
    </div>
</div>

<%@ include file="../tool/footer.jsp" %>
</body>
</html>
