package main.java.liceosorolla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Conexion {
	private static String db_ = "clase" ;
	private static String login_ = "root" ;
	private static String password_ = "12345678" ;
	private static String url_ = "jdbc:mysql://localhost/" + db_  +"?serverTimezone=UTC";
	private static Connection connection_ ;
	private static Statement st_ = null ;
	
	public Conexion() {
		// TODO Auto-generated method stub

		try {
			Class . forName ( "com.mysql.cj.jdbc.Driver" ) ;
			connection_ = DriverManager . getConnection ( url_ ,
			login_ , password_ ) ;
			if ( connection_ != null ) {
				st_ = connection_ . createStatement () ;
				System . out . println ( " Conexion a base de datos " + db_ + " correcta . " ) ;
			}
			else
			System . out . println ( " Conexion fallida . " ) ;
		} catch ( SQLException e ) { e . printStackTrace () ;}
		catch ( ClassNotFoundException e ) { e . printStackTrace () ;}
		catch ( Exception e ) { e . printStackTrace () ;}
		
		
	}
	
	public ArrayList<Trabajador> cargarTrabajadores(String clause){
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		
		try {
			Statement st = connection_.createStatement();
			
			ResultSet rs = st.executeQuery("select * from trabajadores "+ clause);
			while(rs.next()) {
				int id,sueldo;
				String nombre,departamento;
				id = rs.getInt(1);
				nombre = rs.getString(2);
				sueldo = rs.getInt(3);
				departamento = rs.getString(4);
				trabajadores.add(new Trabajador(id,nombre,sueldo,departamento));
			}
		}
		catch(SQLException e ) { e . printStackTrace () ;}
		
		return trabajadores;
	}
	
	public void agregarTrabajador(Trabajador trabajador) {
		try {
			PreparedStatement ps = connection_.prepareStatement("insert into trabajadores(nombre,sueldo,departamento) values(?,?,?)");

			ps.setString(1, trabajador.getNombre());
			ps.setInt(2, trabajador.getSueldo());
			ps.setString(3, trabajador.getDepartamento());
			
			ps.executeUpdate();
		}
		catch(SQLException e ) { e . printStackTrace () ;}
		
	}
	
	public void actualizarSueldo(int id,int sueldo) {
		try {
			PreparedStatement ps = connection_.prepareStatement("update trabajadores set sueldo=? where idtrabajador=?");
			
			ps.setInt(1, sueldo);
			ps.setInt(2, id);
			
			ps.executeUpdate();
		}
		catch(SQLException e ) { e . printStackTrace () ;}
	}
	
	public void eliminaTrabajador(int id) {
		try {
			PreparedStatement ps = connection_.prepareStatement("delete from trabajadores where idtrabajador=?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}
		catch(SQLException e ) { e . printStackTrace () ;}
	}
}