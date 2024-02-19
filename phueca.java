package otraprueba;
	import java.util.Scanner;
public class phueca {

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
			for(j=0;j<altura-i;j++) {
			System.out.print(" ");
			}
			for(k=0;k<2*i+1;k++) {
				if ((k==0 || k==2*i) && i!=altura-1)
					System.out.print(caracter);
					if (i!=0 && i!=altura-1 && k!=0 && k!=2*i) {
						System.out.print(" ");
					} else if (i==altura-1) {
						System.out.print(caracter);
					}
			}
			System.out.println();
			
			
		}
		

	
	}
}
