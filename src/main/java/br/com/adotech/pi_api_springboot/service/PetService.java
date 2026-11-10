package br.com.adotech.pi_api_springboot.service;

import br.com.adotech.pi_api_springboot.database.model.PetEntity;
import br.com.adotech.pi_api_springboot.dto.PetDto;
import br.com.adotech.pi_api_springboot.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service

public class PetService {


        private static final List<PetEntity> PETS = new ArrayList<>();

        static {
            PETS.add(PetEntity.builder()
                    .id(1)
                    .nome("Thor")
                    .especie("CACHORRO")
                    .porte("GRANDE")
                    .idadeAproximada("2 anos")
                    .descricao("Vira-lata brincalhão e vacinado")
                    .fotoUrl("[suspicious link removed]")
                    .status("DISPONÍVEL")
                    .build());

            PETS.add(PetEntity.builder()
                    .id(2)
                    .nome("Mimi")
                    .especie("GATO")
                    .porte("PEQUENO")
                    .idadeAproximada("1 ano")
                    .descricao("Gatinha dócil e castrada")
                    .fotoUrl("[suspicious link removed]")
                    .status("DISPONÍVEL")
                    .build());
        }

        public List<PetEntity> findAll(){
            return new ArrayList<>(PETS);
        }

        public PetEntity createUsuario(PetDto petDto){
            Integer identificador = PETS.stream()
                    .mapToInt(PetEntity::getId)
                    .max()
                    .orElse(0) + 1;

            PetEntity novoPet = PetEntity.builder()
                    .id(identificador)
                    .nome(petDto.getNome())
                    .especie(petDto.getEspecie())
                    .porte(petDto.getPorte())
                    .idadeAproximada(petDto.getIdadeAproximada())
                    .descricao(petDto.getDescricao())
                    .fotoUrl(petDto.getFotoUrl())
                    .status(petDto.getStatus())
                    .build();

           PETS.add(novoPet);
            return novoPet;
        }

        public PetEntity atualizarPet(PetDto petDto, Integer id) throws NotFoundException {
            PetEntity petEncontrado = PETS.stream()
                    .filter(u -> u.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Usuário não encontrado com o ID: " + id));
            petEncontrado.setNome(petDto.getNome());
            petEncontrado.setEspecie(petDto.getEspecie());
            petEncontrado.setPorte(petDto.getPorte());
            petEncontrado.setIdadeAproximada(petDto.getIdadeAproximada());
            petEncontrado.setFotoUrl(petDto.getFotoUrl());
            petEncontrado.setStatus(petDto.getStatus());

            return petEncontrado;
        }

        public void removerUsuario(Integer id) {
            PETS.removeIf(u -> u.getId().equals(id));
        }

    }
