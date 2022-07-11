package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("pesado")
public  class MatricculaPesadoServiceImpl implements IMatriculaService{

	@Override
	public BigDecimal calcularValor(BigDecimal precio) {
		// TODO Auto-generated method stub
		BigDecimal valor = precio.multiply(new BigDecimal(15).divide(new BigDecimal(100)));
		
		return valor;
	}  
	
   
    



}
