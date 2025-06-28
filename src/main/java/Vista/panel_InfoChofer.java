
package Vista;

import Controlador.*;
import Modelo.Chofer;
import Util.FechasHora;
import com.github.lgooddatepicker.components.DatePickerSettings;

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
public class panel_InfoChofer extends JPanel {
    
    private Chofer chofer;
    private C_Controlador controlador;
    private JTable tabla;
    private int fila;
    
    private StringBuilder errores;
    
    public panel_InfoChofer(C_Controlador controlador,JTable tabla) {
        initComponents();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
        
        this.controlador = controlador;
        this.tabla = tabla;
        
        visibilidadComponentes_GuardarChofer(true);
        cambiarFormatoFecha();
    }
    
    public panel_InfoChofer(C_Controlador controlador,JTable tabla,Chofer chofer,int fila){
        initComponents();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
        this.chofer = chofer;
        this.controlador = controlador;
        this.tabla = tabla;
        this.fila = fila;
        
        
        visibilidadComponentes_GuardarChofer(false);
        
        cambiarFormatoFecha();
        llenarCamposChofer(chofer);
    }
    
    private void visibilidadComponentes_GuardarChofer(boolean validar){
        txtID.setVisible(!validar);
        label_ID.setVisible(!validar);
        bttActualizar.setVisible(!validar);  //Bebita gaaa
        bttGuardar.setVisible(validar);
        label_CreaChofer.setVisible(validar);
    }
    
    private void cambiarFormatoFecha(){
        DatePickerSettings settings = new DatePickerSettings();
        settings.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateChofer.setSettings(settings);
        
    }
    
    private void llenarCamposChofer(Chofer chofer){
        txtID.setVisible(true);
        label_chofer.setText("Actualizar informacion del chofer");
        txtID.setText(String.valueOf(chofer.getIdChofer()));
        txtNombre.setText(chofer.getNombre());
        if(chofer.getCategoria().equals("Profesional")){
            rbProfesional.setSelected(true);
        }else if(chofer.getCategoria().equals("Semiprofesional")){
            rbSemiProfesional.setSelected(true);
        }
        dateChofer.getComponentDateTextField().setText(chofer.getFechaIngreso());
    }
    
    private void ponerImagen(JButton boton, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(40,20,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
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
        panel_barra = new javax.swing.JPanel();
        label_chofer = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        bttGuardar = new javax.swing.JButton();
        label_CreaChofer = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbProfesional = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        dateChofer = new com.github.lgooddatepicker.components.DatePicker();
        rbSemiProfesional = new javax.swing.JRadioButton();
        bttActualizar = new javax.swing.JButton();
        label_ID = new javax.swing.JLabel();

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.setToolTipText("");
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));
        panel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        label_chofer.setText("Guardar informacion del chofer");
        label_chofer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_chofer.setForeground(new java.awt.Color(255, 255, 255));

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
                .addComponent(label_chofer, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_barraLayout.setVerticalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_chofer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bttFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 60));

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
        Panel_Principal.add(bttGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 130, 30));

        label_CreaChofer.setText("-- Crea un chofer --");
        label_CreaChofer.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_CreaChofer.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(label_CreaChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 20));

        txtID.setEditable(false);
        txtID.setEnabled(false);
        Panel_Principal.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 110, -1));

        jLabel4.setText("Nombre        ");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));
        Panel_Principal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, -1));

        jLabel5.setText("Categoria");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        buttonGroup1.add(rbProfesional);
        rbProfesional.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbProfesional.setForeground(new java.awt.Color(153, 153, 153));
        rbProfesional.setText("Profesional");
        Panel_Principal.add(rbProfesional, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel7.setText("Fecha de ingreso");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        dateChofer.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(dateChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 30));

        buttonGroup1.add(rbSemiProfesional);
        rbSemiProfesional.setText("Semiprofesional");
        rbSemiProfesional.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(rbSemiProfesional, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

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
        Panel_Principal.add(bttActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 130, 30));

        label_ID.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_ID.setForeground(new java.awt.Color(153, 153, 153));
        label_ID.setText("ID           ");
        Panel_Principal.add(label_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean camposValidos(){
        errores = new StringBuilder();
        if(!txtNombre.getText().trim().matches("^([A-Z][a-z]+)(\\s[A-Z][a-z]+)?$")||txtNombre.getText().isEmpty()){
            errores.append("El campo de nombre es invalido o esta vacio\n");
        }
        if(buttonGroup1.getSelection() == null){
            errores.append("Seleccione un tipo de chofer\n");
        }
        if(dateChofer.getComponentDateTextField().getText().isEmpty()){
            errores.append("El campo de fecha esta vacia\n");
        }
        
        return !(errores.length()>0);
    }
    
    private void bttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarActionPerformed
        if(camposValidos()){
            
            chofer = new Chofer();
            
            chofer.setNombre(txtNombre.getText());
            
            if(rbProfesional.isSelected()){
                chofer.setIndice(rbProfesional.getText());
            }else if(rbSemiProfesional.isSelected()){
                chofer.setIndice(rbSemiProfesional.getText());
            }
            
            chofer.setFechaIngreso(FechasHora.parseString(dateChofer.getDate()));
            
            if(controlador.cChofer.insertarChofer(chofer)){
                controlador.cChofer.insertarMapChofer(chofer);
                controlador.cChofer.insertarTabla(tabla, chofer);
            }
            
            ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);
            
        }else {
            
            JOptionPane.showMessageDialog(this, 
                                                errores,
                                                "Error",
                                            JOptionPane.ERROR_MESSAGE);
            
            limpiarCampos();
        }
    }//GEN-LAST:event_bttGuardarActionPerformed
    
    private void limpiarCampos(){
        txtNombre.setText("");
        buttonGroup1.clearSelection();
        dateChofer.getComponentDateTextField().setText("");
    }
    
    private void bttActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarActionPerformed
        if(camposValidos()){
        
            chofer.setNombre(txtNombre.getText());
            
            if(rbProfesional.isSelected()){
                chofer.setIndice(rbProfesional.getText());
            }else if(rbSemiProfesional.isSelected()){
                chofer.setIndice(rbSemiProfesional.getText());
            }
            
            chofer.setFechaIngreso(String.valueOf(dateChofer.getDate()));
      
            if(controlador.cChofer.actualizarChofer(chofer)){
                
                tabla.setValueAt(chofer.getIdChofer(), fila, 0);
                tabla.setValueAt(chofer.getNombre(), fila, 1);
                tabla.setValueAt(chofer.getCategoria(), fila, 2);
                tabla.setValueAt(chofer.getFechaIngreso(), fila, 3);
                
                controlador.cChofer.insertarMapChofer(chofer); // el metodo put que contiene ese insertarMapChofer tambien actualiza ese valor en el Hash
            }
            
            ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);
            
        }else {
            
            JOptionPane.showMessageDialog(this, 
                                                errores,
                                                "Error",
                                            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton bttActualizar;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JButton bttGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.github.lgooddatepicker.components.DatePicker dateChofer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label_CreaChofer;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_chofer;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JRadioButton rbProfesional;
    private javax.swing.JRadioButton rbSemiProfesional;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
