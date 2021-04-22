package br.com.zup.Marketing.DTOs;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ContatoDTO {

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String email;
    @NotBlank
    private double telefone;

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

    public double getTelefone() {
        return telefone;
    }

    public void setTelefone(double telefone) {
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

    public Contato converterDTOParaModel(){
        Contato contato = new Contato();
        contato.setNomeCompleto(this.nomeCompleto);
        contato.setEmail(this.email);
        contato.setTelefone(this.telefone);
        contato.setProduto(this.produtos);
        contato.setCategoria(this.categorias);
        return contato;
    }
}