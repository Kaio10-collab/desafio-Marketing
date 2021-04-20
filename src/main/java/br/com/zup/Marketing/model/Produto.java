package br.com.zup.Marketing.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    private String nome;

    @ManyToMany
    private List<Categoria> categoria;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}