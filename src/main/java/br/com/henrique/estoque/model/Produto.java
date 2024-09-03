package br.com.henrique.estoque.model;

import br.com.henrique.estoque.model.dto.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produtos")
public class Produto {

    @MongoId
    private String id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;


    public Produto(ProdutoDTO dto){
        this.nome= dto.nome();
        this.descricao = dto.descricao();
        this.quantidade = dto.quantidade();
        this.preco = dto.preco();
    }

}
