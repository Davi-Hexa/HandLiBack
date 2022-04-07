package br.com.handli.pessoa.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastro_alu")
public class CadastroAlu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id_alu;
    private String nome_alu;

    @Column(unique = true)
    private int cpf_alu;

    private Date nasc_alu;

    private String email_alu;


    public int getid_alu() {
        return id_alu;
    }
    public String getEmail_alu() {
        return email_alu;
    }
    public void setEmail_alu(String email_alu) {
        this.email_alu = email_alu;
    }
    public Date getNasc_alu() {
        return nasc_alu;
    }
    public void setNasc_alu(Date nasc_alu) {
        this.nasc_alu = nasc_alu;
    }
    public int getcpf_alu() {
        return cpf_alu;
    }
    public void setcpf_alu(int cpf_alu) {
        this.cpf_alu = cpf_alu;
    }
    public String getNome_alu() {
        return nome_alu;
    }
    public void setNome_alu(String nome_alu) {
        this.nome_alu = nome_alu;
    }
    public void setid_alu(int id_alu) {
        this.id_alu = id_alu;
    }

}
