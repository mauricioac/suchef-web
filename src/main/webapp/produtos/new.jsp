<%@page import="java.util.ArrayList,dbos.Filial"%>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
    <h2>
      Adicionar produto
    </h2>

    <form class="form" action="/produtos/new" method="POST">
      <div class="control-group">
        <label class="control-label">
          Nome do produto
        </label>
        <input class="form-control" type="text" name="nome" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Código
        </label>
        <input class="form-control" type="text" name="ref" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Preco
        </label>
        <input class="form-control" type="text" name="preco" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Descricao
        </label>
        <textarea class="form-control" name="descricao"></textarea>
      </div>

      <div class="control-group">
        <label class="control-label">
          Imagem
        </label>
        <input type="file" name="imagem" />
      </div>
      
      <div class="control-group">
        <label class="control-label">
          Filial
        </label>
        
        <select name="filiais_id" required>
        	<option value>Selecione uma opcao</option>
        	<% for (Filial filial : (ArrayList<Filial>) request.getAttribute("filiais")) { %>
        		<option value="<%= filial.getId() %>"><%= filial.getNome() %></option>
        	<% } %>
        </select>
      </div>

      <div class="form-actions">
        <button type="submit" class="btn btn-primary">
          Adicionar produto
        </button>
      </div>
    </form>
  </div>

	<%@ include file="../footer.jsp" %>
</body>
</html>
