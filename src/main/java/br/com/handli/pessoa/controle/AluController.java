package br.com.handli.pessoa.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.services.AlunoService;
import br.com.handli.pessoa.services.dto.PostAluDto;
import br.com.handli.pessoa.services.dto.ResponseAluDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AluController {
    private final AlunoService alunoService;

    @PostMapping("/v1/alunos")
    public ResponseEntity<?> createUser(@RequestBody PostAluDto dto){
        ResponseAluDto response = this.alunoService.createUser(dto);
        return ResponseEntity.ok(response);
    }

}
