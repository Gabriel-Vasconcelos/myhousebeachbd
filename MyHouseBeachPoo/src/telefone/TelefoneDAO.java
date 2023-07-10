/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telefone;

import dao.InterfaceDao;
import dao.Dao;

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
public class TelefoneDAO extends Dao implements InterfaceDao {
    
    public boolean inserir(int clienteId, int id, int ddd, int numero){
        boolean sucesso = false;
        
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO telefone (id, cliente_id, ddd, numero) VALUES (?, ?,?,?)");
            
            ps.setInt(1, id);
            ps.setInt(2, clienteId);
            ps.setInt(3, ddd);
            ps.setInt(4, numero);
            
            sucesso = (ps.executeUpdate() == 1);
            
            ps.close();
            
            c.close();
            
        }catch(Exception ex){
            sucesso = false;
            System.out.println("METHOD inserir do telefone - " + ex);
        }
        
        return sucesso;
    }
    
    @Override
    public List<Telefone> obter(int clienteId){
        List<Telefone> telefones = new ArrayList<Telefone>();

        
        try {
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT nome, telefone.id, ddd, numero FROM telefone, cliente WHERE cliente_id = ? and cliente.id = ?");
            ps.setInt(1, clienteId);
            ps.setInt(2, clienteId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("id"));
                telefone.setCliente_id(clienteId);
                telefone.setDdd(rs.getInt("ddd"));
                telefone.setNumero(rs.getInt("numero"));
                telefone.setNomeCliente(rs.getString("nome"));
                telefones.add(telefone);
            }
            
            rs.close();
            ps.close();
            c.close();
            
            
        } catch (Exception ex) {
            System.out.println("METHOD obter do Telefone- " + ex);
            telefones = new ArrayList<Telefone>();
        }
        
        return telefones;
       
    }
    
    @Override
    public List<Telefone> obterTodos(){
        List<Telefone> telefones = new ArrayList<Telefone>();

        
        try {
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, cliente_id, ddd, numero FROM telefone");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("id"));
                telefone.setCliente_id(rs.getInt("cliente_id"));
                telefone.setDdd(rs.getInt("ddd"));
                telefone.setNumero(rs.getInt("numero"));
                telefones.add(telefone);
            }
            
            rs.close();
            ps.close();
            c.close();
            
            
        } catch (Exception ex) {
            System.out.println("METHOD obterTodos do Telefone- " + ex);
            telefones = new ArrayList<Telefone>();
        }
        
        return telefones;
       
    }
    
    protected boolean atualizar(int id, int ddd, int numero){
        boolean sucesso = false;
        
        try {
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE telefone SET ddd = ?, numero = ? WHERE id = ?");
            ps.setInt(1, ddd);
            ps.setInt(2, numero);
            ps.setInt(3, id);
            
            sucesso = (ps.executeUpdate() == 1);

            ps.close();
            c.close();
            
        } catch (Exception ex) {
            System.out.println("METHOD atualizar do telefone - " + ex);
            sucesso = false;
        }
        
        return sucesso;
    }
    
    protected boolean remover(int id){
        boolean sucesso = false;
        
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM telefone WHERE id = ?");
            ps.setInt(1, id);
            
            sucesso = (ps.executeUpdate() == 1);
            
            ps.close();
            c.close();
            
        } catch (Exception ex) {
            System.out.println("METHOD remover do telefone - " + ex);
            sucesso = false;
        }
        
        return sucesso;
    }
}
