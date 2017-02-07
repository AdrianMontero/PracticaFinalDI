/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author juanxxiii
 */
public class Modelos {
    private int idModelo;
    private int idMarca;
    private String nombre;
    private int consumo;
    private float emisiones;
    private int idEficiencia;

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getIdModelo() {
        return idModelo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public int getConsumo() {
        return consumo;
    }

    public float getEmisiones() {
        return emisiones;
    }

    public int getIdEficiencia() {
        return idEficiencia;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public void setEmisiones(float emisiones) {
        this.emisiones = emisiones;
    }

    public void setIdEficiencia(int idEficiencia) {
        this.idEficiencia = idEficiencia;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor vacio.
     */
    public Modelos() {
    }
    
    /**
     * Constructor con id para la modificacion de modelos.
     * @param idModelo
     * @param idMarca
     * @param nombre
     * @param consumo
     * @param emisiones
     * @param idEficiencia 
     */
    public Modelos(int idModelo, int idMarca, String nombre, int consumo, float emisiones, int idEficiencia) {
        this.idModelo = idModelo;
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.consumo = consumo;
        this.emisiones = emisiones;
        this.idEficiencia = idEficiencia;
    }
    /**
     * Constructor sin id para la creacion de modelo.
     * @param idMarca
     * @param nombre
     * @param consumo
     * @param emisiones
     * @param idEficiencia 
     */
    public Modelos(int idMarca, String nombre, int consumo, float emisiones, int idEficiencia) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.consumo = consumo;
        this.emisiones = emisiones;
        this.idEficiencia = idEficiencia;
    }
    
    
// </editor-fold>
    
    
    
}
