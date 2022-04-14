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
@Table(name="professores_salas")
public class ProfessoresSalas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private int id_professoresSalas;

    @JoinColumn(name = "usuario_professores")
    @ManyToOne
    private Usuarios usuarioPro;

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
