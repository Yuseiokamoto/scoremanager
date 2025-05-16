<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../header.html" %>

<div id = "wrapper">
		<div id = "header">
			<div id = "title">得点管理システム</div>
			<div id = "subInfo">
				<!-- ログイン?顧客名※(todo)JSPで出力制御 -->
				<div id = "subleft">ログイン</div>
				<!-- ログアウト?非表示※(todo)JSPで出力制御 -->
				<div id = "subright">ログアウト</div>
			</div>
		</div>
		<div id = "main">
			<h3>メインメニュー</h3>
			<div><a href = "todo">学生管理</a></div>
			<div><a href = "todo">成績登録</a></div>
			<div><a href = "todo">成績参照</a></div>
			<div><a href = "todo">科目管理</a></div>
		</div>
	</div>

<%@include file = "../footer.html" %>
