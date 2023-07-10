/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author gabriel
 */
public interface InterfaceDao {
    
    public static final String DRIVER = "org.postgresql.Driver";
    // Acrescente o nome do Banco de Dados depois da última barra
    public static final String URL = "jdbc:postgresql://localhost:5432/myhousebeachbd"; 
    public static final String USUARIO = "postgres";
    //Coloque a senha do pgadmin aqui
    public static final String SENHA = "123456"; 
}
