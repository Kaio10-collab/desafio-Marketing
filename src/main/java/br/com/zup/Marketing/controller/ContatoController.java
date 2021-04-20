package br.com.zup.Marketing.controller;

import br.com.zup.Marketing.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contatos/")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato cadastroContato(@RequestBody Contato contato){
        return contatoService.cadastrarUmContato(contato);
    }

    @GetMapping("{nome}/")
    @ResponseStatus(HttpStatus.OK)
    public Contato pesquisaContato(@PathVariable String nome){
        return contatoService.pesquisarUmContatoPeloNome(nome);
    }

    @GetMapping
    public Iterable<Contato> retornoDeTodosOsContatos(){
        return contatoService.pesquisarTodosOsContatos();
    }

    @PutMapping("{nome}/")
    public Contato atualizandoUmContato(@PathVariable String nome, @RequestBody Contato contato){
        Contato objContato = contatoService.atualizaUmContato(nome, contato);
        return objContato;
    }

    @DeleteMapping("{nome}/")
    public void deletarContato(@PathVariable String nome){
        return contatoService.deletarUmContato(nome);
    }

}
