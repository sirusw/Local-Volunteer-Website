<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/VolunteerWeb/css/Regstyle.css" />

<body>
	<div class="regArea">
		<h2>Login</h2>
		<div class="regAreaIn">
			<form action="loginCheck" method="post">
				Phone Number:<input type="tel" class="form-control" name="tel">
				<br> Password:<input type="password" class="form-control"
					name="pw"> <br> <br> 
					<input type="submit"
					class="btn btn-primary" value="Login" />
			</form>

		</div>
		<h4>${message}</h4>
	</div>

</body>
</html>