package br.com.handli.pessoa.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.handli.pessoa.modelo.CadastroAlu;

@RestController
public class Controle {
    
    @GetMapping
    public String mensagem(){
        return "hello, world!";
    }

    @GetMapping("/n1/{nome}") //com pathVariable
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo " + nome;
    }

    @PostMapping("/pessoa")
    public CadastroAlu pessoa(@RequestBody CadastroAlu p){
        return p;
    }
}
