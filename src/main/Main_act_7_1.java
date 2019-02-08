package main;

import java.util.Scanner;

import methods.Juego;
import methods.Jugador;

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
		
		Jugador [] jugadores = new Jugador [numJugadores];
		
		//Se construyen los jugadores

		jugadores = new Jugador [numJugadores];
		
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador ();
		}

		
		//Empieza el juego
		for (int i = 0; finPartida != numJugadores; i++) {
			
			System.out.println("Ronda " + (i + 1));
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			for (int j = 0; j < jugadores.length; j++) {
				
				
				//Si el jugador tiene menos de 7.5, entonces juega
				if (jugadores[j].puntuacion() <= 7.5 && jugadores[j].getSePlanta() == false) {
				
					//Máquina
					if (j == 0) {
												
						System.out.println("TURNO DE LA MÁQUINA");
						
						System.out.println("\n" + jugadores[j]);	
						System.out.println("tienes una puntuación de " + jugadores[j].puntuacion() + " puntos");

						
						if (jugadores[0].iaRoba(maxPuntuacion(jugadores), i) == true) {
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
						
						System.out.println("\n" + jugadores[j]);	
						System.out.println("tienes una puntuación de " + jugadores[j].puntuacion() + " puntos");
						
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
							
							System.out.println("La carta es " + jugadores[j].pedirCarta());
							
							if (jugadores[j].puntuacion() > 7.5) {
								System.out.println("Lástima, te has pasado");
								jugadores[j].setSePasa(true);
								finPartida++;
							}
							
							else {

								System.out.println("¿Deseas plantarte? tienes una puntuación de " + jugadores[j].puntuacion() + " puntos");
								
								System.out.println("1. Si");
								System.out.println("2. No");
								sePlanta = sc.nextInt();
								while (sePlanta < 1 || sePlanta > 2) {
									System.out.println("Opción incorrecta");
									sePlanta = sc.nextInt();
								}
								
								if (sePlanta == 1) {
									jugadores[j].plantarse();
									finPartida++;
								}
								
							}
							
							break;
							
						//Plantarse (Opción 2)	
						case 2:
							
							System.out.println("¿Seguro que deseas plantarte? tienes una puntuación de " + jugadores[j].puntuacion() + " puntos");
							
							System.out.println("1. Si");
							System.out.println("2. No");
							sePlanta = sc.nextInt();
							while (sePlanta < 1 || sePlanta > 2) {
								System.out.println("Opción incorrecta");
								sePlanta = sc.nextInt();
							}
							
							if (sePlanta == 1) {
								jugadores[j].plantarse();
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
		int l = ganador(jugadores);
		
		if (l == -1) {
			System.out.println("Habeis perdido todos");
		}
		
		else {
			System.out.println("Ha ganado el jugador " + (l + 1) + " con una puntuacion de " + jugadores[l].puntuacion() + " puntos");
		}
		
		sc.close();
	}
	
	//Se elige al ganador
	public static int ganador(Jugador [] jugadores) {
		int l = 0, cont = 0, k = 0;
		float maxPuntuacion = 0;
		for (k = 0; k < jugadores.length; k++) {
			if (jugadores[k].getSePasa() == false) {
				if (k == 0) {
					l = k;
					maxPuntuacion = jugadores[k].puntuacion();
				}
				else {
					if (maxPuntuacion < jugadores[k].puntuacion()) {
						l = k;
						maxPuntuacion = jugadores[k].puntuacion();
					}
				}
			}
			
			else {
				cont++;
			}
			
		}
		
		if (cont == k) {
			l = -1;
		}
		
		return l;
	}
	
	//Puntuación máxima
	public static float maxPuntuacion(Jugador [] jugadores) {
		float maxPuntuacion = 0;
		for (int k = 0; k < jugadores.length; k++) {
			if (jugadores[k].getSePasa() == false) {
				if (maxPuntuacion == 0) {
					maxPuntuacion = jugadores[k].puntuacion();
				}
				else {
					if (maxPuntuacion < jugadores[k].puntuacion()) {
						maxPuntuacion = jugadores[k].puntuacion();
					}
				}
			}
		}
		return maxPuntuacion;
	}

}