package br.com.handli.pessoa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.AlunoSala;

@Repository
public interface AlunoSalaRepositor extends JpaRepository<AlunoSala, Integer>{
    
}
