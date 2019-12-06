package com.projeto.funancial.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe <code>Status</code> é um POJO (Plain Old Java Object) para representar 
 * a os status do usuário no jogo.
 *
 * @author fcalebe@gmail.com
 * @version 1.0
 * @since JDK1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {
	public static final BigDecimal DINHEIRO_INICIAL = BigDecimal.valueOf(30);
	public static final Integer NIVEL_INICIAL = 1;
	public static final Double EXP_INICIAL = 0.0d;
	
	@Builder.Default
	private BigDecimal dinheiro = DINHEIRO_INICIAL;
	@Builder.Default
	private Integer nivel = NIVEL_INICIAL;
	@Builder.Default
	private Double experiencia = EXP_INICIAL;
	
}
