package tech.devinhouse.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.devinhouse.context.ApplicationContextLoad;
import tech.devinhouse.model.UsuarioModel;
import tech.devinhouse.repository.UsuarioRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Service
@Component
public class JWTTokenAutenticacaoService {

    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 2;

    private static final String SECRET = "SenhaExtremamenteSecretaEForte";

    private static final String TOKEN_PREFIX = "Bearer";

    private static  final String HEADER_STRING = "Authorization";

    public void addAuthentication(HttpServletResponse response, String username) throws IOException {

        String JWT =  Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        String token = TOKEN_PREFIX + " " + JWT;

        response.getWriter().write("{\"Authorization\": \""+token+"\"}");

    }

    public Authentication getAuthentication(HttpServletRequest request){

        String token = request.getHeader(HEADER_STRING);

        if(token != null){

            String user = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody().getSubject();

            if (user != null){
                UsuarioModel usuario = ApplicationContextLoad.getApplicationContext()
                        .getBean(UsuarioRepository.class).findUserByLogin(user);

                System.out.println("Login do usuário: "+usuario.getLogin());

                if(usuario != null){
                    return new UsernamePasswordAuthenticationToken(
                            usuario.getLogin(),
                            usuario.getSenha(),
                            usuario.getAuthorities());
                }
            }
        }

        return null;
    }

}
