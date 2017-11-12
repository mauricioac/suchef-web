package daos;

import java.sql.SQLException;

import bd.BD;
import bd.MeuResultSet;
import dbos.Empresa;
import dbos.Usuario;;

public class Usuarios {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios " +
                  "WHERE id = ?";
                  
            BD.COMANDO.prepareStatement (sql);
            
            BD.COMANDO.setInt(1, id);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar usuário!");
        }
        return retorno;
    }
	
	public boolean cpfCadastrado (String cpf) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios " +
                  "WHERE cpf LIKE ?";
                  
            BD.COMANDO.prepareStatement (sql);
            
            BD.COMANDO.setString(1, cpf);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar usuário!");
        }
        return retorno;
    }
	
	public boolean emailCadastrado (String email) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios " +
                  "WHERE email LIKE ?";
                  
            BD.COMANDO.prepareStatement (sql);
            
            BD.COMANDO.setString(1, email);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first();
        } 
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar usuário!");
        }
        return retorno;
    }
	
	public Usuario login (String email, String senha) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios " +
                  "WHERE email = ? AND senha = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString(1, email);
            BD.COMANDO.setString(2, senha);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception("Usuário não encontrada");

           usuario = new Usuario (resultado.getInt    ("id"),
                                   resultado.getString ("email"),
                                   resultado.getString ("nome"),
                                   resultado.getString ("cpf"),
                                   resultado.getString ("senha"),
                                   resultado.getString ("data_cadastro"),
                                   resultado.getString ("status"),
                                   resultado.getString ("token_api"));
           return usuario;
        }
        catch (SQLException erro)
        {
        		erro.printStackTrace();
            throw new Exception ("Erro ao procurar usuário!");
        }
    }
	
	public Usuario loginToken (String token) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios " +
                  "WHERE token_api = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString(1, token);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception("Usuário não encontrada");

           usuario = new Usuario (resultado.getInt    ("id"),
                                   resultado.getString ("email"),
                                   resultado.getString ("nome"),
                                   resultado.getString ("cpf"),
                                   resultado.getString ("senha"),
                                   resultado.getString ("data_cadastro"),
                                   resultado.getString ("status"),
                                   resultado.getString ("token_api"));
           return usuario;
        }
        catch (SQLException erro)
        {
        		erro.printStackTrace();
            throw new Exception ("Erro ao procurar usuário!");
        }
    }

    public void incluir (Usuario usuario)throws Exception
    {
        if(usuario == null)
            throw new Exception("Usuário não fornecido!");
        
        try
        {
            String sql;

            sql = "INSERT INTO usuarios " +
                  "(email, nome, cpf, senha, data_cadastro, status, token_api) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString   (1, usuario.getEmail());
            BD.COMANDO.setString   (2, usuario.getNome());
            BD.COMANDO.setString   (3, usuario.getCpf());
            BD.COMANDO.setString   (4, usuario.getSenha());
            BD.COMANDO.setString   (5, usuario.getData_cadastro());
            BD.COMANDO.setString   (6, usuario.getStatus());
            BD.COMANDO.setString   (7, usuario.getTokenAPI());
            
            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 
       
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir usuário!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM usuarios " +
              "WHERE id=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir usuário!");
        }
    }

    public void alterar (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuário não fornecido!");

        if (!cadastrado (usuario.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE usuarios " +
            	  "SET email=?" +
            	  ", nome=?" +
            	  ", cpf=?" +
            	  ", senha=?" + 
            	  ", data_cadastro = ?" +
            	  ", status = ?" +
            	  ", token_api=?" +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString   (1, usuario.getEmail());
            BD.COMANDO.setString   (2, usuario.getNome());
            BD.COMANDO.setString   (3, usuario.getCpf());
            BD.COMANDO.setString   (4, usuario.getSenha());
            BD.COMANDO.setString   (5, usuario.getData_cadastro());
            BD.COMANDO.setString   (6, usuario.getStatus());
            BD.COMANDO.setString   (7, usuario.getTokenAPI());
            BD.COMANDO.setInt      (8, usuario.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar usuário!");
        }
    }

    public Usuario getUsuario (int id) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios " +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Não cadastrado!");
            /*usuario = new usuario (resultado.getInt    ("ID"),
                                   resultado.getString ("EMAIL"),
                                   resultado.getString ("NOME"),
                                   resultado.getString ("CPF"),
                                   resultado.getString ("SENHA"),
                                   resultado.getString ("DATA_CADASTRO"),
                                   resultado.getString ("STATUS"),
                                   resultado.getString ("USUARIOSCOL"));*/
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuário!");
        }
        return usuario;
    }

    public MeuResultSet getUsuarios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM usuarios";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar usuários!");
        }
        return resultado;
    }

}
