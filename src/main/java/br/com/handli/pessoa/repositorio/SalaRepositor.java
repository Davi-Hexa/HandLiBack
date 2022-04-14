package br.com.handli.pessoa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.Sala;

@Repository
public interface SalaRepositor extends JpaRepository<Sala, Integer>{
    
}
