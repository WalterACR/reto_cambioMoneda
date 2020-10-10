package com.bcp.cambio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcp.cambio.entity.TipoCambio;

@Repository
public interface CambioRepository extends JpaRepository<TipoCambio, Long> {
	@Query("SELECT c  FROM TipoCambio c where c.divisa = :divisa and c.moneda = :moneda") 
	public TipoCambio getTipoCambiobyDivisaAndMoneda(@Param("divisa") String Divisa, @Param("moneda") String Moneda);
}
