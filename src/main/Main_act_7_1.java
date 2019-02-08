package main;

import java.util.Scanner;

import methods.Juego;

public class Main_act_7_1 {

	public static void main(String[] args) {

		Scanner sc =  new Scanner (System.in);
		
		int numJugadores = 1, opt = 0, finPartida = 0, sePlanta = 0;
		
		//Selección de jugadores (Uno de ellos es la máquina)
		System.out.println("¿Cuantos jugadores van a jugar? (de 1 a 5)");
		numJugadores = sc.nextInt();
		while (numJugadores < 1 || numJugadores > 5) {
			System.out.println("Opción incorrecta, solo pueden jugar de 1 a 5 jugadores (mas la máquina)");
			numJugadores = sc.nextInt();
		}
		
		numJugadores = numJugadores + 1;
		
		Juego juego = new Juego (numJugadores);
		
		//Se construyen los jugadores

		
		
		//Empieza el juego
		for (int i = 0; finPartida != numJugadores; i++) {
			
			System.out.println("Ronda " + (i + 1));
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			for (int j = 0; j < juego.jugadores.length; j++) {
				
				
				//Si el jugador tiene menos de 7.5, entonces juega
				if (juego.jugadores[j].puntuacion() <= 7.5 && juego.jugadores[j].getSePlanta() == false) {
				
					//Máquina
					if (j == 0) {
												
						System.out.println("TURNO DE LA MÁQUINA");
						
						System.out.println("\n" + juego.jugadores[j]);	
						System.out.println("tienes una puntuación de " + juego.jugadores[j].puntuacion() + " puntos");

						
						if (juego.jugadores[0].iaRoba(juego.maxPuntuacion(), i) == true) {
							System.out.println("Me planto");
							finPartida++;
						}
						
						else {
							System.out.println("Terminé");
						}
						
					}
					
					//Jugador(es)
					else {
						System.out.println("Jugador " + (j + 1) + ", es tu turno");
						
						System.out.println("\n" + juego.jugadores[j]);	
						System.out.println("tienes una puntuación de " + juego.jugadores[j].puntuacion() + " puntos");
						
						System.out.println("\nElige una opción");
						System.out.println("1. Pedir carta");
						System.out.println("2. Plantarse");
						
						opt = sc.nextInt();
						while (opt < 1 || opt > 3) {
							System.out.println("Opción incorreta");
							opt = sc.nextInt();
						}
						
						switch (opt) {
							
						//Pedir carta (Opción 1)
						case 1:
							
							System.out.println("La carta es " + juego.jugadores[j].pedirCarta());
							
							if (juego.jugadores[j].puntuacion() > 7.5) {
								System.out.println("Lástima, te has pasado");
								juego.jugadores[j].setSePasa(true);
								finPartida++;
							}
							
							else {

								System.out.println("¿Deseas plantarte? tienes una puntuación de " + juego.jugadores[j].puntuacion() + " puntos");
								
								System.out.println("1. Si");
								System.out.println("2. No");
								sePlanta = sc.nextInt();
								while (sePlanta < 1 || sePlanta > 2) {
									System.out.println("Opción incorrecta");
									sePlanta = sc.nextInt();
								}
								
								if (sePlanta == 1) {
									juego.jugadores[j].plantarse();
									finPartida++;
								}
								
							}
							
							break;
							
						//Plantarse (Opción 2)	
						case 2:
							
							System.out.println("¿Seguro que deseas plantarte? tienes una puntuación de " + juego.jugadores[j].puntuacion() + " puntos");
							
							System.out.println("1. Si");
							System.out.println("2. No");
							sePlanta = sc.nextInt();
							while (sePlanta < 1 || sePlanta > 2) {
								System.out.println("Opción incorrecta");
								sePlanta = sc.nextInt();
							}
							
							if (sePlanta == 1) {
								juego.jugadores[j].plantarse();
								finPartida++;
							}
							
							break;

						default:
							break;
						}
						
						System.out.println("........................................................");

					}
					
				}
				
			}
						
		}
		
		//Elección del ganador
		int l = juego.ganador();
		
		if (l == -1) {
			System.out.println("Habeis perdido todos");
		}
		
		else {
			System.out.println("Ha ganado el jugador " + (l + 1) + " con una puntuacion de " + juego.jugadores[l].puntuacion() + " puntos");
		}
		
		sc.close();
	}

}