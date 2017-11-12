<%@page import="java.util.ArrayList,dbos.Produto"%>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
	    <h2>
	      Produtos
	    </h2>
	    
	    <p>
	    		<a href="/produtos/new" class="btn btn-primary">
	    			Cadastrar novo produto
	    		</a>
	    	</p>
	
	    <table class="table">
	      <colgroup>
	        <col width="100" />
	        <col width="*" />
	        <col width="100" />
	        <col width="200" />
	      </colgroup>
	      <thead>
	        <tr>
	          <th>
	            Ref.
	          </th>
	          <th>
	            Nome
	          </th>
	          <th>
	            Preço
	          </th>
	          <th>
	            &nbsp;
	          </th>
	        </tr>
	      </thead>
		
		<tbody>
	      	<% for (Produto produto : (ArrayList<Produto>) request.getAttribute("produtos")) { %>
	        <tr>
	          <td>
	            <%= produto.getRef() %>
	          </td>
	          <td>
	            <%= produto.getNome() %>
	          </td>
	          <td>
	            <%= produto.getPreco() %>
	          </td>
	          <td>
	            <a href="/produtos/edit?id=<%= produto.getId() %>">Editar</a>
	            &nbsp;
	            <a href="/produtos/destroy?id=<%= produto.getId() %>">Deletar</a>
	          </td>
	        </tr>
	        <% } %>
	      </tbody>
	    </table>
	</div>

	<%@ include file="../footer.jsp" %>
</body>
</html>
