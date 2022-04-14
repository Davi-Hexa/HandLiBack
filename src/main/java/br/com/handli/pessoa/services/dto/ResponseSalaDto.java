package br.com.handli.pessoa.services.dto;

import br.com.handli.pessoa.modelo.Sala;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseSalaDto {
    private int id_salas;
    private String nome;

    public ResponseSalaDto(Sala sala){

        this.setId_salas(sala.getId());
        this.setNome(sala.getNome());

    }
}
