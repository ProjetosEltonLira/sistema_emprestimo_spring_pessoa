package br.com.portifolioLira.sistema_financiamento_spring.services;

import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.request.EntryPointPessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaFisicaAposentadaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaFisicaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaJuridicaDTO;
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

    private static Pessoa instanciarPessoa(EntryPointPessoaDTO pessoaDTO) {

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

    private static ResponsePessoaDTO instanciarResponsePessoaDTO(Pessoa pessoa) {

        if(pessoa.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA)) {
            return new ResponsePessoaFisicaDTO(pessoa.getId(), pessoa.getNome(),pessoa.getTelefone(), pessoa.getTipoPessoa(), pessoa.getCpf(), pessoa.getTituloEleitor());
        }
        else if (pessoa.getTipoPessoa().equals(TipoPessoa.PESSOA_FISICA_APOSENTADA)){
            return new ResponsePessoaFisicaAposentadaDTO(pessoa.getId(),  pessoa.getNome(),pessoa.getTelefone(), pessoa.getTipoPessoa(),  pessoa.getCpf(), pessoa.getTituloEleitor(), pessoa.getDataAposentadoria());

        } else if (pessoa.getTipoPessoa().equals(TipoPessoa.PESSOA_JURIDICA)){
            return new ResponsePessoaJuridicaDTO(pessoa.getId(),  pessoa.getNome(),pessoa.getTelefone(), pessoa.getTipoPessoa(), pessoa.getCnpj(), pessoa.getInscricaoMunicipal());
        }
        return null;
    }

}
