package oracle_db_fjag.oracle_db_fjag;
import java.sql.*;
public class AccesoOracle {
	private Connection con;
	public void abrirConexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc_oracle:thin@localhost:1521:XE","SYSTEM","Magete00");
			System.out.println("Conexion OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cerrarConexion() {
		try {
			System.out.println("Conexion Cerrada");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void mostrarContactios() {
		try {
			Statement st=con.createStatement();
			ResultSet resul=st.executeQuery("SELECT c.nombre, c.telefono FROM contactios c");
			System.out.println("INFORMACION DE CONTACTOS-------------");
			while(resul.next()) {
				System.out.printf("\nNOMBRE: %s\nTELFONO: %s",resul.getString(1), resul.getString(2));
			}
			System.out.println("\n----------------");
			resul.close();
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
