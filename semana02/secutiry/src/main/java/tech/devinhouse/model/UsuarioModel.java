package tech.devinhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, unique = true)
    private String login;

    private String senha;

    private String email;

    public UsuarioModel(String nome, String login, String senha, String email) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }
}
