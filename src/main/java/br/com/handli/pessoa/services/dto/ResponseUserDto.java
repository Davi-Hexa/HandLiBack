package br.com.handli.pessoa.services.dto;

import java.util.Date;

import br.com.handli.pessoa.config.Enumerate;
import br.com.handli.pessoa.modelo.Usuarios;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseUserDto {
    private Integer id;
    private String nome;
    private String cpf;
    private Date nasc;
    private String email;
    private String password;
    private Enumerate tipo;

    public ResponseUserDto(Usuarios usuarios){
        this.setId(usuarios.getId());
        this.setPassword(usuarios.getPassword());
        this.setTipo(usuarios.getTipo());
        this.setNasc(usuarios.getNasc());
        this.setNome(usuarios.getNome());
        this.setCpf(usuarios.getCpf());
        this.setEmail(usuarios.getEmail());
    }
}

