package com.projeto.funancial.controller;

import static org.mockito.Mockito.when;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mockito.Mockito;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.UsuarioService;
import com.projeto.funancial.transformation.UsuarioTransformation;

public class JogoControllerTest {
	private UsuarioService svc = Mockito.mock(UsuarioService.class);
	private UsuarioTransformation transformation = Mockito.mock(UsuarioTransformation.class);	
	private JogoController jogoController = new JogoController(svc, transformation);

	
	@Test
	public void iniciar_jogo_deve_retornar_usuario_informado_com_atributos_populados() {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")
												.build();
		Usuario usuario = Usuario.builder()
							._id(ObjectId.get())
							.email("usuarioTeste@teste.com")
							.senha("123")
							.build();
		when(transformation.convert(usuarioCanonical)).thenReturn(usuario);
		//exec
		UsuarioCanonical resultado = this.jogoController.iniciarJogo(usuarioCanonical);
	}
}
