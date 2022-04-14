package br.com.handli.pessoa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.AlunoSala;

@Repository
public interface AlunoSalaRepositor extends JpaRepository<AlunoSala, Integer>{
    
    @Query("select a from AlunoSala a join fetch a.usuarioAluno join fetch a.sala s where s.id = :salaId")
    List<AlunoSala> findByALuRoomId(Integer salaId);
}
