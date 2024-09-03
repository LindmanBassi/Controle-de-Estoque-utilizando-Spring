package br.com.henrique.estoque.controller;

import br.com.henrique.estoque.model.Clientes;
import br.com.henrique.estoque.model.dto.ProdutoDTO;
import br.com.henrique.estoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
   @Autowired
    private ClienteService clienteService;

   @PostMapping
    public Clientes criarClientes(@RequestBody Clientes clientes){
       return clienteService.criarCliente(clientes);
   }
   @GetMapping
    public List<Clientes> listarClientes(){
       return clienteService.listarClientes();
   }
   @DeleteMapping
    public void excluirClientes(@RequestParam String cpf){
       clienteService.excluirClientes(cpf);
   }
   @PutMapping
    public Clientes modificarClientes(Clientes clientes){
       return clienteService.modificarCliente(clientes);
   }
   @GetMapping("/{cpf}")
    public Clientes buscarPorCPF(@PathVariable String cpf){
       return clienteService.buscarPorCPF(cpf);
   }
}
