package br.com.adotech.pi_api_springboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PetDto {

    private String nome;
    private String especie;
    private String porte;
    private String idadeAproximada;
    private String descricao;
    private String fotoUrl;
    private String status;
}
