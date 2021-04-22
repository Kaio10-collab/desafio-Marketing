package br.com.zup.Marketing.controller;

import br.com.zup.Marketing.DTOs.ContatoDTO;
import br.com.zup.Marketing.DTOs.FiltroContatoDTO;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.service.ContatoService;
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

    @GetMapping("{id}/")
    @ResponseStatus(HttpStatus.OK)
    public Contato pesquisaContato(@PathVariable Integer id){
        return contatoService.pesquisarUmContatoPeloId(id);
    }

    @GetMapping
    public Iterable<Contato> retornoDeTodosOsContatos(){
        return contatoService.pesquisarTodosOsContatos();
    }

    @PutMapping("{id}/")
    public Contato atualizandoUmContato(@PathVariable Integer id, @RequestBody Contato contato){
        Contato objContato = contatoService.atualizaUmContato(id, contato);
        return objContato;
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContato(@PathVariable Integer id ){
        contatoService.deletarUmContato(id);
    }

    @GetMapping("{produto}/")
    public Iterable<ContatoDTO> pesquisarTodosOsContatosDeUmProduto(@ModelAttribute FiltroContatoDTO filtro) {
        Iterable<Contato> objcontato = contatoService.pesquisarOsContatosPeloProduto(filtro);
        return ContatoDTO.converterIterableDeModelParaDTO(objcontato);
    }
}