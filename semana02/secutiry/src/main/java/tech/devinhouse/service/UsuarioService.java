package tech.devinhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.dto.UsuarioRequest;
import tech.devinhouse.dto.UsuarioResponse;
import tech.devinhouse.model.UsuarioModel;
import tech.devinhouse.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponse> encontrarTodosOsUsuarios() {
        List<UsuarioModel> modelList = repository.findAll();

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
        UsuarioModel usuarioModel = repository.findById(id).get();

        return new UsuarioResponse(usuarioModel.getId()
                , usuarioModel.getNome()
                , usuarioModel.getLogin()
                , usuarioModel.getSenha()
                , usuarioModel.getEmail()
        );
    }

    public UsuarioResponse cadastrarUsuaio(UsuarioRequest usuarioRequest) {
        UsuarioModel usuarioModel = repository.save(
                new UsuarioModel(usuarioRequest.getNome()
                        , usuarioRequest.getLogin()
                        , usuarioRequest.getSenha()
                        , usuarioRequest.getEmail())
        );

        return new UsuarioResponse(usuarioModel.getId()
                , usuarioModel.getNome()
                , usuarioModel.getLogin()
                , usuarioModel.getSenha()
                , usuarioModel.getEmail()
        );
    }

    public UsuarioResponse atualizarUsuarioPorId(Long id, UsuarioRequest usuarioRequest) {
       UsuarioModel usuarioModel = repository.findById(id).get();

       usuarioModel.setNome(usuarioRequest.getNome());
       usuarioModel.setLogin(usuarioModel.getLogin());
       usuarioModel.setSenha(usuarioRequest.getSenha());
       usuarioModel.setEmail(usuarioRequest.getEmail());

       repository.save(usuarioModel);

       return new UsuarioResponse(usuarioModel.getId()
               , usuarioModel.getNome()
               , usuarioModel.getLogin()
               , usuarioModel.getSenha()
               , usuarioModel.getEmail()
       );
    }

    public void deletarUsuarioPorId(Long id) {
        repository.deleteById(id);
    }

}
