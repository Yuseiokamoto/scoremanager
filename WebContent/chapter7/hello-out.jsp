<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file = "../tool/header.html" %>

<%@page errorPage = "hello-error.jsp" %>

<%
	request.setCharacterEncoding( "UTF-8" );
	int price = Integer.parseInt( request.getParameter( "price" ) );
	int count = Integer.parseInt( request.getParameter( "count" ) );
%>

<%=price %>円×<%=count %>個＝<%=price * count %>円

<%@include file = "../tool/footer.html" %>
</div>