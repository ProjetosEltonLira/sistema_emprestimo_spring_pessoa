package br.com.portifolioLira.sistema_financiamento_spring.services;

import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.request.EntryPointPessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaFisicaAposentadaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaFisicaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.DTO.response.ResponsePessoaJuridicaDTO;
import br.com.portifolioLira.sistema_financiamento_spring.model.entities.Pessoa;
import br.com.portifolioLira.sistema_financiamento_spring.model.enums.TipoPessoa;
import br.com.portifolioLira.sistema_financiamento_spring.repositories.PessoaRepository;
import br.com.portifolioLira.sistema_financiamento_spring.services.exceptions.DataBaseException;
import br.com.portifolioLira.sistema_financiamento_spring.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<ResponsePessoaDTO> findAll(){
        List<Pessoa> listPessoa = repository.findAll();
        List<ResponsePessoaDTO> listRespPessaoDTO = new ArrayList<>();
        for (Pessoa pessoa: listPessoa) {
             listRespPessaoDTO.add(instanciarResponsePessoaDTO(pessoa));
        }
        return listRespPessaoDTO;
    }

    public ResponsePessoaDTO insert(EntryPointPessoaDTO entryPointPessoaDTO){
        Pessoa pessoa = instanciarPessoa(entryPointPessoaDTO);
        repository.save(pessoa);
        return instanciarResponsePessoaDTO(pessoa);
    }



    public ResponsePessoaDTO findById(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return instanciarResponsePessoaDTO(pessoa);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){ //Exceção da minha camada de serviços.
            throw new DataBaseException(e.getMessage());
        }
    }

    public ResponsePessoaDTO update(Long id, EntryPointPessoaDTO pessoaDTO) {
        try {
            Pessoa pessoa = repository.getReferenceById(id);
            atualizarDados(pessoaDTO, pessoa);
            repository.save(pessoa);
            return instanciarResponsePessoaDTO(pessoa);
        }
        catch (EntityNotFoundException e){ //Tratar os casos que o ID não exista
            throw new ResourceNotFoundException(id);
        }
    }

    public void atualizarDados(EntryPointPessoaDTO pessoaDTO, Pessoa pessoa) {
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setCnpj(pessoaDTO.getCnpj());
        pessoa.setInscricaoMunicipal(pessoaDTO.getInscricaoMunicipal());
        pessoa.setTituloEleitor(pessoaDTO.getTituloEleitor());
        pessoa.setDataAposentadoria(pessoaDTO.getDataAposentadoria());
        pessoa.setTipoPessoa(pessoaDTO.getTipoPessoa());
    }

    private static Pessoa instanciarPessoa(EntryPointPessoaDTO pessoaDTO) {

        return switch (TipoPessoa.valueOf(pessoaDTO.getTipoPessoa().getCodigo())) {
            case PESSOA_FISICA ->
                    new Pessoa(pessoaDTO.getCpf(), pessoaDTO.getNome(), pessoaDTO.getTelefone(), pessoaDTO.getTituloEleitor());
            case PESSOA_FISICA_APOSENTADA ->
                    new Pessoa(pessoaDTO.getCpf(), pessoaDTO.getNome(), pessoaDTO.getTelefone(), pessoaDTO.getTituloEleitor(), pessoaDTO.getDataAposentadoria());
            case PESSOA_JURIDICA ->
                    new Pessoa(pessoaDTO.getCnpj(), pessoaDTO.getNome(), pessoaDTO.getTelefone(), pessoaDTO.getInscricaoMunicipal(), TipoPessoa.valueOf("PESSOA_JURIDICA"));
        };
    }
    private static ResponsePessoaDTO instanciarResponsePessoaDTO(Pessoa pessoa) {

        return switch (pessoa.getTipoPessoa()) {
            case PESSOA_FISICA ->
                    new ResponsePessoaFisicaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getTipoPessoa(), pessoa.getCpf(), pessoa.getTituloEleitor());
            case PESSOA_FISICA_APOSENTADA ->
                    new ResponsePessoaFisicaAposentadaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getTipoPessoa(), pessoa.getCpf(), pessoa.getTituloEleitor(), pessoa.getDataAposentadoria());
            case PESSOA_JURIDICA ->
                    new ResponsePessoaJuridicaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getTipoPessoa(), pessoa.getCnpj(), pessoa.getInscricaoMunicipal());
        };
    }
}
