package br.com.handli.pessoa.services.dto;

import br.com.handli.pessoa.enumerate.Enumerate;
import lombok.Data;

@Data
public class PostUserDto {
    private String password;
    private Enumerate tipo;
}
