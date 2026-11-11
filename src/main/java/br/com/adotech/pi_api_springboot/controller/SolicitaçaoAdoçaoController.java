package br.com.adotech.pi_api_springboot.controller;
import br.com.adotech.pi_api_springboot.database.model.PetEntity;
import br.com.adotech.pi_api_springboot.dto.PetDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import br.com.adotech.pi_api_springboot.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pets")
@RequiredArgsConstructor
public class SolicitaçaoAdoçaoController {

        private final SolicitacaoAdocaoService solicitacaoAdocaoService;

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<SolicitacaoAdocaoEntity> findAll() {
            return solicitacaoAdocaoService.findAll();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public SolicitacaoAdocaoEntity createSolicitacao(@RequestBody SolicitacaoAdocaoDto dto) {
            return solicitacaoAdocaoService.createSolicitacao(dto);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public SolicitacaoAdocaoEntity updateSolicitacao(@PathVariable Integer id, @RequestBody SolicitacaoAdocaoDto dto) throws NotFoundException {
            return solicitacaoAdocaoService.atualizarSolicitacao(dto, id);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteSolicitacao(@PathVariable Integer id) {
            solicitacaoAdocaoService.removerSolicitacao(id);
        }
    }

