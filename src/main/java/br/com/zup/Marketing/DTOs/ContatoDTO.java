package br.com.zup.Marketing.DTOs;

import br.com.zup.Marketing.model.Contato;

import javax.validation.constraints.NotBlank;

public class ContatoDTO {

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String email;
    @NotBlank
    private double telefone;

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

    public Contato converterDTOParaModel(){
        Contato contato = new Contato();
        contato.setNomeCompleto(this.nomeCompleto);
        contato.setEmail(this.email);
        contato.setTelefone(this.telefone);
        return contato;
    }
}