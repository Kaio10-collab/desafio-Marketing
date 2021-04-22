package br.com.zup.Marketing.service;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }
}
