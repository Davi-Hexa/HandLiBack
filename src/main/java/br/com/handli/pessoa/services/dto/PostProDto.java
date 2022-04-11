package br.com.handli.pessoa.services.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostProDto {
    private String nome;
    private Date nasc;
    private String cpf;
    private String email;
    private long usuario_id;
}
