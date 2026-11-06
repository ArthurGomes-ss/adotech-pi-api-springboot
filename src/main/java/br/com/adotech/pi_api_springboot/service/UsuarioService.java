package br.com.adotech.pi_api_springboot.service;

import br.com.adotech.pi_api_springboot.database.model.UsuarioEntity;
import br.com.adotech.pi_api_springboot.dto.UsuarioDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service

public class UsuarioService {

    private static final List<UsuarioEntity> USUARIOS = new ArrayList<>();

    static {
        USUARIOS.add(UsuarioEntity.builder()
                        .id(1)
                        .nome("Arthur Gomes")
                        .cpf("123.456.789-00")
                        .endereco("Rua Principal, 789")
                        .tipo("CIDADAO")
                        .email("gomes.arthur99@gmail.com")
                        .senha("abc123")
                .build());

        USUARIOS.add(UsuarioEntity.builder()
                .id(2)
                .nome("Ermerson Rafael")
                .cpf("987.654.321-11")
                .endereco("Cajueiro, 345")
                .tipo("ADMIN")
                .email("admin@adotech.com")
                .senha("rafao987")
                .build());
    }

    public List<UsuarioEntity> findAll(){
        return new ArrayList<>(USUARIOS);
    }

    public UsuarioEntity createUsuario(UsuarioDto usuarioDto){
        Integer identificador = USUARIOS.stream()
                .mapToInt(UsuarioEntity::getId)
                .max()
                .orElse(0) + 1;

        UsuarioEntity novoUsuario = UsuarioEntity.builder()
                .id(identificador)
                .nome(usuarioDto.getNome())
                .cpf(usuarioDto.getCpf())
                .endereco(usuarioDto.getEndereco())
                .tipo(usuarioDto.getTipo())
                .email(usuarioDto.getEmail())
                .senha(usuarioDto.getSenha())
                .build();

        USUARIOS.add(novoUsuario);
        return novoUsuario;
    }

    public UsuarioEntity atualizarUsuario(UsuarioDto usuarioDto, Integer id) throws NotFoundException{
        UsuarioEntity usuarioEncontrado = USUARIOS.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado com o ID: " + id));
        usuarioEncontrado.setNome(usuarioDto.getNome());
        usuarioEncontrado.setCpf(usuarioDto.getCpf());
        usuarioEncontrado.setEndereco(usuarioDto.getEndereco());
        usuarioEncontrado.setTipo(usuarioDto.getTipo());
        usuarioEncontrado.setEmail(usuarioDto.getEmail());
        usuarioEncontrado.setSenha(usuarioDto.getSenha());

        return usuarioEncontrado;
    }

    public void removerUsuario(Integer id) {
        USUARIOS.removeIf(u -> u.getId().equals(id));
    }

}
