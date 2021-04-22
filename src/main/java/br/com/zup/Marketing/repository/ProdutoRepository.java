package br.com.zup.Marketing.repository;

import br.com.zup.Marketing.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
