package com.bcp.cambio.service;

import com.bcp.cambio.entity.RequestCambio;
import com.bcp.cambio.entity.ResponseCambio;
import com.bcp.cambio.model.RequestUpdatecambio;
import com.bcp.cambio.model.ResponseUpdatecambio;

public interface CambioService {
	public ResponseCambio obtenerCambio(RequestCambio montoACambiar);
	public ResponseUpdatecambio actualizarCambio(RequestUpdatecambio tipo);
}
