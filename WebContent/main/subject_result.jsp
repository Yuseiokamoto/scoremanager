<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../tool/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Score Management</title>
<style>
    * { margin: 0; padding: 0; }

    html, body { height: 100%; }

    #wrap {
        min-height: 100%;
        display: flex;
        flex-direction: column;
    }

    #subtitle {
        padding: 0.5rem 0.5rem;
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

    .message-box {
        margin-top: 2rem;
        background-color: #f5f5f5;
        padding: 1.5rem;
        border-radius: 10px;
        box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
</style>
</head>
<body>

<div id="wrap">

    <div id="content">
        <%@ include file="../tool/sidebar.jsp" %>

        <div id="right">
            <div id="subheader">
                <div id="subtitle">
                    <h3>科目情報登録</h3>
                </div>
            </div>

            <div class="message-box">
                <p>登録が完了しました</p>
                <br>
                <!-- 戻るリンク：code を渡して subject_update.jsp に戻る -->
                <!-- subject オブジェクトが正しくリクエストにセットされていることを確認 -->
                <c:if test="${not empty subject}">
                    <a href="subject_update.jsp?code=${subject.cd}">戻る</a>
                </c:if>
                <a href="/tool/SubjectList.action">科目一覧</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="../tool/footer.jsp" %>

</body>
</html>
