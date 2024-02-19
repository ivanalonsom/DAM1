import java.util.Scanner;

//import static java.lang.System.exit;		No muy recomendable pues termina abruptamente el programa

public class AhorcadoFunciones {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 0;
        int intento = 8;

        int r = (int) (Math.random() * 5);
        String palabra = PalabraElegida(r);
        int longitud = palabra.length();

        String[] ahorcado = new String[longitud];

        System.out.println("\nIntroduzca una letra (A-Z)\n");
        for (i = 0; i < longitud; i++) {
            ahorcado[i] = "_ ";
            System.out.print(ahorcado[i]);
        }
        System.out.println("\n\nIntentos totales: 8");

        while (intento > 0) {
            String respuesta = sc.nextLine().toUpperCase();
            char letra = respuesta.charAt(0);
            boolean letraEncontrada = false;

            tableroMod(longitud, letra, palabra, ahorcado, respuesta, letraEncontrada);
            System.out.println("\n");

            intento = vidas(intento, letraEncontrada);
            boolean ganaste = true;
            if(compruebaGanador(ahorcado)){
				System.out.println("Felicidades. Has ganado!");
				return;
			}
        }
        System.out.println("Has perdido :(");
    }

    public static String PalabraElegida(int r) {
        String[] palabras = {"GATO", "OVEJA", "PIEDRA", "GAFAS", "SEÑOR", "PAPEL"};

        String palabraElegida = palabras[r];

        return palabraElegida;
    }

    public static void tableroMod(int longitud, char letra, String palabra, String[] ahorcado, String respuesta, boolean letraEncontrada) {
        for (int i = 0; i < longitud; i++) {
            if (letra == palabra.charAt(i)) {
                ahorcado[i] = respuesta.substring(0, 1);          //Pongo el substring para que solo me coja la primera letra.
                letraEncontrada = true;
            }
            System.out.print(ahorcado[i]);
        }
    }

    public static int vidas(int intento, boolean letraencontrada) {
        if (!letraencontrada) {
            intento--;
            System.out.println("Intentos restantes: " + intento);
        }
        return intento;
    }

	public static boolean compruebaGanador(String[] ahorcado){
		for(String letra: ahorcado){
			if(letra.equals("_ ")){
				return false;
			}
		}
		return true;
	}

    /*public static void compruebaGanador(String[] ahorcado, int longitud, boolean ganaste) {		Opcion más engorrosa

        for (int i = 0; i < longitud; i++) {
            if (ahorcado[i].equals("_ ")) {
                ganaste = false;
                break;
            }
        }
        if (ganaste) {
            System.out.println("Felicidades. Has ganado!");
            System.exit(0);            // Con esto hago que si entra en el if el programa acabe.
        }
    }*/
}