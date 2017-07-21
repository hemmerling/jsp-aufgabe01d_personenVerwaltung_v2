<%--
    Document   : createperson
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personenliste [Web Components ( aufgabe01d_personenVerwaltung_v2 )]</title>
    </head>
    <body>
        <jsp:include page = "header.jsp" />
        <h1>Personenliste</h1>
        <%
            List<String[]> persons = (List<String[]>) session.getAttribute("persons");
            if (persons == null /* || items.isEmpty() */) {
        %>
        <% } else { %>
        <ol>
            <% for (String[] person : persons) {%>
            <li><%= person[0]%> <%= person[1]%></li>
                <% } %>
        </ol>
        <% }%>
        <jsp:include page = "footer.jsp" />
    </body>
</html>
