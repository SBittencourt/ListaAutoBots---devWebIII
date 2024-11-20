package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.modelo.DocumentoSelecionador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {
    @Autowired
    private DocumentoRepositorio repositorio;
    @Autowired
    private DocumentoSelecionador selecionador;

    @GetMapping("/documento/{id}")
    public Documento obterDocumento(@PathVariable long id) {
        List<Documento> documentos = repositorio.findAll();
        return selecionador.selecionar(documentos, id);
    }

    @GetMapping("/documentos")
    public List<Documento> obterDocumentos() {
        List<Documento> documentos = repositorio.findAll();
        return documentos;
    }

    @PostMapping("/cadastro")
    public void cadastrarDocumento(@RequestBody Documento documento) {
        repositorio.save(documento);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizarDocumento(@PathVariable Long id, @RequestBody Documento atualizacao) {
        Documento documento = repositorio.getById(id);
        DocumentoAtualizador atualizador = new DocumentoAtualizador();
        atualizador.atualizar(documento, atualizacao);
        repositorio.save(documento);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirDocumento(@PathVariable Long id) {
        Documento documento = repositorio.getById(id);
        repositorio.delete(documento);
    }
}