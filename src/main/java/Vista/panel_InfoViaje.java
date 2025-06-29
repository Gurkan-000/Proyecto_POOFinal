
package Vista;

import Controlador.C_Controlador;

import Modelo.Bus;
import Modelo.Ruta;
import Modelo.Viaje;

import com.github.lgooddatepicker.components.DatePickerSettings;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author RODRIGO
 */
public class panel_InfoViaje extends javax.swing.JPanel {

    private C_Controlador controlador;
    private JTable tabla;
    private StringBuilder errores;
    private JComboBox<Object> cbRuta;
    private Viaje viaje;
    private Bus bus;
    private int fila;
    
    public panel_InfoViaje(C_Controlador controlador,JTable tabla) {
        initComponents();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
        
        this.controlador = controlador;
        this.tabla = tabla;
        
        dateViaje.getComponentDateTextField().setEnabled(false);
        timeViaje.getComponentTimeTextField().setEnabled(false);
        visibilidadComponentes_GuardarChofer(true);
        cambiarFormatoFecha();
        crearComboRuta();
        
        controlador.cBus.llenarTablaInfoViaje(tabla_IDBusChofer);
    }
    
    public panel_InfoViaje(C_Controlador controlador,JTable tabla,Viaje viaje, int fila) {
        initComponents();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
        
        this.controlador = controlador;
        this.tabla = tabla;
        this.viaje = viaje;
        this.fila = fila;
        
        dateViaje.getComponentDateTextField().setEnabled(false);
        timeViaje.getComponentTimeTextField().setEnabled(false);
        visibilidadComponentes_GuardarChofer(false);
        cambiarFormatoFecha();
        crearComboRuta();
        llenarCampos();
        
        controlador.cBus.llenarTablaInfoViaje(tabla_IDBusChofer);
    }
    
    private void ponerImagen(JButton boton, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(40,20,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
    }

    private void visibilidadComponentes_GuardarChofer(boolean validar){
        txtID.setVisible(!validar);
        label_ID.setVisible(!validar);
        bttActualizar.setVisible(!validar);
        bttGuardar.setVisible(validar);
        label_CreaViaje.setVisible(validar);
    }
    
    private void llenarCampos(){
        label_viaje.setText("Actualizar informacion del viaje");
        txtID.setVisible(true);
        txtID.setText(String.valueOf(viaje.getIdViaje()));
        dateViaje.getComponentDateTextField().setText(viaje.getFecha());
        timeViaje.getComponentTimeTextField().setText(viaje.getHora());
        cbRuta.setSelectedItem(viaje.getRuta());
        bus = viaje.getBus();
    }
    
    private void cambiarFormatoFecha(){
        DatePickerSettings settings = new DatePickerSettings();
        settings.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateViaje.setSettings(settings);
    }
    
    private void crearComboRuta(){
        cbRuta = new JComboBox<>();
        Panel_Principal.add(cbRuta,new AbsoluteConstraints(50, 320, 120, 35));
        controlador.cRuta.llenarComboBox(cbRuta);
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

        Panel_Principal = new javax.swing.JPanel();
        panel_barra = new javax.swing.JPanel();
        label_viaje = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        bttGuardar = new javax.swing.JButton();
        label_ID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateViaje = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        timeViaje = new com.github.lgooddatepicker.components.TimePicker();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_IDBusChofer = new javax.swing.JTable();
        bttActualizar = new javax.swing.JButton();
        label_CreaViaje = new javax.swing.JLabel();

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));
        panel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        label_viaje.setText("Guardar informacion del viaje");
        label_viaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_viaje.setForeground(new java.awt.Color(255, 255, 255));

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
                .addComponent(label_viaje, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );
        panel_barraLayout.setVerticalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_viaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bttFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 60));

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
        Panel_Principal.add(bttGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 90, 30));

        label_ID.setText("ID           ");
        label_ID.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_ID.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(label_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 20));

        txtID.setEditable(false);
        txtID.setEnabled(false);
        txtID.setFocusable(false);
        Panel_Principal.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 120, -1));

        jLabel8.setText("Fecha del viaje          ");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));
        Panel_Principal.add(dateViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 180, -1));

        jLabel9.setText("Hora del viaje           ");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 20));
        Panel_Principal.add(timeViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 180, -1));

        jLabel11.setText("Selecciona la ruta          ");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 20));

        jLabel3.setText("Selecciona el bus del viaje    :");
        jLabel3.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        Panel_Principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        tabla_IDBusChofer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDBus", "Chofer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_IDBusChofer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_IDBusChoferMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_IDBusChofer);

        Panel_Principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 370, 270));

        bttActualizar.setText("Actualizar");
        bttActualizar.setBackground(new java.awt.Color(53, 93, 127));
        bttActualizar.setBorderPainted(false);
        bttActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttActualizar.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        bttActualizar.setForeground(new java.awt.Color(255, 255, 255));
        bttActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarActionPerformed(evt);
            }
        });
        Panel_Principal.add(bttActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 90, 30));

        label_CreaViaje.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_CreaViaje.setForeground(new java.awt.Color(153, 153, 153));
        label_CreaViaje.setText("-- Crea un viaje --");
        Panel_Principal.add(label_CreaViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean camposValidos(){
        errores = new StringBuilder();
        
        if(dateViaje.getComponentDateTextField().getText().isEmpty()){
            errores.append("El campo de fecha esta vacia\n");
        }
        
        if(timeViaje.getComponentTimeTextField().getText().isEmpty()){
            errores.append("El campo de hora esta vacia\n");
        }
        
        if(cbRuta.getSelectedIndex() == 0){
            errores.append("Seleccione una ruta\n");
        }
        
        if(bus == null){
            errores.append("Seleccione un bus\n");
        }
 
        return !(errores.length()>0);
    }
    
    private void bttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarActionPerformed
        
        if(camposValidos()){
            viaje = new Viaje();
            viaje.setFecha(String.valueOf(dateViaje.getDate()));
            viaje.setHora(String.valueOf(timeViaje.getTime()));
            viaje.setRuta((Ruta)cbRuta.getSelectedItem());
            viaje.setBus(bus);
            viaje.setAsientosDispo(20);
            
            if(controlador.cViaje.insertarViaje(viaje)){
                controlador.cViaje.insertarMapViaje(viaje);
                controlador.cViaje.insertarTabla(tabla, viaje);
            }
            
            ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);

        }else{
            JOptionPane.showMessageDialog(this, errores, "Campos invalidos", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_bttGuardarActionPerformed
    
    private void tabla_IDBusChoferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_IDBusChoferMousePressed
        fila = tabla_IDBusChofer.rowAtPoint(evt.getPoint());
        if(fila>=0){
            bus = controlador.cBus.buscarMapBus((Integer)tabla_IDBusChofer.getValueAt(fila, 0));
        }
    }//GEN-LAST:event_tabla_IDBusChoferMousePressed

    private void bttActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarActionPerformed
        if(camposValidos()){
            
            viaje.setIdViaje(Integer.parseInt(txtID.getText()));
            viaje.setFecha(String.valueOf(dateViaje.getDate()));
            viaje.setHora(String.valueOf(timeViaje.getTime()));
            viaje.setRuta((Ruta)cbRuta.getSelectedItem());
            viaje.setBus(bus);
            
            //Cabro el que lo lea
            if(controlador.cViaje.actualizarViaje(viaje)){
                tabla.setValueAt(viaje.getIdViaje(), fila, 0);
                tabla.setValueAt(viaje.getFecha(), fila, 1);
                tabla.setValueAt(viaje.getHora(), fila, 2);
                tabla.setValueAt(viaje.getRuta(), fila, 3);
                controlador.cViaje.insertarMapViaje(viaje); // el metodo put que contiene ese insertarViaje tambien actualiza ese valor en el Hash
            }

            
            ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);

        }else{
            JOptionPane.showMessageDialog(this, errores, "Campos vacios", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton bttActualizar;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JButton bttGuardar;
    private com.github.lgooddatepicker.components.DatePicker dateViaje;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_CreaViaje;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_viaje;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JTable tabla_IDBusChofer;
    private com.github.lgooddatepicker.components.TimePicker timeViaje;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
