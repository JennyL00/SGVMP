/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class MóduloEmpleados extends javax.swing.JFrame {

    Empleado nuevoEmpleado = new Empleado();
    static Empleado nuevoEmpleadoA = new Empleado();
    static String campoActualizar;

    /**
     * Creates new form Interfaz
     */
    public MóduloEmpleados() {
        initComponents();
        setLocationRelativeTo(null);

    }

    void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Numero de Cedula");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Sucursal Asignada");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM empleados";

        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void mostrarInfo(String cedula) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Numero de Cedula");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Sucursal Asignada");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM empleados WHERE numero_cedula LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException e) {

        }
    }

    boolean esEmpleado(String cedula) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Numero de C.I.");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Sucursal Asignada");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM empleados WHERE numero_cedula LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3); //cedula
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                modelo.addRow(datos);
            }
            if (datos[3] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;

    }

    void eliminarEmpleado(String cedula) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;
        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("delete from empleados WHERE numero_cedula LIKE ?");
            pstm.setString(1, cedula);
            pstm.executeUpdate();
        } catch (Exception e) {

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
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtNombreRE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoRE = new javax.swing.JTextField();
        txtCorreoRE = new javax.swing.JTextField();
        txtTelCelRE = new javax.swing.JTextField();
        btnRegistrarEmpleado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSueldoRE = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccionRE = new javax.swing.JTextField();
        btnAtrasRE = new javax.swing.JButton();
        txtCedulaRE = new javax.swing.JTextField();
        cmbSucursalAsignadaRE = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSiguienteAE = new javax.swing.JButton();
        btnAtrasAE = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCedulaAE = new javax.swing.JTextField();
        cmbCampoEmpleadoAE = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNumDocumentoCE = new javax.swing.JTextField();
        btnConsultarEmpleado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAtrasCE = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtCIEE = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JButton();
        btnAtrasEE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerente General");

        lblNombres.setText("Nombre");

        lblApellidos.setText("Apellido");

        jLabel1.setText("Correo Electrónico");

        jLabel2.setText("C.I.");

        jLabel3.setText("Teléfono Celular");

        btnRegistrarEmpleado.setText("Registrar");
        btnRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadoActionPerformed(evt);
            }
        });

        jLabel6.setText("Sueldo");

        jLabel7.setText("Dirección");

        btnAtrasRE.setText("Atrás");
        btnAtrasRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasREActionPerformed(evt);
            }
        });

        cmbSucursalAsignadaRE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matriz - Av. América", "Local - C.C Espiral", "Local - C.C El Caracol", "Local - Av. Lauro Guerrero y Av. Angulo", "Bodega - Valle" }));

        jLabel13.setText("Sucursal Asignada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtrasRE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarEmpleado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreRE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblApellidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApellidoRE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelCelRE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreoRE, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDireccionRE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(116, 116, 116))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSueldoRE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedulaRE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSucursalAsignadaRE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombreRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidoRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtCedulaRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelCelRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSueldoRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSucursalAsignadaRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasRE)
                    .addComponent(btnRegistrarEmpleado))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar Empleado", jPanel1);

        btnSiguienteAE.setText("Siguiente");
        btnSiguienteAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteAEActionPerformed(evt);
            }
        });

        btnAtrasAE.setText("Atrás");
        btnAtrasAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasAEActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Actualizar"));

        jLabel5.setText("Campo");

        jLabel14.setText("C.I.");

        cmbCampoEmpleadoAE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teléfono Celular", "Dirección", "Correo Electrónico", "Sueldo", "Sucursal Asignada" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14))
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCampoEmpleadoAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedulaAE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCedulaAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCampoEmpleadoAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAtrasAE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguienteAE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguienteAE)
                    .addComponent(btnAtrasAE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Actualizar Empleado", jPanel2);

        jLabel10.setText("C.I.");

        txtNumDocumentoCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocumentoCEActionPerformed(evt);
            }
        });

        btnConsultarEmpleado.setText("Consultar");
        btnConsultarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarEmpleadoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos"));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Teléfono Celular", "Correo Electrónico", "Dirección", "Sueldo", "Sucursal Asignada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAtrasCE.setText("Atrás");
        btnAtrasCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAtrasCE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumDocumentoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultarEmpleado)
                        .addGap(53, 53, 53))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsultarEmpleado)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel10))
                        .addComponent(txtNumDocumentoCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtrasCE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar Empleado", jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Eliminar"));

        txtCIEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCIEEActionPerformed(evt);
            }
        });

        jLabel12.setText("C.I.");

        btnEliminarCliente.setText("Eliminar Empleado");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnEliminarCliente))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtCIEE, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCIEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(41, 41, 41)
                .addComponent(btnEliminarCliente)
                .addContainerGap())
        );

        btnAtrasEE.setText("Atrás");
        btnAtrasEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasEEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAtrasEE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtrasEE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Eliminar Empleado", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoActionPerformed
        // TODO add your handling code here:
        String nombre;
        String apellido;
        String cedula;
        String telf;
        String direccion;
        String correo;
        String sueldo;
        String sucursal;
        if (txtNombreRE.getText().equals("")
                || txtApellidoRE.getText().equals("")
                || txtCedulaRE.getText().equals("")
                || txtTelCelRE.getText().equals("")
                || txtDireccionRE.getText().equals("")
                || txtCorreoRE.getText().equals("")
                || txtSueldoRE.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para registrar un empleado debe llenar TODOS los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Conexion con = new Conexion();
            Connection cn = (Connection) con.conexion();
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO empleados(nombre,apellido,numero_cedula,telefono_celular,direccion,correo_electronico,sueldo,sucursal_asignada) VALUES(?,?,?,?,?,?,?,?)");

                nombre = txtNombreRE.getText();
                if (!nuevoEmpleado.esNombreValido(nombre)) {
                    JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                    txtNombreRE.requestFocus();
                } else {
                    nuevoEmpleado.nombre = nombre;
                    apellido = txtApellidoRE.getText();
                    if (!nuevoEmpleado.esApellidoValido(apellido)) {
                        JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                        txtApellidoRE.requestFocus();
                    } else {
                        nuevoEmpleado.apellido = apellido;
                        cedula = txtCedulaRE.getText();
                        cedula = nuevoEmpleado.validarCedula(cedula);
                        if (!nuevoEmpleado.esCedulaValida(cedula)) {
                            JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                            txtCedulaRE.requestFocus();
                        } else {
                            if (esEmpleado(cedula)) {
                                JOptionPane.showMessageDialog(null, "Empleado ya registrado - Ingrese un nuevo Empleado");
                            } else {
                                nuevoEmpleado.numDoc = cedula;
                                telf = txtTelCelRE.getText();
                                if (!nuevoEmpleado.esTelefonoValido(telf)) {
                                    JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                    txtTelCelRE.requestFocus();
                                } else {
                                    nuevoEmpleado.telf = telf;
                                    direccion = txtDireccionRE.getText();
                                    if (!nuevoEmpleado.esDireccionValido(direccion)) {
                                        JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                        txtDireccionRE.requestFocus();
                                    } else {
                                        nuevoEmpleado.direccion = direccion;
                                        correo = txtCorreoRE.getText();
                                        if (!nuevoEmpleado.esCorreoValido(correo)) {
                                            JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                            txtCorreoRE.requestFocus();
                                        } else {
                                            nuevoEmpleado.correo = correo;
                                            sueldo = txtSueldoRE.getText();
                                            if (!nuevoEmpleado.esSueldoValido(sueldo)) {
                                                JOptionPane.showMessageDialog(null, "Datos del cliente incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                txtSueldoRE.requestFocus();
                                            } else {
                                                nuevoEmpleado.sueldo = Double.parseDouble(sueldo);
                                                sucursal = String.valueOf(cmbSucursalAsignadaRE.getSelectedItem());
                                                nuevoEmpleado.sucursal = sucursal;
                                                pps.setString(1, nuevoEmpleado.nombre);
                                                pps.setString(2, nuevoEmpleado.apellido);
                                                pps.setString(3, nuevoEmpleado.numDoc);
                                                pps.setString(4, nuevoEmpleado.telf);
                                                pps.setString(5, nuevoEmpleado.direccion);
                                                pps.setString(6, nuevoEmpleado.correo);
                                                pps.setDouble(7, nuevoEmpleado.sueldo);
                                                pps.setString(8, nuevoEmpleado.sucursal);

                                                int a = pps.executeUpdate();
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(null, "¡Empleado Registrado Exitosamente!");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ERROR", "Error", JOptionPane.WARNING_MESSAGE);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }


    }//GEN-LAST:event_btnRegistrarEmpleadoActionPerformed

    private void txtNumDocumentoCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocumentoCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocumentoCEActionPerformed

    private void txtCIEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCIEEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIEEActionPerformed

    private void btnAtrasREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasREActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasREActionPerformed

    private void btnAtrasAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasAEActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasAEActionPerformed

    private void btnAtrasCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCEActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCEActionPerformed

    private void btnAtrasEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasEEActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasEEActionPerformed

    private void btnSiguienteAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteAEActionPerformed
        // TODO add your handling code here:
        if (txtCedulaAE.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para actualizar un Empleado debe ingresar un número de cédula", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String cedula = txtCedulaAE.getText();
                if (cedula.length() < 10) {
                    JOptionPane.showMessageDialog(null, "Cédula Incorrecta - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCedulaAE.setText("");
                } else {
                    cedula = nuevoEmpleadoA.validarCedula(cedula);
                    if (!nuevoEmpleadoA.esCedulaValida(cedula)) {
                        JOptionPane.showMessageDialog(null, "Cédula Incorrecta - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCedulaAE.setText("");
                    } else {
                        if (!esEmpleado(cedula)) {
                            JOptionPane.showMessageDialog(null, "Empleado no registrado - Primero registre el Empleado");
                            txtCedulaAE.setText("");
                        } else {
                            nuevoEmpleadoA.numDoc = cedula;
                            String campo = String.valueOf(cmbCampoEmpleadoAE.getSelectedItem());
                            switch (campo) {
                                case "Teléfono Celular":
                                    campoActualizar = "telefono_celular";
                                    break;
                                case "Dirección":
                                    campoActualizar = "direccion";
                                    break;
                                case "Correo Electrónico":
                                    campoActualizar = "correo_electronico";
                                    break;
                                case "Sueldo":
                                    campoActualizar = "sueldo";
                                    break;
                                case "Sucursal Asignada":
                                    campoActualizar = "sucursal_asignada";
                                    break;
                            }
                            //----------------------------------------------------------------------
                            ActualizarDatoEmpleado nuevoDato = new ActualizarDatoEmpleado();
                            nuevoDato.setVisible(true);
                            this.dispose();
                            //----------------------------------------------------------------------
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }

    }//GEN-LAST:event_btnSiguienteAEActionPerformed

    private void btnConsultarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarEmpleadoActionPerformed
        // TODO add your handling code here:
        if (txtNumDocumentoCE.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para consultar un Empleado debe ingresar un número de cédula", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String cedula = txtNumDocumentoCE.getText();
            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Cédula Incorrecta - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtNumDocumentoCE.setText("");
            } else {
                cedula = nuevoEmpleado.validarCedula(cedula);
                if (!nuevoEmpleado.esCedulaValida(cedula)) {
                    JOptionPane.showMessageDialog(null, "Cédula Incorrecta - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtNumDocumentoCE.setText("");
                } else {
                    if (!esEmpleado(cedula)) {
                        JOptionPane.showMessageDialog(null, "Empleado no registrado - Primero registre el Empleado");
                        txtNumDocumentoCE.setText("");
                    } else {
                        nuevoEmpleado.numDoc = cedula;
                        JOptionPane.showMessageDialog(null, "Empleado Encontrado");
                        mostrarInfo(nuevoEmpleado.numDoc);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConsultarEmpleadoActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        String cedula = txtCIEE.getText();
        if (cedula.length() < 10) {
            JOptionPane.showMessageDialog(null, "Cédula Incorrecta - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
            txtCIEE.setText("");
        } else {
            cedula = nuevoEmpleado.validarCedula(cedula);
            if (!nuevoEmpleado.esCedulaValida(cedula)) {
                JOptionPane.showMessageDialog(null, "Cédula Incorrecta - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtCIEE.setText("");
            } else {
                if (!esEmpleado(cedula)) {
                    JOptionPane.showMessageDialog(null, "Empleado no registrado - Primero registre el Empleado");
                    txtCIEE.setText("");
                } else {
                    nuevoEmpleado.numDoc = cedula;
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al Empleado?", "ALERTA", WIDTH);
                    switch (confirmacion) {
                        case JOptionPane.YES_OPTION:
                            eliminarEmpleado(nuevoEmpleado.numDoc);
                            JOptionPane.showMessageDialog(null, "Empleado Eliminado Exitosamente");
                            break;
                        case JOptionPane.NO_OPTION:
                            JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            JOptionPane.showMessageDialog(null, "Ha cancelado la operación");
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MóduloEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MóduloEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MóduloEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MóduloEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MóduloEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasAE;
    private javax.swing.JButton btnAtrasCE;
    private javax.swing.JButton btnAtrasEE;
    private javax.swing.JButton btnAtrasRE;
    private javax.swing.JButton btnConsultarEmpleado;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnRegistrarEmpleado;
    private javax.swing.JButton btnSiguienteAE;
    private javax.swing.JComboBox<String> cmbCampoEmpleadoAE;
    private javax.swing.JComboBox<String> cmbSucursalAsignadaRE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApellidoRE;
    private javax.swing.JTextField txtCIEE;
    private javax.swing.JTextField txtCedulaAE;
    private javax.swing.JTextField txtCedulaRE;
    private javax.swing.JTextField txtCorreoRE;
    private javax.swing.JTextField txtDireccionRE;
    private javax.swing.JTextField txtNombreRE;
    private javax.swing.JTextField txtNumDocumentoCE;
    private javax.swing.JTextField txtSueldoRE;
    private javax.swing.JTextField txtTelCelRE;
    // End of variables declaration//GEN-END:variables
}
