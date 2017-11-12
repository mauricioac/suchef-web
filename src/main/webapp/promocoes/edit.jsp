<%@ include file="../head.jsp" %>
<body>
	<%@ include file="../header.jsp" %>

	<div class="container main">
    <h2>
      Editar promoção
    </h2>

    <form class="form" action="" method="">
      <div class="control-group">
        <label class="control-label">
          Código
        </label>
        <input class="form-control" type="text" name="codigo" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Desconto (%)
        </label>
        <input class="form-control" type="number" min="0" max="100" step="1" name="desconto" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Data de início
        </label>
        <input class="form-control" type="date" name="inicio" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Data de término
        </label>

        <input class="form-control" type="date" name="fim" />
      </div>

      <div class="control-group">
        <label class="control-label">
          Filiais em que o cupom é válido
        </label>

        <div class="form-check">
          <label class="form-check-label">
            <input type="checkbox" name="filiais[]" value="" class="form-check-input" />
            Filial 1 sem nome
          </label>
        </div>

        <div class="form-check">
          <label class="form-check-label">
            <input type="checkbox" name="filiais[]" value="" class="form-check-input" />
            Filial 2 sem nome
          </label>
        </div>
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
