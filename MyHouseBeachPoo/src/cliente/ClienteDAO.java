/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conta
 */
public class ClienteDAO {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/myhousebeachbd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    
    
    public boolean inserir(int id, String nome, String cpf, String email, String endereco, String cidade, String estado, String login, String senha){
        boolean sucesso = false;
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO cliente (id, nome, cpf, email, endereco, cidade, estado, login, senha) VALUES (?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            ps.setString(4, email);
            ps.setString(5, endereco);
            ps.setString(6, cidade);
            ps.setString(7, estado);
            ps.setString(8, login);
            ps.setString(9, senha);
          
            
            
            sucesso = (ps.executeUpdate() == 1);
            
            
            ps.close();
            c.close();
            
            
        }catch (Exception ex) {
            sucesso = false;
            System.out.println("METHOD inserir do cliente - " + ex);
        }
        
        
        return sucesso;
    }
    
        
    public List<Cliente> obterTodos(){
        List<Cliente> clientes = new ArrayList<Cliente>();
         
        try {
         Class.forName(DRIVER);
         Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement ps = c.prepareStatement("SELECT id, nome, email, login, cpf FROM cliente");   
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setLogin(rs.getString("login"));
            cliente.setCpf(rs.getString("cpf"));
            clientes.add(cliente);
         }
         
         rs.close();
         ps.close();
         c.close();
         
         
        } catch (Exception ex) {
            System.out.println("METHOD obterTodos do cliente - " + ex);
            clientes = new ArrayList<Cliente>();
        }
        
        return clientes;
    }
        
    
    public Cliente obter(int id){
        Cliente cliente = null;
        
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT nome, email, login, cpf, endereco, cidade, estado FROM cliente WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(id);
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setLogin(rs.getString("login"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEnderecoComp(rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"));
            }
            rs.close();
            ps.close();
            c.close();

        }catch (Exception ex) {
            System.out.println("METHOD obter do cliente - " + ex);
            cliente = null;
        }
        return cliente;
    }
    
    public boolean atualizar(int id, String nome, String email, String cpf, String login, String senha){
        boolean sucesso = false;
        
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE cliente SET nome = ?, email = ?, cpf = ?, login = ?, senha = ? WHERE id = ?");
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, cpf);
            ps.setString(4, login);
            ps.setString(5, senha);
            ps.setInt(6, id);
            
            sucesso = (ps.executeUpdate() == 1);
            
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println("METHOD atualizar do cliente - " + ex);
            sucesso = false;
        }
        return sucesso;
        
    }
    
    public boolean remover(int id){
        boolean sucesso = false;
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM cliente WHERE id = ?");
            ps.setInt(1, id);
            
            sucesso = (ps.executeUpdate() == 1);
            
            ps.close();
            c.close();
        }catch (Exception ex) {
            System.out.println("METHOD remover do cliente - " + ex);
            sucesso = false;
        }
        return sucesso;
    }
}