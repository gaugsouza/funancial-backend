package com.projeto.funancial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.service.JogoService;
import com.projeto.funancial.service.UsuarioService;
import com.projeto.funancial.transformation.UsuarioTransformation;

@RestController
@RequestMapping("/jogo")
@CrossOrigin
public class JogoController {
	private UsuarioService usuarioService;
	private UsuarioTransformation usuarioTransformation;
	private JogoService jogoService;
	
	public JogoController(UsuarioService usuarioService, UsuarioTransformation usuarioTransformation, JogoService jogoService) {
		this.usuarioService = usuarioService;
		this.usuarioTransformation = usuarioTransformation; 
		this.jogoService = jogoService;
	}
	
	public ResponseEntity<List<Object>> iniciarJogo(UsuarioCanonical usuarioCanonical) { 
		List<Object> usuarioHistoria = new ArrayList<Object>();
		
		usuarioCanonical = jogoService.iniciarUsuario(usuarioCanonical);
		usuarioCanonical = usuarioTransformation.convert(
				usuarioService.save(usuarioTransformation.convert(usuarioCanonical)));
		
		
		usuarioHistoria.add(usuarioCanonical);
		
		return new ResponseEntity<>(usuarioHistoria, HttpStatus.OK);
	}
}
