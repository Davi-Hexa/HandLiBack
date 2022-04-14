package br.com.handli.pessoa.services.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProfessorSalasDto {
    private Integer id;
    private Integer id_professoresSalas;
    private Integer proUsuarios;   
}
