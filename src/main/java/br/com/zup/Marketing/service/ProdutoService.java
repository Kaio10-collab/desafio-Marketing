package br.com.zup.Marketing.service;

import br.com.zup.Marketing.model.Produto;
import br.com.zup.Marketing.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> procurarProdutoPorNome(Produto produto) {
        return produtoRepository.findById(produto.getId());
    }

}