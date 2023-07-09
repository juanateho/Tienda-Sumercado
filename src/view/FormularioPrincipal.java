package view;

/**
 *
 * @author juana
 */
public class FormularioPrincipal extends javax.swing.JFrame {

    public FormularioPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu8 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnInicio = new javax.swing.JMenu();
        btnVentas = new javax.swing.JMenu();
        btnCompras = new javax.swing.JMenu();
        btnProductos = new javax.swing.JMenu();
        btnAgregarProductos = new javax.swing.JMenuItem();
        btnInventario = new javax.swing.JMenuItem();
        btnClientes = new javax.swing.JMenu();
        btnAgregarClientes = new javax.swing.JMenuItem();
        btnBuscarClientes = new javax.swing.JMenuItem();
        btnProveedores = new javax.swing.JMenu();
        btnAgregarProveedores = new javax.swing.JMenuItem();
        btnBuscarProveedores = new javax.swing.JMenuItem();
        btnEmpleados = new javax.swing.JMenu();
        btnAgregarEmpleados = new javax.swing.JMenuItem();
        btnBuscarEmpleados = new javax.swing.JMenuItem();

        jMenu8.setText("jMenu8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(153, 153, 0));
        escritorio.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido al sistema de Compra y Venta de Sumercado");

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        btnInicio.setText("Inicio");
        jMenuBar1.add(btnInicio);

        btnVentas.setText("Ventas");
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnVentas);

        btnCompras.setText("Compras");
        btnCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprasMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCompras);

        btnProductos.setText("Productos");

        btnAgregarProductos.setText("Agregar");
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });
        btnProductos.add(btnAgregarProductos);

        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        btnProductos.add(btnInventario);

        jMenuBar1.add(btnProductos);

        btnClientes.setText("Clientes");

        btnAgregarClientes.setText("Agregar");
        btnAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClientesActionPerformed(evt);
            }
        });
        btnClientes.add(btnAgregarClientes);

        btnBuscarClientes.setText("Buscar");
        btnBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClientesActionPerformed(evt);
            }
        });
        btnClientes.add(btnBuscarClientes);

        jMenuBar1.add(btnClientes);

        btnProveedores.setText("Proveedores");

        btnAgregarProveedores.setText("Agregar");
        btnAgregarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedoresActionPerformed(evt);
            }
        });
        btnProveedores.add(btnAgregarProveedores);

        btnBuscarProveedores.setText("Buscar");
        btnBuscarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedoresActionPerformed(evt);
            }
        });
        btnProveedores.add(btnBuscarProveedores);

        jMenuBar1.add(btnProveedores);

        btnEmpleados.setText("Empleados");

        btnAgregarEmpleados.setText("Agregar");
        btnAgregarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadosActionPerformed(evt);
            }
        });
        btnEmpleados.add(btnAgregarEmpleados);

        btnBuscarEmpleados.setText("Buscar");
        btnBuscarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadosActionPerformed(evt);
            }
        });
        btnEmpleados.add(btnBuscarEmpleados);

        jMenuBar1.add(btnEmpleados);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        Ventas ventas = new Ventas();
        escritorio.add(ventas);
        ventas.show();
    }//GEN-LAST:event_btnVentasMouseClicked

    private void btnComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseClicked
        Compras compras = new Compras();
        escritorio.add(compras);
        compras.show();
    }//GEN-LAST:event_btnComprasMouseClicked

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        AgregarProductos agregarProductos = new AgregarProductos();
        escritorio.add(agregarProductos);
        agregarProductos.show();
    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        Inventario inventario = new Inventario();
        escritorio.add(inventario);
        inventario.show();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClientesActionPerformed
        AgregarClientes agregarClientes = new AgregarClientes();
        escritorio.add(agregarClientes);
        agregarClientes.show();
    }//GEN-LAST:event_btnAgregarClientesActionPerformed

    private void btnBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClientesActionPerformed
        BuscarClientes buscarClientes = new BuscarClientes();
        escritorio.add(buscarClientes);
        buscarClientes.show();
    }//GEN-LAST:event_btnBuscarClientesActionPerformed

    private void btnAgregarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedoresActionPerformed
        AgregarProveedores agregarProveedores = new AgregarProveedores();
        escritorio.add(agregarProveedores);
        agregarProveedores.show();
    }//GEN-LAST:event_btnAgregarProveedoresActionPerformed

    private void btnBuscarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedoresActionPerformed
        BuscarProveedores buscarProveedores = new BuscarProveedores();
        escritorio.add(buscarProveedores);
        buscarProveedores.show();
    }//GEN-LAST:event_btnBuscarProveedoresActionPerformed

    private void btnAgregarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadosActionPerformed
        AgregarEmpleados agregarEmpleados = new AgregarEmpleados();
        escritorio.add(agregarEmpleados);
        agregarEmpleados.show();
    }//GEN-LAST:event_btnAgregarEmpleadosActionPerformed

    private void btnBuscarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadosActionPerformed
        BuscarEmpleados buscarEmpleados = new BuscarEmpleados();
        escritorio.add(buscarEmpleados);
        buscarEmpleados.show();
    }//GEN-LAST:event_btnBuscarEmpleadosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new FormularioPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAgregarClientes;
    private javax.swing.JMenuItem btnAgregarEmpleados;
    private javax.swing.JMenuItem btnAgregarProductos;
    private javax.swing.JMenuItem btnAgregarProveedores;
    private javax.swing.JMenuItem btnBuscarClientes;
    private javax.swing.JMenuItem btnBuscarEmpleados;
    private javax.swing.JMenuItem btnBuscarProveedores;
    private javax.swing.JMenu btnClientes;
    private javax.swing.JMenu btnCompras;
    private javax.swing.JMenu btnEmpleados;
    private javax.swing.JMenu btnInicio;
    private javax.swing.JMenuItem btnInventario;
    private javax.swing.JMenu btnProductos;
    private javax.swing.JMenu btnProveedores;
    private javax.swing.JMenu btnVentas;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
