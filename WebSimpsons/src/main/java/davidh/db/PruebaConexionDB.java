package main.java.davidh.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class PruebaConexionDB {

	/**
	 * 
	 * Extrae del context.xml los datos para poder acceder a la BBDD
	 */
	@Resource(name = "jdbc/simpsons")
	private static DataSource miPool;

	public static void main(String[] args) {

		Connection conexionDB = null;
		
		try {
			conexionDB = miPool.getConnection();
			Statement miDeclaracion = conexionDB.createStatement();
			String sentencia = "SELECT * FROM REFERENCIAS";
			ResultSet resultado = miDeclaracion.executeQuery(sentencia);
			
			System.out.println(resultado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			
			if (conexionDB != null) {
				try {
					conexionDB.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}

}
