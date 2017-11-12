<%@page import="java.util.ArrayList,dbos.Filial"%>
<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
	    <h2>
	      Filiais
	    </h2>
	    
	    <p>
	    		<a href="/filiais/new" class="btn btn-primary">
	    			Cadastrar nova filial
	    		</a>
	    </p>
	
	    <table class="table">
	      <colgroup>
	        <col width="40%" />
	        <col width="*" />
	        <col width="200" />
	      </colgroup>
	      <thead>
	        <tr>
	          <th>
	            Nome
	          </th>
	          <th>
	            Endereço
	          </th>
	          <th>
	            &nbsp;
	          </th>
	        </tr>
	      </thead>
	
	      <tbody>
	      	<% for (Filial filial : (ArrayList<Filial>) request.getAttribute("filiais")) { %>
	        <tr>
	          <td>
	            <%= filial.getNome() %>
	          </td>
	          <td>
	            <%= filial.getLogradouro() %>. <%= filial.getMunicipio() %> - <%= filial.getUf() %>
	          </td>
	          <td>
	            <a href="/filiais/edit?id=<%= filial.getId() %>">Editar</a>
	            &nbsp;
	            <a href="/filiais/destroy?id=<%= filial.getId() %>">Deletar</a>
	          </td>
	        </tr>
	        <% } %>
	      </tbody>
	    </table>
	</div>

	<%@ include file="../footer.jsp" %>
</body>
</html>
