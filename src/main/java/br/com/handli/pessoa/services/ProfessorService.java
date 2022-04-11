package br.com.handli.pessoa.services;

import org.springframework.stereotype.Service;

import br.com.handli.pessoa.modelo.CadastroPro;
import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.ProfessorRepositor;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import br.com.handli.pessoa.services.dto.PostProDto;
import br.com.handli.pessoa.services.dto.ResponserProDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class ProfessorService {
    private final ProfessorRepositor professorRepositor;
    private final UsuarioRepositor usuarioRepositor;


    public ResponserProDto getUser(Integer id){
        CadastroPro n1 = this.professorRepositor.findById(id).orElseThrow(RuntimeException::new);

        ResponserProDto response = new ResponserProDto();
        response.setId(n1.getId());
        return response;
    }
    public ResponserProDto createPro(PostProDto dto){
        Usuarios usuarios = this.usuarioRepositor.findById(dto.getUsuario_id()).orElseThrow(RuntimeException::new);

        CadastroPro professor = new CadastroPro();
        professor.setNome(dto.getNome());
        professor.setNasc(dto.getNasc());
        professor.setCpf(dto.getCpf());
        professor.setEmail(dto.getEmail());
        professor.setUsuario_id(usuarios);
        this.professorRepositor.save(professor);

        ResponserProDto response = new ResponserProDto();
        response.setId(professor.getId());
        response.setNome(professor.getNome());
        response.setNasc(professor.getNasc());
        response.setCpf(professor.getCpf());
        response.setEmail(professor.getEmail());
        response.setUsuario_id(professor.getUsuario_id().getId_usu());
        return response;
    }
}
