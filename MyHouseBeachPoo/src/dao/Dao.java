/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author gabriel
 */
public abstract class Dao {
    
    public boolean inserir(){
        System.out.println("Insira os parâmetros corretamente");
        return false;
    }
    
    public boolean atualizar(){
        System.out.println("Insira os parâmetros corretamente");
        return false;
    }
    
    public boolean remover(){
        System.out.println("É necessário passar o ID como parâmetro");
        return false;
    }
    
    public abstract List<?> obterTodos();
    
    public abstract Object obter(int id);
}
