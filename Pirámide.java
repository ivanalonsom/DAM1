package ejerciciosJavaBucles;
	import java.util.Scanner;
public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int altura = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		char caracter;
		
		
		System.out.print("Introduzca la altura de su pirámide: ");
		altura = sc.nextInt();
		
		System.out.print("Introduzca el carácter con el que se construirá: ");
		caracter = sc.next().charAt(0);
			
		
		for(i=0;i<altura;i++) {
			for(j=1;j<altura-i;j++) {
			System.out.print(" ");
			}
			for(k=0;k<2*i+1;k++) {
					System.out.print(caracter);
			}
			System.out.println();
			
	sc.close();
		}
		

	
	}
}
