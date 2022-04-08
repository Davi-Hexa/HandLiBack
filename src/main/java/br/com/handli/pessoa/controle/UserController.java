package br.com.handli.pessoa.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.services.UsuarioService;
import br.com.handli.pessoa.services.dto.ResponserUserDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getUser(@PathVariable(name="id") Integer id){
        ResponserUserDto response = this.usuarioService.getUser(id);
        return ResponseEntity.ok().body(response);
    }
}
