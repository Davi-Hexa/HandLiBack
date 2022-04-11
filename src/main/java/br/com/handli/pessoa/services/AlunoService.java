package br.com.handli.pessoa.services;

import org.springframework.stereotype.Service;

import br.com.handli.pessoa.modelo.CadastroAlu;
import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.AlunoRepositor;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import br.com.handli.pessoa.services.dto.PostAluDto;
import br.com.handli.pessoa.services.dto.ResponseAluDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepositor alunoRepositor;
    private final UsuarioRepositor usuarioRepositor;
    public ResponseAluDto getUser(Integer id){
        CadastroAlu n1 = this.alunoRepositor.findById(id).orElseThrow(RuntimeException::new);
    
        ResponseAluDto response = new ResponseAluDto();
        response.setId(n1.getId());
        return response;

    }
    public ResponseAluDto createUser(PostAluDto dto) {
        Usuarios usuarios = this.usuarioRepositor.findById(dto.getUsuarios_id()).orElseThrow(RuntimeException::new); //para pegar apenas o ID do usuario enviado

        CadastroAlu aluno = new CadastroAlu(); 
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setNasc(dto.getNasc());
        aluno.setEmail(dto.getEmail());
        aluno.setUsuario(usuarios);

        this.alunoRepositor.save(aluno);

        ResponseAluDto response = new ResponseAluDto();
        response.setId(aluno.getId());
        response.setNome(aluno.getNome());
        response.setCpf(aluno.getCpf());
        response.setNasc(aluno.getNasc());
        response.setEmail(aluno.getEmail());
        response.setUsuario_id(aluno.getUsuario().getId_usu());

        return response;
    }
}
