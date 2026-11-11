package br.com.adotech.pi_api_springboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SolicitacaoResgateDto {

        private Integer solicitanteId;
        private String nivelUrgencia;
        private String pontoReferencia;
        private String descricao;
        private String status;
}

