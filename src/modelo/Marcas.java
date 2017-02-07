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
     * @param nombre 
     */
    public Marcas(String nombre) {
        this.nombre = nombre;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
  
    public void crearCine() throws SQLException {
        bd.actualizarTabla("insert into cine values(null, '"
                + nombre + "', '"
                + cif + "', '"
                + direccion + "', '"
                + poblacion + "', "
                + cp + ")");
    }

   
    public Cine mostrarCineId(int _idCine) throws SQLException {
        Cine miCine = new Cine();
        rs = bd.consultarTabla("select * from  cine where idCine = " + _idCine);
        while (rs.next()) {
            miCine.setIdCine(rs.getInt("idCine"));
            miCine.setNombre(rs.getString("nombre_cin"));
            miCine.setCif(rs.getString("cif_cin"));
            miCine.setDireccion(rs.getString("direccion_cin"));
            miCine.setPoblacion(rs.getString("poblacion_cin"));
            miCine.setCp(rs.getInt("cp_cin"));
        }
        return miCine;
    }

    
    public static ArrayList<Cine> mostrarCines(ArrayList listaCines) throws SQLException {
        ResultSet res;
        Cine miCine = new Cine();
        res = bd.consultarTabla("select * from cine");
        listaCines.clear();
        while(res.next()) {
            miCine = new Cine();
            miCine.setIdCine(res.getInt("idCine"));
            miCine.setNombre(res.getString("nombre_cin"));
            miCine.setCif(res.getString("cif_cin"));
            miCine.setDireccion(res.getString("direccion_cin"));
            miCine.setPoblacion(res.getString("poblacion_cin"));
            miCine.setCp(res.getInt("cp_cin"));
            listaCines.add(miCine);
        }
        System.out.println("hola 6");
        return listaCines;
    }

   
    public void modificarMarca() throws SQLException {
        bd.actualizarTabla("Update marca set nombre_cin = '"
                + nombre + "', cif_cin = '"
                + cif + "', direccion_cin = '"
                + direccion + "', poblacion_cin = '"
                + poblacion + "', cp_cin = "
                + cp + " where idCine = " + idCine);
    }
    
    
    public void borrarMarcaID(int _idMarca) throws SQLException {
        bd.actualizarTabla("Delete from marca where idCine = " + _idMarca);
    }

    
// </editor-fold>
    
    
    
    
    
}
