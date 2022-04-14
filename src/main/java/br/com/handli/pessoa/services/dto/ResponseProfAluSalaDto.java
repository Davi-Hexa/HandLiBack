package br.com.handli.pessoa.services.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProfAluSalaDto {
    private ResponseUserDto professor;
    private ResponseSalaAluDto sala;
    
}
