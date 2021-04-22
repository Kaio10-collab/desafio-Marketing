package br.com.zup.Marketing.repository;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {

    Iterable<Contato> findByProdutoNome(String nome);
    Iterable<Categoria> findByProdutosCategoriasNome(String nome);
}