<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url value="/resources/css/user.css" var="userCSS" />
<link href="${userCSS}" rel="stylesheet" type="text/css" />
<title><spring:message code="user.title" /></title>
<spring:url value="/resources/js/jquery-1.10.2.min.js" var="jqueryJs" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
	<div id="dropdown">
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				<spring:message code="global.Language" />
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#" data-lang="en">English</a></li>
				<li><a href="#" data-lang="vi">Tiếng Việt</a></li>
			</ul>
		</div>
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				<spring:message code="global.${sessionScope.btlogin}" />${sessionScope.username}
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="${sessionScope.loginout}"><spring:message
							code="global.${sessionScope.btloginout}" /></a></li>
				<li><a href="${sessionScope.repass}"><spring:message
							code="global.${sessionScope.btrepass}" /></a></li>
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
		<form:form action="users.htm" modelAttribute="users" method="POST">
			<h3 id="accountinformation">
				<spring:message code="user.accountinformation" />
			</h3>
			<div class="information">
				<div>
					<spring:message code="user.account" />
				</div>
				<form:input path="username" class="input" />
				<div>
					<spring:message code="user.password" />
				</div>
				<form:input path="password" class="input" />
				<div>
					<spring:message code="user.fullname" />
				</div>
				<form:input path="fullname" class="input" />
			</div>
			<div id="btn">
				<button name="bntInsert" class="bt">
					<spring:message code="user.add" />
				</button>
				<button name="bntUpdate" class="bt">
					<spring:message code="user.update" />
				</button>
			</div>
		</form:form>
	</div>
	<div class="container">
		<h3>
			<spring:message code="user.accountlist" />
		</h3>
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<th><spring:message code="user.account" /></th>
				<th><spring:message code="user.password" /></th>
				<th><spring:message code="user.fullname" /></th>
				<th></th>
			</tr>
			<c:forEach var="u" items="${user}">
				<tr>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td>${u.fullname}</td>
					<td><a href="edit/${u.username}.htm"><spring:message
								code="user.edit" /> </a> | <a href="deleteUser/${u.username}.htm"><spring:message
								code="user.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
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