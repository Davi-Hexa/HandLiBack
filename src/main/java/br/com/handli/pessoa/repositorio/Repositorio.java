package br.com.handli.pessoa.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.CadastroAlu;

@Repository
public interface Repositorio extends CrudRepository<CadastroAlu, Integer> {

    
}
