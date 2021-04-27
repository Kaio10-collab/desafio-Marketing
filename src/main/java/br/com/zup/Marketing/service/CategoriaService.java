package br.com.zup.Marketing.service;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria cadastrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }

    public Categoria procurarCategoriaPorNome(Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findByNome(categoria.getNome());
        if (optionalCategoria.isPresent()){
            return optionalCategoria.get();
        }
        return cadastrarCategoria(categoria);
    }
}