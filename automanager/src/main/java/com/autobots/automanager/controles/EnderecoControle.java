package com.autobots.automanager.controles;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.modelo.EnderecoSelecionador;
import com.autobots.automanager.repositorios.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {
    @Autowired
    private EnderecoRepositorio repositorio;
    @Autowired
    private EnderecoSelecionador selecionador;

    @GetMapping("/endereco/{id}")
    public Endereco obterEndereco(@PathVariable long id) {
        List<Endereco> enderecos = repositorio.findAll();
        return selecionador.selecionar(enderecos, id);
    }

    @GetMapping("/enderecos")
    public List<Endereco> obterEnderecos() {
        List<Endereco> enderecos = repositorio.findAll();
        return enderecos;
    }

    @PostMapping("/cadastro")
    public void cadastrarEndereco(@RequestBody Endereco endereco) {
        repositorio.save(endereco);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizarEndereco(@PathVariable Long id, @RequestBody Endereco atualizacao) {
        List<Endereco> enderecos = repositorio.findAll();
        Endereco endereco = selecionador.selecionar(enderecos, id);
        EnderecoAtualizador atualizador = new EnderecoAtualizador();
        if (endereco != null) {
            atualizador.atualizar(endereco, atualizacao);
            repositorio.save(endereco);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirEndereco(@PathVariable Long id) {
        Endereco endereco = repositorio.getById(id);
        repositorio.delete(endereco);
    }
}




