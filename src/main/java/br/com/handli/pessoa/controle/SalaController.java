package br.com.handli.pessoa.controle;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.services.SalasService;
import br.com.handli.pessoa.services.dto.PostAlunoSalaDto;
import br.com.handli.pessoa.services.dto.PostProfessorSalasDto;
import br.com.handli.pessoa.services.dto.PostSalasDto;
import br.com.handli.pessoa.services.dto.ResponseSalaDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SalaController {
    private final SalasService salasService;
    
    @PostMapping("/v1/salas")
    public ResponseEntity<?> createUser(@RequestBody @Valid PostSalasDto dto){
        ResponseSalaDto response = this.salasService.createSala(dto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/v1/salasalu/{id}")
    public ResponseEntity<?> createAluInRoom(@PathVariable(name = "id") Integer id, @RequestBody PostAlunoSalaDto dto){
        salasService.associateAlu(id, dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/salaspro/{id}")
    public ResponseEntity<?> createProInRoom(@PathVariable(name = "id") Integer id, @RequestBody PostProfessorSalasDto dto){
        salasService.associatePro(id, dto);
        return ResponseEntity.ok().build();
    }
}
