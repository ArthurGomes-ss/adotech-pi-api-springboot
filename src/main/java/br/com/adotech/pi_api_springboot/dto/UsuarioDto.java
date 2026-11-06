package br.com.adotech.pi_api_springboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDto {

    private String nome;
    private String cpf;
    private String endereco;
    private String tipo;
    private String email;
    private String senha;

}
