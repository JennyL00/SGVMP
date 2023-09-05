/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipointerfaces;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santiago
 */
public class MóduloFacturaciónVentas extends javax.swing.JFrame {

    Producto producto = new Producto();
    static Cliente nuevoCliente = new Cliente();
    DefaultTableModel modeloP;
    DefaultTableModel modeloF;
    static ListaEnlazadaProductos listaP = new ListaEnlazadaProductos();
    static ListaEnlazadaProductos listaF = new ListaEnlazadaProductos();
    static double precioFinal;
    static Factura nuevaFactura = new Factura();
    static Factura nuevaFacturaC = new Factura();

    /**
     * Creates new form Interfaz
     */
    public MóduloFacturaciónVentas() {
        initComponents();
        setLocationRelativeTo(null);
        modeloP = new DefaultTableModel();
        modeloP.addColumn("Nombre Producto");
        modeloP.addColumn("Cantidad");
        modeloP.addColumn("Precio Unitario");
        this.tblProductosP.setModel(modeloP);

        modeloF = new DefaultTableModel();
        modeloF.addColumn("Nombre Producto");
        modeloF.addColumn("Cantidad");
        modeloF.addColumn("Precio Unitario");
        this.tblProductosF.setModel(modeloF);
    }

    boolean hayStock(String codigo, String cantidad) {
        String sql = "SELECT stock FROM productos WHERE codigo LIKE ? AND stock  > ?";
        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;
        ResultSet rs;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            pst.setString(2, cantidad);
            rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                /*
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4); //stock
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                 */
            }
            if (datos[0] == null) {
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;

    }

    boolean existe(String codigo) {
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
            }
            if (datos[0] == null) {
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return true;

    }

    String obtenerNombreProducto(String codigo) {
        String nombre;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(2);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modeloP);
            nombre = String.valueOf(datos[0]);
            return nombre;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerTipoProducto(String codigo) {
        String nombre;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(3);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modeloP);
            nombre = String.valueOf(datos[0]);
            return nombre;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerStockProducto(String codigo) {
        String stock;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(4);
            }
            stock = datos[0];
            return stock;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerPrecioUnitarioProducto(String codigo) {
        String precioUnit;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(5);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modeloP);
            precioUnit = String.valueOf(datos[0]);
            return precioUnit;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerPrecioDistribuidorProducto(String codigo) {
        String precioUnit;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(6);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modeloP);
            precioUnit = String.valueOf(datos[0]);
            return precioUnit;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerProveedorProducto(String codigo) {
        String precioUnit;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(7);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modeloP);
            precioUnit = String.valueOf(datos[0]);
            return precioUnit;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    String obtenerSucursalProducto(String codigo) {
        String precioUnit;
        String sql = "SELECT * FROM productos WHERE codigo LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //datos[0] = rs.getString(1);
                datos[0] = rs.getString(8);
                //datos[2] = rs.getString(3);
                //datos[3] = rs.getString(4);
                //modelo.addRow(datos);
            }
            //tblDatos.setModel(modeloP);
            precioUnit = String.valueOf(datos[0]);
            return precioUnit;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    Producto obtenerProducto(String nombre) {
        Producto prod = new Producto();
        String sql = "SELECT * FROM productos WHERE nombre LIKE ?";

        String datos[] = new String[8];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //codigo
                datos[1] = rs.getString(2); //nombre
                datos[2] = rs.getString(3); //tipo
                datos[3] = rs.getString(4); //stock
                datos[4] = rs.getString(5); //precioUnit
                datos[5] = rs.getString(6); //precioDist
                datos[6] = rs.getString(7); //proveedor
                datos[7] = rs.getString(8); //sucursal
            }
            prod.codigo = datos[0];
            prod.nombre = datos[1];
            prod.tipo = datos[2];
            prod.stock = Integer.parseInt(datos[3]);
            prod.precioUnitario = Double.parseDouble(datos[4]);
            prod.precioDistribuidor = Double.parseDouble(datos[5]);
            prod.proveedor = datos[6];
            prod.sucursal = datos[7];
            return prod;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    String obtenerFecha() {
        String fecha;
        String sql = "SELECT CURDATE()";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
            }
            //tblDatos.setModel(modeloP);
            fecha = String.valueOf(datos[0]);
            return fecha;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    void agregarProducto(String nombre, String cantidad, String precioUnit) {
        String info[] = new String[3];
        info[0] = nombre;
        info[1] = cantidad;
        info[2] = precioUnit;

        modeloP.addRow(info);
    }

    void agregarProductoF(String nombre, String cantidad, String precioUnit) {
        String info[] = new String[3];
        info[0] = nombre;
        info[1] = cantidad;
        info[2] = precioUnit;

        modeloF.addRow(info);
    }

    void eliminarProducto() {
        int fila = tblProductosP.getSelectedRow();
        if (fila >= 0) {
            String nombre = String.valueOf(modeloP.getValueAt(fila, 0));
            Producto prodEliminar = obtenerProducto(nombre);
            NodoProducto nodoEliminar = listaP.buscar(nombre);
            listaP.eliminarNodo(nodoEliminar);
            modeloP.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione una fila de la tabla!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    void eliminarProductoF() {
        int fila = tblProductosF.getSelectedRow();
        if (fila >= 0) {
            String nombre = String.valueOf(modeloF.getValueAt(fila, 0));
            Producto prodEliminar = obtenerProducto(nombre);
            NodoProducto nodoEliminar = listaF.buscar(nombre);
            listaF.eliminarNodo(nodoEliminar);
            modeloF.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione una fila de la tabla!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    void reducirStock(String codigo, String cantidad) {
        String actual = obtenerStockProducto(codigo);
        int stockActual = Integer.parseInt(actual);
        int cant = Integer.parseInt(cantidad);
        int stockActualizado = stockActual - cant;
        String sa = String.valueOf(stockActualizado);

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;

        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set stock = ? WHERE codigo LIKE ?");
            pstm.setString(1, sa);
            pstm.setString(2, codigo);
            pstm.executeUpdate();

        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void aumentarStock(String codigo, String cantidad) {
        String actual = obtenerStockProducto(codigo);
        int stockActual = Integer.parseInt(actual);
        int cant = Integer.parseInt(cantidad);
        int stockActualizado = stockActual + cant;
        String sa = String.valueOf(stockActualizado);

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;

        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update productos set stock = ? WHERE codigo LIKE ?");
            pstm.setString(1, sa);
            pstm.setString(2, codigo);
            pstm.executeUpdate();

        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    double calcularValorAPagar() {
        double valorTotal = 0;
        int columnaPrecio = 2;
        int columnaCantidad = 1;
        int fila = 0;
        int numeroFilas = modeloP.getRowCount();
        while (fila < numeroFilas) {
            String sCantidad = String.valueOf(modeloP.getValueAt(fila, columnaCantidad));
            String sPrecioUnit = String.valueOf(modeloP.getValueAt(fila, columnaPrecio));
            double cantidad = Double.parseDouble(sCantidad);
            double precioUnit = Double.parseDouble(sPrecioUnit);
            valorTotal = valorTotal + (cantidad * precioUnit);
            fila++;
        }
        return valorTotal;
    }

    double calcularValorAPagarF() {
        double valorTotal = 0;
        int columnaPrecio = 2;
        int columnaCantidad = 1;
        int fila = 0;
        int numeroFilas = modeloF.getRowCount();
        while (fila < numeroFilas) {
            String sCantidad = String.valueOf(modeloF.getValueAt(fila, columnaCantidad));
            String sPrecioUnit = String.valueOf(modeloF.getValueAt(fila, columnaPrecio));
            double cantidad = Double.parseDouble(sCantidad);
            double precioUnit = Double.parseDouble(sPrecioUnit);
            valorTotal = valorTotal + (cantidad * precioUnit);
            fila++;
        }
        return valorTotal;
    }

    boolean existeNumFactura(String numFac) {
        String sql = "SELECT numero_factura FROM facturas WHERE numero_factura LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numFac);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //numFac
            }
            if (datos[0] != null) {
                return true;
            }
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }

    boolean existeNumDetalle(String numDet) {
        String sql = "SELECT numero_detalle FROM detalle_factura WHERE numero_detalle LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numDet);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //numFac
            }
            if (datos[0] != null) {
                return true;
            }
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }

    boolean sePuedeAnular(String fecha) {
        String sql = "SELECT TIMESTAMPDIFF(DAY,?,CURDATE())";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //numFac
            }
            int diasTranscurridos = Integer.parseInt(datos[0]);
            if (diasTranscurridos <= 8) {
                return true;
            }
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }

    boolean estaAnulada(String numFac) {
        String sql = "SELECT anulada from facturas WHERE numero_factura LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numFac);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //numFac
            }
            String anulada = datos[0];
            if (anulada.equals("si")) {
                return true;
            }
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }

    String obtenerFechaEmision(String numFac) {
        String fechaEmi;
        String sql = "SELECT fecha FROM facturas WHERE numero_factura LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numFac);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //codigo
            }
            fechaEmi = datos[0];
            return fechaEmi;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }
    
    String obtenerDetalle(String numFac) {
        String numeroDetalle;
        String sql = "SELECT numero_detalle FROM facturas WHERE numero_factura LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numFac);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //codigo
            }
            numeroDetalle = datos[0];
            return numeroDetalle;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
        }
    }

    void anularFactura(String numFac) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;

        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update facturas set anulada = ? WHERE numero_factura LIKE ?");
            pstm.setString(1, "si");
            pstm.setString(2, numFac);
            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "¡Factura anulada exitosamente!");

        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void anularDetalle(String numDet) {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        com.mysql.jdbc.PreparedStatement pstm;

        try {
            pstm = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement("update detalle_factura set anulado = ? WHERE numero_detalle LIKE ?");
            pstm.setString(1, "si");
            pstm.setString(2, numDet);
            pstm.executeUpdate();

        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    String obtenerNumDetalle(String numFac) {
        String numDet;
        String sql = "SELECT numero_detalle FROM facturas WHERE numero_factura LIKE ?";

        String datos[] = new String[1];

        Conexion con = new Conexion();
        Connection cn = (Connection) con.conexion();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, numFac);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); //codigo
            }
            numDet = datos[0];
            return numDet;
        } catch (SQLException e) {
            //Logger.getLogger(MóduloClientes.class.getName()).log(Level.SEVERE, null, e);
            return "";
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
        jPanel7 = new javax.swing.JPanel();
        txtCedulaClienteGP = new javax.swing.JTextField();
        txtCodigoProductoGP = new javax.swing.JTextField();
        txtCantidadProductoGP = new javax.swing.JTextField();
        btnAgregarProductoGP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductosP = new javax.swing.JTable();
        btnEliminarProductoGP = new javax.swing.JButton();
        btnAtrasGP = new javax.swing.JButton();
        btnGenerarProforma = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGenerarFactura = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txtCedulaClienteGF = new javax.swing.JTextField();
        txtCodigoProductoGF = new javax.swing.JTextField();
        txtCantidadProductoGF = new javax.swing.JTextField();
        btnAgregarProductoGF = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductosF = new javax.swing.JTable();
        btnEliminarProductoGF = new javax.swing.JButton();
        btnAtrasGF = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAtrasAF = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        txtNumFacturaAF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAnularFactura = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnAtrasCF = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        txtNumFacturaCF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnConsultarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendedor de Mostrador");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos del Cliente"));

        btnAgregarProductoGP.setText("Agregar Producto");
        btnAgregarProductoGP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoGPActionPerformed(evt);
            }
        });

        jLabel1.setText("Código del Producto");

        jLabel2.setText("C.I. del Cliente");

        jLabel3.setText("Cantidad");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Productos"));

        tblProductosP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Producto", "Cantidad", "Precio Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProductosP);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );

        btnEliminarProductoGP.setText("Eliminar Producto");
        btnEliminarProductoGP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoGPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtCedulaClienteGP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadProductoGP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoProductoGP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregarProductoGP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarProductoGP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaClienteGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProductoGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProductoGP)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadProductoGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnEliminarProductoGP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAtrasGP.setText("Atrás");
        btnAtrasGP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasGPActionPerformed(evt);
            }
        });

        btnGenerarProforma.setText("Generar Proforma");
        btnGenerarProforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarProformaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtrasGP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarProforma)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasGP)
                    .addComponent(btnGenerarProforma))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Generar Proforma", jPanel1);

        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos del Cliente"));

        btnAgregarProductoGF.setText("Agregar Producto");
        btnAgregarProductoGF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoGFActionPerformed(evt);
            }
        });

        jLabel6.setText("Código del Producto");

        jLabel7.setText("C.I. del Cliente");

        jLabel13.setText("Cantidad");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Productos"));

        tblProductosF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Producto", "Cantidad", "Precio Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProductosF);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );

        btnEliminarProductoGF.setText("Eliminar Producto");
        btnEliminarProductoGF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoGFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtCedulaClienteGF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadProductoGF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoProductoGF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregarProductoGF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarProductoGF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaClienteGF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProductoGF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProductoGF)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadProductoGF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnEliminarProductoGF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAtrasGF.setText("Atrás");
        btnAtrasGF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasGFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAtrasGF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarFactura)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasGF)
                    .addComponent(btnGenerarFactura))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Generar Factura", jPanel2);

        btnAtrasAF.setText("Atrás");
        btnAtrasAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasAFActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Anular"));

        jLabel4.setText("Número de Factura");

        btnAnularFactura.setText("Anular Factura");
        btnAnularFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnAnularFactura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(txtNumFacturaAF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumFacturaAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addComponent(btnAnularFactura)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAtrasAF)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnAtrasAF)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Anular Factura", jPanel3);

        btnAtrasCF.setText("Atrás");
        btnAtrasCF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCFActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Consultar"));

        jLabel5.setText("Número de Factura");

        btnConsultarFactura.setText("Consultar Factura");
        btnConsultarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(txtNumFacturaCF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(btnConsultarFactura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumFacturaCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addComponent(btnConsultarFactura)
                .addContainerGap())
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
                        .addComponent(btnAtrasCF)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnAtrasCF)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar Factura", jPanel5);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasGPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasGPActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasGPActionPerformed

    private void btnAtrasGFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasGFActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasGFActionPerformed

    private void btnAtrasAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasAFActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasAFActionPerformed

    private void btnAtrasCFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCFActionPerformed
        // TODO add your handling code here:
        VendedorDeMostrador nuevoVendedor = new VendedorDeMostrador();
        nuevoVendedor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasCFActionPerformed

    private void btnConsultarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarFacturaActionPerformed
        // TODO add your handling code here:
        String numFac;
        if (txtNumFacturaCF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para consultar una factura debe ingresar un número de factura", "Error", JOptionPane.WARNING_MESSAGE);
            txtNumFacturaCF.setText("");
        } else {
            numFac = txtNumFacturaCF.getText();
            if (!nuevaFacturaC.esNumeroFacturaValido(numFac)) {
                JOptionPane.showMessageDialog(null, "Número de factura incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtNumFacturaCF.setText("");
            } else {
                if (!existeNumFactura(numFac)) {
                    JOptionPane.showMessageDialog(null, "¡La factura no existe! - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtNumFacturaCF.setText("");
                } else {
                    nuevaFacturaC.numFactura = numFac;
                    nuevaFacturaC.numDetalle = obtenerDetalle(numFac);
                    //------------------------------------------------------------------------
                    VentanaConsultaFactura nuevaVentanaFactura = new VentanaConsultaFactura();
                    nuevaVentanaFactura.setVisible(true);
                    this.dispose();
                    //------------------------------------------------------------------------
                }
            }
        }
    }//GEN-LAST:event_btnConsultarFacturaActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        // TODO add your handling code here:
        String cedula;

        if (txtCedulaClienteGF.getText().equals("")
                || modeloF.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Error al generar factura", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            cedula = txtCedulaClienteGF.getText();
            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                cedula = nuevoCliente.validarCedula(cedula);
                nuevoCliente.tipoDoc = "C.I.";
                nuevoCliente.numDoc = cedula;
                if (!nuevoCliente.esDocumentoValido()) {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    double precio = calcularValorAPagarF();
                    precioFinal = precio + (precio * (0.12));
                    precioFinal = Math.round(precioFinal * 100.0) / 100.0;

                    String numFac = "";
                    int i = 1;
                    int bandera = 0;
                    while (bandera == 0) {
                        numFac = String.format("%07d", i);
                        if (existeNumFactura(numFac)) {
                            i++;
                        } else {
                            bandera = 1;
                        }
                    }

                    String numDetalle = "";
                    int j = 1;
                    int bandera2 = 0;
                    while (bandera2 == 0) {
                        numDetalle = "d" + String.format("%06d", j);
                        if (existeNumDetalle(numDetalle)) {
                            j++;
                        } else {
                            bandera2 = 1;
                        }
                    }

                    nuevaFactura.numFactura = numFac;
                    nuevaFactura.fecha = obtenerFecha();
                    nuevaFactura.cedulaCliente = nuevoCliente.numDoc;
                    nuevaFactura.numDetalle = numDetalle;
                    nuevaFactura.anulado = "no";
                    nuevaFactura.precioFinal = precioFinal;

                    //----------------------------------------------------------------------
                    VentanaFactura nuevaVentanaFactura = new VentanaFactura();
                    nuevaVentanaFactura.setVisible(true);
                    this.dispose();
                    //----------------------------------------------------------------------
                }
            }
        }


    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void btnGenerarProformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarProformaActionPerformed
        // TODO add your handling code here:
        String cedula;

        if (txtCedulaClienteGP.getText().equals("")
                || modeloP.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Error al generar proforma", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            cedula = txtCedulaClienteGP.getText();
            if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                txtCantidadProductoGP.requestFocus();
            } else {
                cedula = nuevoCliente.validarCedula(cedula);
                nuevoCliente.tipoDoc = "C.I.";
                nuevoCliente.numDoc = cedula;
                if (!nuevoCliente.esDocumentoValido()) {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCantidadProductoGP.requestFocus();
                } else {
                    double precio = calcularValorAPagar();
                    precioFinal = precio + (precio * (0.12));
                    precioFinal = Math.round(precioFinal * 100.0) / 100.0;
                    //----------------------------------------------------------------------
                    VentanaProforma nuevaProforma = new VentanaProforma();
                    nuevaProforma.setVisible(true);
                    this.dispose();
                    //----------------------------------------------------------------------
                }
            }
        }

    }//GEN-LAST:event_btnGenerarProformaActionPerformed

    private void btnAgregarProductoGPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoGPActionPerformed
        // TODO add your handling code here:
        //String cedula;
        String codigoProducto;
        String cantidad;
        Producto nuevoProducto = new Producto();

        if (txtCodigoProductoGP.getText().equals("")
                || txtCantidadProductoGP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para agregar un producto debe llenar los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            codigoProducto = txtCodigoProductoGP.getText();
            if (!nuevoProducto.esCodigoValido(codigoProducto)) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                txtCodigoProductoGP.requestFocus();
            } else {
                nuevoProducto.codigo = codigoProducto;
                if (!existe(nuevoProducto.codigo)) {
                    JOptionPane.showMessageDialog(null, "¡El producto no existe!", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCodigoProductoGP.requestFocus();
                } else {
                    cantidad = txtCantidadProductoGP.getText();
                    if (!nuevoProducto.esStockValido(cantidad)) {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCantidadProductoGP.requestFocus();
                    } else {
                        nuevoProducto.stock = Integer.parseInt(cantidad);
                        if (!hayStock(nuevoProducto.codigo, cantidad)) {
                            JOptionPane.showMessageDialog(null, "La cantidad solicitada sobrepasa el stock del producto", "Error", JOptionPane.WARNING_MESSAGE);
                            txtCantidadProductoGP.requestFocus();
                        } else {
                            String nombre = obtenerNombreProducto(nuevoProducto.codigo);
                            nuevoProducto.nombre = nombre;

                            String tipo = obtenerTipoProducto(nuevoProducto.codigo);
                            nuevoProducto.tipo = tipo;

                            String precioUnit = obtenerPrecioUnitarioProducto(nuevoProducto.codigo);
                            nuevoProducto.precioUnitario = Double.parseDouble(precioUnit);

                            String precioDist = obtenerPrecioDistribuidorProducto(nuevoProducto.codigo);
                            nuevoProducto.precioDistribuidor = Double.parseDouble(precioDist);

                            String proveedor = obtenerProveedorProducto(nuevoProducto.codigo);
                            nuevoProducto.proveedor = proveedor;

                            String sucursal = obtenerSucursalProducto(nuevoProducto.codigo);
                            nuevoProducto.sucursal = sucursal;

                            listaP.insertarOrdenado(nuevoProducto);
                            agregarProducto(nombre, cantidad, precioUnit);

                            txtCodigoProductoGP.setText("");
                            txtCantidadProductoGP.setText("");
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btnAgregarProductoGPActionPerformed

    private void btnEliminarProductoGPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoGPActionPerformed
        // TODO add your handling code here:
        eliminarProducto();
    }//GEN-LAST:event_btnEliminarProductoGPActionPerformed

    private void btnAgregarProductoGFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoGFActionPerformed
        // TODO add your handling code here:
        String codigoProducto;
        String cantidad;
        Producto nuevoProducto = new Producto();

        if (txtCodigoProductoGF.getText().equals("")
                || txtCantidadProductoGF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para agregar un producto debe llenar los campos", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            codigoProducto = txtCodigoProductoGF.getText();
            if (!nuevoProducto.esCodigoValido(codigoProducto)) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                txtCodigoProductoGF.requestFocus();
            } else {
                nuevoProducto.codigo = codigoProducto;
                if (!existe(nuevoProducto.codigo)) {
                    JOptionPane.showMessageDialog(null, "¡El producto no existe!", "Error", JOptionPane.WARNING_MESSAGE);
                    txtCodigoProductoGF.requestFocus();
                } else {
                    cantidad = txtCantidadProductoGF.getText();
                    if (!nuevoProducto.esStockValido(cantidad)) {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos - Corrija", "Error", JOptionPane.WARNING_MESSAGE);
                        txtCantidadProductoGF.requestFocus();
                    } else {
                        nuevoProducto.stock = Integer.parseInt(cantidad);
                        if (!hayStock(nuevoProducto.codigo, cantidad)) {
                            JOptionPane.showMessageDialog(null, "La cantidad solicitada sobrepasa el stock del producto", "Error", JOptionPane.WARNING_MESSAGE);
                            txtCantidadProductoGF.requestFocus();
                        } else {
                            String nombre = obtenerNombreProducto(nuevoProducto.codigo);
                            nuevoProducto.nombre = nombre;

                            String tipo = obtenerTipoProducto(nuevoProducto.codigo);
                            nuevoProducto.tipo = tipo;

                            String precioUnit = obtenerPrecioUnitarioProducto(nuevoProducto.codigo);
                            nuevoProducto.precioUnitario = Double.parseDouble(precioUnit);

                            String precioDist = obtenerPrecioDistribuidorProducto(nuevoProducto.codigo);
                            nuevoProducto.precioDistribuidor = Double.parseDouble(precioDist);

                            String proveedor = obtenerProveedorProducto(nuevoProducto.codigo);
                            nuevoProducto.proveedor = proveedor;

                            String sucursal = obtenerSucursalProducto(nuevoProducto.codigo);
                            nuevoProducto.sucursal = sucursal;

                            listaF.insertarOrdenado(nuevoProducto);
                            agregarProductoF(nombre, cantidad, precioUnit);

                            reducirStock(nuevoProducto.codigo, cantidad);

                            txtCodigoProductoGF.setText("");
                            txtCantidadProductoGF.setText("");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarProductoGFActionPerformed

    private void btnEliminarProductoGFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoGFActionPerformed
        // TODO add your handling code here:
        int fila = tblProductosF.getSelectedRow();
        String nombre = String.valueOf(modeloF.getValueAt(fila, 0));
        Producto prodEliminar = obtenerProducto(nombre);
        aumentarStock(prodEliminar.codigo, String.valueOf(modeloF.getValueAt(fila, 1)));
        eliminarProductoF();
    }//GEN-LAST:event_btnEliminarProductoGFActionPerformed

    private void btnAnularFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularFacturaActionPerformed
        // TODO add your handling code here:
        String numFac;
        if (txtNumFacturaAF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para anular una factura debe ingresar un número de factura", "Error", JOptionPane.WARNING_MESSAGE);
            txtNumFacturaAF.setText("");
        } else {
            numFac = txtNumFacturaAF.getText();
            if (!nuevaFactura.esNumeroFacturaValido(numFac)) {
                JOptionPane.showMessageDialog(null, "Número de factura incorrecto - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                txtNumFacturaAF.setText("");
            } else {
                if (!existeNumFactura(numFac)) {
                    JOptionPane.showMessageDialog(null, "¡La factura no existe! - Vuelva a Ingresar", "Error", JOptionPane.WARNING_MESSAGE);
                    txtNumFacturaAF.setText("");
                } else {
                    String fechaEmision = obtenerFechaEmision(numFac);
                    if (!sePuedeAnular(fechaEmision)) {
                        JOptionPane.showMessageDialog(null, "Se ha excedido la fecha límite para la anulación de esta factura", "Error", JOptionPane.WARNING_MESSAGE);
                        txtNumFacturaAF.setText("");
                    } else {
                        if (estaAnulada(numFac)) {
                            JOptionPane.showMessageDialog(null, "Esta factura ya se ha anulado previamente", "Error", JOptionPane.WARNING_MESSAGE);
                            txtNumFacturaAF.setText("");
                        } else {
                            anularFactura(numFac);
                            String numDetalle = obtenerNumDetalle(numFac);
                            anularDetalle(numDetalle);

                            txtNumFacturaAF.setText("");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAnularFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(MóduloFacturaciónVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MóduloFacturaciónVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MóduloFacturaciónVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MóduloFacturaciónVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MóduloFacturaciónVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProductoGF;
    private javax.swing.JButton btnAgregarProductoGP;
    private javax.swing.JButton btnAnularFactura;
    private javax.swing.JButton btnAtrasAF;
    private javax.swing.JButton btnAtrasCF;
    private javax.swing.JButton btnAtrasGF;
    private javax.swing.JButton btnAtrasGP;
    private javax.swing.JButton btnConsultarFactura;
    private javax.swing.JButton btnEliminarProductoGF;
    private javax.swing.JButton btnEliminarProductoGP;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnGenerarProforma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblProductosF;
    private javax.swing.JTable tblProductosP;
    private javax.swing.JTextField txtCantidadProductoGF;
    private javax.swing.JTextField txtCantidadProductoGP;
    private javax.swing.JTextField txtCedulaClienteGF;
    private javax.swing.JTextField txtCedulaClienteGP;
    private javax.swing.JTextField txtCodigoProductoGF;
    private javax.swing.JTextField txtCodigoProductoGP;
    private javax.swing.JTextField txtNumFacturaAF;
    private javax.swing.JTextField txtNumFacturaCF;
    // End of variables declaration//GEN-END:variables
}
