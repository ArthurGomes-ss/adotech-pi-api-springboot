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


public class PetController {

        private final PetService petService;
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<PetEntity> findAll() {
            return petService.findAll();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public PetEntity createPet(@RequestBody PetDto petDto) {
            return petService.createUsuario(petDto);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public PetEntity updateUsuario(@PathVariable Integer id, @RequestBody PetDto petDto) throws NotFoundException {
            return petService.atualizarPet(petDto, id);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deletePet(@PathVariable Integer id) {
            petService.removerUsuario(id);
        }
}
