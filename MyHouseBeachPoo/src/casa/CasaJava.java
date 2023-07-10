/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casa;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author conta
 */
public class CasaJava {
    protected static void menuInicialCasa(Scanner scanner){
        while(true){
            System.out.println("Menu Inicial da Casa");
            scanner = new Scanner(System.in);
            System.out.println("OPÇÕES:");
            System.out.println("1 - Inserir uma nova casa");
            System.out.println("2 - Buscar por uma casa");
            System.out.println("3 - Listar todos as casas");
            System.out.println("0 - Saiiir");
            
            int opcao = Integer.parseInt(scanner.nextLine());
           
            switch (opcao) {
                case 1: {
                    inserirCasa(scanner);
                    break;
                }
                case 2: {
                    buscarCasa(scanner);
                    break;
                }
                case 3: {
                    listarCasas(scanner);
                    break;
                }
            }
            
            if(opcao == 0){
                break;
            }
        }
        
       
    }
    
    protected static void listarCasas(Scanner scanner){
        System.out.println("Lista das Casas:");
        System.out.println("--------");
        
        CasaDAO casaDAO = new CasaDAO();
        
        List<Casa> casas = casaDAO.obterTodos();
        
        for(Casa c : casas){
            System.out.println(" ID: " + c.getId() + "\n Título: " + c.getTitulo() + "\n Preço: " + c.getPreco() + "\n Endereço Comp: " + c.getEnderecoComp());
            System.out.println("------------------");
        }
        
        if(casas.isEmpty()){
            System.out.println("Não existem Casas Cadastradas");
        }
    } 
    
    protected static void buscarCasa(Scanner scanner){
        System.out.println("Pesquisar por uma Casa de Praia");
        System.out.println("Entre com o ID:");
        int id = Integer.parseInt(scanner.nextLine());
        
        CasaDAO casaDAO = new CasaDAO();
        Casa casa = casaDAO.obter(id);
        
        if(casa == null){
            System.out.println("Casa de ID " + id + " não foi encontrada");
        }else{
            System.out.println(" ID: " + casa.getId() + "\n Título: " + casa.getTitulo() + "\n Preço: " + casa.getPreco() + "\n QTD de Quartos: " + casa.getQtd_quarto() + "\n QTD de Banheiros: " + casa.getQtd_banheiro()+ "\n Foto: " + casa.getFoto()+ "\n Endereço Comp: " + casa.getEnderecoComp());
        }
    } 
    
    protected static void inserirCasa(Scanner scanner){
        System.out.println("Insira uma Nova Casa");
        
        System.out.println("Digite o ID da Casa");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com o titulo: ");
        String titulo = scanner.nextLine();
        
        System.out.println("Entre com o preço: ");
        int preco = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com a quantidade de quartos: ");
        int qtdQuarto = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com a quantidade de banheiros: ");
        int qtdBanheiros = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Entre com a URL da Foto: ");
        String foto = scanner.nextLine();
        
        System.out.println("Entre com o endereço: ");
        String endereco = scanner.nextLine();
        
        System.out.println("Entre com a cidade: ");
        String cidade = scanner.nextLine();
        
        System.out.println("Entre com o estado: ");
        String estado = scanner.nextLine();
        
        
        CasaDAO casaDAO = new CasaDAO();
        boolean sucesso = casaDAO.inserir(id, titulo, preco, qtdQuarto, qtdBanheiros, foto, endereco, cidade, estado);
        
        if(sucesso){
            System.out.println("Casa cadastrada com sucesso");
        }else{
            System.out.println("Não foi possivel cadastrar esta casa");
        }
        
    } 
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuInicialCasa(scanner);
        scanner.close();
    
    }
}
