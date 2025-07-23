
package Vista;

import Controlador.*;
import Modelo.Boleto;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author RODRIGO
 */
public class panel_boleto extends JPanel {

    private C_Controlador controlador;
    private Boleto boletoBuscado;
    private int fila;
   
    public panel_boleto(C_Controlador controlador) {
        initComponents();
        
        ponerImagen(foto_boleto, "boleto_panel");
        ponerImagen(bttEditar, "imagen_editar");
        
        this.controlador = controlador;
        
        visibilidadBotonEditarEliminar(false);
        
        controlador.cBoleto.llenarTabla(tabla_Boleto);
    }
    
    private void ponerImagen(JLabel label, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(50,40,Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    private void ponerImagen(JButton boton, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
    }
    
    private void visibilidadBotonEditarEliminar(boolean validar){
        bttEditar.setVisible(validar);
        bttEliminar.setEnabled(validar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_boleto = new javax.swing.JLabel();
        foto_boleto = new javax.swing.JLabel();
        bttBoleto = new javax.swing.JButton();
        bttEliminar = new javax.swing.JButton();
        bttEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_Boleto = new javax.swing.JTable();
        bttConsulta = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_boleto.setText("Boleto");
        label_boleto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_boleto.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(label_boleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 60, 30));
        jPanel1.add(foto_boleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, 40));

        bttBoleto.setBackground(new java.awt.Color(53, 93, 127));
        bttBoleto.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttBoleto.setForeground(new java.awt.Color(255, 255, 255));
        bttBoleto.setText("Nuevo");
        bttBoleto.setBorderPainted(false);
        bttBoleto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBoletoActionPerformed(evt);
            }
        });
        jPanel1.add(bttBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 130, 40));

        bttEliminar.setBackground(new java.awt.Color(53, 93, 127));
        bttEliminar.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bttEliminar.setText("Eliminar");
        bttEliminar.setBorderPainted(false);
        bttEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 130, 40));

        bttEditar.setBackground(new java.awt.Color(255, 255, 255));
        bttEditar.setBorder(null);
        bttEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 20, 20));

        tabla_Boleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "IDAsiento", "IDViaje", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_Boleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_BoletoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_Boleto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 390, 300));

        bttConsulta.setBackground(new java.awt.Color(53, 93, 127));
        bttConsulta.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bttConsulta.setText("Consulta");
        bttConsulta.setBorderPainted(false);
        bttConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(bttConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 130, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void bttBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBoletoActionPerformed
        panel_InfoBoleto panelInfoBoleto = new panel_InfoBoleto(controlador,tabla_Boleto);
        FrameDialogo frameInfoBoleto = new FrameDialogo(panelInfoBoleto);
        visibilidadBotonEditarEliminar(false);
        frameInfoBoleto.setVisible(true);
        frameInfoBoleto.setResizable(false);
    }//GEN-LAST:event_bttBoletoActionPerformed

    private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed
       controlador.cBoleto.eliminarBoleto(boletoBuscado.getIdBoleto());
       controlador.cViaje.buscarViaje(boletoBuscado.getViaje().getIdViaje()).setAsientosDispo(boletoBuscado.getViaje().getAsientosDispo()+1);
       controlador.cBoleto.eliminarMapBoleto(boletoBuscado.getIdBoleto());
       controlador.cBoleto.habilitarAsientoSeleccionado(boletoBuscado.getViaje().getIdViaje(), boletoBuscado.getIdAsiento());
       controlador.cBoleto.eliminarFilaTablaBoleto(tabla_Boleto,fila);
       visibilidadBotonEditarEliminar(false);
    }//GEN-LAST:event_bttEliminarActionPerformed

    private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
        panel_InfoBoleto panelEditarBoleto = new panel_InfoBoleto(controlador,tabla_Boleto,boletoBuscado,fila);
        FrameDialogo frameEditarBoleto = new FrameDialogo(panelEditarBoleto);
        visibilidadBotonEditarEliminar(false);
        frameEditarBoleto.setVisible(true);
        frameEditarBoleto.setResizable(false);
    }//GEN-LAST:event_bttEditarActionPerformed

    private void tabla_BoletoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_BoletoMousePressed
        fila = tabla_Boleto.rowAtPoint(evt.getPoint());
        if(fila>=0){
            boletoBuscado = controlador.cBoleto.buscarBoleto((Integer)tabla_Boleto.getValueAt(fila, 0));
            visibilidadBotonEditarEliminar(true);
        }
    }//GEN-LAST:event_tabla_BoletoMousePressed

    private void bttConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttConsultaActionPerformed
        Window window = SwingUtilities.getWindowAncestor(this);
        panel_consultaBoleto consultaBoleto = new panel_consultaBoleto(window, controlador);
        consultaBoleto.setLocationRelativeTo(this);
        consultaBoleto.setVisible(true);
    }//GEN-LAST:event_bttConsultaActionPerformed

    private class FrameDialogo extends JDialog {
        
        private int x;
        private int y;
        
        public FrameDialogo(panel_InfoBoleto panel){
            
            super((JFrame) SwingUtilities.getWindowAncestor(panel_boleto.this), true);
            
            setSize(960, 445);
            setLocationRelativeTo((JFrame) SwingUtilities.getWindowAncestor(panel_boleto.this));
            setContentPane(panel);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setUndecorated(true);
            panel.getPanel_barra().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    pressedBarra_Superior(e);
                }
            
            });
            panel.getPanel_barra().addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e){
                    draggedBarra_Superior(e);
                }
                
                
            });
            
            panel.getBttFlecha().addActionListener(e -> tuvieja(e));
            
        }
        
        private void tuvieja(ActionEvent e){
            this.dispose();
        }
        
        private void pressedBarra_Superior(MouseEvent e){
            x = e.getX();
            y = e.getY();
        }
        
        private void draggedBarra_Superior(MouseEvent e){
            int xScreen = e.getXOnScreen();
            int yScreen = e.getYOnScreen();
        
            this.setLocation(xScreen-x, yScreen-y);
        }
        

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttBoleto;
    private javax.swing.JButton bttConsulta;
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEliminar;
    private javax.swing.JLabel foto_boleto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_boleto;
    private javax.swing.JTable tabla_Boleto;
    // End of variables declaration//GEN-END:variables
}
