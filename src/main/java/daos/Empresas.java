package daos;

import java.sql.*;
import java.util.ArrayList;

import daos.*;
import bd.*;
import dbos.*;

public class Empresas
{
    public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM empresas " +
                  "WHERE id = ?";
                  
            BD.COMANDO.prepareStatement (sql);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar Empresa!");
        }
        return retorno;
    }
    
    public Empresa login (String email, String senha) throws Exception
    {
        Empresa empresa = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM empresas " +
                  "WHERE email = ? AND senha = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString(1, email);
            BD.COMANDO.setString(2, senha);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception("Empresa não encontrada");


           empresa = new Empresa (resultado.getInt    ("id"),
                                   resultado.getString ("nome"),
                                   resultado.getString ("email"),
                                   resultado.getString ("senha"),
                                   resultado.getString ("nome_responsavel"),
                                   resultado.getString ("cpf_responsavel"),
                                   resultado.getDate   ("data_cadastro"),
                                   resultado.getString ("logo"));

           return empresa;
        }
        catch (SQLException erro)
        {
        	erro.printStackTrace();
            throw new Exception ("Erro ao procurar empresa!");
        }
    }

    public void incluir (Empresa empresa)throws Exception
    {
        if(empresa == null)
            throw new Exception("Empresa não fornecida!");
        
        try
        {
            String sql;

            sql = "INSERT INTO empresas " +
                  "(nome, email, senha, nome_responsavel, cpf_responsavel, data_cadastro, logo) " +
                  "VALUES " +
                  "(?,?,?,?,?,CURRENT_TIMESTAMP,?)";
            
            BD.COMANDO.prepareStatement(sql);

            BD.COMANDO.setString   (1, empresa.getNome());
            BD.COMANDO.setString   (2, empresa.getEmail());
            BD.COMANDO.setString   (3, empresa.getSenha());
            BD.COMANDO.setString   (4, empresa.getNome_responsavel());
            BD.COMANDO.setString   (5, empresa.getCpf_responsavel());
            BD.COMANDO.setString   (6, empresa.getLogo());

            
            BD.COMANDO.executeUpdate();
            
            while (BD.COMANDO.getGeneratedKeys().next()) {
            	empresa.setId(BD.COMANDO.getGeneratedKeys().getInt(1));
            }
            
            BD.COMANDO.commit();

        }
        catch (SQLException erro)
        {
        		System.out.println(erro.getMessage());
            throw new Exception("Erro ao inserir Empresa!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM EMPRESAS " +
              "WHERE id=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir Empresa");
        }
    }

    public void alterar (Empresa empresa) throws Exception
    {
        if (empresa==null)
            throw new Exception ("Empresa não fornecida!");

        if (!cadastrado (empresa.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE empresas " +
                  "SET nome=? " +
                  "SET email=? " +
                  "SET senha=? " +
                  "SET nome_responsavel=? " +
                  "SET cpf_responsavel=? " +
                  "SET data_cadastro=? " +
                  "SET logo=? " +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString   (1, empresa.getNome ());
            BD.COMANDO.setString   (2, empresa.getEmail ());
            BD.COMANDO.setString   (3, empresa.getSenha());
            BD.COMANDO.setString   (4, empresa.getNome_responsavel());
            BD.COMANDO.setString   (5, empresa.getCpf_responsavel());
            BD.COMANDO.setDate     (6, empresa.getData_cadastro());
            BD.COMANDO.setString   (7, empresa.getLogo());
            BD.COMANDO.setInt      (8, empresa.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados da empresa!");
        }
    }

    public Empresa getEmpresa (int id) throws Exception
    {
        Empresa empresa = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM empresas " +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!r.first())
                throw new Exception ("Não cadastrado!");

           return new Empresa(r.getInt("id"), r.getString("nome"), r.getString("email"), r.getString("senha"), r.getString("nome_responsavel"), r.getString("cpf_responsavel"), r.getDate("data_cadastro"), r.getString("logo"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar empresa!");
        }
    }

    public ArrayList<Empresa> getEmpresas () throws Exception
    {
        ArrayList<Empresa> resultado = new ArrayList<Empresa>();

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM empresas";

            BD.COMANDO.prepareStatement (sql);

            MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();
            
            while (r.next()) {
            		Empresa e = new Empresa(r.getInt("id"), r.getString("nome"), r.getString("email"), r.getString("senha"), r.getString("nome_responsavel"), r.getString("cpf_responsavel"), r.getDate("data_cadastro"), r.getString("logo"));
            		
            		resultado.add(e);
            }
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar empresas!");
        }
        return resultado;
    }
}