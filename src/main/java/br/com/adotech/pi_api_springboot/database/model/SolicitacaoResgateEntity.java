package br.com.adotech.pi_api_springboot.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class SolicitacaoResgateEntity {
    private Integer id;
    private Integer solicitanteId;
    private String nivelUrgencia; // ex.: ALTO, MEDIO, BAIXO
    private String pontoReferencia;
    private String descricao;
    private String status;
}
