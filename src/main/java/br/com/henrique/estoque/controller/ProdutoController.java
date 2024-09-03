package br.com.henrique.estoque.controller;

import br.com.henrique.estoque.model.Clientes;
import br.com.henrique.estoque.model.Produto;
import br.com.henrique.estoque.model.dto.ProdutoDTO;
import br.com.henrique.estoque.repository.ProdutoRepository;
import br.com.henrique.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController{

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criarProduto(@RequestBody ProdutoDTO produto){
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @DeleteMapping
    public void excluirProduto(@RequestParam String id){
        produtoService.excluirProduto(id);
    }

    @PutMapping
    public Produto modificarProduto(@RequestBody ProdutoDTO produto,@RequestParam String id){
        return produtoService.modificarProduto(produto, id);
    }
    @GetMapping("/{nome}")
    public Produto buscarPorNome(@PathVariable String nome){
        return produtoService.buscarPorNome(nome);
    }
}
