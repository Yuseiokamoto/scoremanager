<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../tool/header.html" %>

			<h3>メインメニュー</h3>
			<div><a href = "todo">学生管理</a></div>
			<div><a href = "todo">成績登録</a></div>
			<div><a href = "todo">成績参照</a></div>
			<div><a href = "todo">科目管理</a></div>
			<div style = "margin-top: 1rem; padding: 1rem; background-color: lavender;">
			<div>ここはページ遷移の演習領域</div>
				<form action = "hello-out.jsp" method = "post">
					<input type = "text" name = "price">
					円×
					<input type = "text" name = "count">
					個＝
					<input type = "submit" value = "計算">
				</form>
			</div>

<%@include file = "../tool/footer.html" %>