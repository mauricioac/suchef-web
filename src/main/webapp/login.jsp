<%@include file="head.jsp" %>
<body>
	<%@ include file="header.jsp" %>

	<div class="login container">
		
		<form class="form" method="post" action="/login">
		<h3>Faça o login</h3>
      <div class="control-group">
        <label class="control-label" for="email">
          Email
        </label>
        <input type="email" name="email" class="form-control" />
      </div>

      <div class="control-group">
        <label class="control-label" for="senha">
          Senha
        </label>
        <input type="password" name="senha" class="form-control" />
      </div>

      <div class="control-group">
        <label class="control-label checkbox">
          <input type="checkbox" name="lembrarme" />
          Lembrar-me
        </label>
      </div>

      <div class="form-actions">
        <button type="submit" class="btn btn-primary">
          Login
        </button>
      </div>
    </form>
	</div>

	<%@ include file="footer.jsp" %>
</body>
</html>
