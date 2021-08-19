<!DOCTYPE html>
<html>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/VolunteerWeb/css/Regstyle.css" />

<body>
	<div class="regArea">
		<h2>Register</h2>
		<div class="regAreaIn">
			<form action="regSuccess" method="post">
				First Name:<input type="text" nullmsg="Please enter your first name" class="form-control" name="fname">
				<br>
				Last Name:<input type="text" nullmsg="Please enter your last name" class="form-control" name="lname">
				<br>
				Phone Number:<input type="tel" nullmsg="Please enter your phone number" class="form-control" name="tel">
				<br>
				Password:<input type="password" nullmsg="Please enter your password" class="form-control" name="pw">
				<br><br>
				<input type="submit" class="btn btn-primary" value="Register"/>
			</form>
		</div>
	</div>
</body>
</html>