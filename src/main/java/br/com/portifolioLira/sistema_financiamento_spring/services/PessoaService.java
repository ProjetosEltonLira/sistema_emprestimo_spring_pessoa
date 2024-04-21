package br.com.portifolioLira.sistema_financiamento_spring.services;

import br.com.portifolioLira.sistema_financiamento_spring.model.entities.Pessoa;
import br.com.portifolioLira.sistema_financiamento_spring.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa insert(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }


}
