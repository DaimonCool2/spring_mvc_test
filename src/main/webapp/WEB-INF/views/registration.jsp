<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
    <title>Registration</title>

    <link href="<c:url value="/resources/css/styleForRegistration.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<%--     <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet"> --%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

<div class="container">
    <div class="panel-heading">
        <div class="panel-title text-center">
            <h1 class="title"><spring:message code="registration" /></h1>
            <hr/>
        </div>
    </div>

    <form:form method="POST" modelAttribute="regUser" action="register" class="form-horizontal">

<!--         <div class="form-group input"> -->
<!--             <label class="col-md-4 control-label"><fmt:message key="mail"/></label> -->
<!--             <div class="col-md-4 inputGroupContainer"> -->
<!--                 <div class="input-group"> -->
<!--                     <span class="input-group-addon"><i class="fa fa-envelope"></i></span> -->
<%--                     <input name="email" placeholder="<fmt:message key="mail"/>" class="form-control" type="text" --%>
<%--                            value="${param.email}"> --%>
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->

        <div class="form-group input">
            <form:label path="username" class="col-md-4 control-label"><spring:message code="username" /></form:label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                    <form:input path="username" class="form-control"/> 
                </div>
                <form:errors path="username" />
            </div>
        </div>


        <div class="form-group input">
            <form:label path="password" class="col-md-4 control-label"><spring:message code="password" /></form:label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
			        <form:password path="password" class="form-control"/>
                </div>
                <form:errors path="password" />
            </div>
        </div>

        <div class="form-group input">
            <form:label path="confirmPassword" class="col-md-4 control-label"><spring:message code="confirm.password" /></form:label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                    <form:password path="confirmPassword" class="form-control"/>			        
                </div>
                <form:errors path="confirmPassword" />
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button"><spring:message code="register.button" /> <span
                        class="fa fa-search"></span></button>
            </div>
        </div>

  </form:form>
</div>


</body>

</html>
