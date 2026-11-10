package br.com.adotech.pi_api_springboot.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PetEntity {

    private Integer id;
    private String nome;
    private String especie; // ex.: cachorro, gato...
    private String porte; // ex.: pequeno, médio, grande
    private String idadeAproximada;
    private String descricao;
    private String fotoUrl;
    private String status; // ex.: disponível, em_processo, adotado

}
