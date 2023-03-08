package ej1;

import java.util.*;

public class Corral {
	private List<Vaca> vacasCapturadas;
	private List<Vaca> vacasSueltas;

	public Corral() {
		this.vacasCapturadas = new ArrayList<>();
		this.vacasSueltas = new ArrayList<>();
	}

	public void agregarVacaCapturada(Vaca vaca) {
		vacasCapturadas.add(vaca);
		vacasSueltas.remove(vaca);
	}

	public void agregarVacaSuelta(Vaca vaca) {
		vacasSueltas.add(vaca);
	}

	public int getCantidadVacasCapturadas() {
		return vacasCapturadas.size();
	}

	public int getCantidadVacasSueltas() {
		return vacasSueltas.size();
	}
}