package br.com.handli.pessoa.services.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostSalasDto {
    @NotBlank(message = "Nome Vazio!")
    private String nome;
}
