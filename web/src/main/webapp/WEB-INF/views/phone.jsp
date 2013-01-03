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
<t:header></t:header>
<form:form method="post" action="add" commandName="Phone">
    <c:if test="${!empty Abonent.abonent_fio}">

        <table>
            <tr>
                <td><form:label path="phone_number">
                    <spring:message code="label.phone_number"/>
                </form:label></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message code="label.add"/>"/>
                </td>
            </tr>
        </table>

    </c:if>

    <h3><spring:message code="label.phone_number"/></h3>
    <c:if test="${!empty PhoneList}">

        <table class="data">
            <tr>
                <th><spring:message code="label.phone_number"/></th>
                <th><spring:message code="label.owner"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${PhoneList}" var="Phone">
                <tr>
                    <td><a href="topic/${Phone.id}">${Phone.phone_number}</a></td>
                    <td>${Phone.owner.abonent_fio}</td>
                    <c:if test="${!empty Abonent.abonent_fio}">
                        <td><a href="delete/${Phone.id}"><spring:message code="label.delete"/></a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

    </c:if>
</form:form>
</body>
</html>