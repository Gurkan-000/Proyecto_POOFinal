
package Vista;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RODRIGO
 */

import Controlador.*;

public class Formulario_Viaje extends JFrame {
    
    private panel_chofer chofer;
    private panel_bus bus;
    private panel_viaje viaje;
    private panel_boleto boleto;
    

    private C_Controlador controlador;
   
    public Formulario_Viaje() {
        initComponents();
        
        ponerImagen(labelfoto, "bus_logo");
        ponerImagen(label_busBlanco,"busBlanco");
        
        controlador = new C_Controlador();
        
        llenarMaps();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void llenarMaps(){
        controlador.cChofer.llenarMapChofer();
        controlador.cRuta.llenarMapRuta();
        controlador.cBus.llenarMapBus();
        controlador.cViaje.llenarMapViaje();
        controlador.cBoleto.llenarMapBoleto();
    }

    private void ponerImagen(JLabel label, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    private void cambiarPanel(JPanel panel){
        panel.setSize(680, 490);
        panel.setLocation(0,0);
        
        Contenedor.removeAll();
        Contenedor.add(panel,BorderLayout.CENTER);
        Contenedor.revalidate();
        Contenedor.repaint(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        panel_barra = new javax.swing.JPanel();
        labelfoto = new javax.swing.JLabel();
        bttBus = new javax.swing.JButton();
        bttBoleto = new javax.swing.JButton();
        bttViaje = new javax.swing.JButton();
        bttChofer = new javax.swing.JButton();
        Contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_busBlanco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));

        bttBus.setBackground(new java.awt.Color(53, 93, 127));
        bttBus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bttBus.setForeground(new java.awt.Color(255, 255, 255));
        bttBus.setText("        >    Bus");
        bttBus.setBorder(new javax.swing.border.MatteBorder(null));
        bttBus.setBorderPainted(false);
        bttBus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttBus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBusActionPerformed(evt);
            }
        });

        bttBoleto.setBackground(new java.awt.Color(53, 93, 127));
        bttBoleto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bttBoleto.setForeground(new java.awt.Color(255, 255, 255));
        bttBoleto.setText("        >    Boleto");
        bttBoleto.setBorder(new javax.swing.border.MatteBorder(null));
        bttBoleto.setBorderPainted(false);
        bttBoleto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttBoleto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBoletoActionPerformed(evt);
            }
        });

        bttViaje.setBackground(new java.awt.Color(53, 93, 127));
        bttViaje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bttViaje.setForeground(new java.awt.Color(255, 255, 255));
        bttViaje.setText("        >    Viaje");
        bttViaje.setBorder(new javax.swing.border.MatteBorder(null));
        bttViaje.setBorderPainted(false);
        bttViaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttViaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttViajeActionPerformed(evt);
            }
        });

        bttChofer.setBackground(new java.awt.Color(53, 93, 127));
        bttChofer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bttChofer.setForeground(new java.awt.Color(255, 255, 255));
        bttChofer.setText("        >    Chofer");
        bttChofer.setBorder(new javax.swing.border.MatteBorder(null));
        bttChofer.setBorderPainted(false);
        bttChofer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttChofer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttChoferActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_barraLayout = new javax.swing.GroupLayout(panel_barra);
        panel_barra.setLayout(panel_barraLayout);
        panel_barraLayout.setHorizontalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bttBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bttViaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(bttBoleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bttChofer, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        panel_barraLayout.setVerticalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttBus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 490));

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(53, 93, 127));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(53, 93, 127)));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¡ Bienvenido a Bus Express !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(label_busBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_busBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
        );

        panel_principal.add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 0, 680, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBusActionPerformed
        bus = new panel_bus(controlador);
        cambiarPanel(bus);
    }//GEN-LAST:event_bttBusActionPerformed

    private void bttViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttViajeActionPerformed
        viaje = new panel_viaje(controlador);
        cambiarPanel(viaje);
    }//GEN-LAST:event_bttViajeActionPerformed

    private void bttBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBoletoActionPerformed
        boleto = new panel_boleto(controlador);
        cambiarPanel(boleto);
    }//GEN-LAST:event_bttBoletoActionPerformed

    private void bttChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttChoferActionPerformed
        chofer = new panel_chofer(controlador);
        cambiarPanel(chofer);
    }//GEN-LAST:event_bttChoferActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JButton bttBoleto;
    private javax.swing.JButton bttBus;
    private javax.swing.JButton bttChofer;
    private javax.swing.JButton bttViaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_busBlanco;
    private javax.swing.JLabel labelfoto;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
