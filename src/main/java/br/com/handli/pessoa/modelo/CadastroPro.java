package br.com.handli.pessoa.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cadastro_pro")
public class CadastroPro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_pro;
    private String nome_pro;
    private Date nasc_pro;
    private int cpf;
    private String email_pro;

    public int getId_pro() {
        return id_pro;
    }
    public String getEmail_pro() {
        return email_pro;
    }
    public void setEmail_pro(String email_pro) {
        this.email_pro = email_pro;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public Date getNasc_pro() {
        return nasc_pro;
    }
    public void setNasc_pro(Date nasc_pro) {
        this.nasc_pro = nasc_pro;
    }
    public String getNome_pro() {
        return nome_pro;
    }
    public void setNome_pro(String nome_pro) {
        this.nome_pro = nome_pro;
    }
    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }


}
