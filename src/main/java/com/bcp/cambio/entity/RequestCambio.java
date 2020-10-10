package com.bcp.cambio.entity;

import lombok.Data;

@Data
public class RequestCambio {
	private double monto;
	private String monedaOrigen;
	private String monedaDestino;
}
