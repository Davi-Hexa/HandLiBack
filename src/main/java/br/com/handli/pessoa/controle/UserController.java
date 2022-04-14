package br.com.handli.pessoa.controle;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.services.UsuarioService;
import br.com.handli.pessoa.services.dto.PostUserDto;
import br.com.handli.pessoa.services.dto.ResponseUserDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsuarioService usuarioService;

    @RequestMapping("/v1/alunos")
    public ResponseEntity<?> getUser(String aluno){
        ResponseUserDto response = this.usuarioService.getAluno(aluno);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/v1/usuarios")
    public ResponseEntity<?> createUser(@RequestBody @Valid PostUserDto dto){
        ResponseUserDto response = this.usuarioService.createUser(dto);
        return ResponseEntity.ok().body(response);
    }
}
