package br.com.handli.pessoa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.handli.pessoa.modelo.Usuarios;


@Repository
public interface UsuarioRepositor extends JpaRepository<Usuarios, Integer> {

    @Query("select u from Usuarios u where u.email = :email") //
    Usuarios findByEmail(String email);

    @Query("select u from Usuarios u where u.tipo = 'ALUNO' and u.nome = :aluno")
    Usuarios findAluno(String aluno);

}
