package br.com.zup.Marketing.jwt;

import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioLoginService implements UserDetailsService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Contato> contatoOptional = contatoRepository.findByEmail(email);

        contatoOptional.orElseThrow(() -> new UsernameNotFoundException("Email não cadastrado"));

        Contato contato = contatoOptional.get();

        return new UsuarioLogin(contato.getEmail(), contato.getCpf(), contato.getSenha());
    }
}