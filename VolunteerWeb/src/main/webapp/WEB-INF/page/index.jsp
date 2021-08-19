<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Simple Map</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/VolunteerWeb/css/style.css" />

<script src="/VolunteerWeb/js/index.js"></script>
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script
	src="https://unpkg.com/@googlemaps/markerclustererplus/dist/index.min.js"></script>


<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>


<style>
h1, h2, h3, h4, h5, h6, p {
	font-family: 'Nunito', sans-serif;
}
</style>
<header>
	<h1>Local Volunteer</h1>
	<div class="btnHeader">
		${btnHeader}
		<p id="uid" style="display: none">${id}</p>
		<table align='center' border='1' cellspacing='0' id="volParticipated" style="display: none">
			<tr>
				<td>uid</td>
				<td>eid</td>
			</tr>
			<c:forEach items="${volParticipated}" var="v" varStatus="st">
				<tr>
					<td>${v.uid}</td>
					<td>${v.eid}</td>
				</tr>
			</c:forEach>
		</table>
		
		<table align='center' border='1' cellspacing='0' id="numPeopleParticipated" style="display: none">
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
	<div class="wrapper">
		<div id="map"></div>
		<div class="addEvent">
			<h3>New Event</h3>
			<form action="addEvent" method="post">
				<p>Event Title:</p>
				<input type="text" nullmsg="Please enter your event title"
					class="form-control" name="title"> <br>
				<p>Description:</p>
				<input type="text" nullmsg="Please enter your description"
					class="form-control" name="description"> <br>
				<p>Organizer:</p>
				<input type="text" nullmsg="Please enter the organizer"
					class="form-control" name="organizer"> <br>
				<p>Tel:</p>
				<input type="text" nullmsg="Please enter your phone number"
					class="form-control" name="tel"> <br>
				<p>Number of People:</p>
				<input type="number" nullmsg="Please enter the number of people"
					class="form-control" name="numPeople"> <br>
				<p>Address:</p>
				<input type="text" id="address" nullmsg="Please enter the address"
					value="" class="form-control"> <br> 
				<input type="text"
					id="lat" class="form-control" name="lat" value=""
					style="display: none"> 
				<input type="text" id="lng"
					class="form-control" name="lng" value="" style="display: none">
				<input type="hidden" id="uid" name="uid" value="${id}">
				<% if(request.getAttribute("id")!=null)out.println("<br> <input type=\"submit\" class=\"btn btn-primary\" value=\"Add\" />");
				   else out.println("<br> <input type=\"button\" class=\"btn btn-danger\" value=\"Please log in!\" />");  %>
			
			</form>
		</div>
	</div>
	<table id="volEvent" align='center' border='1' cellspacing='0' style="display: none">

		<c:forEach items="${lv}" var="v" varStatus="st">
			<tr>
				<td>${v.id}</td>
				<td>${v.title}</td>
				<td>${v.description}</td>
				<td>${v.organizer}</td>
				<td>${v.tel}</td>
				<td>${v.numPeople}</td>
				<td>${v.lat}</td>
				<td>${v.lng}</td>
				<td>${v.id}</td>

			</tr>
		</c:forEach>
	</table>
	<!-- Async script executes immediately and must be after any DOM elements used in callback. -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=GOOGLE_MAPS_API_KEY&callback=initMap&libraries=&v=weekly"
		async></script>
</body>
</html>
