package br.com.handli.pessoa.errormessage;

import br.com.handli.pessoa.modelo.ProfessoresSalas;
import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.ProfessorSalaRepositor;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TesteError {
    private final ProfessorSalaRepositor professorSalaRepositor;
    private final UsuarioRepositor usuarioRepositor;

    public boolean TesteProfessor(Integer idPro, Integer idSala){
        Usuarios professor = this.usuarioRepositor.findById(idPro).orElseThrow(RuntimeException::new);
        ProfessoresSalas professorSala = this.professorSalaRepositor.findByProfessorRoomId(professor.getId_usuarios(), idSala).orElseThrow(RuntimeException::new);

        
        if (professor.getId_usuarios() != professorSala.getId_professoresSalas()){
            return false;
        }
        return true;
    }
}
