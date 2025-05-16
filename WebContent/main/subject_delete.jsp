<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.net.URLEncoder" %>
<%
    String cd = request.getParameter("cd");
    String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科目情報削除</title>
    <style>
        * { margin: 0; padding: 0; }

        html, body { height: 100%; font-family: sans-serif; }

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

        .btn {
            padding: 10px 20px;
            background-color: #e74c3c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .link {
            margin-top: 20px;
            display: inline-block;
        }

        .confirm-box {
            margin-top: 30px;
        }
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
                    <h3>科目情報削除</h3>
                </div>
            </div>

            <div class="confirm-box">
                <p>「<%= name %>（<%= cd %>）」を削除してもよろしいですか？</p>

                <form action="SubjectDeleteExecute.action" method="post">
                    <input type="hidden" name="cd" value="<%= cd %>">
                    <button type="submit" class="btn">削除</button>
                </form>

                <div class="link">
                    <a href="subject_list.jsp">戻る</a>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="../tool/footer.jsp" %>

</body>
</html>
