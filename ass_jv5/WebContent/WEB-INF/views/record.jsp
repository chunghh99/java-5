<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="record.Title" /></title>
<spring:url value="/resources/css/record.css" var="record" />
<base href="${pageContext.servletContext.contextPath}/">
<link rel="icon" sizes="96x96"
	href="${pageContext.servletContext.contextPath}/images/avatar.png">
<link href="resources/boostrap/bootstrap.min.css" rel="stylesheet">
<spring:url value="/resources/js/jquery-1.10.2.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="jqueryJs1" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs2" />
<script src="${jqueryJs}"></script>
<script src="${jqueryJs1}"></script>
<script src="${jqueryJs2}"></script>
<link href="${record}" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="header">
		<div class="bgimage">

			<div class="menu">

				<div class="leftmenu">
					<h4>BCTM GROUP</h4>
				</div>

								<div class="rightmenu">
					<ul>
						<li id="fisrtlist"><a href="index.htm"><spring:message
									code="global.Home" /></a></li>
						<li><a href="departs.htm"><spring:message
									code="global.Depart" /></a></li>
						<li><a href="staff.htm"><spring:message
									code="global.Employees" /></a></li>
						<li><a href="report.htm"><spring:message
									code="global.RewardAnddiscipline" /></a></li>
						<li><a href="user.htm"><spring:message code="global.User" /></a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<br>

		<div id="dropdown">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<spring:message code="global.Language"/> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#" data-lang="en">English</a></li>
					<li><a href="#" data-lang="vi">Tiếng Việt</a></li>
				</ul>
			</div>
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<spring:message code="global.${sessionScope.btlogin}"/>${sessionScope.username} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="${sessionScope.loginout}"><spring:message code="global.${sessionScope.btloginout}"/></a></li>
					<li><a href="${sessionScope.repass}"><spring:message code="global.${sessionScope.btrepass}"/></a></li>
				</ul>
			</div>
			<script>
				$(function() {
					$("a[data-lang]").click(function() {
						var lang = $(this).attr("data-lang");
						$.get("index.htm?lang=" + lang, function() {
							location.reload();
						});
						return false;
					});
				});
			</script>

</div>
	<div id="content">
		<div class="container">
			<h3>
				<spring:message code="record.ListOfAchievements" />
			</h3>
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<td><spring:message code="record.StaffId" /></td>
					<td><spring:message code="record.Name" /></td>
					<td><spring:message code="record.Reason" /></td>
					<td><spring:message code="record.DateRecord" /></td>
					<td></td>
				</tr>
				<c:forEach var="u" items="${listThanhtich}">
					<tr>
						<td>${u.staff.getId()}</td>
						<td>${u.staff.getName()}</td>
						<td>${u.reason}</td>
						<td>${u.date}</td>
						<td><a href="removerecord/${u.id}.htm"><spring:message
									code="record.Delete" /></a></td>
					</tr>
				</c:forEach>

			</table>
		</div>


		<div class="container">
			<h3>
				<spring:message code="record.DisciplineList" />
			</h3>
			<table
				class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<td><spring:message code="record.StaffId" /></td>
					<td><spring:message code="record.Name" /></td>
					<td><spring:message code="record.Reason" /></td>
					<td><spring:message code="record.DateRecord" /></td>
					<td></td>
				</tr>
				<c:forEach var="u" items="${listKiluat}">
					<tr>
						<td>${u.staff.getId()}</td>
						<td>${u.staff.getName()}</td>
						<td>${u.reason}</td>
						<td>${u.date}</td>
						<td><a href="removerecord/${u.id}.htm"><spring:message
									code="record.Delete" /></a></td>
					</tr>
				</c:forEach>

			</table>
		</div>

	</div>

	<div id="footer">

		<div class="noidungfooter">
			<div class="cot1">
				<h2>
					<spring:message code="global.Policy" />
				</h2>
				<ul>
					<li><a href="#"><spring:message
								code="global.CompanyRegulation" /></a></li>
					<li><a href="#"><spring:message code="global.SalaryPolicy" /></a></li>
				</ul>
				<div class="follow">
					<br>
					<h2>Follow us</h2>
					<a href="#">Facebook</a> <a href="#">Zalo</a> <a href="#">Instagram</a>
					<a href="#">Youtube</a>
				</div>
			</div>
			<div class="cot2">
				<h2>
					<spring:message code="global.Contact" />
				</h2>
				<ul>
					<li><a href="#"><spring:message code="global.NumberPhone" />:
							1800 1010</a></li>
					<li><a href="#"><spring:message code="global.Email" />:
							nhom2@gmail.com </a></li>
					<li><a href="#"><spring:message code="global.Address" />:
							PT13301UD_Nhom2 </a></li>
				</ul>
			</div>
			<div class="cot3">
				<h2>
					<spring:message code="global.Singup" />
				</h2>
				<p style="text-align: justify">
					<spring:message code="global.Feedback" />
				</p>
				<input type="email" name="Mail" placeholder="abc@xyz.com" />
				<button type="submit" name="submitMail" class="hvr-wobble-vertical">
					<spring:message code="global.Send" />
				</button>
			</div>

		</div>


		<div class="thongtinsohuu">
			<br>
			<p>
				<spring:message code="global.Create" />
			</p>
		</div>
	</div>
</body>
</html>