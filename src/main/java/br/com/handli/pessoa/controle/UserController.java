package br.com.handli.pessoa.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.services.UsuarioService;
import br.com.handli.pessoa.services.dto.PostUserDto;
import br.com.handli.pessoa.services.dto.ResponserUserDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsuarioService usuarioService;

    @GetMapping("/v1/usuarios")
    public ResponseEntity<?> getUser(@PathVariable(name="id") Integer id, @PathVariable(name = "password") String pass){
        ResponserUserDto response = this.usuarioService.getUser(id);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/v1/usuarios")
    public ResponseEntity<?> createUser(@RequestBody PostUserDto dto){
        ResponserUserDto response = this.usuarioService.createUser(dto);
        return ResponseEntity.ok().body(response);
    }
}
