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

<form:form method="post" action="abonent/add" commandName="abonent">
    <fieldset title="<spring:message code="label.subscriber.add"/>" style="width: 350px;">
        <legend><spring:message code="label.subscriber.add"/></legend>
        <table>
            <tr>
                <td><form:label path="firstName">
                    <spring:message code="label.subscriber.firstName"/>
                </form:label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName">
                    <spring:message code="label.subscriber.lastName"/>
                </form:label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><form:label path="address">
                    <spring:message code="label.subscriber.address"/>
                </form:label></td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="label.add"/>"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>

<h3><spring:message code="label.Abonent"/></h3>
<c:if test="${!empty abonentlist}">
    <table class="data">
        <tr>
            <th><spring:message code="label.abonent_fio"/></th>
            <th><spring:message code="label.abonent_adress"/></th>
            <th>&nbsp;</th>
        </tr>

        <c:forEach items="${abonentlist}" var="abonent">
            <tr>
                <td><a href="phone/${abonent.id}">${abonent.firstName} ${abonent.lastName}</a></td>
                <td>${abonent.address}</td>
                <td><a href="abonent/delete/${abonent.id}"><spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>