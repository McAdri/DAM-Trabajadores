package main.java.liceosorolla;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		int opcion = 0;
		do {
			opcion=menu();
			switch (opcion) {
			case 1: 
				listarTrabajadores("");
			break;
			case 2:
				agregarTrabajador();
			break;
			case 3:
				actualizarSueldo();
			break;
			case 4:
				eliminarTrabajador();
			break;
			case 5:
				String departamento = pedirTexto("¿De que departamento quieres ver los trabajadores?");
				listarTrabajadores("where departamento like '"+departamento+"'");
			break;
			case 6:
				int mayor = pedirNumero("¿A partir de cuanto sueldo quiere slos trabajadores?");
				listarTrabajadores("where sueldo>="+mayor);
			break;
			}
			
		} while (opcion!=0);

	}

	public static void listarTrabajadores(String clause) {
		Conexion conexion = new Conexion();
		ArrayList<Trabajador> trabajadores = conexion.cargarTrabajadores(clause);
		
		for(int i=0;i< trabajadores.size();i++) {
			System.out.println(trabajadores.get(i).toString());
		}
		
	}
	
	public static void agregarTrabajador() {
		Conexion conexion = new Conexion();
		int sueldo = pedirNumero("Introduce el sueldo del trabajador");
		String nombre = pedirTexto("Introduce el nombre del trabajador");
		String departamento = pedirTexto("Introduce el departamento del trabajador");
		Trabajador trabajador = new Trabajador(nombre, sueldo, departamento);
		conexion.agregarTrabajador(trabajador);
	}
	
	public static void actualizarSueldo() {
		Conexion conexion = new Conexion();
		int id = pedirNumero("Introduce el id del trabajador");
		int sueldo = pedirNumero("Introduce el sueldo del trabajador");
		
		conexion.actualizarSueldo(id,sueldo);
	}
	
	public static void eliminarTrabajador() {
		Conexion conexion = new Conexion();
		int id = pedirNumero("Introduce el id del trabajador a eliminar");
		conexion.eliminaTrabajador(id);
	}
	
	public static int menu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Elige la opcion:");
		System.out.println("1. Listar trabajadores");
		System.out.println("2. Añadir");
		System.out.println("3. Actualizar");
		System.out.println("4. Eliminar");
		System.out.println("5. Departamento");
		System.out.println("6. Salario");
		
		return teclado.nextInt();
	}
	
	public static int pedirNumero(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextInt();
	}

	public static String pedirTexto(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextLine();
	}
}
