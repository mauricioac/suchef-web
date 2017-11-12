<%@include file="head.jsp" %>
<body>
	<%@ include file="header.jsp" %>

	<div class="container cadastro">
		<form class="form" action="/cadastro" method="post">
		<h3>Cadastre-se já!</h3>
      <div class="control-group">
        <label class="control-label" for="email">
          Nome da sua empresa
        </label>
        <input type="text" name="nome" class="form-control" />
      </div>

      <div class="control-group">
        <label class="control-label" for="email">
          Nome do responsável
        </label>
        <input type="text" name="nome_responsavel" class="form-control" />
      </div>

      <div class="control-group">
        <label class="control-label" for="email">
          CPF do responsável
        </label>
        <input type="text" name="cpf_responsavel" class="form-control" />
      </div>

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
        <label class="control-label" for="senha">
          Repita sua senha
        </label>
        <input type="password" name="confirmacao_senha" class="form-control" />
      </div>

      <div class="form-actions">
        <button type="submit" class="btn btn-primary">
          Enviar
        </button>

        <p>
          Já possui uma conta? <a href="${pageContext.request.contextPath}/login">Faça login aqui</a>
        </p>
      </div>
    </form>
	</div>

	<%@ include file="footer.jsp" %>
</body>
</html>
