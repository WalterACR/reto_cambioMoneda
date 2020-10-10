package com.bcp.cambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.cambio.entity.RequestCambio;
import com.bcp.cambio.entity.ResponseCambio;
import com.bcp.cambio.model.RequestUpdatecambio;
import com.bcp.cambio.model.ResponseUpdatecambio;
import com.bcp.cambio.service.CambioService;

@RestController
@RequestMapping("/api")
public class CambioController {

	@Autowired
	private CambioService cambioService;

	@PostMapping("/cambioT")
	public ResponseEntity<ResponseCambio> cambio(@RequestBody RequestCambio cambio) {
		return ResponseEntity.ok().body(this.cambioService.obtenerCambio(cambio));
	}

	@PutMapping("/actualizarCambio")
	public ResponseUpdatecambio updateProduct(@RequestBody RequestUpdatecambio nuevocambio) {
		return cambioService.actualizarCambio(nuevocambio);
	}

	@PostMapping("/cambio")
	public ResponseCambio obtenercambio(@RequestBody RequestCambio cambio) {
		return cambioService.obtenerCambio(cambio);
	}
}
