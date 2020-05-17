package Main;

import java.util.Scanner;

import Software.Encriptador;
import Software.Usuario;

public class Runner {
	
private static Scanner input;

	public static void main(String[] args) {
		Encriptador e = new Encriptador();
		input= new Scanner(System.in);
		String usuario, password;
		System.out.print("Ingresar usuario:");
		usuario=input.nextLine();
		System.out.print("Ingresar password:");
		password=input.nextLine();
		password=e.encriptarPassword(password);
		Usuario u= new Usuario(usuario,password);
		System.out.print("confirme su password:");
		String confPass=input.nextLine();
		if(e.validarPassword(password, confPass)){
			System.out.println("contraseña correcta");
		}else{
			System.out.println("contraseña incorrecta");
		}
	}

}
