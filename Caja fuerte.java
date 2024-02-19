package ejerciciosJavaBucles;
import java.util.Scanner;
public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduzca el código de la caja fuerte");
		int combi = 0;
		int intento = 1;
		String digitos;
		while (combi!=9768 && intento<=4) {
			System.out.println(intento + " de 4 intentos hasta el bloqueo");
			combi = sc.nextInt();
			digitos = Integer.toString(combi);        //Convierto el número entero a formato string
			int longitud = digitos.length();          // Con formato string puedo establecer un entero que me diga el número de caracteres (dígitos en este caso)
			intento++;
				if (longitud != 4) {
					System.out.println("Error. La combinación debe de tener 4 dígitos");
				}
		}
		if (combi == 9768) {
			System.out.println("Caja fuerte desbloqueada");
		} else {
			System.out.println("Caja fuerte bloqueada.");
		}
		sc.close();
	}

}
