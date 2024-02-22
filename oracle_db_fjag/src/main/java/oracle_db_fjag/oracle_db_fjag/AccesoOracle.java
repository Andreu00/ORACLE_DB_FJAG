package oracle_db_fjag.oracle_db_fjag;
import java.sql.*;
public class AccesoOracle {
	private Connection con;
	public void abrirConexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Magete00");
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
	public void mostrarContactos() {
		try {
			Statement st=con.createStatement();
			ResultSet resul=st.executeQuery("select c.nombre, c.telefono from contactos c");
			System.out.println("\nINFORMACION DE CONTACTOS\n-------------");
			while(resul.next()) {
				System.out.printf("NOMBRE: %s\nTELEFONO: %s",resul.getString(1), resul.getString(2));
			}
			System.out.println("\n----------------");
			resul.close();
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void crearTablaMisAlumnos() {
        try {
            Statement st = con.createStatement();
            String sql = "CREATE TABLE misAlumnos OF ESTUDIANTE";
            st.executeUpdate(sql);
            System.out.println("Tabla misAlumnos creada con éxito");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarEstudiante() {
        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO misAlumnos VALUES('A3C', PERSONA('Juan', '967333333'))";
            st.executeUpdate(sql);
            System.out.println("Estudiante insertado con éxito");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrarAlumnoPorNombre(String nombre) {
        try {
            Statement st = con.createStatement();
            String sql = "DELETE FROM misAlumnos a WHERE a.datos_personales.nombre='" + nombre + "'";
            st.executeUpdate(sql);
            System.out.println("Alumno borrado con éxito");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarTelefonoPorNombre(String nombre) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT a.datos_personales.telefono FROM misAlumnos a WHERE a.datos_personales.nombre='" + nombre + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.printf("Teléfono: %s" + rs.getString(1));
            } else {
                System.out.println("No se encontró el alumno");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodosLosAlumnos() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT a.id_estudiante, a.datos_personales.nombre, a.datos_personales.telefono FROM misAlumnos a";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	System.out.printf("ID: %s, Nombre: %s, Teléfono: %s%n", rs.getString(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarInfoAdmitidos() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT ad.dia, ad.matriculado.id_estudiante, ad.matriculado.datos_personales.nombre, ad.matriculados.datos_personales.telefono FROM admitidos ad";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	System.out.printf("Día: %s, ID: %s, Nombre: %s, Teléfono: %s%n", rs.getDate(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
