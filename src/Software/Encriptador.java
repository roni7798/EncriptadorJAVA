package Software;

import java.util.ArrayList;

public class Encriptador {
	
	private String conversiones(String valor){
		if(esNumero(valor)){
			int num=Integer.parseInt(valor);
			if(num<=5){
				num=num*30;
			}else{
				num=num*50;
			}
			valor=String.valueOf(num).trim();
		}else{
			switch(valor.toLowerCase()){
			case "a":
				valor=valor.toLowerCase().replace('a', 'w');
				break;
			case "b":
				valor=valor.toLowerCase().replace('b', 's');
				break;
			case "c":
				valor=valor.toLowerCase().replace('c', 'o');
				break;
			case "d":
				valor=valor.toLowerCase().replace('d', 'l');
				break;
			case "e":
				valor=valor.toLowerCase().replace('e', 'h');
				break;
			case "f":
				valor=valor.toLowerCase().replace('f', 'd');
				break;
			case "g":
				valor=valor.toLowerCase().replace('g', 'z');
				break;
			case "h":
				valor=valor.toLowerCase().replace('h', 'v');
				break;
			case "i":
				valor=valor.toLowerCase().replace('i', 'r');
				break;
			case "j":
				valor=valor.toLowerCase().replace('j', 'ñ');
				break;
			case "k":
				valor=valor.toLowerCase().replace('k', 'k');
				break;
			case "l":
				valor=valor.toLowerCase().replace('l', 'g');
				break;
			case "m":
				valor=valor.toLowerCase().replace('m', 'c');
				break;
			case "n":
				valor=valor.toLowerCase().replace('n', 'y');
				break;
			case "ñ":
				valor=valor.toLowerCase().replace('ñ', 'u');
				break;
			case "o":
				valor=valor.toLowerCase().replace('o', 'q');
				break;
			case "p":
				valor=valor.toLowerCase().replace('p', 'n');
				break;
			case "q":
				valor=valor.toLowerCase().replace('q', 'j');
				break;
			case "r":
				valor=valor.toLowerCase().replace('r', 'f');
				break;
			case "s":
				valor=valor.toLowerCase().replace('s', 'b');
				break;
			case "t":
				valor=valor.toLowerCase().replace('t', 'x');
				break;
			case "u":
				valor=valor.toLowerCase().replace('u', 't');
				break;
			case "v":
				valor=valor.toLowerCase().replace('v', 'p');
				break;
			case "w":
				valor=valor.toLowerCase().replace('w', 'm');
				break;
			case "x":
				valor=valor.toLowerCase().replace('x', 'i');
				break;
			case "y":
				valor=valor.toLowerCase().replace('y', 'e');
				break;
			case "z":
				valor=valor.toLowerCase().replace('z', 'a');
				break;
			default:
				valor="@";
			}
		}
		return valor.toUpperCase();
	}

	public String encriptarPassword(String password){
		String pass="";
		ArrayList<String> caracteres= new ArrayList<>();
		String []newPassword = new String[50];
		for(int i=0; i<password.length();i++){
			newPassword[i]=String.valueOf(password.charAt(i));
			caracteres.add(conversiones(newPassword[i]));
			pass+=caracteres.get(i);
			
		}
		String pass2=fase2(pass);
		pass=fase3(pass,pass2);
		return pass;
	}
	
	private static boolean esNumero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	private  String fase2(String password){
		int contador=password.length()-1;
		String pass = "";
		for(int i=0; i<password.length();i++){
			pass+=String.valueOf(password.charAt(contador));
			contador--;
		}
		return pass;
	}
	
	private String[] convertirArray(String password){
		String[] newPassword = new String[password.length()];
		for(int i=0; i<password.length();i++){
		newPassword[i]=String.valueOf(password.charAt(i));
		}
		return newPassword;
	}
	
	private String fase3(String pass1, String pass2){
		String password="";
		String []p1 =new String[pass1.length()];
		String []p2 =new String[pass2.length()];
		String pass3 = fase4(pass1.length());
		String [] p3=new String[pass3.length()];
		p1=convertirArray(pass1);
		p2=convertirArray(pass2);
		p3=convertirArray(pass3);
		for(int i=0;i<p1.length;i++){
			password+=p2[i]+p1[i]+p3[i];
		}
		return password;
	}
	
	private String fase4(int nro){
		String password="";
		if(nro<=8){
			password="x844hh367wk5691gfgns764vckhyoieq52n";
		}else if(nro>8 && nro <16){
			password="jajf67ad8324567fhoi6h3piu61gu5c8xr5s9y4536bh";
		}else{
			password="17d87d8219y2bd769d4174619mkcqiouhernqv65";
		}
		return password.toUpperCase();
	}
	
	public boolean validarPassword(String password, String ConfPass){
		ConfPass=encriptarPassword(ConfPass);
		if(password.equals(ConfPass)){
			return true;
		}else{
			return false;
		}
	}
}
