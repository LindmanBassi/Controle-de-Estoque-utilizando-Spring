package br.com.henrique.estoque.model.dto;

public record ProdutoDTO(

        String nome,
        String descricao,
        int quantidade,
        double preco
) {
}
