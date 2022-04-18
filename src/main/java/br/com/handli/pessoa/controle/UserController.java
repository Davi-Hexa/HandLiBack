package br.com.handli.pessoa.controle;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.services.SalasService;
import br.com.handli.pessoa.services.UsuarioService;
import br.com.handli.pessoa.services.dto.PostUserDto;
import br.com.handli.pessoa.services.dto.ResponseUserDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsuarioService usuarioService;
    private final SalasService salasService;

    @PostMapping("/v1/usuarios")
    public ResponseEntity<?> createUser(@RequestBody @Valid PostUserDto dto){
        ResponseUserDto response = this.usuarioService.createUser(dto);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping("/v1/email")
    public ResponseEntity<?> forgotPass(@RequestParam(name = "nome") Usuarios nome){
        return null;
    }
}
