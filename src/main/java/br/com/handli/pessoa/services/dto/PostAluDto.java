package br.com.handli.pessoa.services.dto;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAluDto {
    private String nome;
    private String cpf;
    private Date nasc;
    private String email;
    private Integer usuarios_id; 
}
