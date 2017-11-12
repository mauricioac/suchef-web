package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.Cardapio;;

public class Cardapios {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM cardapios " +
                  "WHERE id = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar cardápio!");
        }
        return retorno;
    }

    public void incluir (Cardapio cardapio)throws Exception
    {
        if(cardapio == null)
            throw new Exception("Cardápio não fornecido!");
        
        try
        {
            String sql;

            sql = "INSERT INTO cardapios " +
                  "(nome, hora_inicio, hora_fim, empresas_id) " +
                  "VALUES " +
                  "(?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString    (1, cardapio.getNome());
            BD.COMANDO.setString   	(2, cardapio.getHora_inicio());
            BD.COMANDO.setString   	(3, cardapio.getHora_fim());
            BD.COMANDO.setInt   	(4, cardapio.getEmpresas_id());
            
            BD.COMANDO.executeUpdate();
            
            if (BD.COMANDO.getGeneratedKeys().next()) {
            	cardapio.setId(BD.COMANDO.getGeneratedKeys().getInt(1));
            }
            
            BD.COMANDO.commit();

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir cardápio!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM cardapios " +
              "WHERE id=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir cardápio!");
        }
    }

    public void alterar (Cardapio cardapio) throws Exception
    {
        if (cardapio==null)
            throw new Exception ("Cardápio não fornecido!");

        if (!cadastrado (cardapio.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE cardapios " +
                  "SET nome=?" +
            	  "SET hora_inicio=? " +
            	  "SET hora_fim=? " +
            	  "SET empresas_id=? " +
                  "WHERE ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString    (1, cardapio.getNome());
            BD.COMANDO.setString   	(2, cardapio.getHora_inicio());
            BD.COMANDO.setString   	(3, cardapio.getHora_fim());
            BD.COMANDO.setInt   	(4, cardapio.getEmpresas_id());
            BD.COMANDO.setInt      	(5, cardapio.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar cardápio!");
        }
    }

    public Cardapio getCardapio (int id) throws Exception
    {
        Cardapio cardapio = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM cardapios " +
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
            throw new Exception ("Erro ao procurar cardápio!");
        }
        return cardapio;
    }

    public MeuResultSet getCardapios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CARDAPIOS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar cardápios!");
        }
        return resultado;
    }

}
