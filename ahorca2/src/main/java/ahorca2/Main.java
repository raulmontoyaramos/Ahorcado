package ahorca2;

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Aquí simplemente creo un array de String que contiene las seis palabras
		// posibles a adivinar,
		// luego uso un random para que elija una posición de entre todas las posiciones
		// de el anterior array
		// y asignándo el String de esa posición a la variable "palabraElegida"
		String[] palabras = { "HOLA", "MUNDO", "JAVA", "PROGRAMACION", "COMPUTADORA", "GITHUB" };
		Random random = new Random();
		String palabraElegida = palabras[random.nextInt(palabras.length)];

		Scanner scanner = new Scanner(System.in);
		// Creo un objeto de la clase Ahorca2 usando su constructor para iniciar el
		// juego con la palabra elegida y 6 intentos.
		Ahorca2 juego = new Ahorca2(palabraElegida, 6);

		// Éste es el bucle donde se desarrolla el juego, éste se itera siempre que no
		// se haya ganado y no se haya perdido,
		// que es lo primero que se comprueba en cada iteración del bucle, en caso de
		// que no se cumpla ésta condición se saldrá
		// directamente de el bucle comprobando si ha ganado para imprimir un mensaje
		// por consola y en caso contrario imprimir
		// otro mensaje por consola donde se desvela cuál era la palabra a adivinar,
		// terminando así el programa.
		// Si se cumple la condición entrará al bucle donde primero se imprimira el
		// espacio para adivinar la palabra donde,
		// si ya se ha adivinado alguna letra saldrá ésta en su posición, también se
		// imprimirán los intentos restantes y te pide
		// que ingreses una letra, ésto lo hago con un system.out.print sin "ln" para
		// que quede más estético a la hora de ingresar
		// la letra, luego escanéo este char que haya ingresado el usuario y uso el
		// método intentar para saber si el intento es
		// acertado o no y (en el caso de que sea acertado que escriba la letra acertada
		// en su posición correspondiente) pasándole por argumento la letra que acaba de
		// ingresar el usuario y asignando el resultado a una variable
		// booleana ya que es lo que devuele el método intentar, por último compruebo si
		// éste booleano es true o false para notificar
		// al usuario si ha acertado o no.
		while (!juego.haGanado() && !juego.haPerdido()) {
			System.out.println("Palabra: " + juego.obtenerPalabraAdivinada());
			System.out.println("Intentos restantes: " + juego.getIntentosRestantes());
			System.out.print("Ingresa una letra: ");
			char letra = scanner.next().charAt(0);
			boolean acierto = juego.intentar(letra);

			if (acierto) {
				System.out.println("¡Acierto!");
			} else {
				System.out.println("Letra incorrecta.");
			}
		}

		if (juego.haGanado()) {
			System.out.println("¡Felicidades! Has ganado.");
		} else {
			System.out.println("¡Lo siento! Has perdido. La palabra era: " + juego.palabraSecreta);
		}
	}

}
