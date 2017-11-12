<%@page import="dbos.Filial"%>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
    <h2>
      Editar filial
    </h2>

    <form class="form" action="/filiais/edit" method="POST">
    	  <% Filial filial = (Filial) request.getAttribute("filial"); %>
    	  
    	  <input type="hidden" name="id" value="<%= filial.getId() %>" />
    	  
      <div class="control-group">
        <label class="control-label">
          Nome da filial
        </label>
        <input class="form-control" type="text" name="nome" value="<%= filial.getNome() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Logradouro
        </label>
        <input class="form-control" type="text" name="logradouro" value="<%= filial.getLogradouro() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Município
        </label>
        <input class="form-control" type="text" name="municipio" value="<%= filial.getMunicipio() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          UF
        </label>
        <input class="form-control" type="text" name="uf" size="2" maxlength="2" value="<%= filial.getUf() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Telefone 1
        </label>
        <input class="form-control" type="text" name="telefone1" value="<%= filial.getTelefone1() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Telefone 2
        </label>
        <input class="form-control" type="text" name="telefone2" value="<%= filial.getTelefone2() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Telefone 3
        </label>
        <input class="form-control" type="text" name="telefone3" value="<%= filial.getTelefone3() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Número
        </label>
        <input class="form-control" type="text" name="numero" value="<%= filial.getNumero() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Complemento
        </label>
        <input class="form-control" type="text" name="complemento" value="<%= filial.getComplemento() %>" />
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
