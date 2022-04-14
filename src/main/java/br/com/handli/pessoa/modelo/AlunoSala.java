package br.com.handli.pessoa.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="aluno_salas")
public class AlunoSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private int id_alunoSalas;

    @ManyToOne
    @JoinColumn(name="usuario_aluno", referencedColumnName = "id")
    private Usuarios usuarioAluno;

    @ManyToOne
    private Sala sala;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void preUpdate(){
        updatedAt = LocalDateTime.now();
    }

}
