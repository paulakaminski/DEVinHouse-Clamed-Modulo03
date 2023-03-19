package tech.devinhouse.pets.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.devinhouse.pets.model.PetModel;
import tech.devinhouse.pets.model.UsuarioModel;
import tech.devinhouse.pets.repository.PetRepository;
import tech.devinhouse.pets.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PetRepository petRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PetRepository petRepository) {
        this.usuarioRepository = usuarioRepository;
        this.petRepository = petRepository;
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
        return usuarioModel;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsuarioModel usuario = this.usuarioRepository.findByLogin(login);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
    }
}
