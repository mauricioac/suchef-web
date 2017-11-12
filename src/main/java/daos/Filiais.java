package daos;

import java.sql.SQLException;
import java.util.ArrayList;

import bd.BD;
import bd.MeuResultSet;
import dbos.Empresa;
import dbos.Filial;;

public class Filiais {
	public boolean cadastrado (int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM filiais " +
                  "WHERE id = ?";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);
            
            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            return resultado.first();
        } 
        catch (SQLException erro)
        {
        	erro.printStackTrace();
            throw new Exception("Erro ao procurar filial!");
        }
    }

    public void incluir (Filial filial)throws Exception
    {
        if(filial == null)
            throw new Exception("Filial não fornecida!");
        
        try
        {
            String sql;

            sql = "INSERT INTO filiais " +
                  "(empresas_id, nome, telefone1, telefone2, telefone3, uf, municipio, logradouro, numero, complemento) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?,?,?,?)";
            
            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      (1, filial.getEmpresas_id());
            BD.COMANDO.setString   (2, filial.getNome());
            BD.COMANDO.setString   (3, filial.getTelefone1());
            BD.COMANDO.setString   (4, filial.getTelefone2());
            BD.COMANDO.setString   (5, filial.getTelefone3());
            BD.COMANDO.setString   (6, filial.getUf());
            BD.COMANDO.setString   (7, filial.getMunicipio());
            BD.COMANDO.setString   (8, filial.getLogradouro());
            BD.COMANDO.setString   (9, filial.getNumero());
            BD.COMANDO.setString   (10, filial.getComplemento());
            
            BD.COMANDO.executeUpdate();
            BD.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao inserir filial!");
        }
    }

    public void excluir (int id) throws Exception
    {
        if(!cadastrado (id))
            throw new Exception ("Não cadastrado!");
        
        try
        {

        String sql;
        sql = "DELETE FROM filiais " +
              "WHERE id=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        (); 

        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao excluir filial!");
        }
    }

    public void alterar (Filial filial) throws Exception
    {
        if (filial==null)
            throw new Exception ("Filial não fornecida!");

        if (!cadastrado (filial.getId()))
            throw new Exception ("Não cadastrado!");

        try
        {
            String sql;

            sql = "UPDATE filiais " +
                  "SET empresas_id=?" +
            	  ", nome=? " +
            	  ", telefone1=? " +
            	  ", telefone2=? " +
            	  ", telefone3=? " +
            	  ", uf=? " +
                  ", municipio=? " +
                  ", logradouro=? " +
                  ", numero=? " +
                  ", complemento=? " +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt      (1, filial.getEmpresas_id());
            BD.COMANDO.setString   (2, filial.getNome());
            BD.COMANDO.setString   (3, filial.getTelefone1());
            BD.COMANDO.setString   (4, filial.getTelefone2());
            BD.COMANDO.setString   (5, filial.getTelefone3());
            BD.COMANDO.setString   (6, filial.getUf());
            BD.COMANDO.setString   (7, filial.getMunicipio());
            BD.COMANDO.setString   (8, filial.getLogradouro());
            BD.COMANDO.setString   (9, filial.getNumero());
            BD.COMANDO.setString   (10, filial.getComplemento());
            BD.COMANDO.setInt      (11, filial.getId());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados da filial!");
        }
    }

    public Filial getFilial (int id) throws Exception
    {
        Filial filial = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM filiais " +
                  "WHERE id = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, id);

            MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!r.next())
                return null;

            filial = new Filial(r.getInt("id"), r.getInt("empresas_id"), r.getString("nome"), r.getString("telefone1"),r.getString("telefone2"),r.getString("telefone3"),r.getString("uf"),r.getString("municipio"),r.getString("logradouro"),r.getString("numero"),r.getString("complemento"));
            return filial;
        }
        catch (SQLException erro)
        {
        		erro.printStackTrace();
            throw new Exception ("Erro ao procurar filial!");
        }
    }

    public ArrayList<Filial> getFiliais (int empresa_id) throws Exception
    {
    		ArrayList<Filial> resultado = new ArrayList<Filial>();

        String sql;

        sql = "SELECT * " +
              "FROM filiais WHERE empresas_id = ?";

        BD.COMANDO.prepareStatement (sql);

        BD.COMANDO.setInt (1, empresa_id);

        MeuResultSet r = (MeuResultSet)BD.COMANDO.executeQuery ();
        
        while (r.next()) {
        		Filial f = new Filial(r.getInt("id"), r.getInt("empresas_id"), r.getString("nome"), r.getString("telefone1"),r.getString("telefone2"),r.getString("telefone3"),r.getString("uf"),r.getString("municipio"),r.getString("logradouro"),r.getString("numero"),r.getString("complemento"));
        		
        		resultado.add(f);
        }
        return resultado;
    }
}
