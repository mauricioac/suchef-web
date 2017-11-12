package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.Pedido;

public class Pedidos {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PEDIDOS " +
                  "WHERE ID = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar pedido!");
        }
        return retorno;
    }

    public void incluir (Pedido pedido)throws Exception
    {
        if(pedido == null)
            throw new Exception("Pedido não fornecido!");
        
        try
        {
            String sql;

            sql = "INSERT INTO PEDIDOS " +
                  "(ID, USUARIOS_ID, ENDERECOS_ID, DATAHORA, OBSERVACOES, TOTAL, FORMA_PAGAMENTO) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      	(1, pedido.getId());
            BD.COMANDO.setInt       (2, pedido.getUsuarios_id());
            BD.COMANDO.setInt   	(3, pedido.getEnderecos_id());
            BD.COMANDO.setString   	(4, pedido.getDatahora());
            BD.COMANDO.setString   	(5, pedido.getObservacoes());
            BD.COMANDO.setFloat   	(6, pedido.getTotal());
            BD.COMANDO.setString   	(7, pedido.getForma_pagamento());

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir pedido!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM PEDIDOS " +
              "WHERE ID=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir pedido!");
        }
    }

    public void alterar (Pedido pedido) throws Exception
    {
        if (pedido==null)
            throw new Exception ("Pedido não fornecido!");

        if (!cadastrado (pedido.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE PEDIDOS " +
                  "SET USUARIOS_ID=?" +
            	  "SET ENDERECOS_ID=? " +
            	  "SET DATAHORA=? " +
            	  "SET OBSERVACOES=? " +
            	  "SET TOTAL=? " +
            	  "SET FORMA_PAGAMENTO=? " +
                  "WHERE ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt       (1, pedido.getUsuarios_id());
            BD.COMANDO.setInt   	(2, pedido.getEnderecos_id());
            BD.COMANDO.setString   	(3, pedido.getDatahora());
            BD.COMANDO.setString   	(4, pedido.getObservacoes());
            BD.COMANDO.setFloat   	(5, pedido.getTotal());
            BD.COMANDO.setString   	(6, pedido.getForma_pagamento());
            BD.COMANDO.setInt      	(7, pedido.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar pedido!");
        }
    }

    public Pedido getPedido (int id) throws Exception
    {
        Pedido pedido = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PEDIDOS " +
                  "WHERE ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Não cadastrado!");

           /* todo */
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar pedido!");
        }
        return pedido;
    }

    public MeuResultSet getPedidos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PEDIDOS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar pedidos!");
        }
        return resultado;
    }

}
