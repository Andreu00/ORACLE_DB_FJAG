package oracle_db_fjag.oracle_db_fjag;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccesoOracle a=new AccesoOracle();
        a.abrirConexion();
        a.mostrarContactios();
        a.cerrarConexion();
    }
}
