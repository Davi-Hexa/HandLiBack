package br.com.handli.pessoa.services.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProDto {
    private Integer id_pro;
    private String nome_pro;
    private Date nasc_pro;
    private Integer cpf;
    private String email_pro;
    private Integer usuario_id;
}
