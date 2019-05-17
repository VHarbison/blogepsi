
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Erreur</title>
    </head>
    
	<body>
	
        <c:if test="${!(empty errors)}">
                <c:forEach var="error" items="${ errors }">
                    <h3 style="color:red"> ${ error } </h3>
                </c:forEach>
        </c:if>
        
        	<c:choose>
			<c:when test="${ (empty user) }">
				Cliquez ici pour<a href="Login.do">here</a> vous identifiez
			</c:when>
			<c:otherwise>
				cliquez ici pour  <a href="Home.do">here</a> retourner à l'acceuil
			</c:otherwise>
		</c:choose>
		
	</body>
</html>
