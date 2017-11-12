<%@ page import="helpers.SessionManager" %>

<nav class="navbar navbar-expand-lg">
  <div class="container">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">SuChef</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/">Página inicial</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/filiais">Filiais</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/produtos">Produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/cardapios">Cardápios</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/promocoes">Promoções</a>
	      </li>
	    </ul>
	    <ul class="navbar-nav">
	      <%
	        if (SessionManager.isAuthenticated(request)) {
	        	String nome = SessionManager.nome(request);
	      %>
		      <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bem vindo, <%= nome %> <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="${pageContext.request.contextPath}/minha_conta">Minha conta</a></li>
		            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
		          </ul>
		        </li>
	      <% } else { %>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/cadastro">Cadastre-se</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
		      </li>
		   <% } %>
	    </ul>
	  </div>
  </div>
</nav>

<%
if (SessionManager.hasFlash(request)) {
%>
	<div class="container">
		<div class="alert alert-info"><%= SessionManager.getFlash(request) %></div>
	</div>
<%
}
%>
