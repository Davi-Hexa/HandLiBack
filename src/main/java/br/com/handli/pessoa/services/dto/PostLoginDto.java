package br.com.handli.pessoa.services.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostLoginDto {
    private String email;
    private String password;
}
