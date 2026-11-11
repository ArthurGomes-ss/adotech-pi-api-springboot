package br.com.adotech.pi_api_springboot.service;
import br.com.adotech.pi_api_springboot.database.model.SolicitacaoAdocaoEntity;
import br.com.adotech.pi_api_springboot.dto.SolicitacaoAdocaoDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service

public class SolicitacaoAdocaoService {
    private static final List<SolicitacaoAdocaoEntity> SOLICITACOES = new ArrayList<>();

    static {
        SOLICITACOES.add(SolicitacaoAdocaoEntity.builder()
                .id(1)
                .usuarioId(1)
                .petId(1)
                .status("EM_ANALISE")
                .observacoes("Adotante possui quintal grande e experiência com cães")
                .build());
    }

    public List<SolicitacaoAdocaoEntity> findAll() {
        return new ArrayList<>(SOLICITACOES);
    }

    public SolicitacaoAdocaoEntity createSolicitacao(SolicitacaoAdocaoDto dto) {
        Integer identificador = SOLICITACOES.stream()
                .mapToInt(SolicitacaoAdocaoEntity::getId)
                .max()
                .orElse(0) + 1;

        SolicitacaoAdocaoEntity novaSolicitacao = SolicitacaoAdocaoEntity.builder()
                .id(identificador)
                .usuarioId(dto.getUsuarioId())
                .petId(dto.getPetId())
                .status(dto.getStatus() != null ? dto.getStatus() : "FORMULARIO_ENVIADO")
                .observacoes(dto.getObservacoes())
                .build();

        SOLICITACOES.add(novaSolicitacao);
        return novaSolicitacao;
    }

    public SolicitacaoAdocaoEntity atualizarSolicitacao(SolicitacaoAdocaoDto dto, Integer id) throws NotFoundException {
        SolicitacaoAdocaoEntity solicitacaoEncontrada = SOLICITACOES.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Solicitação de adoção não encontrada com o ID: " + id));

        solicitacaoEncontrada.setUsuarioId(dto.getUsuarioId());
        solicitacaoEncontrada.setPetId(dto.getPetId());
        solicitacaoEncontrada.setStatus(dto.getStatus());
        solicitacaoEncontrada.setObservacoes(dto.getObservacoes());

        return solicitacaoEncontrada;
    }

    public void removerSolicitacao(Integer id) {
        SOLICITACOES.removeIf(s -> s.getId().equals(id));
    }
}
