package ejerciciosArrays;
	import java.util.Scanner;
public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int i = 1;
		int lista[] = new int [15];
		
		System.out.println("Introduzca 15 números");
		for(i=0;i<15;i++) {
			lista[i] = sc.nextInt();
		}
		System.out.println("Los números introducidos son");
		for(i=0;i<15;i++) {
			System.out.println(i + ". " + lista[i]);
		}
		System.out.println("Y moviéndolos una posición quedaría");
		for(i=0;i<15;i++) {
			if(i!=0) {
				System.out.println(i + ". " + lista[i-1]);
			} else if(i==0) {
				System.out.println(i + ". " + lista[14]);
			}
		}	
		sc.close();
	}

}
