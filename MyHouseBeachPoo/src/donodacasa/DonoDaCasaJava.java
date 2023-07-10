/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donodacasa;


import cliente.Cliente;
import cliente.ClienteJava;
import cliente.ClienteDAO;

import static cliente.ClienteJava.atualizarCliente;
import static cliente.ClienteJava.buscarCliente;
import static cliente.ClienteJava.inserirCliente;
import static cliente.ClienteJava.listarClientes;
import static cliente.ClienteJava.removerCliente;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author conta
 */
public class DonoDaCasaJava extends ClienteJava {
    
    protected static void menuInicialDonoDaCasa(Scanner scanner){
        while(true){
            System.out.println("Menu Inicial do Dono da Casa");
            scanner = new Scanner(System.in);
            System.out.println("OPÇÕES:");
            System.out.println("1 - Inserir um novo cliente");
            System.out.println("2 - Buscar um cliente");
            System.out.println("3 - Listar todos os Clientes");
            System.out.println("4 - Atualizar um cliente");
            System.out.println("5 - Remover um cliente");
            
            System.out.println("---- Dono da Casa ----");
            
            System.out.println("6 - Associar Cliente e Casa de Praia");
            System.out.println("7 - Buscar um Dono de Casa ");
            System.out.println("8 - Listar Donos de Casa ");
            
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
                
                case 6: {
                    ClienteDonoDaCasa(scanner);
                    break;
                }
                
                case 7: {
                    BuscarDono(scanner);
                    break;
                }
                
                case 8: {
                    ListarDono(scanner);
                    break;
                }
            }
                
            if(opcao == 0){
                break;
            }
        }
    }
    
    protected static void ListarDono(Scanner scanner){
        System.out.println("Lista dos Donos de Casas:");
        System.out.println("--------");
        
        DonoDaCasaDAO donoDaCasaDAO = new DonoDaCasaDAO();
        
        List<DonoDaCasa> donos = donoDaCasaDAO.obterTodosDonos();
        
        
        for(DonoDaCasa d : donos){
            System.out.println(" Cliente ID: " + d.getCliente_id() + "\n Casa ID: " + d.getCasa_id());
            System.out.println("------------------");
        }
        
        if(donos.isEmpty()){
            System.out.println("Não existem Donos da Casa Cadastrados");
        }
    }
    
    protected static void BuscarDono(Scanner scanner){
        System.out.println("Buscar por um Dono de Casa de Praia");
        System.out.println("Entre com o ID do Cliente Associado");
        int clienteId = Integer.parseInt(scanner.nextLine());
        
        DonoDaCasaDAO donoDaCasaDAO = new DonoDaCasaDAO();
        DonoDaCasa donoDaCasa = donoDaCasaDAO.obterRelacaoDono(clienteId);
        
        if(donoDaCasa == null){
            System.out.println("Dono da Casa associado ao ID " + clienteId + " não foi encontrada");
            
        }else{
            System.out.println(" Cliente ID: " + donoDaCasa.getCliente_id() + "\n Casa ID: " + donoDaCasa.getCasa_id());
        }
    }
    
    protected static void ClienteDonoDaCasa(Scanner scanner){
        System.out.println("Associar Casa de Praia com o Cliente");
        
        System.out.println("Insira o ID da Casa de Praia ");
        int casaId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Insira o ID do Cliente Associado");
        int clienteId = Integer.parseInt(scanner.nextLine());
        
        DonoDaCasaDAO donoDaCasaDAO = new DonoDaCasaDAO();
        boolean sucesso = donoDaCasaDAO.inserir(clienteId, casaId);
        
        if(sucesso){
            System.out.println("Dono da Casa criado");
        }else{
            System.out.println("Não foi possível criar dono da casa");
        }
        
    }

    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuInicialDonoDaCasa(scanner);
        scanner.close();
    
    }
    
}
