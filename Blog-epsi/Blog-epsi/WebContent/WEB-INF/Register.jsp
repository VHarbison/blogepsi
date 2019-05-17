<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>S'enregistrer</title>
    </head>
    
	<body onload="document.getElementById('email').focus()">
	
	<jsp:include page="page.jsp"/>
		<div  class = "container">
               <div class="sidebar">   
                        
      <c:forEach var="usertmp" items="${users}">
		<c:if test="${user.email ne usertmp.email}">
		<ul><form action="Visitor.do" method="POST">
		<input type="hidden" name="email" value= "${usertmp.email}">
		<a href="javascript:;" onclick="parentNode.submit();"  style="float: right;">${usertmp.firstname} ${usertmp.lastname}</a>
        </form></ul>
      </c:if>
      </c:forEach>
      </div>
      </div>
      
    

      <div class="container">
                <div>
                <h1>
                Bienvenue</h1>
                </div>
		<hr>
		
		  <div class = "error" >
<%
		List<String> errors = (List<String>) request.getAttribute("errors");
		if (errors != null) {
			for (String error : errors) {
%>	
				<h3 style="color:red"> <%= error %> </h3>
<%
			}
		}
%>	
         </div>

		<div class="main-login main-center">
					<form class="form-horizontal" method="post">
					<input type="hidden" name="redirect" value="${redirect}"/>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Mail</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fas fa-envelope" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  value="${param.email}"  placeholder="Entrer votre mail"/>
								</div>
							</div>
						</div>
                        
                        
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Prénom</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fas fa-user"></i></span>
									<input type="text" class="form-control" name="firstName" id="FirstName"  value="${param.firstName}" placeholder="Entrez votre Prenom"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Nom</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fas fa-user"></i></span>
									<input type="text" class="form-control" name="lastName" id="LastName" value="${param.lastName}"  placeholder="Entrez votre Nom"/>
								</div>
							</div>
						</div>
						
						

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Mot de passe</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fas fa-lock " aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password1" id="inputPassword"  value="" placeholder="Entrez votre mot de passe"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Confirmez votre mot de passe</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fas fa-lock " aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password2" id="comfirmPassword"  value="" placeholder="Confirmez votre mot de passe"/>
								</div>
							</div>
						</div>
						


						<div class="form-group ">
						  
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register" name = "button">s'enregistrer</button>
						</div>
						<div class="login-register">
				            <a href="Login.do">se connecter</a>
				         </div>
					</form>
				</div>
			</div>
			

	

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>    