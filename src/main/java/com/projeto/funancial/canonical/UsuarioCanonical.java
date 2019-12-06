package com.projeto.funancial.canonical;

import org.bson.types.ObjectId;

import com.projeto.funancial.model.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe <code>UsuarioCanonical</code> � a intermedi�ria entre o objeto Usuario e os 
 * servi�os que consomem suas APIs.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioCanonical {
	private ObjectId _id;
	private String jwt;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	@Builder.Default
	private Status status = new Status();
}