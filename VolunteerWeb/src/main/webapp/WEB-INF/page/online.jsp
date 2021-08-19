<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>ID</td>
	</tr>
	<c:forEach items="${keys}" var="key" varStatus="st">
		<tr>
			<td>${key}</td>
		</tr>
	</c:forEach>
</table>
