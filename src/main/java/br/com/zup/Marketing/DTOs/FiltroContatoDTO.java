package br.com.zup.Marketing.DTOs;

import br.com.zup.Marketing.model.Categoria;
import br.com.zup.Marketing.model.Produto;

public class FiltroContatoDTO {

    private Produto produto;
    private Categoria categoria;

    public FiltroContatoDTO() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
