package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Matricula;
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.repository.IMatriculaRepository;
import com.uce.edu.demo.prueba.repository.IPropietarioRepository;
import com.uce.edu.demo.prueba.repository.IVehiculoRepository;
@Service
public class FachadaMatriculaServiceImpl implements IFachadaMatriculaService{
	@Autowired
	private IVehiculoRepository vehiculo;
	@Autowired
	private IPropietarioRepository propietario;   
    @Autowired
    @Qualifier("liviano")
	private IMatriculaService matriculaServiceL;
    @Autowired
    @Qualifier("pesado")
	private IMatriculaService matriculaServiceP;
    @Autowired
    private IMatriculaRepository iMatriculaRepository;
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		BigDecimal valor;
		BigDecimal descuento;
		Propietario p=this.propietario.consultarPorCedula(cedula);
		Vehiculo v = this.vehiculo.buscarPorPlaca(placa);
		if (v.getTipo().equals("L")) {
			
			valor = this.matriculaServiceL.calcularValor( v.getPrecio());
			
		}
		else {
			valor = this.matriculaServiceP.calcularValor( v.getPrecio());
			}
		
		if(valor.compareTo(new BigDecimal(2000))>0) {
		     descuento  = valor.multiply(new BigDecimal(7).divide(new BigDecimal(100)));
		     valor = valor.subtract(descuento);
			
		}
		Matricula m = new Matricula();
		m.setFechaMatricula(LocalDateTime.now());
		m.setPropietario(p);
		m.setVehiculo(v);
		m.setValorMatricula(valor);
		this.iMatriculaRepository.crear(m);
	}


	
		



}
