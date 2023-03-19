package tech.devinhouse.pets.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.pets.model.PetModel;
import tech.devinhouse.pets.model.UsuarioModel;
import tech.devinhouse.pets.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.cadastrarUsuario(usuarioModel);
    }

}
