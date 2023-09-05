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
public class MóduloAdministraciónSistema extends javax.swing.JFrame {

    Usuario nuevoUsuario = new Usuario();
    static Usuario nuevoUsuarioA = new Usuario();
    static String antiguaPassword;

    /**
     * Creates new form Interfaz
     */
    public MóduloAdministraciónSistema() {
        initComponents();
        setLocationRelativeTo(null);

    }

    void mostrarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo de Usuario");
        modelo.addColumn("Usuario");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM usuarios";

        String datos[] = new String[2];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //String cedula = rs.getString(1);
                //datos[0] = obtenerNombre(cedula);
                datos[0] = rs.getString(4);
                datos[1] = rs.getString(2);
                modelo.addRow(datos);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    String obtenerNombre(String cedula) {
        String nombre;
        //DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("Nombre");
        //tblDatos.setModel(modelo);

        String sql = "SELECT * FROM empleados WHERE numero_cedula LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(1) + " " + rs.getString(2);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modelo);
            nombre = String.valueOf(datos[0]);
            return nombre;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerPassword(String usuario) {
        String password;
        //DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("Nombre");
        //tblDatos.setModel(modelo);

        String sql = "SELECT * FROM usuarios WHERE usuario LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, usuario);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(3);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modelo);
            password = String.valueOf(datos[0]);
            return password;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    void mostrarInfo(String cedula) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo de Usuario");
        modelo.addColumn("Usuario");
        tblDatos.setModel(modelo);

        String sql = "SELECT * FROM usuarios WHERE cedula LIKE ?";

        String datos[] = new String[3];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            rs = pst.executeQuery();
            datos[0] = obtenerNombre(cedula);
            while (rs.next()) {
                //cedula = rs.getString(1);
                datos[1] = rs.getString(4);
                datos[2] = rs.getString(2);
                modelo.addRow(datos);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void mostrarInfoPassword(String cedula) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo de Usuario");
        modelo.addColumn("Password");
        tblDatos2.setModel(modelo);

        String sql = "SELECT * FROM usuarios WHERE cedula LIKE ?";

        String datos[] = new String[3];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            rs = pst.executeQuery();
            datos[0] = obtenerNombre(cedula);
            while (rs.next()) {
                //cedula = rs.getString(1);
                datos[1] = rs.getString(4);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
            tblDatos2.setModel(modelo);
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    boolean existe(String cedula) {

        String sql = "SELECT * FROM usuarios WHERE cedula LIKE ?";
        String datos[] = new String[4];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, cedula);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //cedula
                datos[1] = rs.getString(2); //usuario
                datos[2] = rs.getString(3); //password
                datos[2] = rs.getString(4); //tipo_usuario
                //modelo.addRow(datos);
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

    boolean existeUsuario(String usuario) {

        String sql = "SELECT * FROM usuarios WHERE usuario LIKE ?";
        String datos[] = new String[4];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //cedula
                datos[1] = rs.getString(2); //usuario
                datos[2] = rs.getString(3); //password
                datos[2] = rs.getString(4); //tipo_usuario
                //modelo.addRow(datos);
            }
            if (datos[1] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;
    }

    boolean esUsuario(String usuario, String password) {
        String sql = "SELECT * FROM usuarios WHERE usuario LIKE ? AND password LIKE ?";
        String datos[] = new String[2];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            //usuario = "'" + usuario + "'";
            //password = "'" + password + "'";
            pst.setString(1, usuario);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
            }
            if (datos[0] == null || datos[1] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;
    }

    boolean estaRegistrado(String cedula, String usuario, String tipoUsuario) {
        String sql = "SELECT * FROM usuarios WHERE cedula LIKE ? AND usuario LIKE ? AND tipo_usuario LIKE ?";
        String datos[] = new String[3];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            //usuario = "'" + usuario + "'";
            //password = "'" + password + "'";
            pst.setString(1, cedula);
            pst.setString(2, usuario);
            pst.setString(3, tipoUsuario);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(4);
            }
            if (datos[0] == null || datos[1] == null || datos[2] == null) {
                //JOptionPane.showMessageDialog(null, "Cliente no registrado - Primero registre el Cliente");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;
    }

    boolean esEmpleado(String cedula) {
        /*
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
         */
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
                //modelo.addRow(datos);
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

    void eliminarUsuario(String usuario, String password) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;
        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("delete from usuarios WHERE usuario LIKE ? AND password LIKE ?");
            pstm.setString(1, usuario);
            pstm.setString(2, password);
            pstm.executeUpdate();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnAtrasCPU = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        txtCedulaUsuarioCPU = new javax.swing.JTextField();
        txtUsuarioCPU = new javax.swing.JTextField();
        txtPasswordCPU = new javax.swing.JTextField();
        txtConfPassCPU = new javax.swing.JTextField();
        cmbTipoUsuarioCPU = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAtrasCU = new javax.swing.JButton();
        txtCedulaUsuarioCU = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnConsultarUsuario = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtCedulaUsuarioCP = new javax.swing.JTextField();
        btnAtrasCP = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnConsultarPassword = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnAtrasEU = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btnEliminarUsuario = new javax.swing.JButton();
        txtUsuarioEU = new javax.swing.JTextField();
        txtPasswordEU = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAtrasRP = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtCedulaUsuarioRP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuarioRP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoUsuarioRP = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnSiguienteRP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerente General");

        btnAtrasCPU.setText("Atrás");
        btnAtrasCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCPUActionPerformed(evt);
            }
        });

        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        cmbTipoUsuarioCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Vendedor de Mostrador", "Encargado de Bodega" }));

        jLabel1.setText("Confirmar Password");

        jLabel2.setText("Password");

        jLabel3.setText("Usuario");

        jLabel8.setText("C.I.");

        jLabel9.setText("Tipo de Usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtrasCPU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(btnCrearUsuario)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedulaUsuarioCPU)
                    .addComponent(txtUsuarioCPU)
                    .addComponent(txtPasswordCPU)
                    .addComponent(txtConfPassCPU)
                    .addComponent(cmbTipoUsuarioCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaUsuarioCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfPassCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoUsuarioCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasCPU)
                    .addComponent(btnCrearUsuario))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crear Usuario", jPanel1);

        btnAtrasCU.setText("Atrás");
        btnAtrasCU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCUActionPerformed(evt);
            }
        });

        jLabel10.setText("C.I.");

        btnConsultarUsuario.setText("Consultar");
        btnConsultarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarUsuarioActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos"));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Tipo de Usuario", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAtrasCU))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel10)
                                .addGap(36, 36, 36)
                                .addComponent(txtCedulaUsuarioCU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnConsultarUsuario)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaUsuarioCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnConsultarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnAtrasCU)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar Usuario", jPanel2);

        btnAtrasCP.setText("Atrás");
        btnAtrasCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCPActionPerformed(evt);
            }
        });

        jLabel12.setText("C.I.");

        btnConsultarPassword.setText("Consultar");
        btnConsultarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPasswordActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos"));

        tblDatos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Tipo de Usuario", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDatos2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAtrasCP))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel12)
                                .addGap(36, 36, 36)
                                .addComponent(txtCedulaUsuarioCP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnConsultarPassword)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaUsuarioCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(btnConsultarPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnAtrasCP)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar Password", jPanel3);

        btnAtrasEU.setText("Atrás");
        btnAtrasEU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasEUActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Eliminar"));

        btnEliminarUsuario.setText("EliminarUsuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Password");

        jLabel13.setText("Usuario");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuarioEU)
                    .addComponent(txtPasswordEU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarUsuario)
                .addGap(203, 203, 203))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioEU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordEU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnEliminarUsuario)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAtrasEU)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAtrasEU)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Eliminar Usuario", jPanel5);

        btnAtrasRP.setText("Atrás");
        btnAtrasRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasRPActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Resetear"));

        jLabel6.setText("C.I.");

        jLabel7.setText("Usuario");

        cmbTipoUsuarioRP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Vendedor de Mostrador", "Encargado de Bodega" }));

        jLabel11.setText("Tipo de Usuario");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoUsuarioRP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioRP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedulaUsuarioRP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaUsuarioRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoUsuarioRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnSiguienteRP.setText("Siguiente");
        btnSiguienteRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteRPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAtrasRP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguienteRP)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasRP)
                    .addComponent(btnSiguienteRP))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Resetear Password", jPanel4);

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

    private void btnAtrasCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCPUActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCPUActionPerformed

    private void btnAtrasCUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCUActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCUActionPerformed

    private void btnAtrasEUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasEUActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasEUActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        String usuario;
        String password;
        if (txtUsuarioEU.getText().equals("")
                || txtPasswordEU.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para eliminar un Usuario debe llenar TODOS los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            usuario = txtUsuarioEU.getText();
            if (!nuevoUsuario.esUsuarioValido(usuario)) {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtUsuarioEU.setText("");
                txtPasswordEU.setText("");
            } else {
                /*if (!existeUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario no registrado - Primero Registre el Usuario", "Error", JOptionPane.WARNING_MESSAGE);
                txtUsuarioEU.setText("");
                txtPasswordEU.setText("");
            } else {*/
                //usuario = "\"" + txtUsuarioEU.getText() + "\"";
                nuevoUsuario.setUsuario(usuario);
                //password = "\""+txtPasswordEU.getText()+"\"";
                password = txtPasswordEU.getText();
                nuevoUsuario.setPassword(password);

                if (!esUsuario(nuevoUsuario.getUsuario(), nuevoUsuario.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Usuario no registrado - Primero Registre el Usuario", "Error", JOptionPane.WARNING_MESSAGE);
                    txtUsuarioEU.setText("");
                    txtPasswordEU.setText("");
                } else {
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea borrar el usuario?", "ALERTA", WIDTH);
                    switch (confirmacion) {
                        case JOptionPane.YES_OPTION:
                            eliminarUsuario(nuevoUsuario.getUsuario(), nuevoUsuario.getPassword());
                            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
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


    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        // TODO add your handling code here:
        String cedula;
        String usuario;
        String password;
        String confirmacion;
        String tipoUsuario;

        if (txtCedulaUsuarioCPU.getText().equals("")
                || txtUsuarioCPU.getText().equals("")
                || txtPasswordCPU.getText().equals("")
                || txtConfPassCPU.getText().equals("")
                || String.valueOf(cmbTipoUsuarioCPU.getSelectedItem()).equals("Seleccionar...")) {
            JOptionPane.showMessageDialog(null, "Para crear un usuario debe llenar TODOS los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Conexion con = new Conexion();
            Connection cn = (Connection) con.conexion();
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO usuarios(cedula,usuario,password,tipo_usuario) VALUES(?,?,?,?)");

                cedula = txtCedulaUsuarioCPU.getText();
                if (cedula.length() < 10) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCedulaUsuarioCPU.setText("");
                } else {
                    cedula = nuevoUsuario.validarCedula(cedula);
                    nuevoUsuario.setCedula(cedula);
                    if (!nuevoUsuario.esCedulaValida(cedula)) {
                        JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCedulaUsuarioCPU.setText("");
                    } else {
                        if (existe(nuevoUsuario.getCedula())) {
                            JOptionPane.showMessageDialog(null, "El usuario ya existe - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                            txtCedulaUsuarioCPU.setText("");
                        } else {
                            if (!esEmpleado(nuevoUsuario.getCedula())) {
                                JOptionPane.showMessageDialog(null, "\tEl usuario que intenta crear\n\tNO está registrado como un Empleado\n\tVuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                txtCedulaUsuarioCPU.setText("");
                            } else {
                                usuario = txtUsuarioCPU.getText();
                                if (!nuevoUsuario.esUsuarioValido(usuario)) {
                                    JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                    txtUsuarioCPU.setText("");
                                } else {
                                    if (existeUsuario(usuario)) {
                                        JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                        txtUsuarioCPU.setText("");
                                    } else {
                                        nuevoUsuario.setUsuario(usuario);
                                        password = txtPasswordCPU.getText();
                                        if (!nuevoUsuario.esPasswordValida(password)) {
                                            JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                            txtPasswordCPU.setText("");
                                        } else {
                                            nuevoUsuario.setPassword(password);
                                            confirmacion = txtConfPassCPU.getText();
                                            if (!nuevoUsuario.getPassword().equals(confirmacion)) {
                                                JOptionPane.showMessageDialog(null, "¡Las contraseñas no coinciden! - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                                            } else {
                                                tipoUsuario = String.valueOf(cmbTipoUsuarioCPU.getSelectedItem());
                                                nuevoUsuario.setTipoUsuario(tipoUsuario);
                                                pps.setString(1, nuevoUsuario.getCedula());
                                                pps.setString(2, nuevoUsuario.getUsuario());
                                                pps.setString(3, nuevoUsuario.getPassword());
                                                pps.setString(4, nuevoUsuario.getTipoUsuario());

                                                int a = pps.executeUpdate();
                                                if (a > 0) {
                                                    JOptionPane.showMessageDialog(null, "¡Usuario Registrado Exitosamente!");
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


    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnAtrasRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasRPActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasRPActionPerformed

    private void btnSiguienteRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteRPActionPerformed
        // TODO add your handling code here:
        String cedula;
        String usuario;
        String tipoUsuario;
        if (txtCedulaUsuarioRP.getText().equals("")
                || txtUsuarioRP.getText().equals("")
                || String.valueOf(cmbTipoUsuarioRP.getSelectedItem()).equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Para resetear un password debe llenar TODOS los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            cedula = txtCedulaUsuarioRP.getText();
            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                cedula = nuevoUsuarioA.validarCedula(cedula);
                if (!nuevoUsuarioA.esCedulaValida(cedula)) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    nuevoUsuarioA.setCedula(cedula);
                    usuario = txtUsuarioRP.getText();
                    if (!nuevoUsuarioA.esUsuarioValido(usuario)) {
                        JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        nuevoUsuarioA.setUsuario(usuario);
                        tipoUsuario = String.valueOf(cmbTipoUsuarioRP.getSelectedItem());
                        nuevoUsuarioA.setTipoUsuario(tipoUsuario);
                        if (!estaRegistrado(nuevoUsuarioA.getCedula(), nuevoUsuarioA.getUsuario(), nuevoUsuarioA.getTipoUsuario())) {
                            JOptionPane.showMessageDialog(null, "Usuario no registrado - Primero Registre el Usuario", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            antiguaPassword = obtenerPassword(nuevoUsuarioA.getUsuario());
                            nuevoUsuarioA.setPassword(antiguaPassword);
                            //----------------------------------------------------------------------
                            ActualizarPassword nuevoReseteo = new ActualizarPassword();
                            nuevoReseteo.setVisible(true);
                            this.dispose();
                            //----------------------------------------------------------------------
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_btnSiguienteRPActionPerformed

    private void btnAtrasCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCPActionPerformed
        // TODO add your handling code here:
        GerenteGeneral nuevoGerente = new GerenteGeneral();
        nuevoGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCPActionPerformed

    private void btnConsultarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarUsuarioActionPerformed
        // TODO add your handling code here:
        if (txtCedulaUsuarioCU.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para consultar un usuario debe ingresar un número de cédula", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String cedula = txtCedulaUsuarioCU.getText();
            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtCedulaUsuarioCU.setText("");
            } else {
                cedula = nuevoUsuario.validarCedula(cedula);
                if (!nuevoUsuario.esCedulaValida(cedula)) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCedulaUsuarioCU.setText("");
                } else {
                    if (!existe(cedula)) {
                        JOptionPane.showMessageDialog(null, "Usuario no Registrado - Primero registre el Usuario", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCedulaUsuarioCU.setText("");
                    } else {
                        nuevoUsuario.setCedula(cedula);
                        JOptionPane.showMessageDialog(null, "Usuario Encontrado");
                        //obtenerNombre(nuevoUsuario.getCedula());
                        mostrarInfo(nuevoUsuario.getCedula());
                        txtCedulaUsuarioCU.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConsultarUsuarioActionPerformed

    private void btnConsultarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPasswordActionPerformed
        // TODO add your handling code here:
        if (txtCedulaUsuarioCP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para consultar un password debe ingresar un número de cédula", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String cedula = txtCedulaUsuarioCP.getText();
            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtCedulaUsuarioCP.setText("");
            } else {
                cedula = nuevoUsuario.validarCedula(cedula);
                if (!nuevoUsuario.esCedulaValida(cedula)) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCedulaUsuarioCP.setText("");
                } else {
                    if (!existe(cedula)) {
                        JOptionPane.showMessageDialog(null, "Usuario no Registrado - Primero registre el Usuario", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCedulaUsuarioCP.setText("");
                    } else {
                        nuevoUsuario.setCedula(cedula);
                        JOptionPane.showMessageDialog(null, "Usuario Encontrado");
                        //obtenerNombre(nuevoUsuario.getCedula());
                        mostrarInfoPassword(nuevoUsuario.getCedula());
                        txtCedulaUsuarioCP.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnConsultarPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(MóduloAdministraciónSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MóduloAdministraciónSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MóduloAdministraciónSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MóduloAdministraciónSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new MóduloAdministraciónSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasCP;
    private javax.swing.JButton btnAtrasCPU;
    private javax.swing.JButton btnAtrasCU;
    private javax.swing.JButton btnAtrasEU;
    private javax.swing.JButton btnAtrasRP;
    private javax.swing.JButton btnConsultarPassword;
    private javax.swing.JButton btnConsultarUsuario;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnSiguienteRP;
    private javax.swing.JComboBox<String> cmbTipoUsuarioCPU;
    private javax.swing.JComboBox<String> cmbTipoUsuarioRP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblDatos2;
    private javax.swing.JTextField txtCedulaUsuarioCP;
    private javax.swing.JTextField txtCedulaUsuarioCPU;
    private javax.swing.JTextField txtCedulaUsuarioCU;
    private javax.swing.JTextField txtCedulaUsuarioRP;
    private javax.swing.JTextField txtConfPassCPU;
    private javax.swing.JTextField txtPasswordCPU;
    private javax.swing.JTextField txtPasswordEU;
    private javax.swing.JTextField txtUsuarioCPU;
    private javax.swing.JTextField txtUsuarioEU;
    private javax.swing.JTextField txtUsuarioRP;
    // End of variables declaration//GEN-END:variables
}
