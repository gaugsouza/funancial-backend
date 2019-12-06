package com.projeto.funancial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.projeto.funancial.model.Status;
import com.projeto.funancial.model.Usuario;

public class EstatisticaServiceTest {
	EstatisticasService service = new EstatisticasService();

	@Test
	public void deve_retornar_progresso_no_nivel_do_usuario() {
		// config
		Usuario usuario = new Usuario();
		Status status = new Status();
		status.setNivel(2);
		usuario.setStatus(status);
		Integer diferencaNivelEsperada = usuario.getNivel() - Status.NIVEL_INICIAL;
		// exec
		Integer estatisticaNivel = service.gerarEstatisticaNivel(usuario);
		// check
		assertEquals(diferencaNivelEsperada, estatisticaNivel);
	}

	@Test
	public void deve_retornar_progresso_no_dinheiro_do_usuario() {
		// config
		Usuario usuario = new Usuario();
		Status status = new Status();
		status.setDinheiro(BigDecimal.valueOf(30d));
		usuario.setStatus(status);
		Double diferencaEsperada = usuario.getDinheiro().doubleValue() - Status.DINHEIRO_INICIAL.doubleValue();
		// exec
		Double estatisticaDinheiro = service.gerarEstatisticaDinheiro(usuario);
		// check
		assertEquals(diferencaEsperada, estatisticaDinheiro);
	}

	@Test
	public void deve_retornar_zero_no_progresso_nivel_por_nao_ter_tido_nenhum_avanco() {
		// config
		Usuario usuario = new Usuario();
		usuario.setStatus(new Status());

		// exec
		Integer estatisticaNivel = service.gerarEstatisticaNivel(usuario);
		// check
		assertEquals(0, estatisticaNivel);
	}

	@Test
	public void deve_retornar_zero_no_dinheiro() {
		// config
		Usuario usuario = new Usuario();
		usuario.setStatus(new Status());

		// exec
		Double estatisticaDinheiro = service.gerarEstatisticaDinheiro(usuario);
		// check
		assertEquals(0d, estatisticaDinheiro);
	}

	@Test
	public void deve_retornar_valor_negativo() {
		// config
		Usuario usuario = new Usuario();
		Status status = new Status();
		status.setDinheiro(BigDecimal.valueOf(20d));
		usuario.setStatus(status);

		Double valorEsperado = 20 - Status.DINHEIRO_INICIAL.doubleValue();

		// exec
		Double estatisticaDinheiro = service.gerarEstatisticaDinheiro(usuario);
		// check
		assertEquals(valorEsperado, estatisticaDinheiro);
	}

}
