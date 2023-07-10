/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donodacasa;

import cliente.Cliente;
import casa.Casa;

/**
 *
 * @author conta
 */
public class DonoDaCasa extends Cliente{
     private int casa_id;
     private int cliente_id;
     
    /**
     * @return the casa_id
     */
    public int getCasa_id() {
        return casa_id;
    }

    /**
     * @param casa_id the casa_id to set
     */
    public void setCasa_id(int casa_id) {
        this.casa_id = casa_id;
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
    
    
    
}
