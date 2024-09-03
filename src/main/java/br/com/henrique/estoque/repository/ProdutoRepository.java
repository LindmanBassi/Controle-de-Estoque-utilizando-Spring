package br.com.henrique.estoque.repository;

import br.com.henrique.estoque.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

    Produto findByNome(String nome);
}
