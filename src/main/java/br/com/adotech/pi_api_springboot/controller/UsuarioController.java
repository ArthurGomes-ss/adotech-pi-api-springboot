package br.com.adotech.pi_api_springboot.controller;

import br.com.adotech.pi_api_springboot.database.model.UsuarioEntity;
import br.com.adotech.pi_api_springboot.dto.UsuarioDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import br.com.adotech.pi_api_springboot.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntity createUsuario(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.createUsuario(usuarioDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioEntity updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) throws NotFoundException {
        return usuarioService.atualizarUsuario(usuarioDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.removerUsuario(id);
    }

}
