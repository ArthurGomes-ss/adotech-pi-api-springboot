package br.com.adotech.pi_api_springboot.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class UsuarioEntity {

    private Integer id;
    private String nome;
    private String cpf;
    private String endereco;
    private String tipo; // CIDADÃO ou ADMIN
    private String email;
    private String senha;

}
