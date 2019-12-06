package com.projeto.funancial.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class StatusTest {
	@Test
	public void deve_retornar_usuario_com_nivel_inicial() {
		// config
		Usuario usuario = new Usuario();
		// exec
		usuario.setStatus(new Status());
		Integer nivel = usuario.getNivel();
		// check
		assertEquals(Status.NIVEL_INICIAL, nivel);
	}

	@Test
	public void deve_retornar_usuario_com_dinheiro_inicial() {
		// config
		Usuario usuario = new Usuario();
		// exec
		usuario.setStatus(new Status());
		BigDecimal dinheiro = usuario.getDinheiro();
		// check
		assertEquals(Status.DINHEIRO_INICIAL, dinheiro);
	}

	@Test
	public void deve_retornar_usuario_com_experiencia_inicial() {
		// config
		Usuario usuario = new Usuario();

		// exec
		usuario.setStatus(new Status());
		Double experiencia = usuario.getExperiencia();
		// check
		assertEquals(Status.EXP_INICIAL, experiencia);
	}
}
