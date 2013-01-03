<%@ tag body-content="empty" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="header">
    <div class="wrap">
        <div class="logo"><a href="#"></a></div>
        <div class="form">
            <c:choose>
                <c:when test="${Abonent.nick==null}">
                    <form:form method="post" action="/login" commandName="Abonent">
                        <table>
                            <tr>
                                <td><input type="text" name="email"></td>
                                <td><input type="text" name="password"></td>
                                <td><input type="submit" value="send"/></td>
                            </tr>
                            <tr>
                                <td align="center"><a href="/registration" class="underline"
                                                      title="Register">Register</a>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </c:when>
                <c:when test="${Abonent.nick!=null}">
                    <div class="logged">
                        <div class="cont">
                            <p>Welcome, <strong><c:out value="${Abonent.nick}"/></strong>
                                <a href="/logout">logout </a></p>
                        </div>
                    </div>
                </c:when>
            </c:choose>
            <a href="/home">home</a>
        </div>
    </div>
</div>