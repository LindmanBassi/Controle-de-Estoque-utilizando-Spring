package br.com.henrique.estoque.service;

import br.com.henrique.estoque.model.Clientes;
import br.com.henrique.estoque.model.Produto;
import br.com.henrique.estoque.model.dto.ProdutoDTO;
import br.com.henrique.estoque.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes criarCliente(Clientes cliente) {
        if (clientesRepository.existsById(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        return clientesRepository.save(cliente);
    }
    public List<Clientes> listarClientes(){
        return clientesRepository.findAll();
    }
    public void excluirClientes(String cpf){
        clientesRepository.deleteById(cpf);
    }
    public Clientes modificarCliente(Clientes cliente){
        Clientes clientesnovo = clientesRepository.findById(cliente.getCpf()).orElseThrow();
        clientesnovo.setNome(cliente.getNome());
        clientesnovo.setEmail(cliente.getEmail());
        return clientesRepository.save(clientesnovo);
    }
    public Clientes buscarPorCPF(String cpf){
        Clientes cliente = clientesRepository.findById(cpf).orElseThrow();
        return cliente;
    }
}
