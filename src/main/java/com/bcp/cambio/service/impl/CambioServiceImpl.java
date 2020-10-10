package com.bcp.cambio.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.cambio.entity.RequestCambio;
import com.bcp.cambio.entity.ResponseCambio;
import com.bcp.cambio.entity.TipoCambio;
import com.bcp.cambio.model.RequestUpdatecambio;
import com.bcp.cambio.model.ResponseUpdatecambio;
import com.bcp.cambio.repository.CambioRepository;
import com.bcp.cambio.service.CambioService;

@Service
@Transactional
public class CambioServiceImpl implements CambioService{

	@Autowired
	private CambioRepository cambioRepository;
	
	@Override
	public ResponseCambio obtenerCambio(RequestCambio montoACambiar) {
		TipoCambio tipo= cambioRepository.getTipoCambiobyDivisaAndMoneda(montoACambiar.getMonedaDestino(), montoACambiar.getMonedaOrigen());		
		double precio = tipo.getValorTipoCambio().doubleValue();
		ResponseCambio Montocambiado = new ResponseCambio();
		Montocambiado.setMonto(montoACambiar.getMonto());
		Montocambiado.setMontoCambiado(montoACambiar.getMonto()*precio);
		Montocambiado.setMonedaOrigen(montoACambiar.getMonedaOrigen());
		Montocambiado.setMonedaDestino(montoACambiar.getMonedaDestino());
		Montocambiado.setTipoCambio(precio);
		return Montocambiado;
	}

	@Override
	public ResponseUpdatecambio actualizarCambio(RequestUpdatecambio tipo) {
		ResponseUpdatecambio response = new ResponseUpdatecambio();
		TipoCambio  tipoOld= cambioRepository.getTipoCambiobyDivisaAndMoneda(tipo.getDivisa(), tipo.getMoneda());		
		if(tipoOld != null) {
			
			TipoCambio productUpdate = tipoOld;
			
			response.setDivisa(productUpdate.getDivisa());
			response.setMoneda(productUpdate.getMoneda());
			response.setPrecioAnterior(tipoOld.getValorTipoCambio().doubleValue());
			response.setPrecioNuevo(tipo.getPrecio());
			
			productUpdate.setValorTipoCambio( new BigDecimal(tipo.getPrecio()));
			cambioRepository.save(productUpdate);
			
			
			return response;
		}else {
			return null; 
		}
	}

}
