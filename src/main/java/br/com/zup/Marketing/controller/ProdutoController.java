package br.com.zup.Marketing.controller;

import br.com.zup.Marketing.model.Produto;
import br.com.zup.Marketing.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastroProduto(@RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Integer id){
        produtoService.deletarProduto(id);
    }
}