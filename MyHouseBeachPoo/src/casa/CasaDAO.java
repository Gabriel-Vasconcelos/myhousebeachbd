/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casa;

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
public class CasaDAO {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/myhousebeachbd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    
    public boolean inserir(int id, String titulo, int preco, int qtdQuarto, int qtdBanheiro, String foto, String endereco, String cidade, String estado){
        boolean sucesso = false;
        
        try {
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO casa (id, titulo, preco, qtd_quarto, qtd_banheiro, foto, endereco, cidade, estado) VALUES (?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, id);
            ps.setString(2, titulo);
            ps.setInt(3, preco);
            ps.setInt(4, qtdQuarto);
            ps.setInt(5, qtdBanheiro);
            ps.setString(6, foto);
            ps.setString(7, endereco);
            ps.setString(8, cidade);
            ps.setString(9, estado);
            
            sucesso = (ps.executeUpdate() == 1);
            
            ps.close();
            c.close();
            
        } catch (Exception ex) {
            sucesso = false;
            System.out.println("METHOD inserir da casa - " + ex);
            
        }
        
        return sucesso;
    }
    
    public Casa obter(int id){
        Casa casa = null;
        
        try {
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, titulo, preco, qtd_quarto, qtd_banheiro, foto, endereco, cidade, estado FROM casa WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                casa = new Casa();
                casa.setId(id);
                casa.setTitulo(rs.getString("titulo"));
                casa.setPreco(rs.getInt("preco"));
                casa.setQtd_quarto(rs.getInt("qtd_quarto"));
                casa.setQtd_banheiro(rs.getInt("qtd_banheiro"));
                casa.setFoto(rs.getString("foto"));
                casa.setEnderecoComp(rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"));
                
            }
            
            rs.close();
            ps.close();
            c.close();
            
        } catch (Exception ex) {
            System.out.println("METHOD obter da Casa - " + ex);
            casa = null;
        }
        
        return casa;
    }
    
    public List<Casa> obterTodos(){
        List<Casa> casas = new ArrayList<Casa>();
         
        try {
         Class.forName(DRIVER);
         Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement ps = c.prepareStatement("SELECT id, titulo, preco, endereco, cidade, estado FROM casa");   
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()){
            Casa casa = new Casa();
            casa.setId(rs.getInt("id"));
            casa.setTitulo(rs.getString("titulo"));
            casa.setPreco(rs.getInt("preco"));
            casa.setEnderecoComp(rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"));
            casas.add(casa);
         }
         
         rs.close();
         ps.close();
         c.close();
         
         
        } catch (Exception ex) {
            System.out.println("METHOD obterTodos da casa - " + ex);
            casas = new ArrayList<Casa>();
        }
        
        return casas;
    }
}
