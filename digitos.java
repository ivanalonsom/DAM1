package otraprueba;
import java.util.Scanner;

public class digitos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		char digito;
		boolean encontrado = false; // Variable para verificar si el dígito ha sido encontrado

		System.out.println("Introduzca un número:");
		N = sc.nextInt();

		System.out.println("Indique el dígito a encontrar:");
		digito = sc.next().charAt(0);

		String numero = String.valueOf(N);

		System.out.println("Las posición(es) en las que aparece el dígito " + digito + ": ");

		for (int i = 0; i < numero.length(); i++) {
			if (numero.charAt(i) == digito) {
				System.out.println(i + 1);
				encontrado = true; // Marca que el dígito ha sido encontrado
			}
		}

		if (!encontrado) {
			System.out.println("El dígito especificado no aparece en el número.");
		}
	}
}
