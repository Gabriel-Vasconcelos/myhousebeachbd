/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

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
    private static final String SENHA = "codi123";
    
    
    public boolean inserir(int id, String nome, String email, String cpf, String genero, String rua, int number, String complemento, String cidade, String estado, String cep, String login, String senha){
        boolean sucesso = false;
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO pessoa (id, nome, email, cpf, genero, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, email);
            ps.setString(5, cpf);
            ps.setString(5, genero);
            ps.setString(6, login);
            ps.setString(7, senha);
            
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        }catch (Exception ex) {
            sucesso = false;
        }
        return sucesso;
    }
    
    public Cliente obter(int id){
        Cliente cliente = null;
        
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT nome, email, login, cpf FROM cliente WHERE codigo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setLogin(rs.getString("login"));
                cliente.setCpf(rs.getString("cpf"));
            }
            rs.close();
            ps.close();
            c.close();

        }catch (Exception ex) {
            cliente = null;
        }
        return cliente;
    }
    
    public boolean atualizar(int id, String nome, String email, String cpf, String genero, String login, String senha){
        boolean sucesso = false;
        
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE cliente SET nome = ?, email = ?, cpf = ?, genero = ?, login = ?, senha = ? WHERE id = ?");
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, cpf);
            ps.setString(4, genero);
            ps.setString(5, login);
            ps.setString(6, senha);
            ps.setInt(7, id);
            ps.close();
            c.close();
        } catch (Exception ex) {
            sucesso = false;
        }
        return sucesso;
        
    }
    
    public boolean remover(int id){
        boolean sucesso = false;
        try{
            Class.forName(DRIVER);
            Connection c= DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM cliente WHERE id = ?");
            ps.setInt(1, id);
            sucesso = (ps.executeUpdate() == 1);
            
            ps.close();
            c.close();
        }catch (Exception ex) {
            sucesso = false;
        }
        return sucesso;
    }
}
