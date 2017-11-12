<%@page import="dbos.Produto,dbos.Filial, java.util.ArrayList"%>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
    <h2>
      Editar produto
    </h2>

    <form class="form" action="/produtos/edit" method="post">
    	 <% Produto produto = (Produto) request.getAttribute("produto"); %>
    	  
    	  <input type="hidden" name="id" value="<%= produto.getId() %>" />
    
      <div class="control-group">
        <label class="control-label">
          Nome do produto
        </label>
        <input class="form-control" type="text" name="nome" value="<%= produto.getNome() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Código de referência
        </label>
        <input class="form-control" type="text" name="ref" value="<%= produto.getRef() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Preco
        </label>
        <input class="form-control" type="text" name="preco" value="<%= produto.getPreco() %>" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Descricao
        </label>
        <textarea class="form-control" name="descricao"><%= produto.getDescricao() %></textarea>
      </div>

      <div class="control-group">
        <label class="control-label">
          Imagem
        </label>
        <input type="file" name="imagem" value="<%= produto.getImagem() %>" />
      </div>
      
      <div class="control-group">
        <label class="control-label">
          Filial
        </label>
        
        <select name="filiais_id" required value="<%= produto.getFiliais_id() %>">
        	<option value>Selecione uma opcao</option>
        	<% for (Filial filial : (ArrayList<Filial>) request.getAttribute("filiais")) { %>
        		<option value="<%= filial.getId() %>" <%= filial.getId() == produto.getFiliais_id() ? "selected" : "" %>><%= filial.getNome() %></option>
        	<% } %>
        </select>
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
