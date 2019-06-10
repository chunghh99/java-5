<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sp:url value="/resources/css/login.css" var="loginCSS" />
<link href="${loginCSS}" rel="stylesheet" type="text/css" />
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/boostrap/bootstrap.min.css" rel="stylesheet">
<sp:url value="/resources/js/jquery-1.10.2.min.js" var="jqueryJs" />
<sp:url value="/resources/js/bootstrap.min.js" var="jqueryJs1" />
<sp:url value="/resources/js/jquery.min.js" var="jqueryJs2" />
<script src="${jqueryJs}"></script>
<script src="${jqueryJs1}"></script>
<script src="${jqueryJs2}"></script>
<title><sp:message code="login.Title"/>  </title>
</head>
<body>
<div id="dropdown">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					<sp:message code="global.Language"/> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#" data-lang="en">English</a></li>
					<li><a href="#" data-lang="vi">Tiếng Việt</a></li>
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
<div class="loginbox">
<img src="<sp:url value="/images/avatar.png"/>" class="avatar"/>
<spring:form method="POST" commandName="user" action="login.htm">
	<sp:message code="login.${message}"/>
	<p><sp:message code="login.Username"/> </p> 	<spring:input path="username" placeholder="Enter Usename "/><br>
	<p><sp:message code="login.Password"/> </p> 	<spring:password  path="password" placeholder="Enter Password"/><br>
	<input type="submit" value="login" class="login100-form-btn">
</spring:form>
<a href="index.htm"><sp:message code="login.Message"/></a>
</div>
</body>
</html>