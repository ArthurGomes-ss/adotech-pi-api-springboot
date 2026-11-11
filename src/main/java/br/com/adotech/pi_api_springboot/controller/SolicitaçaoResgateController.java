
package br.com.adotech.pi_api_springboot.controller;
import br.com.adotech.pi_api_springboot.database.model.SolicitaçaoResgateEntity;
import br.com.adotech.pi_api_springboot.dto.SolicitaçaoResgateDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import br.com.adotech.pi_api_springboot.service.SolicitaçaoResgateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pets")
@RequiredArgsConstructor
public class SolicitaçaoResgateController {

    private final SolicitacaoResgateService solicitacaoResgateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SolicitacaoResgateEntity> findAll() {
        return solicitacaoResgateService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitacaoResgateEntity createResgate(@RequestBody SolicitacaoResgateDto dto) {
        return solicitacaoResgateService.createResgate(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SolicitacaoResgateEntity updateResgate(@PathVariable Integer id, @RequestBody SolicitacaoResgateDto dto) throws NotFoundException {
        return solicitacaoResgateService.atualizarResgate(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResgate(@PathVariable Integer id) {
        solicitacaoResgateService.removerResgate(id);
    }
}

