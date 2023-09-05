/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class ActualizarDatoProducto extends javax.swing.JFrame {

    String codigo = MóduloProductos.nuevoProductoA.codigo;
    String campo = MóduloProductos.campoActualizar;

    /**
     * Creates new form ActualizarDatoCliente
     */
    public ActualizarDatoProducto() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarInfo(codigo);
    }

    void mostrarInfo(String codigo) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Precio de Distribuidor");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Sucursal");

        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //Codigo
                datos[1] = rs.getString(2); //Nombre
                datos[2] = rs.getString(3); //Tipo
                datos[3] = rs.getString(4); //Stock
                datos[4] = rs.getString(5); //Precio Unitario
                datos[5] = rs.getString(6); //Precio de Distribuidor
                datos[6] = rs.getString(7); //Proveedor
                datos[7] = rs.getString(8); //Sucursal
                modelo.addRow(datos);
            }
            switch (campo) {
                case "nombre":
                    txtActual.setText(datos[1]);
                    break;
                case "stock":
                    txtActual.setText(datos[3]);
                    break;
                case "precio_unitario":
                    txtActual.setText(datos[4]);
                    break;
                case "precio_distribuidor":
                    txtActual.setText(datos[5]);
                    break;
                case "proveedor":
                    txtActual.setText(datos[6]);
                    break;
                case "sucursal":
                    txtActual.setText(datos[7]);
                    break;
            }
        } catch (SQLException e) {

        }
    }

    void actualizarInfo(String nuevoDato) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;
        try {
            switch (campo) {
                case "nombre":
                    if (!MóduloProductos.nuevoProductoA.esNombreValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Nombre del producto Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set nombre = ? WHERE codigo LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, codigo);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Nombre del Producto Actualizado Exitosamente!");
                        //------------------------------------------------------
                        MóduloProductos newMod = new MóduloProductos();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "stock":
                    if (!MóduloProductos.nuevoProductoA.esStockValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Stock del producto Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        int stock = Integer.parseInt(nuevoDato);
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set stock = ? WHERE codigo LIKE ?");
                        pstm.setInt(1, stock);
                        pstm.setString(2, codigo);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Stock del Producto Actualizado Exitosamente!");
                        //------------------------------------------------------
                        MóduloProductos newMod = new MóduloProductos();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "precio_unitario":
                    if (!MóduloProductos.nuevoProductoA.esPrecioUnitarioValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Precio Unitario del producto Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        double precioUnit = Double.parseDouble(nuevoDato);
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set precio_unitario = ? WHERE codigo LIKE ?");
                        pstm.setDouble(1, precioUnit);
                        pstm.setString(2, codigo);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Precio Unitario del Producto Actualizado Exitosamente!");
                        //------------------------------------------------------
                        MóduloProductos newMod = new MóduloProductos();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "precio_distribuidor":
                    if (!MóduloProductos.nuevoProductoA.esPrecioDistribuidorValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Precio de Distribuidor del producto Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        double precioDist = Double.parseDouble(nuevoDato);
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set precio_distribuidor = ? WHERE codigo LIKE ?");
                        pstm.setDouble(1, precioDist);
                        pstm.setString(2, codigo);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Precio de Distribuidor del Producto Actualizado Exitosamente!");
                        //------------------------------------------------------
                        MóduloProductos newMod = new MóduloProductos();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "proveedor":
                    if (!MóduloProductos.nuevoProductoA.esProveedorValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Proveedor del producto Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set proveedor = ? WHERE codigo LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, codigo);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Proveedor del Producto Actualizado Exitosamente!");
                        //------------------------------------------------------
                        MóduloProductos newMod = new MóduloProductos();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "sucursal":
                    if (!MóduloProductos.nuevoProductoA.esSucursalValida(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nueva Sucursal del producto Incorrecta - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set sucursal = ? WHERE codigo LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, codigo);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Sucursal del Producto Actualizada Exitosamente!");
                        //------------------------------------------------------
                        MóduloProductos newMod = new MóduloProductos();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtActual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNuevo = new javax.swing.JTextField();
        btnActualizarProducto = new javax.swing.JButton();
        btnAtrásAP2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encargado de Bodega");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ingresar"));

        jLabel1.setText("Actual");

        txtActual.setEditable(false);
        txtActual.setDragEnabled(true);
        txtActual.setEnabled(false);

        jLabel2.setText("Nuevo");

        btnActualizarProducto.setText("Actualizar Producto");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnAtrásAP2.setText("Atrás");
        btnAtrásAP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrásAP2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtrásAP2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnActualizarProducto)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnActualizarProducto)
                .addGap(18, 18, 18)
                .addComponent(btnAtrásAP2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrásAP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrásAP2ActionPerformed
        // TODO add your handling code here:
        MóduloProductos nuevoModProd = new MóduloProductos();
        nuevoModProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrásAP2ActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        // TODO add your handling code here:
        String nuevoDato = txtNuevo.getText();
        actualizarInfo(nuevoDato);
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarDatoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarDatoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarDatoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarDatoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarDatoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnAtrásAP2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtActual;
    private javax.swing.JTextField txtNuevo;
    // End of variables declaration//GEN-END:variables
}
