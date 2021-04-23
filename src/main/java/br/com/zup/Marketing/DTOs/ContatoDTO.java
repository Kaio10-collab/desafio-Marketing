package br.com.zup.Marketing.DTOs;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ContatoDTO {

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;

    @NotNull
    private List<Produto> produtos;
    private List<Categoria> categorias;

    public ContatoDTO() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }


    public static Iterable<ContatoDTO> converterIterableDeModelParaDTO(Iterable<Contato> contatos){
        List<ContatoDTO> contatosDTOS = new ArrayList<>();
        for(Contato contato: contatos){
            contatosDTOS.add(converterModelParaDTO(contato));
        }
        return contatosDTOS;
    }

    public static ContatoDTO converterModelParaDTO(Contato contato){
        ContatoDTO contatoDTO = new ContatoDTO();

        contatoDTO.setNomeCompleto(contato.getNomeCompleto());
        contatoDTO.setEmail(contato.getEmail());
        contatoDTO.setTelefone(contato.getTelefone());
        contatoDTO.setProdutos(contato.getProduto());
        return contatoDTO;
    }
}