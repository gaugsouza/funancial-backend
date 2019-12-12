package com.projeto.funancial.controller;

import org.mockito.Mockito;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.service.UsuarioService;
import com.projeto.funancial.transformation.UsuarioTransformation;

@RestController
@RequestMapping("/jogo")
@CrossOrigin
public class JogoController {
	private UsuarioService usuarioService;
	private UsuarioTransformation usuarioTransformation;
	
	public JogoController(UsuarioService usuarioService, UsuarioTransformation usuarioTransformation) {
		this.usuarioService = usuarioService;
		this.usuarioTransformation = usuarioTransformation; 
	}
	
	public UsuarioCanonical iniciarJogo(UsuarioCanonical usuarioCanonical) { return usuarioCanonical;}
}
