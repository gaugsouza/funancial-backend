package com.projeto.funancial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.funancial.model.Historia;
import com.projeto.funancial.model.Opcao;

public interface HistoriaRepository extends MongoRepository<Historia, String>{
	Historia getHistoriaBySequenciaAndNivel(Integer sequencia, Integer nivel);
}