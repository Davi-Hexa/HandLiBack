package br.com.handli.pessoa.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.ProfessoresSalas;

@Repository //TODO REPOSITÓRIO SAO INTERFACES!!
public interface ProfessorSalaRepositor extends JpaRepository<ProfessoresSalas, Integer> {

    @Query("select ps from ProfessoresSalas ps join fetch ps.usuarioPro p join fetch ps.sala s where p.id = :proId and s.id = :idSala" )
    Optional<ProfessoresSalas> findByProfessorRoomId(Integer proId, Integer idSala);
    
}
