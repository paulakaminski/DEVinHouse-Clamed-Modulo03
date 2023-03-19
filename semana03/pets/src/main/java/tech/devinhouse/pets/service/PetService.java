package tech.devinhouse.pets.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.pets.model.PetModel;
import tech.devinhouse.pets.model.UsuarioModel;
import tech.devinhouse.pets.repository.PetRepository;
import tech.devinhouse.pets.repository.UsuarioRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final UsuarioRepository usuarioRepository;

    public PetService(PetRepository petRepository, UsuarioRepository usuarioRepository) {
        this.petRepository = petRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PetModel cadastrarPet(PetModel petModel) {
        petRepository.save(petModel);
        return petModel;
    }

    public List<PetModel> encontrarTodosOsPets() {
        return petRepository.findAll();
    }

    public PetModel adotarPet(Long idTutor, Long idPet) {
        PetModel pet = petRepository.findById(idPet).get();
        UsuarioModel usuario = usuarioRepository.findById(idTutor).get();

        pet.setSituacao("Adotado");
        pet.setTutor(usuario);
        petRepository.save(pet);

        return pet;
    }

}
