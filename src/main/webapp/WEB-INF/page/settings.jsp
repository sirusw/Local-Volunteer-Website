<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/VolunteerWeb/css/settings.css" />


<script>
var a = ['','one ','two ','three ','four ', 'five ','six ','seven ','eight ','nine ','ten ','eleven ','twelve ','thirteen ','fourteen ','fifteen ','sixteen ','seventeen ','eighteen ','nineteen '];
var b = ['', '', 'twenty','thirty','forty','fifty', 'sixty','seventy','eighty','ninety'];

function inWords (num) {
    if ((num = num.toString()).length > 9) return 'overflow';
    n = ('000000000' + num).substr(-9).match(/^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
    if (!n) return; var str = '';
    str += (n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'crore ' : '';
    str += (n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'lakh ' : '';
    str += (n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'thousand ' : '';
    str += (n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'hundred ' : '';
    str += (n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]])   : '';
    return str;
}

function capitalizeFirstLetter(string) {
	  return string.charAt(0).toUpperCase() + string.slice(1);
}

function digToEng() {
	for(var i = 1; i<100; i++){
		
		
		if(document.getElementById("collapse"+i).getAttribute("href")!= null){
			document.getElementById("collapse"+i).getAttribute("href") = "#collapse" +capitalizeFirstLetter(inWords(i));	
			
		}
		else break;
		
	}
    
};

window.onload = function() {
	  digToEng();
	};
</script>

<title>Insert title here</title>

<header>
	<h1>Local Volunteer</h1>
	<div class="btnHeader">
		${btnHeader}
		<p id="uid" style="display: none">${id}</p>


		<table align='center' border='1' cellspacing='0'
			id="numPeopleParticipated" style="display: none"	>
			<tr>
				<td>eid</td>
				<td>numPeople</td>
			</tr>
			<c:forEach items="${numPeopleParticipated}" var="n" varStatus="st">
				<tr>
					<td>${n.eid}</td>
					<td>${n.numPeople}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</header>
</head>
<body>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#eventsPosted"
			data-toggle="tab"> Events Posted </a></li>
		<li><a href="#eventsParticipated" data-toggle="tab">Events Participated</a></li>
		<li><a href="#settings" data-toggle="tab">Settings</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="eventsPosted">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<c:forEach items="${eventPosted}" var="event" varStatus="st">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="heading${st.index+1}">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="" aria-expanded="true"
									aria-controls="collapseOne" id="collapse${st.index+1}" > ${event.title} </a>
							</h4>
						</div>

						<div id="collapseOne" class="panel-collapse collapse in container"
							role="tabpanel" aria-labelledby="heading${st.index}">
							<div class="panel-body row">
								<div class="col-xs-6">
									<h4>Details</h4>
									<table class="table table-striped"
										style="margin: 5px 0px;">
										<tbody>
											<tr>
												<td>Title</td>
												<td>${event.title}</td>
											</tr>
											<tr>
												<td>description</td>
												<td>${event.description}</td>
											</tr>
											<tr>
												<td>organizer</td>
												<td>${event.organizer}</td>
											</tr>
											<tr>
												<td>Phone number:</td>
												<td>${event.tel}</td>
											</tr>
											<tr>
												<td>People needed</td>
												<td>${event.numPeople}</td>
											</tr>
											<tr>
												<td>Completion Status</td>
												<td>${event.isComplete}</td>
											</tr>

										</tbody>
									</table>
								</div>
								<div class="col-xs-6" >
									<h4>Participants</h4>
									<table class="table table-striped col-xs-6"
										style=" margin: 5px 0px;">
										<tbody>
											<c:forEach items="${listVolunteer[st.index]}" var="v" varStatus="s">
												
													<tr>
														<td>Name</td>
														<td>${v.fname} ${v.lname}</td>
													</tr>
													<tr>
														<td>Phone Number</td>
														<td>${v.tel}</td>
													</tr>
												
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="tab-pane fade" id="eventsParticipated" style="width:80%; margin:auto; padding:20px;">
			<table align='center'  id="volParticipated" class="table table-striped">
				<tr>
					<td>eid</td>
					<td>title</td>
					<td>description</td>
					<td>organizer</td>
					<td>contact</td>
				</tr>
				<c:forEach items="${volParticipated}" var="v" varStatus="st">
					<tr>
						<td>${v.eid}</td>
						<td>${v.title}</td>
						<td>${v.description}</td>
						<td>${v.organizer}</td>
						<td>${v.contact}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="settings" style="width:80%; margin:auto; padding:20px;">
			<form action="changeInfo" method="post">
				<p>First Name:</p>
				<input type="text"
					class="form-control" name="fname" value="${user.fname}"> <br>
				<p>Last Name</p>
				<input type="text" 
					class="form-control" name="lname" value="${user.lname}"> <br>
				<p>Phone Number:</p>
				<input type="text" 
					class="form-control" name="tel" value="${user.tel}"> <br>
				<p>Password:</p>
				<input type="password" 
					class="form-control" name="pw" > <br>
				<input type="submit" class="btn btn-primary" value="Update" />
			
			</form>
			${updateMsg}
		</div>

	</div>
	<div style="height: 700px"></div>
</body>
</html>