package br.com.portifolioLira.sistema_financiamento_spring.config;

import br.com.portifolioLira.sistema_financiamento_spring.model.entities.Pessoa;
import br.com.portifolioLira.sistema_financiamento_spring.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Random;


@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {

        /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Random random = new Random();
        Long idAleatório = random.nextLong(9999999999L);


        Pessoa pessoa = new Pessoa(idAleatório,"testeSpring","11154999988","45465454","1231231", formato.parse("23/11/2015"),"testePessoa");
        pessoaRepository.save(pessoa);*/

    }
}
