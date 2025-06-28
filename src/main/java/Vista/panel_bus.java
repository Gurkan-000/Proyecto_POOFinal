
package Vista;

import Controlador.*;
import Modelo.Bus;
import Modelo.Chofer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteConstraints;


/**
 *
 * @author RODRIGO
 */
public class panel_bus extends JPanel {

    private C_Controlador controlador;
    private Bus busBuscado;
    private int fila;
    private JComboBox<Object>cbChofer;
    
    public panel_bus(C_Controlador controlador) {
        initComponents();
        ponerImagen(foto_bus,"bus_panel");
        ponerImagen(bttEditar, "imagen_editar");
        
        this.controlador = controlador;
        
        controlador.cBus.llenarTabla(tabla_Bus);
        crearComboChofer();
        
        visibilidadComponentesConsulta(false);
        visibilidadBotonEditarEliminar(false);
        
        bttEditar.setVisible(false);
    }
    
    private void crearComboChofer(){
        cbChofer = new JComboBox<>();
        cbChofer.addItemListener(e -> ItemcbBus(e));
        jPanel1.add(cbChofer,new AbsoluteConstraints(210, 80, 150, 30));
        controlador.cChofer.llenarComboChofer(cbChofer);
    }
    
    private void visibilidadBotonEditarEliminar(boolean validar){
        bttEditar.setVisible(validar);
        bttEliminar.setEnabled(validar);
    }
    
    private void ItemcbBus(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (cbChofer.getSelectedIndex() > 0) {
                Chofer choferxbus = (Chofer) cbChofer.getSelectedItem();
                controlador.cBus.llenarTablaBusxChofer(tabla_Bus, choferxbus.getIdChofer());
            }
        }
    }
    
    private void ponerImagen(JLabel label, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(50,30,Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    private void ponerImagen(JButton boton, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_seleccioneChofer = new javax.swing.JLabel();
        foto_bus = new javax.swing.JLabel();
        bttBus = new javax.swing.JButton();
        bttEliminar = new javax.swing.JButton();
        bttConsulta = new javax.swing.JButton();
        bttCerrarConsulta = new javax.swing.JButton();
        label_bus1 = new javax.swing.JLabel();
        bttEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_Bus = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_seleccioneChofer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_seleccioneChofer.setForeground(new java.awt.Color(153, 153, 153));
        label_seleccioneChofer.setText("Seleccione un chofer :");
        jPanel1.add(label_seleccioneChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, 30));
        jPanel1.add(foto_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, 30));

        bttBus.setBackground(new java.awt.Color(53, 93, 127));
        bttBus.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttBus.setForeground(new java.awt.Color(255, 255, 255));
        bttBus.setText("Nuevo");
        bttBus.setBorderPainted(false);
        bttBus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBusActionPerformed(evt);
            }
        });
        jPanel1.add(bttBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 130, 40));

        bttEliminar.setBackground(new java.awt.Color(53, 93, 127));
        bttEliminar.setFont(new java.awt.Font("MS UI Gothic", 1, 15)); // NOI18N
        bttEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bttEliminar.setText("Eliminar");
        bttEliminar.setBorderPainted(false);
        bttEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEliminar.setFocusable(false);
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

        bttCerrarConsulta.setBackground(new java.awt.Color(53, 93, 127));
        bttCerrarConsulta.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        bttCerrarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        bttCerrarConsulta.setText("X");
        bttCerrarConsulta.setBorderPainted(false);
        bttCerrarConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttCerrarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCerrarConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(bttCerrarConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 20, 20));

        label_bus1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_bus1.setForeground(new java.awt.Color(102, 102, 102));
        label_bus1.setText("Bus");
        jPanel1.add(label_bus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 40, 30));

        bttEditar.setBackground(new java.awt.Color(255, 255, 255));
        bttEditar.setBorder(null);
        bttEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 20, 20));

        tabla_Bus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Chofer"
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
        tabla_Bus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_BusMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_Bus);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 390, 300));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void bttBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBusActionPerformed
        panel_InfoBus infoBus = new panel_InfoBus(controlador,tabla_Bus);
        FrameDialogo frameInfoBus = new FrameDialogo(infoBus); 
        visibilidadBotonEditarEliminar(false);
        frameInfoBus.setResizable(false);
        frameInfoBus.setVisible(true);
    }//GEN-LAST:event_bttBusActionPerformed

    private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed
        
        if(!controlador.cViaje.existeBusesAsignados(busBuscado.getIdBus())){
            controlador.cBus.eliminarBus(busBuscado.getIdBus());
            controlador.cBus.eliminarFilaTablaBus(tabla_Bus, fila);
            visibilidadBotonEditarEliminar(false);
        }else{
            JOptionPane.showMessageDialog(this, "No se puede eliminar un bus con viajes asociados", "Error de eliminacion", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_bttEliminarActionPerformed

    private void bttConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttConsultaActionPerformed
        visibilidadComponentesConsulta(true);
        bttEliminar.setEnabled(false);
        bttEditar.setVisible(false);
    }//GEN-LAST:event_bttConsultaActionPerformed

    private void bttCerrarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCerrarConsultaActionPerformed
        cbChofer.setSelectedIndex(0);
        controlador.cBus.llenarTabla(tabla_Bus);
        visibilidadComponentesConsulta(false);
    }//GEN-LAST:event_bttCerrarConsultaActionPerformed

    private void tabla_BusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_BusMousePressed
        fila = tabla_Bus.rowAtPoint(evt.getPoint());
        if(fila>=0){
           busBuscado = controlador.cBus.buscarMapBus((Integer)tabla_Bus.getValueAt(fila, 0));
           visibilidadBotonEditarEliminar(true);
        }
    }//GEN-LAST:event_tabla_BusMousePressed

    private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
        panel_InfoBus infoBus = new panel_InfoBus(controlador,tabla_Bus,busBuscado,fila);
        FrameDialogo frameEditarBus = new FrameDialogo(infoBus);
        visibilidadBotonEditarEliminar(false);
        frameEditarBus.setResizable(false); 
        frameEditarBus.setVisible(true);
    }//GEN-LAST:event_bttEditarActionPerformed
    
    private void visibilidadComponentesConsulta(boolean validar){
        label_seleccioneChofer.setVisible(validar);
        cbChofer.setVisible(validar);
        bttCerrarConsulta.setVisible(validar);
    }
    
    private class FrameDialogo extends JDialog {
        
        private int x;
        private int y;
        
        public FrameDialogo(panel_InfoBus panel){
            
            super((JFrame) SwingUtilities.getWindowAncestor(panel_bus.this), true);
            
            
            setSize(675, 435);
            setLocationRelativeTo((JFrame) SwingUtilities.getWindowAncestor(panel_bus.this));
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
    private javax.swing.JButton bttBus;
    private javax.swing.JButton bttCerrarConsulta;
    private javax.swing.JButton bttConsulta;
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEliminar;
    private javax.swing.JLabel foto_bus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_bus1;
    private javax.swing.JLabel label_seleccioneChofer;
    private javax.swing.JTable tabla_Bus;
    // End of variables declaration//GEN-END:variables
}
