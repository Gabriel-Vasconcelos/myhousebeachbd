/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telefone;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author conta
 */
public class TelefoneJava {
    protected static void menuInicialTelefone(Scanner scanner){
        while(true){
            System.out.println("Menu Inicial do Telefone");
            scanner = new Scanner(System.in);
            System.out.println("OPÇÕES:");
            System.out.println("1 - Inserir um novo telefone");
            System.out.println("2 - Buscar o Telefone de um Cliente");
            System.out.println("3 - Listar todos os Telefones");
            System.out.println("4 - Atualizar um Telefone");
            System.out.println("5 - Remover um Telefone");
            System.out.println("0 - Saiiir");
            System.out.println("Digite uma opção:");
            
            int opcao = Integer.parseInt(scanner.nextLine());
            
            switch (opcao) {
                case 1: {
                    inserirTelefone(scanner);
                    break;
                }
                case 2: {
                    buscarTelefone(scanner);
                    break;
                }
                case 3: {
                    listarTelefones(scanner);
                    break;
                }
                case 4: {
                    atualizarTelefone(scanner);
                    break;
                }
                case 5: {
                    removerTelefone(scanner);
                    break;
                }
            }
                
            if(opcao == 0){
                break;
            }
        }
    }
        
    
    protected static void inserirTelefone(Scanner scanner){
        System.out.println("Inserir um novo telefone");
        
        System.out.println("Digite o ID do Cliente Associado");
        int clienteId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Digite o ID do Telefone");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o DDD do Telefone");
        int ddd = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o Número do Telefone");
        int numero = Integer.parseInt(scanner.nextLine());
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        boolean sucesso = telefoneDAO.inserir(clienteId, id , ddd, numero);
        
        if(sucesso){
            System.out.println("Telefone Cadastrado com sucesso");
        }else{
            System.out.println("Não foi possível cadastrar este Telefone");
        }
    }
    
    protected static void buscarTelefone(Scanner scanner){
        System.out.println("Pesquisar Telefone por um Cliente Associado");
        System.out.println("Entre com o ID do Cliente:");
        int id = Integer.parseInt(scanner.nextLine());
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> telefones = telefoneDAO.obter(id);
        
        for(Telefone t : telefones){
            System.out.println(" ID: " + t.getId() + "\n Cliente Nome(ID): " + t.getNomeCliente() + "(" + t.getCliente_id() + ")\n DDD: " + t.getDdd() + "\n Número: " + t.getNumero());
            System.out.println("------------------");
        }
        
        if(telefones.isEmpty()){
            System.out.println("Não existem telefones associados a esse Cliente");
        }
        
    }
    
    protected static void listarTelefones(Scanner scanner){
        System.out.println("Lista dos Telefones");
        System.out.println("--------");
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> telefones = telefoneDAO.obterTodos();
        
        for(Telefone t : telefones){
            System.out.println( " ID: " + t.getId() +"\n Cliente ID: " + t.getCliente_id() + "\n DDD: " + t.getDdd() + "\n Número: " + t.getNumero());
            System.out.println("------------------");
        }
        
        if(telefones.isEmpty()){
            System.out.println("Não existem telefones cadastrados");
        }
    }
    
    
    
    protected static void atualizarTelefone(Scanner scanner){
        System.out.println("Atualizar um Telefone existente");
        System.out.println("Entre com o ID do Telefone");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o novo DDD ");
        int ddd = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o novo numero");
        int numero = Integer.parseInt(scanner.nextLine());
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        boolean sucesso = telefoneDAO.atualizar(id, ddd, numero);
        
        if(sucesso){
            System.out.println("Telefone atualizado com sucesso!");
        }else{
            System.out.println("Não foi possível atualizar este telefone :<");
        }
    }
    
    protected static void removerTelefone(Scanner scanner){
        System.out.println("Remover um Telefone Existente");
        System.out.println("Entre com o ID:");
        int id = Integer.parseInt(scanner.nextLine());
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        boolean sucesso = telefoneDAO.remover(id);
        
        if(sucesso){
            System.out.println("Telefone removido com sucesso");
        }else{
            System.out.println("Não foi possível remover este Telefone");
        }

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuInicialTelefone(scanner);
        scanner.close();
    
    }
    
}
