package tech.devinhouse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.dto.UsuarioRequest;
import tech.devinhouse.dto.UsuarioResponse;
import tech.devinhouse.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> encontrarTodosOsUsuarios() {
        List<UsuarioResponse> responseList = service.encontrarTodosOsUsuarios();

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> encontrarUsuarioPorId(@PathVariable("id") Long id) {
        UsuarioResponse usuarioResponse = service.encontrarUsuarioPorId(id);

        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioRequest request) {
        UsuarioResponse usuarioResponse = service.cadastrarUsuaio(request);

        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuarioPorId(@PathVariable("id") Long id, @RequestBody UsuarioRequest request) {
        UsuarioResponse usuarioResponse = service.atualizarUsuarioPorId(id, request);

        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity detetarUsuarioPorId(@PathVariable("id") Long id) {
        service.deletarUsuarioPorId(id);

        return ResponseEntity.ok().build();
    }

}
