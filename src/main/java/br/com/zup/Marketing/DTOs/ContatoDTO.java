package br.com.zup.Marketing.DTOs;

import br.com.zup.Marketing.model.Contato;
import br.com.zup.Marketing.model.Produto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ContatoDTO {

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String email;
    @NotBlank
    private double telefone;

    private List<Produto> produto;

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

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Contato converterDTOParaModel(){
        Contato contato = new Contato();
        contato.setNomeCompleto(this.nomeCompleto);
        contato.setEmail(this.email);
        contato.setTelefone(this.telefone);
        contato.setProduto(this.produto);
        return contato;
    }
}