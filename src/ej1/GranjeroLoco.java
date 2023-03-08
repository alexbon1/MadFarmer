package ej1;

import java.util.*;

public class GranjeroLoco {
	private static Scanner in = new Scanner(System.in);
	private List<Vaca> vacas;
	private Corral corral;
	private int tamañoCampo;
	private int x;
	private int y;

	public GranjeroLoco(int cantidadVacas, int tamañoCampo) {
		this.tamañoCampo = tamañoCampo;
		this.vacas = new ArrayList<>();
		this.corral = new Corral();

		// Crear vacas y ubicarlas aleatoriamente en el campo
		for (int i = 1; i <= cantidadVacas; i++) {
			int x = new Random().nextInt(tamañoCampo);
			int y = new Random().nextInt(tamañoCampo);
			Vaca vaca = new Vaca(i, x, y);
			vacas.add(vaca);
			corral.agregarVacaSuelta(vaca);
		}
	}

	public void verUbicacionVacas() {
		for (Vaca vaca : vacas) {
			System.out.println("Vaca " + vaca.getId() + ": (" + vaca.getX() + "," + vaca.getY() + ")");
		}
	}

	public void moverse() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese la nueva coordenada x: ");
		int newX = scanner.nextInt();
		System.out.print("Ingrese la nueva coordenada y: ");
		int newY = scanner.nextInt();
		x = newX;
		y = newY;
	}

	public void capturarVaca() {
		Vaca vaca = null;

		for (Vaca v : vacas) {
			if (v.getX() == x && v.getY() == y) {
				vaca = v;
			}
		}

		if (vaca == null) {
			System.out.println("No hay vacas en esta posición");
		} else {
			vacas.remove(vaca);
			corral.agregarVacaCapturada(vaca);
			System.out.println("Vaca " + vaca.getId() + " capturada");
		}
	}

	public void mostrarEstadoCorral() {
		System.out.println("Cantidad de vacas capturadas: " + corral.getCantidadVacasCapturadas());
		System.out.println("Cantidad de vacas sueltas: " + corral.getCantidadVacasSueltas());
	}

	public static void main(String[] args) {
		boolean fin = false;
		System.out.println("Inserte el tamaño de la parcela del granjero: ");
		int parcela = in.nextInt();
		System.out.println("Inserte cuantas vacas hay en total: ");
		int becerros = in.nextInt();

		GranjeroLoco granjero = new GranjeroLoco(becerros, parcela);

		while (!fin) {
			System.out.println();
			System.out.println("¿Qué hará el granjero? :");
			System.out.println("1. Ver ubicación de las vacas");
			System.out.println("2. Moverse");
			System.out.println("3. Capturar una vaca");
			System.out.println("4. Mostrar estado del corral");
			System.out.println("5. Terminar la captura");

			Scanner scanner = new Scanner(System.in);
			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				granjero.verUbicacionVacas();
				break;
			case 2:
				granjero.moverse();
				break;
			case 3:
				granjero.capturarVaca();
				break;
			case 4:
				granjero.mostrarEstadoCorral();
				break;
			case 5:
				fin = true;
				break;
			default:
				System.out.println("Opción inválida");
			}
			System.out.println("El estado final del corral es: ");
			granjero.mostrarEstadoCorral();
		}
	}
}