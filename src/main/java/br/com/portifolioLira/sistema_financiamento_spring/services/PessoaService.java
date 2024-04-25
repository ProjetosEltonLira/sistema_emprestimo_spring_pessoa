package br.com.portifolioLira.sistema_financiamento_spring.services;

import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.PessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.entities.Pessoa;
import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import br.com.portifolioLira.sistema_financiamento_spring.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa insert(PessoaDTO pessoaDTO){

        Pessoa pessoa = instanciarPessoa(pessoaDTO);
        return repository.save(pessoa);
    }

    private static Pessoa instanciarPessoa(PessoaDTO pessoaDTO) {

        if(pessoaDTO.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA.toString())) {
            return new Pessoa(null, pessoaDTO.getCpf(), pessoaDTO.getNome(), pessoaDTO.getTelefone(), pessoaDTO.getTituloEleitor());
        }
        else if (pessoaDTO.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA_APOSENTADA.toString())){
            return new Pessoa(null, pessoaDTO.getCpf(), pessoaDTO.getNome(), pessoaDTO.getTelefone(), pessoaDTO.getTituloEleitor(), pessoaDTO.getDataAposentadoria());

        } else if (pessoaDTO.getTipoPessoa().equals(TipoPessoa.PESSOA_JURIDICA.toString())){
            return new Pessoa(null, pessoaDTO.getCnpj(), pessoaDTO.getNome(), pessoaDTO.getTelefone(), pessoaDTO.getInscricaoMunicipal(), TipoPessoa.valueOf("PESSOA_JURIDICA"));
        }
        return null;
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }


}
