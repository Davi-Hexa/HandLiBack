package br.com.handli.pessoa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id_usu;
    
    @OneToOne(mappedBy = "usuario")
    private CadastroPro professor;

    @OneToOne(mappedBy = "usuario")
    private CadastroAlu aluno;

    @Column(nullable = true)
    private String password;
}
