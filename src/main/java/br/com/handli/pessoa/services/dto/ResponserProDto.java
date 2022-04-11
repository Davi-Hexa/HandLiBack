package br.com.handli.pessoa.services.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponserProDto {
    private Integer id;
    private String nome;
    private Date nasc;
    private String cpf;
    private String email;
    private Integer usuario_id;
}
