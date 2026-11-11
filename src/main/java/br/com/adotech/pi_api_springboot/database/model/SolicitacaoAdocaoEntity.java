package br.com.adotech.pi_api_springboot.database.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class SolicitacaoAdocaoEntity {
    private Integer id;
    private Integer usuarioId;
    private Integer petId;
    private String status; // ex.: FORMULARIO_ENVIADO, EM_ANALISE, APROVADO, RECUSADO
    private String observacoes;
}
