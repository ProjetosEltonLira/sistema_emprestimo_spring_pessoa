package br.com.portifolioLira.sistema_financiamento_spring.services;

import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.request.EntryPointPessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaDTO;
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

    public List<Pessoa> findAll(){
        return repository.findAll();
    }
    public ResponsePessoaDTO insert(EntryPointPessoaDTO entryPointPessoaDTO){

        Pessoa pessoa = instanciarPessoa(entryPointPessoaDTO);
        repository.save(pessoa);
        return instanciarResponsePessoaDTO(pessoa);
    }

    private static Pessoa instanciarPessoa(EntryPointPessoaDTO entryPointPessoaDTO) {

        if(entryPointPessoaDTO.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA.toString())) {
            return new Pessoa(null, entryPointPessoaDTO.getCpf(), entryPointPessoaDTO.getNome(), entryPointPessoaDTO.getTelefone(), entryPointPessoaDTO.getTituloEleitor());
        }
        else if (entryPointPessoaDTO.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA_APOSENTADA.toString())){
            return new Pessoa(null, entryPointPessoaDTO.getCpf(), entryPointPessoaDTO.getNome(), entryPointPessoaDTO.getTelefone(), entryPointPessoaDTO.getTituloEleitor(), entryPointPessoaDTO.getDataAposentadoria());

        } else if (entryPointPessoaDTO.getTipoPessoa().equals(TipoPessoa.PESSOA_JURIDICA.toString())){
            return new Pessoa(null, entryPointPessoaDTO.getCnpj(), entryPointPessoaDTO.getNome(), entryPointPessoaDTO.getTelefone(), entryPointPessoaDTO.getInscricaoMunicipal(), TipoPessoa.valueOf("PESSOA_JURIDICA"));
        }
        return null;
    }

    private static ResponsePessoaDTO instanciarResponsePessoaDTO(Pessoa pessoa) {

        if(pessoa.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA)) {
            return new ResponsePessoaDTO(pessoa.getId(), pessoa.getCpf(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getTituloEleitor());
        }
        else if (pessoa.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA_APOSENTADA)){
            return new ResponsePessoaDTO(pessoa.getId(), pessoa.getCpf(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getTituloEleitor(), pessoa.getDataAposentadoria());

        } else if (pessoa.getTipoPessoa().equals(TipoPessoa.PESSOA_JURIDICA)){
            return new ResponsePessoaDTO(pessoa.getId(), pessoa.getCnpj(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getInscricaoMunicipal(), TipoPessoa.valueOf("PESSOA_JURIDICA"));
        }
        return null;
    }




}
