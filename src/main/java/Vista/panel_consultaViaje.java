
package Vista;

import Controlador.*;
import Modelo.Viaje;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RODRIGO
 */
public class panel_consultaViaje extends javax.swing.JPanel {

    private C_Controlador controlador;
    
    public panel_consultaViaje(C_Controlador controlador) {
        initComponents();
        this.controlador = controlador;
        ponerImagen(bttFlecha, "Flecha_de_tu_vieja");
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

        jLabel7 = new javax.swing.JLabel();
        Panel_Principal = new javax.swing.JPanel();
        panel_barra = new javax.swing.JPanel();
        label_chofer = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        label_AsientosDisponibles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ViajeBoleto = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtIDViaje = new javax.swing.JTextField();
        txtAsientosDisponibles = new javax.swing.JTextField();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Ingrese un ID de viaje :");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.setToolTipText("");
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));
        panel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        label_chofer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_chofer.setForeground(new java.awt.Color(255, 255, 255));
        label_chofer.setText("Consultar informacion del viaje");

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
                .addContainerGap(233, Short.MAX_VALUE))
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

        Panel_Principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 60));

        label_AsientosDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_AsientosDisponibles.setForeground(new java.awt.Color(153, 153, 153));
        label_AsientosDisponibles.setText("Asientos disponibles   :");
        Panel_Principal.add(label_AsientosDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, 30));

        tabla_ViajeBoleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDBoleto", "Nombre", "Tipo", "Asiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_ViajeBoleto);

        Panel_Principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 220));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Ingrese un ID de viaje :");
        Panel_Principal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, 20));

        txtIDViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDViajeActionPerformed(evt);
            }
        });
        Panel_Principal.add(txtIDViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 110, 20));

        txtAsientosDisponibles.setEditable(false);
        txtAsientosDisponibles.setEnabled(false);
        txtAsientosDisponibles.setFocusable(false);
        Panel_Principal.add(txtAsientosDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 360, 101, 30));

        add(Panel_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 430));
    }// </editor-fold>//GEN-END:initComponents
    
    private void limpiarTabla(){
        DefaultTableModel dt = (DefaultTableModel)tabla_ViajeBoleto.getModel();
        dt.setRowCount(0);
    }
    
    private void txtIDViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDViajeActionPerformed
        try {
            limpiarTabla();
            int idViaje = Integer.parseInt(txtIDViaje.getText());
            Viaje viaje = controlador.cViaje.buscarViaje(idViaje);
            if (viaje != null) {
                controlador.cBoleto.llenarViajexBoleto(tabla_ViajeBoleto, viaje.getIdViaje()); 
                txtAsientosDisponibles.setText(String.valueOf(viaje.getAsientosDispo()));
            } else {
                JOptionPane.showMessageDialog(this, "No existe ese viaje", "Viaje no existente", JOptionPane.ERROR_MESSAGE);
                txtAsientosDisponibles.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número.", "Error de entrada", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_txtIDViajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_AsientosDisponibles;
    private javax.swing.JLabel label_chofer;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JTable tabla_ViajeBoleto;
    private javax.swing.JTextField txtAsientosDisponibles;
    private javax.swing.JTextField txtIDViaje;
    // End of variables declaration//GEN-END:variables
}
