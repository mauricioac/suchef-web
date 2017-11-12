package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.Endereco;

public class Enderecos {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ENDERECOS " +
                  "WHERE ID = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar Endereços!");
        }
        return retorno;
    }

    public void incluir (Endereco endereco)throws Exception
    {
        if(endereco == null)
            throw new Exception("Endereço não fornecida!");
        
        try
        {
            String sql;

            sql = "INSERT INTO ENDERECOS " +
                  "(ID, USUARIOS_ID, UF, MUNICIPIO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, NOME) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      (1, endereco.getId());
            BD.COMANDO.setInt  	   (2, endereco.getUsuarios_id());
            BD.COMANDO.setString   (3, endereco.getUf());
            BD.COMANDO.setString   (4, endereco.getMunicipio());
            BD.COMANDO.setString   (5, endereco.getLogradouro());
            BD.COMANDO.setString   (6, endereco.getNumero());
            BD.COMANDO.setString   (7, endereco.getComplemento());
            BD.COMANDO.setString   (8, endereco.getCep());
            BD.COMANDO.setString   (9, endereco.getNome());
            

        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir Endereço!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM ENDERECOS " +
              "WHERE ID=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir Endereço!");
        }
    }

    public void alterar (Endereco endereco) throws Exception
    {
        if (endereco==null)
            throw new Exception ("Endereço não fornecido!");

        if (!cadastrado (endereco.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE ENDERECOS " +
            	  "SET USUARIOS_ID=?" +
            	  "SET UF=?" +
            	  "SET MUNICIPIO=?" +
            	  "SET LOGRADOURO=?" + 
            	  "SET NUMERO" +
            	  "SET COMPLEMENTO" +
            	  "SET CEP=?" +
            	  "SET NOME=?" +
                  "WHERE ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt  	   (1, endereco.getUsuarios_id());
            BD.COMANDO.setString   (2, endereco.getUf());
            BD.COMANDO.setString   (3, endereco.getMunicipio());
            BD.COMANDO.setString   (4, endereco.getLogradouro());
            BD.COMANDO.setString   (5, endereco.getNumero());
            BD.COMANDO.setString   (6, endereco.getComplemento());
            BD.COMANDO.setString   (7, endereco.getCep());
            BD.COMANDO.setString   (8, endereco.getNome());
            BD.COMANDO.setInt      (9, endereco.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do Endereço!");
        }
    }

    public Endereco getEndereco (int id) throws Exception
    {
        Endereco endereco = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ENDERECOS " +
                  "WHERE ID = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Não cadastrado!");
            /*endereco = new Endereco (resultado.getInt    ("ID"),
                                   resultado.getInt ("USUARIOS_ID"),
                                   resultado.getString ("UF"),
                                   resultado.getString ("MUNICIPIO"),
                                   resultado.getString ("LOGRADOURO"),
                                   resultado.getString ("NUMERO"),
                                   resultado.getString ("COMPLEMENTO"),
                                   resultado.getString ("CEP"),
                                   resultado.getString ("NOME"));*/
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar endereço!");
        }
        return endereco;
    }

    public MeuResultSet getEnderecos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ENDERECOS";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar endereço!");
        }
        return resultado;
    }

}
