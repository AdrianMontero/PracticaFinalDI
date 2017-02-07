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
public class Eficiencia {
    private int idEficiencia;
    private String nombre;
    private String imageName;

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getIdEficiencia() {
        return idEficiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImageName() {
        return imageName;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setIdEficiencia(int idEficiencia) {
        this.idEficiencia = idEficiencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    
    /**
     * Constructor vacio.
     */
    public Eficiencia() {
    }
    
    /**
     * Contructor con id para la modificacion de Eficiencia.
     * @param idEficiencia
     * @param nombre
     * @param imageName 
     */
    public Eficiencia(int idEficiencia, String nombre, String imageName) {
        this.idEficiencia = idEficiencia;
        this.nombre = nombre;
        this.imageName = imageName;
    }
    
    /**
     * Constructor sin id para la creacion de nueva Eficiencia.
     * @param nombre
     * @param imageName 
     */
    public Eficiencia(String nombre, String imageName) {
        this.nombre = nombre;
        this.imageName = imageName;
    }
    // </editor-fold>

    

    
}
