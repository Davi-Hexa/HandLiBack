package br.com.handli.pessoa.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import br.com.handli.pessoa.services.dto.PostUserDto;
import br.com.handli.pessoa.services.dto.ResponseUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //declarar como final as classes
public class UsuarioService {
    private final UsuarioRepositor usuarioRepositor;
	private final PasswordEncoder passwordEncoder;

    public ResponseUserDto getUser(Integer id){
        Usuarios n1 = this.usuarioRepositor.findById(id).orElseThrow(RuntimeException::new); //para pegar apenas o ID do usuario enviado
        ResponseUserDto response = new ResponseUserDto(n1);
        return response;
    }

    public ResponseUserDto createUser(PostUserDto dto) {
        Usuarios usuarios = new Usuarios();

        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        usuarios.setPassword(encodedPassword);
        usuarios.setTipo(dto.getTipo());
        usuarios.setCpf(dto.getCpf());
        usuarios.setEmail(dto.getEmail());
        usuarios.setNasc(dto.getNasc());
        usuarios.setCpf(dto.getCpf());
        usuarios.setNome(dto.getNome());

        this.usuarioRepositor.save(usuarios);

        ResponseUserDto response = new ResponseUserDto(usuarios);
        return response;
    }
    public ResponseUserDto login(PostUserDto login){
        Usuarios usuario = this.usuarioRepositor.findByUsername(login.getNome());
        boolean passwordMatch = passwordEncoder.matches(login.getPassword(), usuario.getPassword());
        if(passwordMatch){
            ResponseUserDto responserUserDto = new ResponseUserDto(usuario);
            return responserUserDto;
        }
        throw new RuntimeException("Usuario ou senha invalida!");
    }
}

// 12/03
// Ontem foi criado os comandos de inserção de dados no banco handli, foi utilizado o comando setCpf, setName etc...
// Os comandos set servem para a inserção de dados, onde pegam o valor passado para o Dto e armazenam em CadastroAlu, o response abaixo serve para pegar o ID e o resto que falta para o Dto