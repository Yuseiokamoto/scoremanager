<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file = "../tool/header.html" %>

<%@page isErrorPage = "true" %>
<%@page errorPage = "hello-error.jsp" %>
<p>数値を入力してください。</p>
<p><%=exception %></p>

<%@include file = "../tool/footer.html" %>
</div>