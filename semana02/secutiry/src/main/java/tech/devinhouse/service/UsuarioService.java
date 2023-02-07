package tech.devinhouse.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.devinhouse.dto.UsuarioRequest;
import tech.devinhouse.dto.UsuarioResponse;
import tech.devinhouse.model.RoleModel;
import tech.devinhouse.model.UsuarioModel;
import tech.devinhouse.repository.RoleRepository;
import tech.devinhouse.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponse> encontrarTodosOsUsuarios() {
        List<UsuarioModel> modelList = usuarioRepository.findAll();

        List<UsuarioResponse> responseList = new ArrayList<>();

        for (UsuarioModel model:modelList) {
            responseList.add(
                    new UsuarioResponse(model.getId()
                            , model.getNome()
                            , model.getLogin()
                            , model.getSenha()
                            , model.getEmail())
            );
        }

        return responseList;
    }

    public UsuarioResponse encontrarUsuarioPorId(Long id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id).get();

        return new UsuarioResponse(usuarioModel.getId()
                , usuarioModel.getNome()
                , usuarioModel.getLogin()
                , usuarioModel.getSenha()
                , usuarioModel.getEmail()
        );
    }

    public UsuarioResponse cadastrarUsuaio(UsuarioRequest usuarioRequest) {
        RoleModel roleModel = roleRepository.findById(usuarioRequest.getIdRole()).get();

        List<RoleModel> roleModels = new ArrayList<>();
        roleModels.add(roleModel);

        usuarioRequest.setSenha(new BCryptPasswordEncoder().encode(usuarioRequest.getSenha()));

        UsuarioModel usuarioModel = usuarioRepository.save(
                new UsuarioModel(usuarioRequest.getNome()
                        , usuarioRequest.getLogin()
                        , usuarioRequest.getSenha()
                        , usuarioRequest.getEmail()
                        , roleModels)
        );

        return new UsuarioResponse(usuarioModel.getId()
                , usuarioModel.getNome()
                , usuarioModel.getLogin()
                , usuarioModel.getSenha()
                , usuarioModel.getEmail()
        );
    }

    public UsuarioResponse atualizarUsuarioPorId(Long id, UsuarioRequest usuarioRequest) {
       UsuarioModel usuarioModel = usuarioRepository.findById(id).get();

       RoleModel roleModel = roleRepository.findById(usuarioRequest.getIdRole()).get();

       usuarioRequest.setSenha(new BCryptPasswordEncoder().encode(usuarioRequest.getSenha()));

       List<RoleModel> roleModels = new ArrayList<>();
       roleModels.add(roleModel);

       usuarioModel.setNome(usuarioRequest.getNome());
       usuarioModel.setLogin(usuarioRequest.getLogin());
       usuarioModel.setSenha(usuarioRequest.getSenha());
       usuarioModel.setEmail(usuarioRequest.getEmail());
       usuarioModel.setRoles(roleModels);

       usuarioRepository.save(usuarioModel);

       return new UsuarioResponse(usuarioModel.getId()
               , usuarioModel.getNome()
               , usuarioModel.getLogin()
               , usuarioModel.getSenha()
               , usuarioModel.getEmail()
       );
    }

    @Transactional
    public void deletarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsuarioModel usuarioModel = usuarioRepository.findUserByLogin(login);

        if (usuarioModel == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        return new User(usuarioModel.getLogin(), usuarioModel.getPassword(), usuarioModel.getAuthorities());
    }

}
