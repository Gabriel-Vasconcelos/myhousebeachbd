/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casa;

/**
 *
 * @author conta
 */
public class Casa {
    private int id;
    private String titulo;
    private int preco;
    private int qtd_quarto;
    private int qtd_banheiro;
    private String foto;
    private String endereco;
    private String cidade;
    private String estado;

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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the preco
     */
    public int getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(int preco) {
        this.preco = preco;
    }

    /**
     * @return the qtd_quarto
     */
    public int getQtd_quarto() {
        return qtd_quarto;
    }

    /**
     * @param qtd_quarto the qtd_quarto to set
     */
    public void setQtd_quarto(int qtd_quarto) {
        this.qtd_quarto = qtd_quarto;
    }

    /**
     * @return the qtd_banheiro
     */
    public int getQtd_banheiro() {
        return qtd_banheiro;
    }

    /**
     * @param qtd_banheiro the qtd_banheiro to set
     */
    public void setQtd_banheiro(int qtd_banheiro) {
        this.qtd_banheiro = qtd_banheiro;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
