package bd;
import bd.*;
import daos.*;

public class BD 
{
    public static final MeuPreparedStatement COMANDO;
    public static final Empresas             EMPRESAS;
    public static final Produtos             PRODUTOS;
    public static final Filiais              FILIAIS;
    public static final Usuarios             USUARIOS;

    static
    {
    	MeuPreparedStatement comando = null;
     	Empresas             empresas  = null;
     	Produtos             produtos = null;
     	Filiais              filiais = null;
     	Usuarios              usuarios = null;
    	try
        {
            comando =
            new MeuPreparedStatement (
            "org.postgresql.Driver",
            "jdbc:postgresql://" + ConnectionInformation.DB_HOST + "/" + ConnectionInformation.DB_NAME + "?sslmode=require",
            ConnectionInformation.DB_USER,
            ConnectionInformation.DB_PASS);

            empresas = new Empresas (); //um como esse para cada classe DAO
            produtos = new Produtos ();
            filiais = new Filiais ();
            usuarios = new Usuarios ();
        }
        catch (Exception erro)
        {
        		System.out.println(erro.getMessage());
        		erro.printStackTrace();
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
        EMPRESAS  = empresas; //um como esse para cada classe DAO
        PRODUTOS = produtos;
        FILIAIS = filiais;
        USUARIOS = usuarios;
    }

}
