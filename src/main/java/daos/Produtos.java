package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import bd.BD;
import bd.MeuResultSet;
import dbos.Produto;;

public class Produtos {
	public boolean cadastrado (int id) throws Exception
    {
        String sql;

        sql = "SELECT * " +
              "FROM produtos " +
              "WHERE id = ?";
              
        bd.BD.COMANDO.prepareStatement (sql);

        bd.BD.COMANDO.setInt (1, id);


            MeuResultSet resultado = (MeuResultSet)bd.BD.COMANDO.executeQuery ();

            return resultado.first();
    }

    public void incluir (Produto produto)throws Exception
    {
        if(produto == null)
            throw new Exception("Produto não fornecido!");
        
        String sql;

        sql = "INSERT INTO produtos " +
              "(filiais_id, ref, nome, descricao, imagem, preco) " +
              "VALUES " +
              "(?,?,?,?,?,?)";
        
        bd.BD.COMANDO.prepareStatement (sql);

        bd.BD.COMANDO.setInt	   (1, produto.getFiliais_id());
        bd.BD.COMANDO.setString   (2, produto.getRef());
        bd.BD.COMANDO.setString   (3, produto.getNome());
        bd.BD.COMANDO.setString   (4, produto.getDescricao());
        bd.BD.COMANDO.setString   (5, produto.getImagem());
        bd.BD.COMANDO.setFloat    (6, produto.getPreco());
        
        bd.BD.COMANDO.executeUpdate();
        bd.BD.COMANDO.commit();
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");

        String sql;
        sql = "DELETE FROM produtos WHERE id=?";

        BD.COMANDO.prepareStatement (sql);

        BD.COMANDO.setInt (1, id);

        BD.COMANDO.executeUpdate ();
        BD.COMANDO.commit        ();
    }

    public void alterar (Produto produto) throws Exception
    {
        if (produto==null)
            throw new Exception ("Produto não fornecido!");

        if (!cadastrado (produto.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE produtos " +
                  "SET filiais_id=? " +
                  ", ref=? " +
                  ", nome=? " +
                  ", descricao=? " +
                  ", imagem=? " +
                  ", preco=? " +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt	   (1, produto.getFiliais_id());
            BD.COMANDO.setString   (2, produto.getRef());
            BD.COMANDO.setString   (3, produto.getNome());
            BD.COMANDO.setString   (4, produto.getDescricao());
            BD.COMANDO.setString   (5, produto.getImagem());
            BD.COMANDO.setFloat    (6, produto.getPreco());
            BD.COMANDO.setInt      (7, produto.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar produto!");
        }
    }

    public Produto getProduto (int id) throws Exception
    {

       Produto produto = null;

       String sql;

        sql = "SELECT * " +
              "FROM produtos " +
              "WHERE id = ?";

        BD.COMANDO.prepareStatement (sql);

        BD.COMANDO.setInt (1, id);

        MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();

        if (!r.first())
            throw new Exception ("Não cadastrado!");

       return new Produto(r.getInt("id"), r.getInt("filiais_id"), r.getString("ref"),r.getString("nome"), r.getString("descricao"), r.getString("imagem"), r.getFloat("preco"));
    }
    
    public ArrayList<Produto> getProdutos (int id) throws Exception
    {
    	ArrayList<Produto> resultado = new ArrayList<Produto>();

        String sql;

            sql = "SELECT * " +
                  "FROM produtos JOIN filiais ON filiais.id = produtos.filiais_id WHERE filiais.empresas_id = ?";


        BD.COMANDO.prepareStatement (sql);

        BD.COMANDO.setInt (1, id);

        MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();
        
        while (r.next()) {
        		Produto p = new Produto(r.getInt("id"), r.getInt("filiais_id"), r.getString("ref"),r.getString("nome"), r.getString("descricao"), r.getString("imagem"), r.getFloat("preco"));
        		
        		resultado.add(p);
        }
        return resultado;
    }

  public ArrayList<Produto> getProdutosFilial(int id) throws Exception {
    ArrayList<Produto> resultado = new ArrayList<Produto>();

    String sql = "SELECT * FROM produtos WHERE filiais_id = ?";

    BD.COMANDO.prepareStatement (sql);

    BD.COMANDO.setInt (1, id);

    MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();

    while (r.next()) {
      Produto p = new Produto(r.getInt("id"), r.getInt("filiais_id"), r.getString("ref"),r.getString("nome"), r.getString("descricao"), r.getString("imagem"), r.getFloat("preco"));

      resultado.add(p);
    }
    return resultado;
  }

}
