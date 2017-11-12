package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.FilialPromocao;;

public class FiliaisPromocoes {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILIAIS_PROMOCOES " +
                  "WHERE ID = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar promoção da filial!");
        }
        return retorno;
    }

    public void incluir (FilialPromocao filialpromocao)throws Exception
    {
        if(filialpromocao == null)
            throw new Exception("Promoção na filial não fornecido!");
        
        try
        {
            String sql;

            sql = "INSERT INTO FILIAIS_PROMOCOES " +
                  "(FILIAIS_ID, PROMOCOES_ID) " +
                  "VALUES " +
                  "(?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      	(1, filialpromocao.getFiliais_id());
            BD.COMANDO.setInt       (2, filialpromocao.getPromocoes_id());

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir promoção na filial!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM FILIAIS_PROMOCOES " +
              "WHERE ID=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir promoção da filial!");
        }
    }

    public void alterar (FilialPromocao filialpromocao) throws Exception
    {
        if (filialpromocao==null)
            throw new Exception ("Promoção da filial não fornecido!");

        if (!cadastrado (filialpromocao.getFiliais_id()) || !cadastrado (filialpromocao.getPromocoes_id()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE FILIAIS_PROMOCOES " +
                  "SET FILIAIS_ID=?" +
            	  "SET PROMOCOES_ID=? ";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      	(1, filialpromocao.getFiliais_id());
            BD.COMANDO.setInt       (2, filialpromocao.getPromocoes_id());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar promoção na filial!");
        }
    }

    public FilialPromocao getFilialPromocao (int id) throws Exception
    {
        FilialPromocao filialpromocao = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILIAIS_PROMOCOES ";

            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Não cadastrado!");

           /* todo */
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar promoções nas filiais!");
        }
        return filialpromocao;
    }

    public MeuResultSet getFiliaisPromocoes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM FILIAIS_PROMOCOES";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar promoções nas filiais!");
        }
        return resultado;
    }

}
