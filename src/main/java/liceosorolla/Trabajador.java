package main.java.liceosorolla;

public class Trabajador {

	private int id;
	private String nombre;
	private int sueldo;
	private String departamento;
	
	public Trabajador(int id,String nombre,int sueldo,String departamento) {
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	
	public Trabajador(String nombre,int sueldo,String departamento) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + ", departamento=" + departamento
				+ "]";
	}
	
	
}
