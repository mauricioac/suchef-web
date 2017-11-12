<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
    <h2>
      Criar nova filial
    </h2>

    <form class="form" action="/filiais/new" method="POST">
      <div class="control-group">
        <label class="control-label">
          Nome da filial
        </label>
        <input class="form-control" type="text" name="nome" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Logradouro
        </label>
        <input class="form-control" type="text" name="logradouro" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Município
        </label>
        <input class="form-control" type="text" name="municipio" />
      </div>

      <div class="control-group">
        <label class="control-label">
          UF
        </label>
        <input class="form-control" type="text" name="uf" size="2" maxlength="2" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Telefone 1
        </label>
        <input class="form-control" type="text" name="telefone1" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Telefone 2
        </label>
        <input class="form-control" type="text" name="telefone2" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Telefone 3
        </label>
        <input class="form-control" type="text" name="telefone3" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Número
        </label>
        <input class="form-control" type="text" name="numero" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Complemento
        </label>
        <input class="form-control" type="text" name="complemento" />
      </div>

      <div class="form-actions">
        <button type="submit" class="btn btn-primary">
          Salvar
        </button>
      </div>
    </form>
  </div>

	<%@ include file="../footer.jsp" %>
</body>
</html>
