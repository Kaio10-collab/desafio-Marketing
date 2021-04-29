package br.com.zup.Marketing.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component // vai transformar a classe em um objeto e vai instaciar com os métodos do Bean.
// INSTANCIA UM OBJETO Da classe marcada que o spring boot vai gerenciar (bean).
public class ComponenteJWT {

    @Value("${jwt.segredo}")
    private String segredo;

    @Value("${jwt.time}")
    private Long time;

    public String criarToken(String user){

        Date vencto = new Date(System.currentTimeMillis()+time);

        String token = Jwts.builder().setSubject(user).
                setExpiration(vencto).signWith(SignatureAlgorith.HS512,segredo.getBytes()).compact();

        return token;
    }
}
