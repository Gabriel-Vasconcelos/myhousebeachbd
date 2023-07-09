/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donodacasa;

import cliente.ClienteDAO;

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
public class DonoDaCasaDAO extends ClienteDAO{
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/myhousebeachbd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    
    
    public boolean inserir(int clienteId, int casaId){
        boolean sucesso = false;
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO dono_da_casa (cliente_id, casa_id) VALUES (?, ?)");
            
            ps.setInt(1, clienteId);
            ps.setInt(2, casaId);
          
            
            
            sucesso = (ps.executeUpdate() == 1);
            
            
            ps.close();
            c.close();
            
            
        }catch (Exception ex) {
            sucesso = false;
            System.out.println("METHOD inserir do dono da casa - " + ex);
        }
        
        return sucesso;
    }
    
    public DonoDaCasa obter(int ClientId){
        DonoDaCasa donoDaCasa = null;
        
        try {
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT cliente_id, casa_id FROM dono_da_casa WHERE cliente_id = ?");
            ps.setInt(1, ClientId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                donoDaCasa = new DonoDaCasa();
                donoDaCasa.setCliente_id(ClientId);
                donoDaCasa.setCasa_id(rs.getInt("casa_id"));
            }
            
            rs.close();
            ps.close();
            c.close();
            
        } catch (Exception ex) {
            System.out.println("METHOD obter do dono da casa - " + ex);
            donoDaCasa = null;
        }
        
        return donoDaCasa;
    }
    
    
    
    public List<DonoDaCasa> obterTodosDonos(){
        List<DonoDaCasa> donos = new ArrayList<DonoDaCasa>();
         
        try {
         Class.forName(DRIVER);
         Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement ps = c.prepareStatement("SELECT cliente_id, casa_id FROM dono_da_casa");   
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()){
            DonoDaCasa dono = new DonoDaCasa();
            dono.setCliente_id(rs.getInt("cliente_id"));
            dono.setCasa_id(rs.getInt("casa_id"));
            donos.add(dono);
         }
         
         rs.close();
         ps.close();
         c.close();
         
         
        } catch (Exception ex) {
            System.out.println("METHOD obterTodosDonos do Dono Da Casa - " + ex);
            donos = new ArrayList<DonoDaCasa>();
        }
        
        return donos;
    }
}
