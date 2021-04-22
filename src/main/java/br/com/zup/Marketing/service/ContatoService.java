package br.com.zup.Marketing.service;


import br.com.zup.Marketing.DTOs.ContatoDTO;
import br.com.zup.Marketing.DTOs.FiltroContatoDTO;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private List<Contato> contatos = new ArrayList<>();

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

    public Iterable<Contato> pesquisarOsContatosPeloProduto(FiltroContatoDTO contatoDTO) {
        if (contatoDTO.getProduto() == null) {
            return contatoRepository.findAll();
        }
        return contatoRepository.findByProdutoNome(contatoDTO.getProduto().getNome());
    }
}