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

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv_cjHBq_jwSSm4BbQkH7PoZsoGLHpczI&callback=initMap&libraries=&v=weekly"
	async></script>



<title>Insert title here</title>

<header>
	<h1>Local Volunteer</h1>
	<div class="btnHeader">
		${btnHeader}
		<p id="uid" style="display: none">${id}</p>
		<table align='center' border='1' cellspacing='0' id="volParticipated">
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

		<table align='center' border='1' cellspacing='0'
			id="numPeopleParticipated">
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
		<li class="active"><a href="#eventsParticipated"
			data-toggle="tab"> Events Participated </a></li>
		<li><a href="#eventsPosted" data-toggle="tab">Events Posted</a></li>
		<li><a href="#settings" data-toggle="tab">Settings</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="eventsParticipated">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<c:forEach items="${eventPosted}" var="event" varStatus="st">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne"> ${event.title} </a>
							</h4>
						</div>

						<div id="collapseOne" class="panel-collapse collapse in container"
							role="tabpanel" aria-labelledby="headingOne">
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
								<div class="col-xs-6">
									<h4>Participants</h4>
									<table class="table table-striped col-xs-6"
										style=" margin: 5px 0px;">
										<tbody>
											<c:forEach items="${listVolunteer[st.index]}" var="v" varStatus="s">
												
													<tr>
														<td>Name</td>
														<td>${v.fname}${v.lname}</td>
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
		<div class="tab-pane fade" id="eventsPosted">
			<p>《英雄联盟》（简称lol）是由美国Riot Games开发，中国大陆地区由腾讯游戏运营的网络游戏。</p>
		</div>
		<div class="tab-pane fade" id="settings">
			<p>《风暴英雄》 是由暴雪娱乐公司开发的一款运行在Windows和Mac OS上的在线多人竞技PC游戏。</p>
			<p>
				游戏中的英雄角色主要来自于暴雪三大经典游戏系列：《魔兽世界》、《暗黑破坏神》和《星际争霸》。它是一款道具收费的游戏，与《星际争霸Ⅱ》基于同一引擎开发。
			</p>
		</div>

	</div>
	<div style="height: 700px"></div>
</body>
</html>