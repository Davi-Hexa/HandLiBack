package br.com.handli.pessoa.services;

import org.springframework.stereotype.Service;

import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import br.com.handli.pessoa.services.dto.ResponserUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //declarar como final as classes
public class UsuarioService {
    private final UsuarioRepositor usuarioRepositor;
    public ResponserUserDto getUser(Integer id){
        Usuarios n1 = this.usuarioRepositor.findById(id).orElseThrow(RuntimeException::new);
        ResponserUserDto response = new ResponserUserDto();
        response.setId(n1.getId_usu());
        return response;
    }
}
