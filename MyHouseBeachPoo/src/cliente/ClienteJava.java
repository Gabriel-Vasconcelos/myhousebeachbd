/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author conta
 */
public class ClienteJava {
    public static void menuInicialCliente(Scanner scanner){
        while(true){
            System.out.println("Menu Inicial do Cliente");
            scanner = new Scanner(System.in);
            System.out.println("OPÇÕES:");
            System.out.println("1 - Inserir um novo cliente");
            System.out.println("2 - Buscar um cliente");
            System.out.println("3 - Listar todos os Clientes");
            System.out.println("4 - Atualizar um cliente");
            System.out.println("5 - Remover um cliente");
            System.out.println("0 - Saiiir");
            System.out.println("Digite uma opção:");
            
            int opcao = Integer.parseInt(scanner.nextLine());
            
            switch (opcao) {
                case 1: {
                    inserirCliente(scanner);
                    break;
                }
                case 2: {
                    buscarCliente(scanner);
                    break;
                }
                case 3: {
                    listarClientes(scanner);
                    break;
                }
                case 4: {
                    atualizarCliente(scanner);
                    break;
                }
                case 5: {
                    removerCliente(scanner);
                    break;
                }
            }
                
            if(opcao == 0){
                break;
            }
        }
    }
    
    public static void inserirCliente(Scanner scanner){
        System.out.println("Inserir um novo cliente");
        
        System.out.println("Digite o ID do Cliente");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o nome: ");
        String nome = scanner.nextLine();
        
        System.out.println("Entre com o cpf: ");
        String cpf = scanner.nextLine();
        
        System.out.println("Entre com o email: ");
        String email = scanner.nextLine();
        
        System.out.println("Entre com o endereço: ");
        String endereco = scanner.nextLine();
        
        System.out.println("Entre com a cidade: ");
        String cidade = scanner.nextLine();
        
        System.out.println("Entre com o estado: ");
        String estado = scanner.nextLine();
        
        System.out.println("Entre com o login: ");
        String login = scanner.nextLine();
        
        System.out.println("Entre com a senha: ");
        String senha = scanner.nextLine();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        boolean sucesso = clienteDAO.inserir(id, nome, cpf, email, endereco ,cidade, estado, login, senha);
        
        if (sucesso) {
            System.out.println("Cliente cadastrado com sucesso");
        } else {
            System.out.println("Não foi possível cadastrar este cliente");
        }

    }
    
    public static void buscarCliente(Scanner scanner){
        System.out.println("Pesquisar por um Cliente");
        System.out.println("Entre com o ID:");
        int id = Integer.parseInt(scanner.nextLine());
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.obter(id);
        
        if(cliente == null){
            System.out.println("Cliente de ID " + id + " não foi encontrada");
        }else{
            System.out.println(" ID: " + cliente.getId() + "\n Nome: " + cliente.getNome() + "\n Email: " + cliente.getEmail() + "\n Login: " + cliente.getLogin() + "\n CPF: " + cliente.getCpf() + "\n Endereço Completo: " + cliente.getEnderecoComp());
        }
        
    }
    
    
    public static void listarClientes(Scanner scanner){
        System.out.println("Lista dos Clientes:");
        System.out.println("--------");
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
        List<Cliente> clientes = clienteDAO.obterTodos();
        
        for(Cliente c : clientes){
            System.out.println(" ID: " + c.getId() + "\n Nome: " + c.getNome() + "\n Email: " + c.getEmail() + "\n Login: " + c.getLogin() + "\n CPF: " + c.getCpf());
            System.out.println("------------------");
        }
        
        if(clientes.isEmpty()){
            System.out.println("Não existem Clientes Cadastrados");
        }
    }
    
    public static void atualizarCliente(Scanner scanner){
        System.out.println("Atualizar um Cliente Existente");
        System.out.println("Entre com o ID:");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o novo nome");
        String nome = scanner.nextLine();
        
        System.out.println("Entre com o novo email");
        String email = scanner.nextLine();
        
        System.out.println("Entre com o novo cpf");
        String cpf = scanner.nextLine();
        
        System.out.println("Entre com o novo login");
        String login = scanner.nextLine();
        
        System.out.println("Entre com a nova senha");
        String senha = scanner.nextLine();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        boolean sucesso = clienteDAO.atualizar(id,nome,email,cpf,login,senha);
        
        if(sucesso){
            System.out.println("Cliente atualizado com sucesso!");
        }else{
            System.out.println("Não foi possivel atualizar este cliente");
        }
    }
    
    public static void removerCliente(Scanner scanner){
        System.out.println("Remover um Cliente Existente");
        System.out.println("Entre com o ID");
        int id = Integer.parseInt(scanner.nextLine());
        
        ClienteDAO clienteDAO = new ClienteDAO();
        boolean sucesso = clienteDAO.remover(id);
        
        if(sucesso){
            System.out.println("Cliente removida com sucesso");
        }else{
            System.out.println("Não foi possivel remover este Cliente");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuInicialCliente(scanner);
        scanner.close();
    
    }
}