<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/res/css/styles.css"/>"/>
</head>
<body>
<%--<t:header></t:header>--%>
<form:form method="post" action="add" commandName="phone">
    <fieldset title="<spring:message code="label.subscriber.add"/>" style="width: 350px;">
        <legend><spring:message code="label.subscriber.add"/></legend>
        <table class="data">
            <tr>
                <td>
                    <form:label path="number">
                        <spring:message code="label.phone_number"/>
                    </form:label>
                </td>
                <td><form:input path="number"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="label.add"/>"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>

<h3><spring:message code="label.phone_number"/></h3>
<c:if test="${!empty phoneList}">

    <table class="data">
        <tr>
            <th><spring:message code="label.phone_number"/></th>
            <th><spring:message code="label.owner"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${phoneList}" var="phone">
            <tr>
                <td><a href="topic/${phone.id}">${phone.number}</a></td>
                <td>${phone.owner.lastName} ${phone.owner.lastName}</td>
                <td><a href="delete/${phone.id}"><spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

</body>
</html>