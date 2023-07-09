/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.util.List;

import enderecocomp.EnderecoComp;


/**
 *
 * @author conta
 */
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private EnderecoComp enderecoComp;
    private String login;
    private String senha;
    
    public Cliente(){
        this.enderecoComp = new EnderecoComp();
    }
    
    
    public String getEnderecoComp(){
        return enderecoComp.getEndereco() + "," + enderecoComp.getCidade() + "-" + enderecoComp.getEstado();
    }
    
    public void setEnderecoComp(String endereco, String cidade, String estado){
        enderecoComp.setEndereco(endereco);
        enderecoComp.setCidade(cidade);
        enderecoComp.setEstado(estado);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

   
}
