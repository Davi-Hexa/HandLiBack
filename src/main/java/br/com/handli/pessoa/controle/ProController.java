package br.com.handli.pessoa.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.services.ProfessorService;
import br.com.handli.pessoa.services.dto.PostProDto;
import br.com.handli.pessoa.services.dto.ResponserProDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProController {
    private final ProfessorService service;

    @PostMapping("/v1/professores")
    public ResponseEntity<?> createUser(@RequestBody PostProDto dto){

        ResponserProDto response = this.service.createPro(dto);
        return ResponseEntity.ok().body(response);
    }

}
