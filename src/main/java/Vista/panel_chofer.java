
package Vista;

import Controlador.*;
import Modelo.Chofer;

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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author RODRIGO
 */
public class panel_chofer extends JPanel {
    
    private C_Controlador controlador;
    private Chofer choferBuscado;
    private int fila;
    
    public panel_chofer(C_Controlador controlador) {
        initComponents();
        ponerImagen(foto_chofer, "chofer_panel");
        ponerImagen(bttEditar, "imagen_editar");
        
        this.controlador = controlador;
        
        visibilidadBotonEditarEliminar(false);
        controlador.cChofer.llenarTabla(tabla_Chofer);

    }
    
    private void ponerImagen(JLabel label, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        foto_chofer = new javax.swing.JLabel();
        bttChofer = new javax.swing.JButton();
        bttEliminar = new javax.swing.JButton();
        bttConsulta = new javax.swing.JButton();
        label_chofer1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bttEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_Chofer = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(foto_chofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 40));

        bttChofer.setBackground(new java.awt.Color(53, 93, 127));
        bttChofer.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttChofer.setForeground(new java.awt.Color(255, 255, 255));
        bttChofer.setText("Nuevo");
        bttChofer.setBorderPainted(false);
        bttChofer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttChoferActionPerformed(evt);
            }
        });
        jPanel1.add(bttChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 130, 40));

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

        label_chofer1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_chofer1.setForeground(new java.awt.Color(102, 102, 102));
        label_chofer1.setText("Chofer");
        jPanel1.add(label_chofer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 140, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        bttEditar.setBackground(new java.awt.Color(255, 255, 255));
        bttEditar.setBorder(null);
        bttEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 20, 20));

        tabla_Chofer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Fecha_Ingreso"
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
        tabla_Chofer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_ChoferMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_Chofer);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 390, 300));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void bttChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttChoferActionPerformed
        panel_InfoChofer panelInfoChofer = new panel_InfoChofer(controlador,tabla_Chofer);
        FrameDialogo frameInfoChofer = new FrameDialogo(panelInfoChofer,385,455);
        visibilidadBotonEditarEliminar(false);
        frameInfoChofer.setVisible(true);
        frameInfoChofer.setResizable(false);
    }//GEN-LAST:event_bttChoferActionPerformed

    private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed
        controlador.cChofer.eliminarChofer(choferBuscado.getIdChofer());
        controlador.cBus.eliminarChoferMapBus(choferBuscado.getIdChofer()); //Pondra como null choferes del map cBus
        controlador.cChofer.eliminarMapChofer(choferBuscado.getIdChofer()); //Eliminara al chofer del map
        controlador.cChofer.eliminarFilaTablaChofer(tabla_Chofer, fila);
        visibilidadBotonEditarEliminar(false);
    }//GEN-LAST:event_bttEliminarActionPerformed

    private void bttConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttConsultaActionPerformed
        panel_consultaChofer consultaChofer = new panel_consultaChofer(controlador);
        FrameDialogo frameConsultaChofer = new FrameDialogo(consultaChofer,670, 399);
        visibilidadBotonEditarEliminar(false);
        frameConsultaChofer.setVisible(true);
        frameConsultaChofer.setResizable(false);
    }//GEN-LAST:event_bttConsultaActionPerformed

    private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
        panel_InfoChofer panelInfoChofer = new panel_InfoChofer(controlador,tabla_Chofer,choferBuscado,fila);
        FrameDialogo frameEditarChofer = new FrameDialogo(panelInfoChofer,385,455);
        visibilidadBotonEditarEliminar(false);
        frameEditarChofer.setVisible(true);
        frameEditarChofer.setResizable(false);
    }//GEN-LAST:event_bttEditarActionPerformed

    private void tabla_ChoferMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ChoferMousePressed
        fila = tabla_Chofer.rowAtPoint(evt.getPoint());
        if(fila>=0){
            choferBuscado = controlador.cChofer.buscarMapChofer((Integer)tabla_Chofer.getValueAt(fila, 0));
            visibilidadBotonEditarEliminar(true);
        }
    }//GEN-LAST:event_tabla_ChoferMousePressed

    private class FrameDialogo extends JDialog {

        private int x, y;
        
        public FrameDialogo(JPanel panel, int ancho, int altura) {
            super((JFrame) SwingUtilities.getWindowAncestor(panel_chofer.this), true);
          
            
            setSize(ancho, altura);
            setLocationRelativeTo(getParent());
            setContentPane(panel);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setUndecorated(true);

            switch (panel) {
                case panel_InfoChofer infoPanel -> configurarEventos(infoPanel.getPanel_barra(), infoPanel.getBttFlecha());
                case panel_consultaChofer consultaPanel -> configurarEventos(consultaPanel.getPanel_barra(), consultaPanel.getBttFlecha());
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
            dispose();
        }

        private void pressedBarra_Superior(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        private void draggedBarra_Superior(MouseEvent e) {
            setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttChofer;
    private javax.swing.JButton bttConsulta;
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEliminar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel foto_chofer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_chofer1;
    private javax.swing.JTable tabla_Chofer;
    // End of variables declaration//GEN-END:variables
}
