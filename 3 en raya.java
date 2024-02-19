package examen2023EVA1;
import java.util.Scanner;

public class Pregunta6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		String tablero[][] = new String [4][4];
		int i = 1;
		int j = 1;
		char fila[] = new char[4];
		int col[] = new int[4];
		int filaPC = 0;
		int colPC = 0;
		int turn=0;

		try {
			tablero[0][0]="/";					//Por comodidad muestro en el tablero los numeros 1,2 y 3 arriba para que las posiciones del array coincida con las introducidas
			tablero[0][1]="1";
			tablero[1][0]="c";
			tablero[0][2]="2";
			tablero[2][0]="b";
			tablero[0][3]="3";
			tablero[3][0]="a";

			for(i=1;i<4;i++) {
				for(j=1;j<4;j++) {
					tablero[i][j] = "-";
				}
			}
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					System.out.print(tablero[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("Que comience la partida");

			for(turn=0;turn<3;turn++) {					//Limito 3 turnos porque son 3 fichas.
				System.out.println("Le toca jugar. Introduzca la posición de su ficha");
				System.out.print("Fila: (a,b,c)\n");
				fila[turn] = sc.next().charAt(0);
				switch (fila[turn]) {
				case 'a': 
					fila[turn]=3;
					break;
				case 'b': 
					fila[turn]=2;
					break;
				case 'c': 
					fila[turn]=1;
					break;
				}
				System.out.print("\nColumna: ");
				col[turn] = sc.nextInt();
				while(fila[turn]<1 || fila[turn]>3 || col[turn]<1 || col[turn]>3) {				//Limito posiciones inválidas (nota post examen: puse un if, mejor un while)
					System.out.println("Posición no válida. Introduzca una posición válida (1~3)");
					System.out.print("Fila: ");
					fila[turn] = sc.next().charAt(0);
					System.out.print("\nColumna: ");
					col[turn] = sc.nextInt();
				}

				while(tablero[fila[turn]][col[turn]]!="-") {
					System.out.println("Posición ocupada. Introduzca otra posición");
					System.out.print("Fila: ");
					fila[turn] = sc.next().charAt(0);
					System.out.print("\nColumna: ");
					col[turn] = sc.nextInt();
				}

				tablero[fila[turn]][col[turn]]=".";

				for(i=0;i<4;i++) {
					for(j=0;j<4;j++) {
						System.out.print(tablero[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("Le toca a tu oponente:");

				do {
					filaPC=(int) (Math.random()*3)+1;
					colPC=(int) (Math.random()*3)+1;
				}while(tablero[filaPC][colPC]!="-");

				tablero[filaPC][colPC]="*";

				for(i=0;i<4;i++) {
					for(j=0;j<4;j++) {
						System.out.print(tablero[i][j] + " ");
					}
					System.out.println();
				}
			}

			boolean alguienGana = false;

			if(tablero[1][1]==".") {                
				if( (tablero[1][2]=="." && tablero[1][3]==".") || (tablero[2][1]=="." && tablero[3][1]==".") || (tablero[2][2]=="." && tablero[3][3]==".") ) {
					System.out.println("Has ganado!");
					alguienGana = true;
				}
			} else if (tablero[2][1]==".") {
				if( tablero[2][2]=="." && tablero[2][3]=="." ) {
					System.out.println("Has ganado!");
					alguienGana = true;
				}
			} else if (tablero[3][1]==".") {
				if((tablero[3][2]=="X" && tablero[3][3]==".") || (tablero[2][2]=="." && tablero[1][3]==".") )  {
					System.out.println("Has ganado!");
					alguienGana = true;
				}
			} else if (tablero[1][2]==".") {
				if((tablero[2][2]=="." && tablero[3][2]==".") )  {
					System.out.println("Has ganado!");
					alguienGana = true;
				}
			} else if (tablero[1][3]==".") {
				if((tablero[2][3]=="." && tablero[3][3]==".") )  {
					System.out.println("Has ganado!");
					alguienGana = true;
				}
			}
			if(tablero[1][1]=="*") {                
				if( (tablero[1][2]=="*" && tablero[1][3]=="") || (tablero[2][1]=="*" && tablero[3][1]=="*") || (tablero[3][2]=="*" && tablero[3][3]=="*") ) {
					System.out.println("Has perdido :(");
					alguienGana = true;
				}
			} else if (tablero[3][1]=="*") {
				if( tablero[2][2]=="*" && tablero[2][3]=="*" ) {
					System.out.println("Has perdido :(");
					alguienGana = true;
				}
			} else if (tablero[3][1]=="*") {
				if((tablero[3][2]=="*" && tablero[3][3]=="*") || (tablero[2][2]=="*" && tablero[1][3]=="*") )  {
					System.out.println("Has perdido :(");
					alguienGana = true;
				}
			} else if (tablero[1][2]=="*") {
				if((tablero[2][2]=="*" && tablero[3][2]=="*") )  {
					System.out.println("Has perdido :(");
					alguienGana = true;
				}
			} else if (tablero[1][3]=="*") {
				if((tablero[2][3]=="*" && tablero[3][3]=="*") )  {
					System.out.println("Has perdido :(");
					alguienGana = true;
				}
			}

			if(alguienGana==false) {
				System.out.println("Empate");
			}

		} catch (Exception e){
			System.out.println("No ha introducido un valor correcto. Fin del juego.");
		}
	}
}




