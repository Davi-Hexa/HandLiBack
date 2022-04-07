package br.com.handli.pessoa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id_usu;

    @OneToOne
    @JoinColumn(unique = true)
    private CadastroPro id_pro;

    @OneToOne
    @JoinColumn(unique = true)
    private CadastroAlu id_alu;

    @Column(nullable = true)
    private String password;

    public int getId_usu() {
        return id_usu;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }


}
