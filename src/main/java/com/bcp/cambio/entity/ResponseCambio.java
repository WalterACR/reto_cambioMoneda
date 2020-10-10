package com.bcp.cambio.entity;

import lombok.Data;

@Data
public class ResponseCambio {
	private double monto;
	private double montoCambiado;
	private String monedaOrigen;
	private String monedaDestino;
	private double tipoCambio;
}
