package com.autobots.automanager.modelo;

import com.autobots.automanager.entidades.Documento;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DocumentoSelecionador {
	public Documento selecionar(List<Documento> documentos, long id) {
		for (Documento doc : documentos) {
			if (doc.getId() == id) {
				return doc;
			}
		}
		return null;
	}
}
