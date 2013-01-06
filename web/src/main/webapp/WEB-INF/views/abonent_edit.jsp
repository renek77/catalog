<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/res/css/styles.css"/>"/>
</head>
<body>
<t:header></t:header>

<h2><spring:message code="label.title"/></h2>

<form:form method="get" action="/abonent/update/${abonent.id}/${abonent.firstName}" commandName="abonent">
    <fieldset title="<spring:message code="label.subscriber.edit"/>" style="width: 350px;">
        <legend><spring:message code="label.subscriber.edit"/></legend>
        <table>
            <tr>
                <td>
                    <spring:message code="label.subscriber.firstName"/>
                </td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>
                    <spring:message code="label.subscriber.lastName"/>
                </td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td>
                    <spring:message code="label.subscriber.address"/>
                </td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="label.update"/>"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>