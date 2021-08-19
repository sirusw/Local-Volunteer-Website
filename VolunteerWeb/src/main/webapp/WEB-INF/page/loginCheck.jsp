<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	window.onload = function(){
  		document.forms['logininfo'].submit();
  	}
</script>
<form action="index" method="post" name="logininfo" style="display:none">
	<input type="text" value="${id}" name="id"/>
	<input type="text" value="${fname}" name="fname"/>
	<input type="text" value="${lname}" name="lname"/>
	<input type="text" value="${tel}" name="tel"/>
</form>