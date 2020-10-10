package com.bcp.cambio.model;

import lombok.Data;

@Data
public class RequestUpdatecambio {
	private double precio;
	private String divisa;
	private String moneda;
}
