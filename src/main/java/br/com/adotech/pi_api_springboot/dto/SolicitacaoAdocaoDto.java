package br.com.adotech.pi_api_springboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SolicitacaoAdocaoDto {
    private Integer usuarioId;
    private Integer petId;
    private String status;
    private String observacoes;
}
