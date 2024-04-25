package br.com.portifolioLira.sistema_financiamento_spring.controllers;


import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.PessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.entities.Pessoa;
import br.com.portifolioLira.sistema_financiamento_spring.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Pessoa> insert(@RequestBody PessoaDTO pessoaDTO){
        Pessoa pessoa = service.insert(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }
}
