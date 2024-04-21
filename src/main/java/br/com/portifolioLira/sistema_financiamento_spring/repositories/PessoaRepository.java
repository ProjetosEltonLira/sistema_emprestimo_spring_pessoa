package br.com.portifolioLira.sistema_financiamento_spring.repositories;

import br.com.portifolioLira.sistema_financiamento_spring.model.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa,Long> {
}
