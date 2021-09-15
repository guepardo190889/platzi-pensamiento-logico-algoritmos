package platzi.pensamiento.logico.algoritmos;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Ejercicios de funciones recursivas para el Curso Básico de Algoritmos y
 * Pensamiento Lógico de Platzi
 * <p>
 * https://platzi.com/clases/pensamiento-logico/
 * 
 * @author sethluis
 *
 */
public class FuncionesRecursivas {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("===Ejercicio 1===");
		timer(5, 10, 5);
		System.out.println("======");
		System.out.println("");

		System.out.println("===Ejercicio 2===");
		encontrarNumeroMayor(new int[] { 5, 7, 3, 1, 9 }, 0, 0);
		System.out.println("======");
		System.out.println("");

		System.out.println("===Ejercicio 3===");
		convertirMayusculas("murcielago", 0);
		System.out.println("======");
		System.out.println("");

		System.out.println("===Ejercicio 4===");
		fibonacci(0, 1, 1, 10);
		System.out.println("======");
		System.out.println("");

		System.out.println("===Ejercicio 5===");
		generarPassword("");
		System.out.println("======");
		System.out.println("");
	}

	/**
	 * Escribe una función recursiva para un timer que cada 5 minutos se agregue 10
	 * minutos más a su cuenta total.
	 * 
	 * @param periodicidad
	 * @param incremento
	 * @param tiempoTotal
	 */
	public static void timer(int periodicidad, int incremento, int tiempoTotal) {
		System.out.println("hora: " + new Date() + " - tiempoTotal: " + tiempoTotal);

		try {
			TimeUnit.MINUTES.sleep(periodicidad);
			timer(periodicidad, incremento, tiempoTotal - periodicidad + incremento);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Escribe una función recursiva para encontrar el número mayor de un array.
	 * 
	 * @param arreglo
	 * @param valorMaximoActual
	 * @param indiceActual
	 */
	public static void encontrarNumeroMayor(int arreglo[], int valorMaximoActual, int indiceActual) {
		int valorActual = arreglo[indiceActual];

		System.out.println("valorMaximoActual: " + valorMaximoActual + " - valorActual: " + valorActual
				+ " - índiceActual: " + indiceActual);

		int valorMaximoEncontrado = valorMaximoActual;

		if (valorActual > valorMaximoActual) {
			valorMaximoEncontrado = valorActual;

			System.out.println("valorActual > valorMaximoActual");
		}

		if (indiceActual == arreglo.length - 1) {
			System.out.println("Valor máximo encontrado: " + valorMaximoEncontrado);
		} else {
			encontrarNumeroMayor(arreglo, valorMaximoEncontrado, indiceActual + 1);
		}
	}

	/**
	 * Escribe una función recursiva para convertir de minúscula a mayúscula el
	 * primer y último carácter de un string.
	 * 
	 * @param cadena
	 * @param indiceActual
	 */
	public static void convertirMayusculas(String cadena, int indiceActual) {
		String cadenaConvertida = cadena;

		System.out.println("indiceActual: " + indiceActual);

		if (indiceActual == 0) {
			String primerCaracter = String.valueOf(cadena.charAt(indiceActual)).toUpperCase();
			String caracteresSiguientes = cadena.substring(indiceActual + 1, cadena.length());
			cadenaConvertida = primerCaracter + caracteresSiguientes;

			System.out.println("primerCaracter: " + primerCaracter);
			System.out.println("caracteresSiguientes: " + caracteresSiguientes);
			System.out.println("cadenaConvertida: " + cadenaConvertida);

			convertirMayusculas(cadenaConvertida, indiceActual + 1);
		} else if (indiceActual == cadena.length() - 1) {
			String caracteresAnteriores = cadena.substring(0, cadena.length() - 1);
			String ultimoCaracter = cadena.substring(cadena.length() - 1).toUpperCase();

			cadenaConvertida = caracteresAnteriores + ultimoCaracter;

			System.out.println("caracteresAnteriores: " + caracteresAnteriores);
			System.out.println("ultimoCaracter: " + ultimoCaracter);
			System.out.println("cadenaConvertida: " + cadenaConvertida);
		} else {
			convertirMayusculas(cadenaConvertida, indiceActual + 1);
		}
	}

	/**
	 * Escribe una función recursiva para escribir la serie Fibonacci hasta su
	 * décima iteración.
	 * 
	 * @param numeroAnterior
	 * @param numeroActual
	 * @param numeroIteracion
	 * @param limiteIteracion
	 */
	public static void fibonacci(int numeroAnterior, int numeroActual, int numeroIteracion, int limiteIteracion) {
		int nuevoNumero = numeroAnterior + numeroActual;

		if (numeroIteracion == 1) {
			System.out.println(numeroAnterior);
			System.out.println(numeroActual);

			fibonacci(numeroActual, nuevoNumero, numeroIteracion + 1, limiteIteracion);
		} else if (numeroIteracion == limiteIteracion) {
			System.out.println(nuevoNumero);
		} else {
			System.out.println(nuevoNumero);

			fibonacci(numeroActual, nuevoNumero, numeroIteracion + 1, limiteIteracion);
		}
	}

	/**
	 * Escribe una función recursiva para generar un password aleatorio con 20
	 * caracteres combinando letras-números-símbolos-números-letras-día-new-año.
	 * 
	 * @param password
	 */
	public static void generarPassword(String password) {
		if (password.length() == 20) {
			System.out.println(password);
		} else {
			int primerCaracterASCIIValido = 32;
			int ultimoCaracterASCIIValido = 126;
			int codigoASCIICaracter = (int) Math
					.floor(Math.random() * (ultimoCaracterASCIIValido - primerCaracterASCIIValido + 1)
							+ primerCaracterASCIIValido); // Valor entre M y N, ambos incluidos.

			System.out.println("codigoASCIICaracter: " + codigoASCIICaracter);

			String caracterGenerado = String.valueOf((char) codigoASCIICaracter);

			generarPassword(password + caracterGenerado);
		}
	}

}
