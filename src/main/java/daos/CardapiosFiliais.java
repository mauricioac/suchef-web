package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.CardapioFilial;;

public class CardapiosFiliais {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CARDAPIOSFILIAIS " +
                  "WHERE ID = ?";
                  
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

    public void incluir (CardapioFilial cardapiofilial)throws Exception
    {
        if(cardapiofilial == null)
            throw new Exception("Cardápio da filial não fornecido!");
        
        try
        {
            String sql;

            sql = "INSERT INTO CARDAPIOSFILIAIS " +
                  "(CARDAPIOS_ID, FILIAIS_ID) " +
                  "VALUES " +
                  "(?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt    (1, cardapiofilial.getCardapios_id());
            BD.COMANDO.setInt    (2, cardapiofilial.getFiliais_id());

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir cardápio da filial!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM CARDAPIOSFILIAIS " +
              "WHERE ID=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir cardápio da filial!");
        }
    }

    public void alterar (CardapioFilial cardapiofilial) throws Exception
    {
        if (cardapiofilial==null)
            throw new Exception ("Cardápio da filial não fornecido!");

        if (!cadastrado (cardapiofilial.getCardapios_id()))
            throw new Exception ("Não cadastrado!");
        
        if (!cadastrado (cardapiofilial.getFiliais_id()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE CARDAPIOSFILIAIS " +
                  "SET CARDAPIOS_ID=?" +
            	  "SET FILIAIS_ID=? ";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt    (1, cardapiofilial.getCardapios_id());
            BD.COMANDO.setInt    (2, cardapiofilial.getFiliais_id());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar cardápio da filial!");
        }
    }

    public CardapioFilial getCardapioFilial (int id) throws Exception
    {
        CardapioFilial cardapiofilial = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CARDAPIOSFILIAIS " +
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
        return cardapiofilial;
    }

    public MeuResultSet getCardapiosFiliais () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CARDAPIOSFILIAIS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar cardápios das filiais!");
        }
        return resultado;
    }
}
