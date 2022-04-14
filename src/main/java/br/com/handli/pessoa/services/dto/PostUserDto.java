package br.com.handli.pessoa.services.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.handli.pessoa.config.EnumerateCadastro;
import lombok.Data;

@Data
public class PostUserDto {
    @NotBlank(message="Nome Obrigatorio!")
    private String nome;

    @CPF(message = "CPF invalido!")
    private String cpf;

    
    private LocalDate nasc;

    @Email
    @NotBlank(message = "Email obrigatório!")
    private String email;

    @NotBlank(message = "Insira uma senha!")
    private String password;

    private EnumerateCadastro tipo;
}
// 12/03
// O que eu fiz ontem nestá pagina:
// ontem foi criado está pagina para funcionar a inserção de valores para a criação de dados no banco chamado handli.
// a criação desta página é essencial para o funcionamento do código completo, o post e o responser funcionam como um só retornando para o banco, post para receber e encaminhar para o ResponserUserDto.

// está classe não vai o ID pq ele é um valor AUTO_INCREMENT.