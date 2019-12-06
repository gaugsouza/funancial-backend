package com.projeto.funancial.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

import com.projeto.funancial.model.Status;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.repository.UsuarioRepository;

public class StatusServiceTest {
	private UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
	private StatusService service = new StatusService(repository);

	@Test
	public void deve_retornar_usuario_com_dinheiro_atualizado() {
		// config
		Usuario usuario = new Usuario();
		usuario.setStatus(new Status());
		BigDecimal dinheiroEsperado = usuario.getDinheiro().add(BigDecimal.valueOf(10d));

		when(repository.save(usuario)).thenReturn(usuario);

		// exec
		Usuario usuarioTest = service.alterarDinheiroUsuario(usuario, 10d);
		// check
		assertEquals(dinheiroEsperado, usuarioTest.getDinheiro());
	}

	@Test
	public void deve_retornar_usuario_com_experiencia_atualizada() {
		// Config
		Usuario usuario = new Usuario();
		usuario.setStatus(new Status());
		Double experienciaEsperada = usuario.getExperiencia() + 10;
		
		when(repository.save(usuario)).thenReturn(usuario);
		// exec
		Usuario usuarioTest = service.aumentarExperienciaUsuario(usuario, 10d);
		
		// check
		assertEquals(experienciaEsperada, usuarioTest.getExperiencia());
	}
	
	@Test
	public void deve_retornar_usuario_com_nivel_aumentado() {
		// config
		Usuario usuario = new Usuario();
		usuario.setStatus(new Status());
		Integer nivelEsperado = usuario.getNivel() + 1;
		
		when(repository.save(usuario)).thenReturn(usuario);
		// exec
		Usuario usuarioTest = service.aumentarExperienciaUsuario(usuario, 102d);
		// check
		assertEquals(nivelEsperado, usuarioTest.getNivel());
	}
	
	@Test
	public void deve_retornar_usuario_com_experiencia_resetada() {
		// config
		Usuario usuario = new Usuario();
		Status status = new Status();
		status.setExperiencia(1d);
		usuario.setStatus(status);
		
		Double experienciaEsperada = usuario.getExperiencia();
		when(repository.save(usuario)).thenReturn(usuario);
		// exec
		Usuario usuarioTest = service.aumentarExperienciaUsuario(usuario, 100d);
		
		// check
		assertEquals(experienciaEsperada, usuarioTest.getExperiencia());
	}
	
	@Test
	public void deve_retornar_usuario_com_dinheiro_menor_do_que_inicial() {
		// config
		Usuario usuario = new Usuario();
		usuario.setStatus(new Status());
		BigDecimal dinheiroInicial = usuario.getDinheiro();
		when(repository.save(usuario)).thenReturn(usuario);
		// exec
		Usuario usuarioTest = service.alterarDinheiroUsuario(usuario, -20d);
		Boolean isDinheiroMenorDoQueInicial = dinheiroInicial.doubleValue() > usuarioTest.getDinheiro().doubleValue();
		// check
		assertTrue(isDinheiroMenorDoQueInicial);
	}
}
