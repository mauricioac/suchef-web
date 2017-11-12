package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.PedidoProduto;;

public class PedidosProdutos {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PEDIDOS_PRODUTOS " +
                  "WHERE ID = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar produtos do pedido!");
        }
        return retorno;
    }

    public void incluir (PedidoProduto pedidoproduto)throws Exception
    {
        if(pedidoproduto == null)
            throw new Exception("Produto do pedido não fornecido!");
        
        try
        {
            String sql;

            sql = "INSERT INTO PEDIDOS_PRODUTOS " +
                  "(PEDIDOS_ID, PRODUTOS_ID, QUANTIDADE, SUBTOTAL) " +
                  "VALUES " +
                  "(?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      (1, pedidoproduto.getPedidos_id());
            BD.COMANDO.setInt  	   (2, pedidoproduto.getProdutos_id());
            BD.COMANDO.setInt      (3, pedidoproduto.getQuantidade());
            BD.COMANDO.setFloat    (4, pedidoproduto.getSubtotal());

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir produto no pedido!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM PEDIDOS_PRODUTOS " +
              "WHERE PRODUTOS_ID=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir produto!");
        }
    }

    public void alterar (PedidoProduto pedidoproduto) throws Exception
    {
        if (pedidoproduto==null)
            throw new Exception ("Produto no pedido não fornecido!");

        if (!cadastrado (pedidoproduto.getProdutos_id()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE PEDIDOS_PRODUTOS " +
            	  "SET PEDIDOS_ID=?" +
            	  "SET QUANTIDADE=?" +
            	  "SET SUBTOTAL=?" +
                  "WHERE PRODUTOS_ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      (1, pedidoproduto.getPedidos_id());
            BD.COMANDO.setInt      (2, pedidoproduto.getQuantidade());
            BD.COMANDO.setFloat    (3, pedidoproduto.getSubtotal());
            BD.COMANDO.setInt  	   (4, pedidoproduto.getProdutos_id());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar produtos no pedido!");
        }
    }

    public PedidoProduto getPedidoProduto (int id) throws Exception
    {
        PedidoProduto pedidoproduto = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PEDIDOS_PRODUTOS " +
                  "WHERE PRODUTOS_ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Não cadastrado!");
            /*pedidoproduto = new PedidoProduto (resultado.getInt    ("PEDIDOS_ID"),
                                   resultado.getInt        ("USUARIOS_ID"),
                                   resultado.getFloat      ("QUANTIDADE"),
                                   resultado.getFloat      ("SUBTOTAL"));*/
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar endereço!");
        }
        return pedidoproduto;
    }

    public MeuResultSet getPedidosProdutos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PEDIDOS_PRODUTOS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar produtos do pedido!");
        }
        return resultado;
    }

}
