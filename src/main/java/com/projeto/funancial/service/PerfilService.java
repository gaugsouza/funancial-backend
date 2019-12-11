package com.projeto.funancial.service;

import org.springframework.stereotype.Service;

import com.projeto.funancial.model.Usuario;

@Service
public class PerfilService {
	public PerfilService() {
	}

	public String pegarNome(Usuario usuario) {
		String nome = usuario.getNome(); 
		return nome;
	}

}
