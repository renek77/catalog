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

<h2><spring:message code="label.title"/></h2>

<form:form method="post" action="/Abonent/add" commandName="Abonent">
    <table>
        <tr>
            <td><form:label path="abonent_fio">
                <spring:message code="label.abonent_fio"/>
            </form:label></td>
            <td><form:input path="abonent_fio"/></td>
        </tr>
        <tr>
            <td><form:label path="abonent_adress">
                <spring:message code="label.abonent_adress"/>
            </form:label></td>
            <td><form:input path="abonent_adress"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<h3><spring:message code="label.Abonent"/></h3>
<c:if test="${!empty Abonentlist}">
    <table class="data">
        <tr>
            <th><spring:message code="label.abonent_fio"/></th>
            <th><spring:message code="label.abonent_adress"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${Abonentlist}" var="Abonent">
            <tr>
                <td>${Abonent.abonent_fio}</td>
                <td>${Abonent.abonent_adress}</td>
                <td><a href="Abonent/delete/${Abonent.id}"><spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>