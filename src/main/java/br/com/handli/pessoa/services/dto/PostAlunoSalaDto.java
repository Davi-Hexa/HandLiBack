package br.com.handli.pessoa.services.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostAlunoSalaDto {
    private List<Integer> id_alunos;
}
