package br.com.portifolioLira.sistema_financiamento_spring.controllers;


import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.request.EntryPointPessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaDTO;
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
    public ResponseEntity<List<ResponsePessoaDTO>> findAll(){
        List<ResponsePessoaDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (value = "/{id}")// Isso indica que permite receber um valor na URL
    public ResponseEntity<ResponsePessoaDTO> findById(@PathVariable Long id){
        ResponsePessoaDTO responsePessoaDTO = service.findById(id);
        return ResponseEntity.ok().body(responsePessoaDTO);
    }


    @PostMapping
    public ResponseEntity<ResponsePessoaDTO> insert(@RequestBody EntryPointPessoaDTO pessoaDTO){
        ResponsePessoaDTO responsePessoaDTO = service.insert(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responsePessoaDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(responsePessoaDTO);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<ResponsePessoaDTO> update(@PathVariable Long id,@RequestBody EntryPointPessoaDTO pessoaDTO){
        ResponsePessoaDTO responsePessoaDTO = service.update(id,pessoaDTO);
        return ResponseEntity.ok().body(responsePessoaDTO);
    }
}