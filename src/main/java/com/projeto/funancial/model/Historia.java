package com.projeto.funancial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Historia {
	@Id 
	private ObjectId _id;
	private String historia;
	private Integer nivel;
	private Integer sequencia;
	private List<Opcao> opcao;
}
