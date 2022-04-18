package br.com.handli.pessoa.services.dto;

import java.time.LocalDate;

import br.com.handli.pessoa.modelo.Usuarios;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseUserDto {
    private Integer id_usuarios;
    private String nome;
    private LocalDate nasc;
    private String email;
    private String cpf;
    private String password;

    public ResponseUserDto(Usuarios usuarios){
        this.setId_usuarios(usuarios.getId_usuarios());
        this.setCpf(usuarios.getCpf());
        this.setPassword(usuarios.getPassword());
        this.setNasc(usuarios.getNasc());
        this.setNome(usuarios.getNome());
        this.setEmail(usuarios.getEmail().toLowerCase().strip());
    
    }
}

