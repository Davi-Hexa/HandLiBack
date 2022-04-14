package br.com.handli.pessoa.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.handli.pessoa.modelo.Usuarios;
import br.com.handli.pessoa.repositorio.UsuarioRepositor;
import br.com.handli.pessoa.services.dto.PostLoginDto;
import br.com.handli.pessoa.services.dto.PostUserDto;
import br.com.handli.pessoa.services.dto.ResponseUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //declarar como final as classes
public class UsuarioService {
    private final UsuarioRepositor usuarioRepositor;
	private final PasswordEncoder passwordEncoder;

    public ResponseUserDto getAluno(String aluno){
        Usuarios n1 = this.usuarioRepositor.findAluno(aluno); 
        ResponseUserDto response = new ResponseUserDto(n1);
        return response;
    }

    public ResponseUserDto createUser(PostUserDto dto) {
        Usuarios usuarios = new Usuarios();

        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        usuarios.setPassword(encodedPassword);
        usuarios.setTipo(dto.getTipo());
        usuarios.setCpf(dto.getCpf());
        usuarios.setEmail(dto.getEmail().toLowerCase().strip());
        usuarios.setNasc(dto.getNasc());
        usuarios.setCpf(dto.getCpf());
        usuarios.setNome(dto.getNome());

        this.usuarioRepositor.save(usuarios);   //SALVAR OS DADOS DO NOVO USUARIO NO DB

        ResponseUserDto response = new ResponseUserDto(usuarios); //ESTA PARTE SERVE PARA RECEBER OS VALORES DE USUARIOS QUE JÁ ENCAMINHOU PARA O RESPONSER
        return response;
    }
    public ResponseUserDto login(PostLoginDto login){
        Usuarios usuarios = this.usuarioRepositor.findByEmail(login.getEmail()); //O comando findByEmail está sendo referenciado no UsuarioRepositor, este comando pega o valor "select u from Usuarios u where u.email = :email" e ve se o valor do usuario é igual a do valor recebido
        boolean passwordMatch = passwordEncoder.matches(login.getPassword(), usuarios.getPassword());

        if(passwordMatch){
            ResponseUserDto responserUserDto = new ResponseUserDto(usuarios); //verificação da senha se elas batem se sim o login é realizado com sucesso.
            return responserUserDto;
        }
        throw new RuntimeException("Usuario ou senha invalida!");
    }
}

// 12/03
// Ontem foi criado os comandos de inserção de dados no banco handli, foi utilizado o comando setCpf, setName etc...
// Os comandos set servem para a inserção de dados, onde pegam o valor passado para o Dto e armazenam em CadastroAlu, o response abaixo serve para pegar o ID e o resto que falta para o Dto

// 13/03
// Ontem foi criado os comandos de segurança no banco de dados, onde ele criptografava a senha e mandava para o usuario o dado repassado para ele e criptografava a senha e repassava para o resultado correto.
