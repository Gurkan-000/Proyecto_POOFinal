
package Vista;

import Controlador.*;
import Modelo.Viaje;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author RODRIGO
 */
public class panel_viaje extends JPanel {

    private C_Controlador controlador;
    
    private Viaje viajeBuscado;
    private int fila;
    
    public panel_viaje(C_Controlador controlador) {
        initComponents();
        ponerImagen(foto_viaje, "viaje_panel");
        ponerImagen(bttEditar, "imagen_editar");
        //Si lees esto te gusta la uchulu
        this.controlador = controlador;
        this.tabla_Viaje.setModel(tabla_Viaje.getModel());
        
        visibilidadBotonEditarEliminar(false);
        controlador.cViaje.llenarTabla(tabla_Viaje);
    }
    
    private void ponerImagen(JLabel label, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
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

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label_viaje = new javax.swing.JLabel();
        foto_viaje = new javax.swing.JLabel();
        bttViaje = new javax.swing.JButton();
        bttEliminar = new javax.swing.JButton();
        bttConsulta = new javax.swing.JButton();
        bttEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_Viaje = new javax.swing.JTable();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("ID           ");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_viaje.setText("Viaje");
        label_viaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_viaje.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(label_viaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 50, 30));
        jPanel1.add(foto_viaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 50));

        bttViaje.setText("Nuevo");
        bttViaje.setBackground(new java.awt.Color(53, 93, 127));
        bttViaje.setBorderPainted(false);
        bttViaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttViaje.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttViaje.setForeground(new java.awt.Color(255, 255, 255));
        bttViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttViajeActionPerformed(evt);
            }
        });
        jPanel1.add(bttViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 130, 40));

        bttEliminar.setText("Eliminar");
        bttEliminar.setBackground(new java.awt.Color(53, 93, 127));
        bttEliminar.setBorderPainted(false);
        bttEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEliminar.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bttEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 130, 40));

        bttConsulta.setText("Consulta");
        bttConsulta.setBackground(new java.awt.Color(53, 93, 127));
        bttConsulta.setBorderPainted(false);
        bttConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttConsulta.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bttConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(bttConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 130, 40));

        bttEditar.setBackground(new java.awt.Color(255, 255, 255));
        bttEditar.setBorder(null);
        bttEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 20, 20));

        tabla_Viaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ruta", "Fecha", "Hora"
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
        tabla_Viaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_ViajeMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_Viaje);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 390, 300));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void bttViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttViajeActionPerformed
        panel_InfoViaje panelInfoViaje = new panel_InfoViaje(controlador,tabla_Viaje);
        FrameDialogo frameInfoViaje = new FrameDialogo(panelInfoViaje,730, 475);
        frameInfoViaje.setVisible(true);
        frameInfoViaje.setResizable(false);
        visibilidadBotonEditarEliminar(false);
    }//GEN-LAST:event_bttViajeActionPerformed

    private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed

        if(viajeBuscado.getAsientosDispo() == 20){
            controlador.cViaje.eliminarViaje(viajeBuscado.getIdViaje());
            controlador.cViaje.eliminarMapViaje(viajeBuscado.getIdViaje());
            controlador.cViaje.eliminarFilaTablaViaje(tabla_Viaje, fila);
            visibilidadBotonEditarEliminar(false);
        }else {
            JOptionPane.showMessageDialog(this, "Lo siento, no puede eliminar un viaje con boletos emitidos","Error de eliminacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bttEliminarActionPerformed

    private void bttConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttConsultaActionPerformed
        panel_consultaViaje panelConsultaViaje = new panel_consultaViaje(controlador);
        FrameDialogo frameConsultaViaje = new FrameDialogo(panelConsultaViaje,619, 427);
        frameConsultaViaje.setVisible(true);
        frameConsultaViaje.setResizable(false);
        visibilidadBotonEditarEliminar(false);
    }//GEN-LAST:event_bttConsultaActionPerformed

    private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
        panel_InfoViaje panelInfoViaje = new panel_InfoViaje(controlador,tabla_Viaje,viajeBuscado,fila);
        FrameDialogo frameEditarViaje = new FrameDialogo(panelInfoViaje,730, 475);
        frameEditarViaje.setVisible(true);
        frameEditarViaje.setResizable(false);
        visibilidadBotonEditarEliminar(false);
    }//GEN-LAST:event_bttEditarActionPerformed

    private void tabla_ViajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ViajeMousePressed

        fila = tabla_Viaje.rowAtPoint(evt.getPoint());
        if(fila>=0){
            viajeBuscado = controlador.cViaje.buscarViaje((Integer)tabla_Viaje.getValueAt(fila, 0));
            visibilidadBotonEditarEliminar(true);
        }
        
    }//GEN-LAST:event_tabla_ViajeMousePressed
    
    private class FrameDialogo extends JDialog {

    private int x, y;
    
    public FrameDialogo(JPanel panel, int ancho, int altura) {
        super((JFrame) SwingUtilities.getWindowAncestor(panel_viaje.this), true);
        
        setSize(ancho, altura);
        setLocationRelativeTo(getParent());
        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);

        switch (panel) {
            case panel_InfoViaje infoPanel -> configurarEventos(infoPanel.getPanel_barra(), infoPanel.getBttFlecha());
            case panel_consultaViaje consultaPanel -> configurarEventos(consultaPanel.getPanel_barra(), consultaPanel.getBttFlecha());
            default -> {
            }
        }
        
    }

    private void configurarEventos(JComponent barra, JButton botonCerrar) {
        barra.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressedBarra_Superior(e);
            }
        });

        barra.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                draggedBarra_Superior(e);
            }
        });

        botonCerrar.addActionListener(this::cerrar);
    }

    private void cerrar(ActionEvent e) {
        this.dispose();
    }

    private void pressedBarra_Superior(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    private void draggedBarra_Superior(MouseEvent e) {
        int xScreen = e.getXOnScreen();
        int yScreen = e.getYOnScreen();
        setLocation(xScreen - x, yScreen - y);
    }
    
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttConsulta;
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEliminar;
    private javax.swing.JButton bttViaje;
    private javax.swing.JLabel foto_viaje;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_viaje;
    private javax.swing.JTable tabla_Viaje;
    // End of variables declaration//GEN-END:variables
}
