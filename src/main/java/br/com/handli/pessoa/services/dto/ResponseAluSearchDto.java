package br.com.handli.pessoa.services.dto;

import java.time.LocalDate;

import br.com.handli.pessoa.modelo.Usuarios;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseAluSearchDto {
    private String nome;
    private LocalDate nasc;
    private String email;


    public ResponseAluSearchDto(Usuarios usuarios){
        this.setNasc(usuarios.getNasc());
        this.setNome(usuarios.getNome());
        this.setEmail(usuarios.getEmail().toLowerCase().strip());
    }
}
