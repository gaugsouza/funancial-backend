package com.projeto.funancial.controller;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.model.Perfil;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.PerfilService;
import com.projeto.funancial.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuario/{id}/perfil")
public class PerfilController {
	private UsuarioService usuarioService;
	private PerfilService perfilService;

	public PerfilController(UsuarioService usuarioService, PerfilController perfilService) {
		this.usuarioService = usuarioService;
		this.perfilService = perfilService;
	}
	
	@GetMapping
	public ResponseEntity<Perfil> getUserPerfil(@PathVariable("id") ObjectId id) {
		Optional<Usuario> usuarioDB = Optional.ofNullable(usuarioService.findBy_Id(id));
		
		if (!usuarioDB.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		String perfilNome =  perfilService.pegarNome(usuarioDB.get());
		
		Perfil userPerfil = new Perfil(usuarioDB.get(), perfilNome);
		return new ResponseEntity<>(userPerfil, HttpStatus.OK);

	}

}
