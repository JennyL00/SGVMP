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
public class ActualizarDatoEmpleado extends javax.swing.JFrame {
    String cedula = MóduloEmpleados.nuevoEmpleadoA.numDoc;
    String campo = MóduloEmpleados.campoActualizar;
    /**
     * Creates new form ActualizarDatoCliente
     */
    public ActualizarDatoEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarInfo(cedula);
    }
    
    void mostrarInfo(String cedula) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Numero de Cedula");
        modelo.addColumn("Telefono Celular");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Sucursal Asignada");

        String sql = "SELECT * FROM empleados WHERE numero_cedula LIKE ?";
        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //nombre
                datos[1] = rs.getString(2); //apellido
                datos[2] = rs.getString(3); //cedula
                datos[3] = rs.getString(4); //correo
                datos[4] = rs.getString(5); //telefono
                datos[5] = rs.getString(6); //direccion
                datos[6] = rs.getString(7); //sueldo
                datos[7] = rs.getString(8); //sucursal
                modelo.addRow(datos);
            }
            switch (campo) {
                case "correo_electronico":
                    txtActual.setText(datos[3]);
                    break;
                case "telefono_celular":
                    txtActual.setText(datos[4]);
                    break;
                case "direccion":
                    txtActual.setText(datos[5]);
                    break;
                case "sueldo":
                    txtActual.setText(datos[6]);
                    break;
                case "sucursal_asignada":
                    txtActual.setText(datos[7]);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
    
    void actualizarInfo(String nuevoDato) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;
        try {
            switch (campo) {
                case "telefono_celular":
                    if (!MóduloEmpleados.nuevoEmpleadoA.esTelefonoValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Teléfono Celular Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update empleados set telefono_celular = ? WHERE numero_cedula LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, cedula);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Teléfono Celular del Empleados Actualzado Exitosamente!");
                        //------------------------------------------------------
                        MóduloEmpleados newMod = new MóduloEmpleados();
                        newMod.setVisible(true);
                        this.dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "direccion":
                    if (!MóduloEmpleados.nuevoEmpleadoA.esDireccionValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nueva Dirección Incorrecta - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update empleados set direccion = ? WHERE numero_cedula LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, cedula);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Dirección del Empleado Actualzada Exitosamente!");
                        //------------------------------------------------------
                        MóduloEmpleados newMod = new MóduloEmpleados();
                        newMod.setVisible(true);
                        dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "correo_electronico":
                    if (!MóduloEmpleados.nuevoEmpleadoA.esCorreoValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Correo Electrónico Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update empleados set correo_electronico = ? WHERE numero_cedula LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, cedula);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Correo Electrónico del Empleado Actualzado Exitosamente!");
                        //------------------------------------------------------
                        MóduloEmpleados newMod = new MóduloEmpleados();
                        newMod.setVisible(true);
                        dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "sueldo":
                    if (!MóduloEmpleados.nuevoEmpleadoA.esSueldoValido(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nuevo Sueldo Incorrecto - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update empleados set sueldo = ? WHERE numero_cedula LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, cedula);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Sueldo del Empleado Actualzado Exitosamente!");
                        //------------------------------------------------------
                        MóduloEmpleados newMod = new MóduloEmpleados();
                        newMod.setVisible(true);
                        dispose();
                        //------------------------------------------------------
                    }
                    break;
                case "sucursal_asignada":
                    if (!MóduloEmpleados.nuevoEmpleadoA.esSucursalValida(nuevoDato)) {
                        JOptionPane.showMessageDialog(null, "Nueva Sucursal Incorrecta - Corrija");
                        txtNuevo.setText("");
                    } else {
                        pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update empleados set sucursal_asignada = ? WHERE numero_cedula LIKE ?");
                        pstm.setString(1, nuevoDato);
                        pstm.setString(2, cedula);
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "¡Sucursal del Empleado Actualzado Exitosamente!");
                        //------------------------------------------------------
                        MóduloEmpleados newMod = new MóduloEmpleados();
                        newMod.setVisible(true);
                        dispose();
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
        btnActualizarEmpleado = new javax.swing.JButton();
        btnAtrasAE2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerente General");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ingresar"));

        jLabel1.setText("Actual");

        txtActual.setEditable(false);
        txtActual.setDragEnabled(true);
        txtActual.setEnabled(false);

        jLabel2.setText("Nuevo");

        btnActualizarEmpleado.setText("Actualizar Empleado");
        btnActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEmpleadoActionPerformed(evt);
            }
        });

        btnAtrasAE2.setText("Atrás");
        btnAtrasAE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasAE2ActionPerformed(evt);
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
                            .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnActualizarEmpleado))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtrasAE2)))
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
                .addComponent(btnActualizarEmpleado)
                .addGap(18, 18, 18)
                .addComponent(btnAtrasAE2)
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

    private void btnAtrasAE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasAE2ActionPerformed
        // TODO add your handling code here:
        MóduloEmpleados nuevoEmpleado = new MóduloEmpleados();
        nuevoEmpleado.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnAtrasAE2ActionPerformed

    private void btnActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEmpleadoActionPerformed
        // TODO add your handling code here:
        String nuevoDato = txtNuevo.getText();
        actualizarInfo(nuevoDato);
    }//GEN-LAST:event_btnActualizarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarDatoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarDatoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarDatoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarDatoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarDatoEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEmpleado;
    private javax.swing.JButton btnAtrasAE2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtActual;
    private javax.swing.JTextField txtNuevo;
    // End of variables declaration//GEN-END:variables
}
