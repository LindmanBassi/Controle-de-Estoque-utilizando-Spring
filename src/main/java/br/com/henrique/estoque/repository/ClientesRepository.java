package br.com.henrique.estoque.repository;

import br.com.henrique.estoque.model.Clientes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientesRepository extends MongoRepository <Clientes, String> {

}
