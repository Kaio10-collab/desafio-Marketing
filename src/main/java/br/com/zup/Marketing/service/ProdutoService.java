package br.com.zup.Marketing.service;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.model.Produto;
import br.com.zup.Marketing.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Produto cadastrarProduto(Produto produto) {
        Produto objContato = produtoRepository.save(produto);
        objContato.setCategoria(listarAsCategorias(objContato.getCategoria()));
        return objContato;
    }

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> procurarProdutoPorNome(Produto produto) {
        return produtoRepository.findById(produto.getId());
    }

    private List<Categoria> listarAsCategorias(List<Categoria> categorias){

        List<Categoria> categoriasAdicionarContato = new ArrayList<>();

        for (Categoria categoria : categorias) {
            categoriasAdicionarContato.add(categoriaService.procurarCategoriaPorNome(categoria).get());
        }
        return categoriasAdicionarContato;
    }
}