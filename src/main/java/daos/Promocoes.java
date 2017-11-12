package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.Promocao;;

public class Promocoes {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PROMOCOES " +
                  "WHERE ID = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar promoção!");
        }
        return retorno;
    }

    public void incluir (Promocao promocao)throws Exception
    {
        if(promocao == null)
            throw new Exception("Promoção não fornecida!");
        
        try
        {
            String sql;

            sql = "INSERT INTO PROMOCOES " +
                  "(ID, EMPRESAS_ID, CODIGO, PORCENTAGEM, INICIO, FIM) " +
                  "VALUES " +
                  "(?,?,?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      	(1, promocao.getId());
            BD.COMANDO.setInt	    (2, promocao.getEmpresas_id());
            BD.COMANDO.setString   	(3, promocao.getCodigo());
            BD.COMANDO.setFloat   	(4, promocao.getPorcentagem());
            BD.COMANDO.setString   	(5, promocao.getInicio());
            BD.COMANDO.setString   	(6, promocao.getFim());

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir promoção!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM PROMOCOES " +
              "WHERE ID=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir promoção!");
        }
    }

    public void alterar (Promocao promocao) throws Exception
    {
        if (promocao==null)
            throw new Exception ("Promoção não fornecida!");

        if (!cadastrado (promocao.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE PROMOCOES " +
                  "SET EMPRESAS_IDE=?" +
            	  "SET CODIGO=? " +
            	  "SET PORCENTAGEM=? " +
            	  "SET INICIO=? " +
            	  "SET FIM=? " +
                  "WHERE ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt	    (1, promocao.getEmpresas_id());
            BD.COMANDO.setString   	(2, promocao.getCodigo());
            BD.COMANDO.setFloat   	(3, promocao.getPorcentagem());
            BD.COMANDO.setString   	(4, promocao.getInicio());
            BD.COMANDO.setString   	(5, promocao.getFim());
            BD.COMANDO.setInt      	(6, promocao.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar promoção!");
        }
    }

    public Promocao getPromocao (int id) throws Exception
    {
        Promocao promocao = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PROMOCOES " +
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
            throw new Exception ("Erro ao procurar promoção!");
        }
        return promocao;
    }

    public MeuResultSet getPromocoes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM PROMOCOES";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar promoções!");
        }
        return resultado;
    }

}
