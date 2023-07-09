/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telefone;

import cliente.Cliente;

/**
 *
 * @author conta
 */
public class Telefone {
    private int id;
    private int cliente_id;
    private int ddd;
    private int numero;
    private Cliente cliente;
    
    public Telefone(){
        this.cliente = new Cliente();
    }
    
    public String getNomeCliente(){
        return cliente.getNome();
    }
    
    public void setNomeCliente(String nome){
        cliente.setNome(nome);
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
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
}
