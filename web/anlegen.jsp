<%-- 
    Document   : createperson
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person anlegen [Web Components ( aufgabe01b_formular )]</title>
    </head>
    <body>
        <jsp:include page = "header.jsp"/>
        <h1>Person anlegen</h1>

        <script type="text/javascript">
            function fillForm1() {
                document.getElementsByName("vorname")[0].value = 'Joe';
                document.getElementsByName("nachname")[0].value = 'Doe';
            }
            function fillForm2() {
                document.getElementsByName("vorname")[0].value = 'Mary';
                document.getElementsByName("nachname")[0].value = 'Doe';
            }
        </script>
        <form method="post" action="FrontController" name="theForm">
            Vorname: <input type="text" name="vorname" />
            Nachname: <input type="text" name="nachname" />
            <input type="button" value="Ausfüllen des Forumulars #1" onclick="fillForm1()"  />
            <input type="button" value="Ausfüllen des Forumulars #2" onclick="fillForm2()"  />
            <input type="reset" value="Reset" />
            <input type="submit" value="Submit" />
        </form>
        <jsp:include page = "footer.jsp" />
    </body>
</html>
