package tech.devinhouse.pets.controller;

import org.springframework.web.bind.annotation.*;
import tech.devinhouse.pets.model.PetModel;
import tech.devinhouse.pets.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public PetModel cadastrarPet(@RequestBody PetModel petModel) {
        return petService.cadastrarPet(petModel);
    }

    @GetMapping
    public List<PetModel> encontrarTodosOsPets() {
        return petService.encontrarTodosOsPets();
    }

    @PutMapping("/adocao/{idUsuario}")
    public PetModel adotarPet(@PathVariable ("idUsuario") Long idUsuario, @RequestParam("idPet") Long idPet) {
        return petService.adotarPet(idUsuario, idPet);
    }
}
