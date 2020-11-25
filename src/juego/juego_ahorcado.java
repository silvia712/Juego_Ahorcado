package juego;

import java.util.Scanner;

public class juego_ahorcado {

	public static void pintarmuneco(int vidas, String palabra) {
		
		switch (vidas) {
		case 7:
			System.out.println("______________");
			break;
		case 6:
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________");
			break;
		case 5:
			System.out.println("______________");
			System.out.println("|      |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________");
			break;
		case 4:
			System.out.println("______________");
			System.out.println("|      |");
			System.out.println("|      0");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________");
			break;
		case 3:
			System.out.println("______________");
			System.out.println("|      |");
			System.out.println("|      0");
			System.out.println("|      |");
			System.out.println("|      |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________");
			break;
		case 2:
			System.out.println("______________");
			System.out.println("|      |");
			System.out.println("|      0");
			System.out.println("|     ,|,");
			System.out.println("|      |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________");
			break;
		case 1:
			System.out.println("______________");
			System.out.println("|      |");
			System.out.println("|      0");
			System.out.println("|     ,|,");
			System.out.println("|      |");
			System.out.println("|     , ,");
			System.out.println("|");
			System.out.println("|_____________");
			System.out.println("Has agotado los intentos. Lo siento!");
			System.out.println("La palabra secreta era: " + palabra);
			break;
		} 
	}
	
	public static int comprobarletra(int vidas,String letra,String vPalabra[], String vAciertos[], String vFallos[]) {
		
		 boolean encontrada = false;
			
			for (int i=0;i<vPalabra.length;i++) {
				if (vPalabra[i].equalsIgnoreCase(letra)) {
					vAciertos[i]=letra;//guardo la letra en vAciertos
					encontrada=true;
					}
			}
			if (encontrada==false){//utilizado para no meter un ELSE dentro de un FOR
				for (int i=0;i<vFallos.length;i++) {
					if(vFallos[i].equals("_")) {
						vFallos[i]=letra;//guardo la letra en vFallos
						vidas--;//resto una vida
						break;
						}
					}
				}
			return vidas;
		}
			
	public static void inicializarVectores(String palabra, String vPalabra[], String vAciertos[], String vFallos[]) {
		
		for (int i=0;i<vFallos.length;i++) {
			vFallos[i]="_";
		}
		for (int i=0;i<vPalabra.length;i++) {
			vPalabra[i]=palabra.substring(i,i+1);
			vAciertos[i]="_";
		}			
	}
		
	public static void dibujarAciertosyErrores(String vFallos[], String vAciertos[]) {
		
		System.out.print("\nLetras falladas: ");
		for (int i=0;i<vFallos.length;i++) {
			if (!vFallos[i].equals("_")) {
			System.out.print(vFallos[i] + " ");
			}
		}
		System.out.print("\nPalabra secreta: ");
		for (int i=0;i<vAciertos.length;i++) {
			System.out.print(vAciertos[i]+ " ");
		}	
	}
		
	public static boolean ganado(String vAciertos[]) {
		boolean ganado=true;

		for (int i=0;i<vAciertos.length;i++) {
			if (vAciertos[i].equals("_")) {
				ganado=false;
				break;
			}
	
			
		}return ganado;
	}
	
	public static void main(String[] args) {
	
		int vidas=8;
		String palabra="gitkraken";
		Scanner leer=new Scanner(System.in);
		String letra;
		String vPalabra[],vAciertos[],vFallos[];
		
		vPalabra=new String[palabra.length()];
		vAciertos=new String[palabra.length()];
		vFallos=new String[vidas+1];
		inicializarVectores(palabra,vPalabra,vAciertos,vFallos);
		
		System.out.println("Bienvenido al juego del ahorcado! Acierta la palabra ");	
		System.out.println("Escribe una letra"); 
		
		do {	
			letra=leer.nextLine();
			vidas=comprobarletra(vidas,letra,vPalabra,vAciertos,vFallos);	
			dibujarAciertosyErrores(vFallos,vAciertos);	
			System.out.println(" "); 
			pintarmuneco(vidas,palabra);
			
		}while (vidas>1 && ganado(vAciertos)==false);	
		if (ganado(vAciertos) == true) {
			System.out.println("\nEnhorabuena!Has acertado ");
		}
			
		
		
		}
	}	





