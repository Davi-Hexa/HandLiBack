package br.com.handli.pessoa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.handli.pessoa.config.MailConfig;
import br.com.handli.pessoa.errormessage.ErrorMessageEditable;
import br.com.handli.pessoa.modelo.AlunoSala;
import br.com.handli.pessoa.modelo.ProfessoresSalas;
import br.com.handli.pessoa.modelo.Sala;
import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.AlunoSalaRepositor;
import br.com.handli.pessoa.repositorio.ProfessorSalaRepositor;
import br.com.handli.pessoa.repositorio.SalaRepositor;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import br.com.handli.pessoa.services.dto.PostAlunoSalaDto;
import br.com.handli.pessoa.services.dto.PostProfessorSalasDto;
import br.com.handli.pessoa.services.dto.PostSalasDto;
import br.com.handli.pessoa.services.dto.ResponseAluSearchDto;
import br.com.handli.pessoa.services.dto.ResponseProfAluSalaDto;
import br.com.handli.pessoa.services.dto.ResponseSalaAluDto;
import br.com.handli.pessoa.services.dto.ResponseSalaDto;
import br.com.handli.pessoa.services.dto.ResponseUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalasService {
    private final SalaRepositor salasRepositor;
    private final UsuarioRepositor usuarioRepositor;
    private final AlunoSalaRepositor alunoSalaRepositor;
    private final ProfessorSalaRepositor professorSalaRepositor;

    public ResponseProfAluSalaDto getAluno(Integer idPro, Integer idSala){
        Usuarios professor = this.usuarioRepositor.findById(idPro).orElseThrow(() -> new ErrorMessageEditable("Usuario não encontrado!"));
        ProfessoresSalas professorSala = this.professorSalaRepositor.findByProfessorRoomId(professor.getId_usuarios(), idSala).orElseThrow(() -> new ErrorMessageEditable("Professor não está nesta sala!"));
        
        ResponseUserDto responseUserDto = new ResponseUserDto(professor);
        ResponseProfAluSalaDto response= new ResponseProfAluSalaDto();
        ResponseSalaAluDto responseSalaAluDto = new ResponseSalaAluDto();
        
        responseSalaAluDto.setSala(professorSala.getSala().getNome());

        List<AlunoSala> alunos = this.alunoSalaRepositor.findByALuRoomId(idSala);
        List<ResponseAluSearchDto> alunosResponse = alunos.stream().map((alunoSala) -> {
            ResponseAluSearchDto aluno = new ResponseAluSearchDto(alunoSala.getUsuarioAluno());
            return aluno;
        }).collect(Collectors.toList());
        responseSalaAluDto.setAlunos(alunosResponse);
        response.setProfessor(responseUserDto);
        response.setSala(responseSalaAluDto);

        return response;
    }

    public ResponseSalaDto createSala(PostSalasDto dto){
        Sala salas = new Sala();
        
        salas.setNome(dto.getNome());
        this.salasRepositor.save(salas);

        ResponseSalaDto response = new ResponseSalaDto(salas);
        return response;
    }

    public void associateAlu(Integer salaId, PostAlunoSalaDto dto){
        Sala sala = this.salasRepositor.getById(salaId);

        for(Integer AlunoId:dto.getId_alunos()){
            Usuarios aluno = this.usuarioRepositor.findById(AlunoId).orElseThrow(RuntimeException::new);

            AlunoSala alunoSala = new AlunoSala();
            alunoSala.setUsuarioAluno(aluno);
            alunoSala.setSala(sala);
            this.alunoSalaRepositor.save(alunoSala);
        }
    }

    public void associatePro(Integer salaId, PostProfessorSalasDto dto){
        Sala sala = this.salasRepositor.getById(salaId);

        for(Integer ProfessorId:dto.getId_professoresSalas()){
            Usuarios professor = this.usuarioRepositor.findById(ProfessorId).orElseThrow(RuntimeException::new);

            ProfessoresSalas professoresSalas = new ProfessoresSalas();
            professoresSalas.setUsuarioPro(professor);
            professoresSalas.setSala(sala);
            this.professorSalaRepositor.save(professoresSalas);
        }
    }

    // public MailConfig forgotPassword(Usuarios usuarios){
    //     Usuarios response = this.usuarioRepositor.forgotPassword(usuarios.getEmail().toString());
    //     MailConfig mailConfig = new MailConfig();

    //     mailConfig.enviarEmail(response);
    //     return mailConfig;
    // }
}
