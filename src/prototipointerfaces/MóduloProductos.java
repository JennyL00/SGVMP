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
public class MóduloProductos extends javax.swing.JFrame {

    Producto nuevoProducto = new Producto();
    static Producto nuevoProductoA = new Producto();
    static String campoActualizar;

    /**
     * Creates new form Interfaz
     */
    public MóduloProductos() {
        initComponents();
        setLocationRelativeTo(null);

    }

    void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Precio de Distribuidor");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Sucursal");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM productos";

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

    void mostrarInfo(String codigo) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Precio de Distribuidor");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Sucursal");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
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

    boolean esProducto(String codigo) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Precio de Distribuidor");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Sucursal");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
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
            if (datos[0] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;

    }

    boolean existe(String codigo) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Precio de Distribuidor");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Sucursal");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
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
            if (datos[0] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;

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
        txtNombreProductoR = new javax.swing.JTextField();
        btnRegistrarProducto = new javax.swing.JButton();
        btnSalirRP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoProductoRP = new javax.swing.JTextField();
        txtTipoProductoR = new javax.swing.JTextField();
        txtStockR = new javax.swing.JTextField();
        txtPrecioUnitarioR = new javax.swing.JTextField();
        txtPrecioDistribuidorR = new javax.swing.JTextField();
        txtProveedorR = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbSucursalR = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSiguienteAP = new javax.swing.JButton();
        btnSalirAP = new javax.swing.JButton();
        txtCodigoProductoAP = new javax.swing.JTextField();
        cmbCampoProductoAP = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigoProductoCP = new javax.swing.JTextField();
        btnConsultarProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnSalirCP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encargado de Bodega");

        lblNombres.setText("Nombre");

        btnRegistrarProducto.setText("Registrar");
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });

        btnSalirRP.setText("Salir");
        btnSalirRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirRPActionPerformed(evt);
            }
        });

        jLabel11.setText("Código");

        txtPrecioUnitarioR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitarioRActionPerformed(evt);
            }
        });

        jLabel12.setText("Tipo");

        jLabel13.setText("Stock");

        jLabel14.setText("Precio Unitario");

        jLabel15.setText("Precio del Distribuidor");

        jLabel16.setText("Proveedor");

        jLabel17.setText("Sucursal");

        cmbSucursalR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matriz - Av. América", "Local - C.C Espiral", "Local - C.C El Caracol", "Local - Av. Lauro Guerrero y Av. Angulo", "Bodega - Valle" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalirRP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                .addComponent(btnRegistrarProducto)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombres)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombreProductoR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipoProductoR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStockR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioUnitarioR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioDistribuidorR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProveedorR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoProductoRP)
                    .addComponent(cmbSucursalR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProductoRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombreProductoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoProductoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUnitarioR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioDistribuidorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProveedorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbSucursalR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarProducto)
                    .addComponent(btnSalirRP))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar Producto", jPanel1);

        jLabel4.setText("Código");

        jLabel5.setText("Campo");

        btnSiguienteAP.setText("Siguiente");
        btnSiguienteAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteAPActionPerformed(evt);
            }
        });

        btnSalirAP.setText("Salir");
        btnSalirAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAPActionPerformed(evt);
            }
        });

        cmbCampoProductoAP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Precio Unitario", "Precio de Distribuidor", "Proveedor", "Sucursal" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalirAP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                .addComponent(btnSiguienteAP)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigoProductoAP)
                    .addComponent(cmbCampoProductoAP, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigoProductoAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCampoProductoAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguienteAP)
                    .addComponent(btnSalirAP))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Actualizar Producto", jPanel2);

        jLabel10.setText("Código");

        txtCodigoProductoCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoCPActionPerformed(evt);
            }
        });

        btnConsultarProducto.setText("Consultar");
        btnConsultarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProductoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos"));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Tipo", "Stock", "Precio Unitario", "Precio de Distribuidor", "Proveedor", "Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSalirCP.setText("Salir");
        btnSalirCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCPActionPerformed(evt);
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
                        .addComponent(btnSalirCP)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtCodigoProductoCP, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultarProducto)
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCodigoProductoCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarProducto))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirCP)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar Producto", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoProductoCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoCPActionPerformed

    private void txtPrecioUnitarioRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUnitarioRActionPerformed

    private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
        // TODO add your handling code here:
        String codigo;
        String nombre;
        String tipo;
        String stock;
        String precioUnit;
        String precioDist;
        String proveedor;
        String sucursal;
        if (txtCodigoProductoRP.getText().equals("")
                || txtNombreProductoR.getText().equals("")
                || txtTipoProductoR.getText().equals("")
                || txtStockR.getText().equals("")
                || txtPrecioUnitarioR.getText().equals("")
                || txtPrecioDistribuidorR.getText().equals("")
                || txtProveedorR.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para registrar un producto debe llenar TODOS los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Conexion con = new Conexion();
            Connection cn = (Connection) con.conexion();
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO productos(codigo,nombre,tipo,stock,precio_unitario,precio_distribuidor,proveedor,sucursal) VALUES(?,?,?,?,?,?,?,?)");

                codigo = txtCodigoProductoRP.getText();
                if (!nuevoProducto.esCodigoValido(codigo)) {
                    JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCodigoProductoRP.requestFocus();
                } else {
                    if (existe(codigo)) {
                        JOptionPane.showMessageDialog(null, "Código del nuevo producto ya registrado - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCodigoProductoRP.setText("");
                        txtCodigoProductoRP.requestFocus();
                    } else {
                        nuevoProducto.codigo = codigo;
                        nombre = txtNombreProductoR.getText();
                        if (!nuevoProducto.esNombreValido(nombre)) {
                            JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                            txtNombreProductoR.requestFocus();
                        } else {
                            nuevoProducto.nombre = nombre;
                            tipo = txtTipoProductoR.getText();
                            if (!nuevoProducto.esTipoValido(tipo)) {
                                JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                txtTipoProductoR.requestFocus();
                            } else {
                                nuevoProducto.tipo = tipo;
                                stock = txtStockR.getText();
                                if (!nuevoProducto.esStockValido(stock)) {
                                    JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                    txtStockR.requestFocus();
                                } else {
                                    nuevoProducto.stock = Integer.parseInt(stock);
                                    precioUnit = txtPrecioUnitarioR.getText();
                                    if (!nuevoProducto.esPrecioUnitarioValido(precioUnit)) {
                                        JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                        txtPrecioUnitarioR.requestFocus();
                                    } else {
                                        nuevoProducto.precioUnitario = Double.parseDouble(precioUnit);
                                        precioDist = txtPrecioDistribuidorR.getText();
                                        if (!nuevoProducto.esPrecioDistribuidorValido(precioDist)) {
                                            JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                            txtPrecioDistribuidorR.requestFocus();
                                        } else {
                                            nuevoProducto.precioDistribuidor = Double.parseDouble(precioDist);
                                            proveedor = txtProveedorR.getText();
                                            if (!nuevoProducto.esProveedorValido(proveedor)) {
                                                JOptionPane.showMessageDialog(null, "Datos del producto incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                                                txtProveedorR.requestFocus();
                                            } else {
                                                nuevoProducto.proveedor = proveedor;
                                                nuevoProducto.sucursal = String.valueOf(cmbSucursalR.getSelectedItem());

                                                pps.setString(1, nuevoProducto.codigo);
                                                pps.setString(2, nuevoProducto.nombre);
                                                pps.setString(3, nuevoProducto.tipo);
                                                pps.setInt(4, nuevoProducto.stock);
                                                pps.setDouble(5, nuevoProducto.precioUnitario);
                                                pps.setDouble(6, nuevoProducto.precioDistribuidor);
                                                pps.setString(7, nuevoProducto.proveedor);
                                                pps.setString(8, nuevoProducto.sucursal);

                                                int a = pps.executeUpdate();
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(null, "¡Producto Registrado Exitosamente!");
                                                    txtCodigoProductoRP.setText("");
                                                    txtNombreProductoR.setText("");
                                                    txtTipoProductoR.setText("");
                                                    txtStockR.setText("");
                                                    txtPrecioUnitarioR.setText("");
                                                    txtPrecioDistribuidorR.setText("");
                                                    txtProveedorR.setText("");
                                                    cmbSucursalR.setSelectedIndex(1);
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
                //String claveDuplicada = "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 'AAB001' for key 'PRIMARY'";
            }
        }
    }//GEN-LAST:event_btnRegistrarProductoActionPerformed

    private void btnSalirRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRPActionPerformed
        // TODO add your handling code here:
        Login nuevoLogin = new Login();
        nuevoLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirRPActionPerformed

    private void btnSalirAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAPActionPerformed
        // TODO add your handling code here:
        Login nuevoLogin = new Login();
        nuevoLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirAPActionPerformed

    private void btnSalirCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCPActionPerformed
        // TODO add your handling code here:
        Login nuevoLogin = new Login();
        nuevoLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirCPActionPerformed

    private void btnSiguienteAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteAPActionPerformed
        // TODO add your handling code here:
        try {
            String codigo = String.valueOf(txtCodigoProductoAP.getText());
            if (!nuevoProductoA.esCodigoValido(codigo)) {
                JOptionPane.showMessageDialog(null, "Codigo incorrecto - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                txtCodigoProductoAP.setText("");
                txtCodigoProductoAP.requestFocus();
            } else {
                if (!existe(codigo)) {
                    JOptionPane.showMessageDialog(null, "Producto no registrado - Primero registre el Producto");
                    txtCodigoProductoAP.setText("");
                    txtCodigoProductoAP.requestFocus();
                } else {
                    nuevoProductoA.codigo = codigo;
                    String campo = String.valueOf(cmbCampoProductoAP.getSelectedItem());
                    switch (campo) {
                        /*
                        case "Nombre":
                            campoActualizar = "nombre";
                            break;
                        case "Stock":
                            campoActualizar = "stock";
                            break;
                            */
                        case "Precio Unitario":
                            campoActualizar = "precio_unitario";
                            break;
                        case "Precio de Distribuidor":
                            campoActualizar = "precio_distribuidor";
                            break;
                        case "Proveedor":
                            campoActualizar = "proveedor";
                            break;
                        case "Sucursal":
                            campoActualizar = "sucursal";
                            break;
                    }
                    //----------------------------------------------------------------------
                    ActualizarDatoProducto nuevaActualizacion = new ActualizarDatoProducto();
                    nuevaActualizacion.setVisible(true);
                    this.dispose();
                    //----------------------------------------------------------------------
                }
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }


    }//GEN-LAST:event_btnSiguienteAPActionPerformed

    private void btnConsultarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProductoActionPerformed
        // TODO add your handling code here:
        nuevoProducto.codigo = txtCodigoProductoCP.getText();
        if (!nuevoProducto.esCodigoValido(txtCodigoProductoCP.getText())) {
            JOptionPane.showMessageDialog(null, "Código del producto incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
            txtCodigoProductoCP.setText("");
        } else {
            if (!esProducto(nuevoProducto.codigo)) {
                JOptionPane.showMessageDialog(null, "Producto no Registrado - Primero registre el Producto", "Error", JOptionPane.WARNING_MESSAGE);
                txtCodigoProductoCP.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Producto Encontrado");
                mostrarInfo(nuevoProducto.codigo);
            }
        }
    }//GEN-LAST:event_btnConsultarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(MóduloProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MóduloProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MóduloProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MóduloProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MóduloProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarProducto;
    private javax.swing.JButton btnRegistrarProducto;
    private javax.swing.JButton btnSalirAP;
    private javax.swing.JButton btnSalirCP;
    private javax.swing.JButton btnSalirRP;
    private javax.swing.JButton btnSiguienteAP;
    private javax.swing.JComboBox<String> cmbCampoProductoAP;
    private javax.swing.JComboBox<String> cmbSucursalR;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCodigoProductoAP;
    private javax.swing.JTextField txtCodigoProductoCP;
    private javax.swing.JTextField txtCodigoProductoRP;
    private javax.swing.JTextField txtNombreProductoR;
    private javax.swing.JTextField txtPrecioDistribuidorR;
    private javax.swing.JTextField txtPrecioUnitarioR;
    private javax.swing.JTextField txtProveedorR;
    private javax.swing.JTextField txtStockR;
    private javax.swing.JTextField txtTipoProductoR;
    // End of variables declaration//GEN-END:variables
}
