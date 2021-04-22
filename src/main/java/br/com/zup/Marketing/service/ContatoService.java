package br.com.zup.Marketing.service;

import br.com.zup.Marketing.DTOs.FiltroContatoDTO;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato cadastrarUmContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato pesquisarUmContatoPeloId(Integer id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isPresent()){
            return contatoOptional.get();
        }
        throw new RuntimeException("Contato não foi encontrado");
    }

    public Iterable<Contato> pesquisarTodosOsContatos(){
        return contatoRepository.findAll();
    }

    public Contato atualizaUmContato(Integer id, Contato contato){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (!contatoOptional.isPresent())
            throw new RuntimeException("Contato não foi encontrado para atualização");

        contato.setId(id);
        contatoRepository.save(contato);
        return contato;
    }

    public void deletarUmContato(Integer id){
        contatoRepository.deleteById(id);
    }

    public Iterable<Contato> pesquisarOsContatosPeloProduto(String produto, FiltroContatoDTO contatoDTO) {
        if (contatoDTO.getProduto() == null) {
            return contatoRepository.findAll();
        }
        return contatoRepository.findByProdutosNome(contatoDTO.getProduto().getNome());
    }

    public Iterable<Contato> pesquisarOsContatosPelaCategoria(String categoria, FiltroContatoDTO contatoDTO) {
        if (contatoDTO.getCategoria() == null) {
            return contatoRepository.findAll();
        }
        return contatoRepository.findByProdutosCategoriasNome(contatoDTO.getCategoria().getNome());
    }
}