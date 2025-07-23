
package Vista;

import Controlador.C_Controlador;
import Modelo.Boleto;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author RODRIGO
 */

public class panel_consultaBoleto extends JDialog {

    private Boleto boleto;
    private C_Controlador controlador;
    
    private panel_BoletoID boletoID = new panel_BoletoID();
   
    public panel_consultaBoleto(Window window,C_Controlador controlador) {
        super(window, ModalityType.APPLICATION_MODAL);
        initComponents();
        this.controlador = controlador;
        
        ponerImagen(bttFlecha, "Flecha_de_tu_vieja", 40, 20);    
    }

    private void ponerImagen(JButton boton, String URL,int ancho, int altura){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(ancho,altura,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Principal = new javax.swing.JPanel();
        panel_barra = new javax.swing.JPanel();
        label_boleto = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtIDBoleto = new javax.swing.JTextField();
        panel_Boleto = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.setToolTipText("");
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));
        panel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        label_boleto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_boleto.setForeground(new java.awt.Color(255, 255, 255));
        label_boleto.setText("Consulta infomacion de un boleto");

        bttFlecha.setBackground(new java.awt.Color(53, 93, 127));
        bttFlecha.setBorderPainted(false);
        bttFlecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttFlecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttFlechaActionPerformed(evt);
            }
        });

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
        jLabel4.setText("Ingrese el ID de boleto :");
        Panel_Principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 40));

        txtIDBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBoletoActionPerformed(evt);
            }
        });
        Panel_Principal.add(txtIDBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 110, 20));

        javax.swing.GroupLayout panel_BoletoLayout = new javax.swing.GroupLayout(panel_Boleto);
        panel_Boleto.setLayout(panel_BoletoLayout);
        panel_BoletoLayout.setHorizontalGroup(
            panel_BoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        panel_BoletoLayout.setVerticalGroup(
            panel_BoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        Panel_Principal.add(panel_Boleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 460, 195));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBoletoActionPerformed
        try {
            int codigo = Integer.parseInt(txtIDBoleto.getText());
            boleto = controlador.cBoleto.buscarBoleto(codigo);
            boletoID.setBoleto(boleto);
            boletoID.llenarInformacion();
            cambiarPanel(boletoID);
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txtIDBoletoActionPerformed

    private void bttFlechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttFlechaActionPerformed
        this.dispose();
    }//GEN-LAST:event_bttFlechaActionPerformed

    private void cambiarPanel(JPanel panel){
        panel.setSize(460, 195);
        
        panel_Boleto.removeAll();
        panel_Boleto.add(panel, BorderLayout.CENTER);
        panel_Boleto.revalidate();
        panel_Boleto.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label_boleto;
    private javax.swing.JPanel panel_Boleto;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JTextField txtIDBoleto;
    // End of variables declaration//GEN-END:variables
}
