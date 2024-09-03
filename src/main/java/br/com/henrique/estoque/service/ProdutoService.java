package br.com.henrique.estoque.service;

import br.com.henrique.estoque.model.Clientes;
import br.com.henrique.estoque.model.Produto;
import br.com.henrique.estoque.model.dto.ProdutoDTO;
import br.com.henrique.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(ProdutoDTO produto) {
        if (produtoRepository.findByNome(produto.nome()) != null) {
            throw new IllegalArgumentException("Nome de produto já cadastrado.");
        }
        Produto produto1 = new Produto(produto);
        return produtoRepository.save(produto1);
    }
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
    public void excluirProduto(String id){
        produtoRepository.deleteById(id);

    }

    public Produto modificarProduto(ProdutoDTO produto, String id){
        Produto produtonovo = produtoRepository.findById(id).orElseThrow();
        produtonovo.setNome(produto.nome());
        produtonovo.setDescricao(produto.descricao());
        produtonovo.setPreco(produto.preco());
        produtonovo.setQuantidade(produto.quantidade());
        return produtoRepository.save(produtonovo);
    }

    public Produto buscarPorNome(String nome){
        Produto produto = produtoRepository.findByNome(nome);
        return produto;
    }



}
