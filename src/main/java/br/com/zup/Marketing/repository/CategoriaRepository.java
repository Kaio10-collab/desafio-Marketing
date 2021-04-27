package br.com.zup.Marketing.repository;

import br.com.zup.Marketing.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);
}
