/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juanxxiii
 */
public class Marcas {

    private int idMarca;
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getIdMarca() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor vacio.
     */
    public Marcas() {
    }

    /**
     *
     * @param idMarca
     * @param nombre
     */
    public Marcas(int idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    /**
     * Constructor sin id para la creacion de marcas.
     *
     * @param nombre
     */
    public Marcas(String nombre) {
        this.nombre = nombre;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    /**
     * Crea nueva marca.
     *
     * @throws SQLException
     */
    public void crearMarca() throws SQLException {
        bd.actualizarTabla("insert into marca values(null, '" + nombre + ")");
    }

    /**
     * 
     * @param _idMarca
     * @return
     * @throws SQLException 
     */
    public Marcas mostrarMarcaId(int _idMarca) throws SQLException {
        ResultSet res;
        Marcas miMarca = new Marcas();
        res = bd.consultarTabla("select * from  marca where idMarca = " + _idMarca);
        while (res.next()) {
            miMarca.setNombre(res.getString("nombre"));
        }
        return miMarca;
    }
    
    /**
     * 
     * @param listaMarcas
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Marcas> mostrarMarcas(ArrayList listaMarcas) throws SQLException {
        ResultSet res;
        Marcas miMarca = new Marcas();
        res = bd.consultarTabla("select * from marca");
        listaMarcas.clear();
        while (res.next()) {
            miMarca = new Marcas();
            miMarca.setNombre(res.getString("nombre"));

            listaMarcas.add(miMarca);
        }

        return listaMarcas;
    }
    
    /**
     * 
     * @param nombre
     * @param _idMarca
     * @throws SQLException 
     */
    public void modificarMarca(String nombre, int _idMarca) throws SQLException {
        bd.actualizarTabla("Update marca set nombre = '"+ nombre + "' where idCine = " + _idMarca);
    }

    /**
     * 
     * @param _idMarca
     * @throws SQLException 
     */
    public void borrarMarcaID(int _idMarca) throws SQLException {
        bd.actualizarTabla("Delete from marca where idCine = " + _idMarca);
    }

// </editor-fold>
}