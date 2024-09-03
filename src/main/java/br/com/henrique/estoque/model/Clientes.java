package br.com.henrique.estoque.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class Clientes {

    @Id
    private String cpf;
    private String nome;
    private String email;




}
