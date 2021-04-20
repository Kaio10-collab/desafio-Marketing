package br.com.zup.Marketing.model;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    private String nome;

    public Categoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
