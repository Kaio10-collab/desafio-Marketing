package br.com.zup.Marketing.repository;

import br.com.zup.Marketing.model.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, String> {

    Iterable<Contato> findByProduto(String nome);
}