package br.com.handli.pessoa.services.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponserUserDto {
    private Integer id;
    private String password;
}
