package br.com.handli.pessoa.services.dto;

import java.time.LocalDate;

import br.com.handli.pessoa.config.EnumerateCadastro;
import br.com.handli.pessoa.modelo.Usuarios;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseUserDto {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate nasc;
    private String email;
    private String password;
    private EnumerateCadastro tipo;

    public ResponseUserDto(Usuarios usuarios){
        this.setId(usuarios.getId_usuarios());
        this.setPassword(usuarios.getPassword());
        this.setTipo(usuarios.getTipo());
        this.setNasc(usuarios.getNasc());
        this.setNome(usuarios.getNome());
        this.setCpf(usuarios.getCpf());
        this.setEmail(usuarios.getEmail().toLowerCase().strip());
    }
}

