
package Vista;

import Controlador.*;
import Modelo.Bus;
import Modelo.Chofer;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
/**
 *
 * @author RODRIGO
 */
public class panel_InfoBus extends JPanel {
    
    private C_Controlador controlador;
    private JTable tabla;
    private Chofer chofer;
    private Bus bus;
    private int fila;
    
    public panel_InfoBus(C_Controlador controlador, JTable tabla) {
        initComponents();
        
        this.controlador = controlador;
        this.tabla = tabla;
        
        visibilidadComponentes_de_GuardarChofer(true);
        
        crearDatosInfoBus();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
    }
    
    public panel_InfoBus(C_Controlador controlador, JTable tabla,Bus bus,int fila) {
        initComponents();
        
        this.controlador = controlador;
        this.tabla = tabla;
        this.bus = bus;
        this.fila=fila;
        
        visibilidadComponentes_de_GuardarChofer(false);
        
        llenarCamposBus();
        crearDatosInfoBus();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
    }
    
    private void ponerImagen(JButton boton, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(40,20,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
    }
    
    private void visibilidadComponentes_de_GuardarChofer(Boolean validar){
        txtID.setVisible(!validar);
        label_ID.setVisible(!validar);
        bttActualizar.setVisible(!validar);
        label_CrearBus.setVisible(validar);
        bttGuardar.setVisible(validar);
    }
    
    private void llenarCamposBus(){
        txtID.setVisible(true);
        label_bus.setText("Actualizar informacion del bus");
        txtID.setText(String.valueOf(bus.getIdBus()));
        chofer = bus.getChofer();
    }
    
    private void crearDatosInfoBus(){
        controlador.cChofer.llenarTablaChoferInfoBus(tabla_Choferxbus);
        rbTodos.setSelected(true);
    }
    
    public JButton getBttFlecha() {
        return bttFlecha;
    }

    public void setBttFlecha(JButton bttFlecha) {
        this.bttFlecha = bttFlecha;
    }

    public JPanel getPanel_barra() {
        return panel_barra;
    }

    public void setPanel_barra(JPanel panel_barra) {
        this.panel_barra = panel_barra;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Panel_Principal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Choferxbus = new javax.swing.JTable();
        panel_barra = new javax.swing.JPanel();
        label_bus = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        bttActualizar = new javax.swing.JButton();
        label_CrearBus = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        rbSemiprofesional = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rbProfesional = new javax.swing.JRadioButton();
        bttGuardar = new javax.swing.JButton();
        label_ID = new javax.swing.JLabel();

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Mostrar :");
        Panel_Principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, 20));

        tabla_Choferxbus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Chofer", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_Choferxbus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_ChoferxbusMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_Choferxbus);

        Panel_Principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 370, 250));

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));
        panel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        label_bus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_bus.setForeground(new java.awt.Color(255, 255, 255));
        label_bus.setText("Guardar informacion del bus");

        bttFlecha.setBackground(new java.awt.Color(53, 93, 127));
        bttFlecha.setBorderPainted(false);
        bttFlecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panel_barraLayout = new javax.swing.GroupLayout(panel_barra);
        panel_barra.setLayout(panel_barraLayout);
        panel_barraLayout.setHorizontalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(bttFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        panel_barraLayout.setVerticalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bttFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

        bttActualizar.setBackground(new java.awt.Color(53, 93, 127));
        bttActualizar.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        bttActualizar.setForeground(new java.awt.Color(255, 255, 255));
        bttActualizar.setText("Actualizar");
        bttActualizar.setBorderPainted(false);
        bttActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarActionPerformed(evt);
            }
        });
        Panel_Principal.add(bttActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, 30));

        label_CrearBus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_CrearBus.setForeground(new java.awt.Color(153, 153, 153));
        label_CrearBus.setText("-- Crea un bus --");
        Panel_Principal.add(label_CrearBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        txtID.setEditable(false);
        txtID.setEnabled(false);
        Panel_Principal.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, -1));

        buttonGroup1.add(rbSemiprofesional);
        rbSemiprofesional.setForeground(new java.awt.Color(153, 153, 153));
        rbSemiprofesional.setText("Semiprofesional");
        rbSemiprofesional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSemiprofesionalItemStateChanged(evt);
            }
        });
        Panel_Principal.add(rbSemiprofesional, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        buttonGroup1.add(rbTodos);
        rbTodos.setForeground(new java.awt.Color(153, 153, 153));
        rbTodos.setText("Todos");
        rbTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbTodosItemStateChanged(evt);
            }
        });
        Panel_Principal.add(rbTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText(" Selecciona el chofer para su bus: ");
        Panel_Principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        buttonGroup1.add(rbProfesional);
        rbProfesional.setForeground(new java.awt.Color(153, 153, 153));
        rbProfesional.setText("Profesional");
        rbProfesional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbProfesionalItemStateChanged(evt);
            }
        });
        Panel_Principal.add(rbProfesional, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        bttGuardar.setBackground(new java.awt.Color(53, 93, 127));
        bttGuardar.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        bttGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bttGuardar.setText("Guardar");
        bttGuardar.setBorderPainted(false);
        bttGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarActionPerformed(evt);
            }
        });
        Panel_Principal.add(bttGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, 30));

        label_ID.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_ID.setForeground(new java.awt.Color(153, 153, 153));
        label_ID.setText("IDBus        ");
        Panel_Principal.add(label_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean camposValidos(){
        return !(chofer == null);
    }
    
    private void bttActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarActionPerformed
        if(camposValidos()){
            
            bus.setIdBus(Integer.parseInt(txtID.getText()));
            bus.setChofer(chofer);
            
            if(controlador.cBus.actualizarBus(bus)){
                tabla.setValueAt(bus.getIdBus(), fila, 0);
                tabla.setValueAt(bus.getChofer().getNombre(), fila, 1);
                controlador.cBus.insertarMapBus(bus); // el metodo put que contiene ese insertarMapBus tambien actualiza ese valor en el Hash
            }
            
            ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un chofer", "Chofer nulo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttActualizarActionPerformed

    private void rbTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbTodosItemStateChanged
        controlador.cChofer.llenarTablaChoferInfoBus(tabla_Choferxbus);
    }//GEN-LAST:event_rbTodosItemStateChanged

    private void rbProfesionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbProfesionalItemStateChanged
        controlador.cChofer.llenarTablaChoferInfoBusFiltro(tabla_Choferxbus,"Profesional");
    }//GEN-LAST:event_rbProfesionalItemStateChanged

    private void rbSemiprofesionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSemiprofesionalItemStateChanged
        controlador.cChofer.llenarTablaChoferInfoBusFiltro(tabla_Choferxbus,"Semiprofesional");
    }//GEN-LAST:event_rbSemiprofesionalItemStateChanged

    private void bttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarActionPerformed
        if(camposValidos()){
            
            bus = new Bus();
            bus.setChofer(chofer);
            
            if(controlador.cBus.insertarBus(bus)){
                controlador.cBus.insertarMapBus(bus);
                controlador.cBus.insertarTabla(tabla, bus);
            }

            ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un chofer", "Chofer nulo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttGuardarActionPerformed

    private void tabla_ChoferxbusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ChoferxbusMousePressed
        int fila = tabla_Choferxbus.rowAtPoint(evt.getPoint()); // no confundan la variable fila con la fila que se pasa por parametro del constructor son distintos
        if(fila>=0){
            chofer = controlador.cChofer.buscarMapChofer((Integer)tabla_Choferxbus.getValueAt(fila, 0));
        }
    }//GEN-LAST:event_tabla_ChoferxbusMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton bttActualizar;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JButton bttGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_CrearBus;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_bus;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JRadioButton rbProfesional;
    private javax.swing.JRadioButton rbSemiprofesional;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tabla_Choferxbus;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
