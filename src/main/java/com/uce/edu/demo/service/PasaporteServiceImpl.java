package com.uce.edu.demo.service;

import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPasaporteRepository;
import com.uce.edu.demo.repository.modelo.Pasaporte;
@Service
public class PasaporteServiceImpl implements IPasaporteService{

	private IPasaporteRepository iPasaporteRepository;
	@Override
	public void insertar(Pasaporte pasaporte) {
		// TODO Auto-generated method stub
		this.iPasaporteRepository.insertar(pasaporte);
	}

}
