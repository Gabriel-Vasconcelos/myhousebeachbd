/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

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
            System.out.println("3 - Atualizar um cliente");
            System.out.println("4 - Remover um cliente");
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
                    atualizarCliente(scanner);
                    break;
                }
                case 4: {
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
        
    }
    
    public static void buscarCliente(Scanner scanner){
        
    }
    
    public static void atualizarCliente(Scanner scanner){
        
    }
    
    public static void removerCliente(Scanner scanner){
        
    }
    
    public static void main(String[] args) {
        
    
    }
}
