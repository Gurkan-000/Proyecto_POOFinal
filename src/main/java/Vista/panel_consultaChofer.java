
package Vista;

import Controlador.*;
import Modelo.Chofer;
import java.awt.Image;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author RODRIGO
 */
public class panel_consultaChofer extends javax.swing.JPanel {

    private JComboBox<Object>cbChofer;
    private C_Controlador controlador;
    
    public panel_consultaChofer(C_Controlador controlador) {
        initComponents();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja");
        
        this.controlador = controlador;
        
        crearCombo();
        controlador.cChofer.llenarComboChofer(cbChofer);
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

    private void crearCombo(){
        cbChofer = new JComboBox<>();
        cbChofer.addItemListener(e -> ItemcbChofer(e));
        Panel_Principal.add(cbChofer, new AbsoluteConstraints(250, 110, 150, 30));
    }
    
    private void ItemcbChofer(ItemEvent e){
        if(cbChofer.getSelectedIndex() > 0){
            Chofer buscado = (Chofer)cbChofer.getSelectedItem();
            controlador.cViaje.llenarTablaChoferViajes(tabla, buscado.getIdChofer());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Principal = new javax.swing.JPanel();
        panel_barra = new javax.swing.JPanel();
        label_boleto = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.setToolTipText("");
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));
        panel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        label_boleto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_boleto.setForeground(new java.awt.Color(255, 255, 255));
        label_boleto.setText("Consulta infomacion de un chofer");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        panel_barraLayout.setVerticalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGroup(panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_barraLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bttFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_barraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Seleccione un chofer :");
        Panel_Principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDViaje", "Fecha", "Ruta", "Pago"
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
        jScrollPane1.setViewportView(tabla);

        Panel_Principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 170));

        add(Panel_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_boleto;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
