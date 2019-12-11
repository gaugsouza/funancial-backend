package com.projeto.funancial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {
	@Id 
	private ObjectId _id;
	private String nome;

}
