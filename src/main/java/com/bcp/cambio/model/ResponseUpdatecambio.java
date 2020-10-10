package com.bcp.cambio.model;

import lombok.Data;

@Data
public class ResponseUpdatecambio {
	private double precioAnterior;
	private double precioNuevo;
	private String divisa;
	private String moneda;
}
