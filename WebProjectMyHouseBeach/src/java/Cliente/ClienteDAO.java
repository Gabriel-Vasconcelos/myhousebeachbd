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
 * @author aluno
 */
public class ClienteDAO {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/myhousebeachbd";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "ufc123";
    
    public boolean inserir(String nome, String email, String cpf, String genero, String rua, int number, String complemento, String cidade, String estado, String cep, String login, String senha){
        boolean sucesso = false;
        try{
            Class.forName(DRIVER);
            Connection c = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO pessoa (nome, email, cpf, genero, login, senha) VALUES (?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, cpf);
            ps.setString(4, genero);
            ps.setString(5, login);
            ps.setString(6, senha);
            
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        }catch (Exception ex) {
            sucesso = false;
        }
        return sucesso;
    }
}
