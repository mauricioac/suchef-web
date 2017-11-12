<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container minha-conta">
		<form class="form">
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
        <label class="control-label" for="senha">
          Senha
        </label>
        <input type="password" name="senha" class="form-control" />
        <small class="text-muted form-text">Deixe em branco para não alterar a senha.</small>
      </div>

      <div class="control-group">
        <label class="control-label" for="senha">
          Repita sua senha
        </label>
        <input type="password" name="confirmacao_senha" class="form-control" />
      </div>

      <div class="form-actions">
      	<button type="submit" class="btn btn-primary">
          Salvar alterações
        </button>
        
        <a href="${pageContext.request.contextPath}/" class="btn btn-link">
      		cancelar
      	</a>
      </div>
    </form>
	</div>

	<%@ include file="../footer.jsp" %>
</body>
</html>