<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code="global.HomePage" /></title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="icon" sizes="96x96"
	href="${pageContext.servletContext.contextPath}/images/avatar.png">
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/boostrap/bootstrap.min.css" rel="stylesheet">
<spring:url value="/resources/js/jquery-1.10.2.min.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="jqueryJs1" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs2" />
<script src="${jqueryJs}"></script>
<script src="${jqueryJs1}"></script>
<script src="${jqueryJs2}"></script>
</head>
<body>

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

		<div id="content">
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

			<div class="text">
				<h4>
					<spring:message code="global.DesignDevelopmentBrand" />
				</h4>
				<h1>
					<spring:message code="global.CreativeAndExperience" />
				</h1>
				<h3>
					<spring:message code="global.Helo" />
				</h3>
				<button id="buttonone">
					<spring:message code="global.Employees" />
				</button>
				<button id="buttontwo">
					<spring:message code="global.Depart" />
				</button>
			</div>


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
					<h2><spring:message code="global.Follow"/></h2>
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