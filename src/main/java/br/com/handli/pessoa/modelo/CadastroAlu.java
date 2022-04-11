package br.com.handli.pessoa.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cadastro_alu")
public class CadastroAlu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    private String nome;

    @Column(unique = true)
    private String cpf;

    private Date nasc;

    private String email;

    @OneToOne
    @JoinColumn(name="usuarioId")
    private Usuarios usuario;
}
