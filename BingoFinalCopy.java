import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoFinalCopy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opciones = 0;
        int[][] cartonActual = new int[3][9];
        int contLinea = 0;
        int contBingo = 0;
        boolean linea1 = false, linea2 = false, linea3 = false;
        do {
            menu();
            opciones = sc.nextInt();
            if(opciones==1){
                cartonActual = generarCarton();
            } else if (opciones==2){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (cartonActual[i][j] == -1) {
                            System.out.print("X \t");
                        } else if (cartonActual[i][j] == 0) {
                            System.out.print("■ \t");
                        } else if (cartonActual[i][j] != -1) {
                            System.out.print(cartonActual[i][j] + "\t");
                        }
                    }
                    System.out.println(" ");
                }
                System.out.println("\n");
            } else if (opciones == 3) {
                int bola = sacarbola();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                        if(bola==cartonActual[i][j]){
                            cartonActual[i][j] = -1;
                            contLinea++;
                            contBingo++;
                        }
                        if (contBingo == 15) {
                            System.out.println("BINGO");
                            return;
                        }
                    }
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (cartonActual[i][j] == -1) {
                            contLinea++;
                        }
                        if (contLinea == 5 && i==0 && linea1==false) {
                            linea1 = true;
                            System.out.println("LINEA");
                        }
                        if (contLinea == 5 && i==1 && linea2==false) {
                            linea2 = true;
                            System.out.println("LINEA");
                        }
                        if (contLinea == 5 && i==2 && linea2==false) {
                            linea3 = true;
                            System.out.println("LINEA");
                        }
                    }
                    contLinea = 0;
                }
            }
        } while (opciones != 4);
    }

    public static void menu(){
        System.out.println("Elija una opción");
        System.out.println("1- Generar cartón.");
        System.out.println("2- Mostrar estado del cartón.");
        System.out.println("3- Sacar bola.");
        System.out.println("4- Salir del juego.");
    }

    public static int[][] generarCarton() {
        int[][] carton = cartonHuecos(cartonOrdenado());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] != 0) {
                    System.out.print(carton[i][j] + "\t");
                } else if (carton[i][j] == 0) {
                    System.out.print("■ \t");
                }
            }
            System.out.println(" ");
        }
        System.out.println("\n");
        return carton;
    }
    private static List<Integer> bolasSacadas = new ArrayList<>();
    public static int sacarbola(){
        Random random = new Random();
        int bola;
        do{
            bola = random.nextInt(1,89);
        } while (bolasSacadas.contains(bola));

        bolasSacadas.add(bola);
        System.out.println("\n" + bola + "\n");
        return bola;
    }

    public static int[][] cartonOrdenado() {
        Random random = new Random();
        boolean repe;
        int[][] carton = new int[4][10];
        int i, j, k;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                do {
                    carton[i][j] = random.nextInt(10 * j, 10 * j + 9);
                    repe = false;
                    for (k = 0; k < 10 * i + j; k++) {
                        if (carton[i][j] == carton[k / 10][k % 10]) {
                            repe = true;
                            break;                                  //Una vez es true ya se que el numero esta repe, no tiene sentido seguir comprobando, uso break y que vuelva al do para dar otro valor
                        }
                    }
                } while (repe);
            }
        }

        int temp;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                for (int l = 0; l <= i - 1; l++) {
                    if (carton[i][j] < carton[l][j]) {
                        temp = carton[i][j];
                        carton[i][j] = carton[l][j];
                        carton[l][j] = temp;
                    }
                }
            }

        }
        return carton;
    }
    public static int[][] cartonHuecos(int[][] cartonOrdenado){
        Random random = new Random();

        int i, j;

        int huecos = 4;
        int posHueco;

        for (i = 0; i < 3; i++) {
            while (huecos > 0) {
                posHueco = random.nextInt(9);
                if (cartonOrdenado[i][posHueco] != 0 && i < 2) {
                    cartonOrdenado[i][posHueco] = 0;
                    huecos--;
                } else if (cartonOrdenado[i][posHueco] != 0 && i == 2) {
                    if (cartonOrdenado[i - 1][posHueco] != 0 || cartonOrdenado[i - 2][posHueco] != 0) {
                        cartonOrdenado[i][posHueco] = 0;
                        huecos--;
                    }
                }
            }
            huecos = 4;
        }

        boolean repetir;

        for (j = 0; j < 9; j++) {
            repetir = true;         // Lo pongo para que bucle while vuelva a ocurrir en caso de que tenga más de una situacion con tres unos en columna
            if (cartonOrdenado[0][j] != 0 && cartonOrdenado[1][j] != 0 && cartonOrdenado[2][j] != 0) {
                cartonOrdenado[2][j] = 0;
                while (repetir) {
                    posHueco = random.nextInt(0, 8);
                    if (cartonOrdenado[2][posHueco] == 0 && (cartonOrdenado[0][posHueco] == 0 || cartonOrdenado[1][posHueco] == 0)) {
                        cartonOrdenado[2][posHueco] = random.nextInt(posHueco*10, posHueco*10+9);
                        repetir = false;
                    }
                }
            }
        }
        return cartonOrdenado;
    }
}
