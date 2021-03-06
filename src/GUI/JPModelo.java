/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Eficiencia;
import modelo.Marcas;
import modelo.Modelos;

/**
 * Formularios de creación, modificación, consulta y borrado de modelos.
 * 
 * @author GreenMonster
 */
public class JPModelo extends javax.swing.JPanel {

    private void PropiedadesTabla(int idModelo) throws SQLException {
        //Cargamos los modelos en "misModelos"
        misModelos.clear();
        miModelo = new Modelos();
        miMarca = new Marcas();

        Modelos.mostrarModelos(misModelos);
        for (int i = 0; i < misModelos.size(); i++) {
            if (misModelos.get(i).getIdModelo() == idModelo) {
                miModelo = misModelos.get(i);
            }
        }

        //Cargamos las eficiencias en "misEficiencias"
        misEficiencias.clear();
        miEficiencia = new Eficiencia();

        Eficiencia.mostrarEficiencias(misEficiencias);
        for (int i = 0; i < misEficiencias.size(); i++) {
            if (misEficiencias.get(i).getIdEficiencia() == miModelo.getIdEficiencia()) {
                miEficiencia = misEficiencias.get(i);
            }
        }

        //Cargamos las marcas en "misMarcas"
        misMarcas.clear();
        miMarca = new Marcas();

        Marcas.mostrarMarcas(misMarcas);
        for (int i = 0; i < misMarcas.size(); i++) {
            if (misMarcas.get(i).getIdMarca() == miModelo.getIdMarca()) {
                miMarca = misMarcas.get(i);
            }
        }

        jtConsultar.setDefaultRenderer(Object.class, new ImgTabla());
        DefaultTableModel tm = (DefaultTableModel) jtConsultar.getModel();
        tm.setRowCount(0);
        tm.addRow(new Object[]{miMarca.getNombre(), miModelo.getNombre(), miModelo.getConsumo(), miModelo.getEmisiones(), new JLabel(new ImageIcon(getClass().getResource(miEficiencia.getImageName().toString())))});

        jtConsultar.setModel(tm);
    }

    /**
     * Clase usada para guardar imagenes en jTable
     */
    public class ImgTabla extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JLabel) {
                JLabel lbl = (JLabel) value;
                return lbl;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    ArrayList<Modelos> misModelos = new ArrayList();
    Modelos miModelo;

    ArrayList<Marcas> misMarcas = new ArrayList();
    Marcas miMarca;

    ArrayList<Eficiencia> misEficiencias = new ArrayList();
    Eficiencia miEficiencia;

    /**
     * Creates new form JPModelo
     */
    public JPModelo() {

        initComponents();
        String stringIdModelo;
        String stringNombreModelo;
        String stringIdMarca;
        String stringIdEficiencia;
        String titulos[] = {"Nombre marca", "Nombre modelo", "Consumo", "Emisiones", "Imagen"};
        DefaultTableModel tm = new DefaultTableModel(null, titulos);
        /**
         * Carga los ComboBox de marcas al crear un modelo.
         */
        try {
            Marcas.mostrarMarcas(misMarcas);
            for (int i = 0; i < misMarcas.size(); i++) {
                miMarca = (Marcas) misMarcas.get(i);
                stringIdMarca = String.valueOf(miMarca.getIdMarca());
                System.out.println(stringIdMarca);

                jcbIdMarcaCrear.addItem(stringIdMarca);
                jcbIdMarcaMod.addItem(stringIdMarca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Carga el ComboBox de idEficiencia al crear un nuevo modelo.
         */
        try {
            Eficiencia.mostrarEficiencias(misEficiencias);
            for (int i = 0; i < misEficiencias.size(); i++) {
                miEficiencia = (Eficiencia) misEficiencias.get(i);
                stringIdEficiencia = String.valueOf(miEficiencia.getIdEficiencia());

                jcbIdEficienciaCrear.addItem(stringIdEficiencia);
                jcbIdEficienciaMod.addItem(stringIdEficiencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Carga el ComboBox de modelos para cada uno de las vistas.
         */
        try {
            Modelos.mostrarModelos(misModelos);
            for (int i = 0; i < misModelos.size(); i++) {

                miModelo = (Modelos) misModelos.get(i);
                stringIdModelo = String.valueOf(miModelo.getIdModelo());
                stringNombreModelo = String.valueOf(miModelo.getNombre());

                jcbIdModeloMod.addItem(stringIdModelo);
                jcbIdModeloCon.addItem(stringIdModelo);
                jcbIdModeloBorrar.addItem(stringIdModelo);

                jtfNombreModeloCon.setText(stringNombreModelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPMarca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbIdMarcaCrear = new javax.swing.JComboBox<>();
        jtfNombreModeloCrear = new javax.swing.JTextField();
        jcbIdEficienciaCrear = new javax.swing.JComboBox<>();
        jbCrearModelo = new javax.swing.JButton();
        jsConsumoCrear = new javax.swing.JSlider();
        jtfEmisionesCrear = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcbIdEficienciaMod = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfNombreModeloMod = new javax.swing.JTextField();
        jcbIdMarcaMod = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbIdModeloMod = new javax.swing.JComboBox<>();
        jbModificarModelo = new javax.swing.JButton();
        jtfEmisionesMod = new javax.swing.JTextField();
        jtfConsumoMod = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbIdModeloCon = new javax.swing.JComboBox<>();
        jtfNombreModeloCon = new javax.swing.JTextField();
        jbConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultar = new javax.swing.JTable();
        jcbBorrarTabla = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbIdModeloBorrar = new javax.swing.JComboBox<>();
        jtfNombreModeloBorrar = new javax.swing.JTextField();
        jbBorrrar = new javax.swing.JButton();

        jLabel1.setText("Id Marca:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Consumo (l/100km):");

        jLabel4.setText("Emisiones( gCO2/km):");

        jLabel5.setText("Id Eficiencia:");

        jcbIdMarcaCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdMarcaCrearActionPerformed(evt);
            }
        });

        jbCrearModelo.setText("Crear Modelo");
        jbCrearModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearModeloActionPerformed(evt);
            }
        });

        jsConsumoCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsConsumoCrearMouseClicked(evt);
            }
        });

        jLabel16.setText("Consumo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCrearModelo)
                    .addComponent(jcbIdMarcaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNombreModeloCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jsConsumoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfEmisionesCrear, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcbIdEficienciaCrear, javax.swing.GroupLayout.Alignment.LEADING, 0, 65, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbIdMarcaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNombreModeloCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jsConsumoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfEmisionesCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbIdEficienciaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbCrearModelo)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Crear Modelo", jPanel1);

        jLabel6.setText("Id Eficiencia:");

        jLabel7.setText("Emisiones( gCO2/km):");

        jLabel8.setText("Consumo (l/100km):");

        jLabel9.setText("Nombre:");

        jLabel10.setText("Id Marca:");

        jLabel11.setText("Id Modelo:");

        jcbIdModeloMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdModeloModActionPerformed(evt);
            }
        });

        jbModificarModelo.setText("Modificar Modelo");
        jbModificarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbIdModeloMod, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbIdMarcaMod, javax.swing.GroupLayout.Alignment.LEADING, 0, 68, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addComponent(jbModificarModelo)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombreModeloMod, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfConsumoMod, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfEmisionesMod, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbIdEficienciaMod, javax.swing.GroupLayout.Alignment.LEADING, 0, 65, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcbIdModeloMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificarModelo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcbIdMarcaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfNombreModeloMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfConsumoMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfEmisionesMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbIdEficienciaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("Modificar Modelo", jPanel2);

        jLabel14.setText("Id Modelo:");

        jLabel15.setText("Nombre Modelo:");

        jcbIdModeloCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdModeloConActionPerformed(evt);
            }
        });

        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jtConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Marca", "Nombre Modelo", "Consumo", "Emisiones", "Imagen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtConsultar);

        jcbBorrarTabla.setText("Borrar Tabla");
        jcbBorrarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBorrarTablaActionPerformed(evt);
            }
        });

        jbExportar.setText("Exportar a Excel");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNombreModeloCon, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbIdModeloCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jbConsultar)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbExportar)
                        .addContainerGap(183, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbBorrarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jcbIdModeloCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConsultar)
                    .addComponent(jcbBorrarTabla))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtfNombreModeloCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExportar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar Modelo", jPanel3);

        jLabel12.setText("Id Modelo:");

        jLabel13.setText("Nombre Modelo:");

        jcbIdModeloBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIdModeloBorrarActionPerformed(evt);
            }
        });

        jbBorrrar.setText("Borrar por Nombre");
        jbBorrrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbIdModeloBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtfNombreModeloBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrrar)))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jcbIdModeloBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtfNombreModeloBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBorrrar))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Borrar Modelo", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearModeloActionPerformed
        // TODO add your handling code here:
        if (jtfNombreModeloCrear.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No se puede crear con el campo nombre en blanco");
        } else if(jtfEmisionesCrear.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "No se puede crear con el campo emision en blanco");
        }else{
            miModelo.setIdMarca(Integer.parseInt((String) jcbIdMarcaCrear.getSelectedItem()));
            miModelo.setNombre(jtfNombreModeloCrear.getText());
            miModelo.setConsumo(jsConsumoCrear.getValue());
            System.out.println(jsConsumoCrear.getValue());
            miModelo.setEmisiones(Integer.parseInt(jtfEmisionesCrear.getText()));
            miModelo.setIdEficiencia(Integer.parseInt((String) jcbIdEficienciaCrear.getSelectedItem()));
            
            JOptionPane.showMessageDialog(null, "Modelo creado", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            try {
                miModelo.crearModelo();
            } catch (SQLException ex) {
                //Logger.getLogger(JPMarca.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error durante la creacion del modelo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCrearModeloActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        try {
            PropiedadesTabla(Integer.parseInt(jcbIdModeloCon.getSelectedItem().toString()));
        } catch (SQLException ex) {
            System.out.println("buscar el modelo");
            Logger.getLogger(JPModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jcbIdModeloConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdModeloConActionPerformed
        // TODO add your handling code here:

        int modeloBuscado;
        modeloBuscado = jcbIdModeloCon.getSelectedIndex();
        miModelo = misModelos.get(modeloBuscado);

        jtfNombreModeloCon.setText(miModelo.getNombre());


    }//GEN-LAST:event_jcbIdModeloConActionPerformed

    private void jcbIdModeloBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdModeloBorrarActionPerformed
        // TODO add your handling code here:

        int modeloBuscado;
        modeloBuscado = jcbIdModeloBorrar.getSelectedIndex();
        miModelo = misModelos.get(modeloBuscado);

        jtfNombreModeloBorrar.setText(miModelo.getNombre());
    }//GEN-LAST:event_jcbIdModeloBorrarActionPerformed

    private void jbBorrrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrrarActionPerformed
        // TODO add your handling code here:
        int idModelo;

        idModelo = Integer.parseInt(jcbIdModeloBorrar.getSelectedItem().toString());
        try {
            miModelo.borrarModeloID(idModelo);
            JOptionPane.showMessageDialog(null, "Modelo borrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error durante el borrado del modelo", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbBorrrarActionPerformed

    private void jsConsumoCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsConsumoCrearMouseClicked
        jLabel16.setText(String.valueOf(jsConsumoCrear.getValue()));
    }//GEN-LAST:event_jsConsumoCrearMouseClicked

    private void jcbIdModeloModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdModeloModActionPerformed
        int modeloBuscado;
        modeloBuscado = jcbIdModeloMod.getSelectedIndex();
        miModelo = misModelos.get(modeloBuscado);
        jtfNombreModeloMod.setText(miModelo.getNombre());
        jtfConsumoMod.setText(String.valueOf(miModelo.getConsumo()));
        jtfEmisionesMod.setText(String.valueOf(miModelo.getEmisiones()));
        jcbIdMarcaMod.setSelectedItem(String.valueOf(miModelo.getIdMarca()));
        jcbIdEficienciaMod.setSelectedItem(String.valueOf(miModelo.getIdEficiencia()));
    }//GEN-LAST:event_jcbIdModeloModActionPerformed

    private void jcbIdMarcaCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIdMarcaCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbIdMarcaCrearActionPerformed

    private void jbModificarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarModeloActionPerformed
        miModelo.setNombre(jtfNombreModeloMod.getText());
        miModelo.setConsumo(Integer.parseInt(jtfConsumoMod.getText()));
        miModelo.setEmisiones(Float.parseFloat(jtfEmisionesMod.getText()));
        miModelo.setIdMarca(Integer.parseInt((String) jcbIdMarcaMod.getSelectedItem()));
        miModelo.setIdEficiencia(Integer.parseInt((String) jcbIdEficienciaMod.getSelectedItem()));
        
        JOptionPane.showMessageDialog(null, "Modelo modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        try {
            miModelo.modificarModelo();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error durante durante la modificacion del modelo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbModificarModeloActionPerformed

    private void jcbBorrarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBorrarTablaActionPerformed
        DefaultTableModel model = (DefaultTableModel) jtConsultar.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jcbBorrarTablaActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:/modelo.xls");
            pw = new PrintWriter(fichero);
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<table border=\"2px\">");
            pw.println("<tr>");
            pw.println("<td>");
            pw.println("Nombre del modelo: ");
            pw.println("</td>");
            pw.println("<td>");
            pw.println(miModelo.getNombre());
            pw.println("</td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>");
            pw.println("Nombre del marca: ");
            pw.println("</td>");
            pw.println("<td>");
            pw.println(miMarca.getNombre());
            pw.println("</td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>");
            pw.println("Consumo: ");
            pw.println("</td>");
            pw.println("<td>");
            pw.println(miModelo.getConsumo());
            pw.println("</td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>");
            pw.println("Emisiones: ");
            pw.println("</td>");
            pw.println("<td>");
            pw.println(miModelo.getEmisiones());
            pw.println("</table>");

            
            JOptionPane.showMessageDialog(null, "Excel generado en la ubicación del programa 'modelo.xls'", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al exportar a excel", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Nos aseguramos que se cierra el fichero.
                
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//GEN-LAST:event_jbExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbBorrrar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbCrearModelo;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbModificarModelo;
    private javax.swing.JButton jcbBorrarTabla;
    private javax.swing.JComboBox<String> jcbIdEficienciaCrear;
    private javax.swing.JComboBox<String> jcbIdEficienciaMod;
    private javax.swing.JComboBox<String> jcbIdMarcaCrear;
    private javax.swing.JComboBox<String> jcbIdMarcaMod;
    private javax.swing.JComboBox<String> jcbIdModeloBorrar;
    private javax.swing.JComboBox<String> jcbIdModeloCon;
    private javax.swing.JComboBox<String> jcbIdModeloMod;
    private javax.swing.JSlider jsConsumoCrear;
    private javax.swing.JTable jtConsultar;
    private javax.swing.JTextField jtfConsumoMod;
    private javax.swing.JTextField jtfEmisionesCrear;
    private javax.swing.JTextField jtfEmisionesMod;
    private javax.swing.JTextField jtfNombreModeloBorrar;
    private javax.swing.JTextField jtfNombreModeloCon;
    private javax.swing.JTextField jtfNombreModeloCrear;
    private javax.swing.JTextField jtfNombreModeloMod;
    // End of variables declaration//GEN-END:variables
}
