package br.com.zup.Marketing.repository;

import br.com.zup.Marketing.model.Contato;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {

    Iterable<Contato> findByProdutosNome(String nome);
    Iterable<Contato> findByProdutosCategoriasNome(String nome);
    Optional<Contato> findByEmail(String email);
}