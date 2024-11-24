package com.autobots.automanager.modelo;

public class StringVerificadorNulo {

	public boolean verificar(String dado) {
		if (dado != null) {
			if (!dado.isBlank()) {
				return false;
			}
		}
		return true;
	}
}