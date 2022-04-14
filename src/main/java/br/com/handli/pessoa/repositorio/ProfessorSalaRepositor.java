package br.com.handli.pessoa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.ProfessoresSalas;

@Repository //TODO REPOSITÓRIO SAO INTERFACES!!
public interface ProfessorSalaRepositor extends JpaRepository<ProfessoresSalas, Integer> {
    
}
