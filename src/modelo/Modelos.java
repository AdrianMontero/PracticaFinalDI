/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import core.BDCore;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author juanxxiii
 */
public class Modelos {

    //Metodos para interactuar con la BD.
    private static BDCore bd = new BDCore();
    private static String sql = null;
    private static ResultSet rs = null;

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
     *
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
     *
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
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    /**
     *
     * @throws SQLException
     */
    public void crearModelo() throws SQLException {
        bd.actualizarTabla("insert into modelo values(null, " + idModelo + "," + idMarca + ",'" + nombre + ",'" + consumo + "'," + emisiones + "," + idEficiencia + ")");
    }

    /**
     *
     * @param _idModelo
     * @return
     * @throws SQLException
     */
    public Modelos mostrarModeloId(int _idModelo) throws SQLException {
        ResultSet res;
        Modelos miModelo = new Modelos();
        res = bd.consultarTabla("select * from modelo  where id_mod = " + _idModelo);
        while (res.next()) {
            miModelo.setIdMarca(res.getInt("id_mar"));
            miModelo.setIdEficiencia(res.getInt("id_efi"));
            miModelo.setNombre(res.getString("nombre_mod"));
            miModelo.setConsumo(res.getInt("consumo_mod"));
            miModelo.setEmisiones(res.getFloat("emisiones_mod"));

        }
        return miModelo;
    }

    /**
     *
     * @param listaModelos
     * @return
     * @throws SQLException
     */
    public static ArrayList<Modelos> mostrarModelos(ArrayList listaModelos) throws SQLException {
        ResultSet res;
        Modelos miModelo = new Modelos();
        res = bd.consultarTabla("select * from modelo");
        listaModelos.clear();
        while (res.next()) {
            miModelo = new Modelos();
            miModelo.setIdModelo(res.getInt("id_mod"));           
            miModelo.setIdMarca(res.getInt("id_mar"));
            miModelo.setIdEficiencia(res.getInt("id_efi"));
            miModelo.setNombre(res.getString("nombre_mod"));
            miModelo.setConsumo(res.getInt("consumo_mod"));
            miModelo.setEmisiones(res.getFloat("emisiones_mod"));

            listaModelos.add(miModelo);
        }

        return listaModelos;
    }

    /**
     *
     * @throws SQLException
     */
    public void modificarModelo() throws SQLException {
        bd.actualizarTabla("Update modelo set id_mar = " + idMarca + ", id_efi = " + idEficiencia + ",nombre_mod = " + nombre + ",consumo_mod = " + consumo + ",emisiones_mod = " + emisiones + "  where id_mar = " + idMarca);
    }

    /**
     *
     * @param _idModelo
     * @throws SQLException
     */
    public void borrarModeloID(int _idModelo) throws SQLException {
        bd.actualizarTabla("Delete from marca where id_mod = " + _idModelo);
    }

// </editor-fold>
}
