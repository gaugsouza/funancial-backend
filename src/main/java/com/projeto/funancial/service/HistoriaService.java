package com.projeto.funancial.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.projeto.funancial.model.Historia;
import com.projeto.funancial.repository.HistoriaRepository;

@Service
public class HistoriaService {
    private HistoriaRepository historiaRepository;
	
    public HistoriaService(HistoriaRepository historiaRepository) {
    	this.historiaRepository = historiaRepository;
    }

    public getHistoriaBySequenciaAndNivel(Historia sequencia, Historia nivel) {
    	this.historiaRepository.getHistoriaBySequenciaAndNivel(sequencia, nivel);
    }
    
}