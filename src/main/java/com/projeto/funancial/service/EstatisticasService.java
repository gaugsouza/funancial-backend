package com.projeto.funancial.service;

import org.springframework.stereotype.Service;

import com.projeto.funancial.model.Status;
import com.projeto.funancial.model.Usuario;

@Service
public class EstatisticasService {
	public EstatisticasService() {
	}

	public Double gerarEstatisticaDinheiro(Usuario usuario) {
		Double dinheiroAtual = usuario.getDinheiro().doubleValue();
		Double dinheiroEstatistica = dinheiroAtual - Status.DINHEIRO_INICIAL.doubleValue(); 
		return dinheiroEstatistica;
	}

	public Integer gerarEstatisticaNivel(Usuario usuario) {
		Integer nivelAtual = usuario.getNivel();
		Integer nivelEstatistica = nivelAtual - Status.NIVEL_INICIAL;
		return nivelEstatistica;
	}
}
