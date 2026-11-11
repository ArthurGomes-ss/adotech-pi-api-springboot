
package br.com.adotech.pi_api_springboot.service;
import br.com.adotech.pi_api_springboot.database.model.SolicitaçaoResgateEntity;
import br.com.adotech.pi_api_springboot.dto.SolicitaçaoResgateDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class SolicitaçaoResgateService {

    private static final List<SolicitacaoResgateEntity> RESGATES = new ArrayList<>();

    static {
        RESGATES.add(SolicitacaoResgateEntity.builder()
                .id(1)
                .solicitanteId(1)
                .nivelUrgencia("ALTO")
                .pontoReferencia("Próximo à praça central, em frente ao mercado")
                .descricao("Cão atropelado precisando de cuidados veterinários imediatos")
                .status("PENDENTE")
                .build());
    }

    public List<SolicitacaoResgateEntity> findAll() {
        return new ArrayList<>(RESGATES);
    }

    public SolicitacaoResgateEntity createResgate(SolicitacaoResgateDto dto) {
        Integer identificador = RESGATES.stream()
                .mapToInt(SolicitacaoResgateEntity::getId)
                .max()
                .orElse(0) + 1;

        SolicitacaoResgateEntity novoResgate = SolicitacaoResgateEntity.builder()
                .id(identificador)
                .solicitanteId(dto.getSolicitanteId())
                .nivelUrgencia(dto.getNivelUrgencia())
                .pontoReferencia(dto.getPontoReferencia())
                .descricao(dto.getDescricao())
                .status(dto.getStatus() != null ? dto.getStatus() : "PENDENTE")
                .build();

        RESGATES.add(novoResgate);
        return novoResgate;
    }

    public SolicitacaoResgateEntity atualizarResgate(SolicitacaoResgateDto dto, Integer id) throws NotFoundException {
        SolicitacaoResgateEntity resgateEncontrado = RESGATES.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Solicitação de resgate não encontrada com o ID: " + id));

        resgateEncontrado.setSolicitanteId(dto.getSolicitanteId());
        resgateEncontrado.setNivelUrgencia(dto.getNivelUrgencia());
        resgateEncontrado.setPontoReferencia(dto.getPontoReferencia());
        resgateEncontrado.setDescricao(dto.getDescricao());
        resgateEncontrado.setStatus(dto.getStatus());

        return resgateEncontrado;
    }

    public void removerResgate(Integer id) {
        RESGATES.removeIf(r -> r.getId().equals(id));
    }
}

