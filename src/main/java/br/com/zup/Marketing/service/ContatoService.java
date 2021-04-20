package br.com.zup.Marketing.service;

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

    public Contato pesquisarUmContatoPeloNome(String nome){
        Optional<Contato> contatoOptional = contatoRepository.findById(nome);

        if (contatoOptional.isPresent()){
            return contatoOptional.get();
        }
        throw new RuntimeException("Contato não foi encontrado");
    }

    public Iterable<Contato> pesquisarTodosOsContatos(){
        return contatoRepository.findAll();
    }

    public Contato atualizaUmContato(String nome, Contato contato){
        Optional<Contato> contatoOptional = contatoRepository.findById(nome);

        if (!contatoOptional.isPresent())
            throw new RuntimeException("Contato não foi encontrado para atualização");

        contato.setNomeCompleto(nome);
        contatoRepository.save(contato);
        return contato;
    }

    public void deletarUmContato(String nome){
        contatoRepository.deleteById(nome);
    }
}