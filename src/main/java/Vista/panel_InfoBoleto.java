
package Vista;

/**
 *
 * @author RODRIGO
 */

import Controlador.*;
import Modelo.AsientosViaje;
import Modelo.Boleto;
import Modelo.Viaje;
import Modelo.Ruta;
import java.awt.Color;

import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class panel_InfoBoleto extends JPanel implements ActionListener{
    
    private JButton[] asientos;
    private JComboBox<Object> cbRuta;
    private C_Controlador controlador;
    private StringBuilder errores;
    private JTable tabla;
    
    private Boleto boleto;
    private Viaje viaje;
    private AsientosViaje asientoViaje;
    private int NumAsiento;
    private int fila;
    
    public panel_InfoBoleto(C_Controlador controlador,JTable tabla) {
        initComponents();
        generarBotonesAsiento();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja",40,20);
        
        this.controlador = controlador;
        this.tabla = tabla;
        
        controlador.cBoleto.llenarListAsientoViaje();
        controlador.cBoleto.habilitarAsientos(asientos, false);
        visibilidadComponentes_GuardarChofer(true);
        habilitarComponentesInfoRuta(false);
        
        crearComboRuta();
    }

    public panel_InfoBoleto(C_Controlador controlador,JTable tabla,Boleto boleto,int fila) {
        initComponents();
        generarBotonesAsiento();
        ponerImagen(bttFlecha,"Flecha_de_tu_vieja",40,20);
        
        this.controlador = controlador;
        this.tabla = tabla;
        this.boleto = boleto;
        this.fila = fila;
        
        controlador.cBoleto.llenarListAsientoViaje();
        controlador.cBoleto.habilitarAsientos(asientos, false);
        visibilidadComponentes_GuardarChofer(false);
        habilitarComponentesInfoRuta(false);
        
        crearComboRuta();
        llenarCampos();
    }
    
    private void ponerImagen(JButton boton, String URL,int ancho, int altura){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(ancho,altura,Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(image));
    }
    
    private void ponerImagen(JLabel label, String URL,int ancho, int altura){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(ancho,altura,Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    private void llenarCampos(){
        label_boleto.setText("Actualizar informacion del boleto");
        txtID.setText(String.valueOf(boleto.getIdBoleto()));
        txtPasajero.setText(boleto.getNombre());
        viaje = boleto.getViaje();
        cbTipoPasajero.setSelectedItem(boleto.getTipo());
        cbRuta.setSelectedItem(boleto.getViaje().getRuta());
        
        controlador.cBoleto.habilitarAsientos(asientos, true);
        controlador.cBoleto.habilitarAsientoSeleccionado(boleto.getViaje().getIdViaje(),boleto.getIdAsiento());
        controlador.cBoleto.llamarAsientosDeViaje(asientos, boleto.getViaje().getIdViaje());
        botonAnterior = asientos[boleto.getIdAsiento()-1];
        asientos[boleto.getIdAsiento()-1].setBackground(new Color(153,153,153));
        asientos[boleto.getIdAsiento()-1].setForeground(Color.WHITE);
        
    }
    
    private void visibilidadComponentes_GuardarChofer(boolean validar){
        txtID.setVisible(!validar);
        label_ID.setVisible(!validar);
        bttActualizar.setVisible(!validar);  //Bebita gaaa
        bttGuardar.setVisible(validar);
        label_CreaBoleto.setVisible(validar);
    }
    
    private void crearComboRuta(){
        cbRuta = new JComboBox<>();
        cbRuta.addItemListener(e -> ItemcbRuta(e));
        Panel_Principal.add(cbRuta,new AbsoluteConstraints(390, 91, 165, 35));
        controlador.cRuta.llenarComboBox(cbRuta);
    }
    
    private void generarBotonesAsiento() {
        // Esto es para los asientos
        int[][] coordenadas = {
            {10, 30}, {60, 30},  {130, 30}, {180, 30},
            {10, 60}, {60, 60},  {130, 60}, {180, 60},
            {10, 90}, {60, 90},  {130, 90}, {180, 90},
            {10, 120}, {60, 120}, {130, 120}, {180, 120},
            {10, 150}, {60, 150}, {130, 150}, {180, 150}
        };


        asientos = new JButton[coordenadas.length];

        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = new JButton(String.valueOf(i + 1));
            asientos[i].setBorderPainted(true);
            asientos[i].setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
            asientos[i].setBackground(Color.WHITE);
            asientos[i].setForeground(Color.BLACK);
            asientos[i].setEnabled(false);
            panel_asiento.add(asientos[i],new AbsoluteConstraints(coordenadas[i][0], coordenadas[i][1], 40, 30));
            asientos[i].addActionListener(this);
        }
        
        panel_asiento.revalidate();
        panel_asiento.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Principal = new javax.swing.JPanel();
        panel_asiento = new javax.swing.JPanel();
        Salida = new javax.swing.JLabel();
        Chofer = new javax.swing.JLabel();
        label_ReferenciaRuta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ViajeAsiento = new javax.swing.JTable();
        label_CreaBoleto = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPasajero = new javax.swing.JTextField();
        panel_barra = new javax.swing.JPanel();
        label_boleto = new javax.swing.JLabel();
        bttFlecha = new javax.swing.JButton();
        bttGuardar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbTipoPasajero = new javax.swing.JComboBox<>();
        label_ID = new javax.swing.JLabel();
        bttActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Imagen_RutaRef = new javax.swing.JLabel();
        label_CostoInicial = new javax.swing.JLabel();
        txtCostoInicial = new javax.swing.JTextField();

        Panel_Principal.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Panel_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_asiento.setBackground(new java.awt.Color(255, 255, 255));
        panel_asiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panel_asiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Salida.setForeground(new java.awt.Color(102, 102, 102));
        Salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salida.setText("<- Salida");
        Salida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        panel_asiento.add(Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 70, 30));

        Chofer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Chofer.setForeground(new java.awt.Color(102, 102, 102));
        Chofer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Chofer.setText("Chofer");
        Chofer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        panel_asiento.add(Chofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 50, 50));

        Panel_Principal.add(panel_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 239, 290));

        label_ReferenciaRuta.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        label_ReferenciaRuta.setForeground(new java.awt.Color(102, 102, 102));
        label_ReferenciaRuta.setText("Referencia de la ruta  :");
        Panel_Principal.add(label_ReferenciaRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        tabla_ViajeAsiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_ViajeAsiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_ViajeAsientoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_ViajeAsiento);

        Panel_Principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 370, 100));

        label_CreaBoleto.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_CreaBoleto.setForeground(new java.awt.Color(153, 153, 153));
        label_CreaBoleto.setText("-- Crea un boleto --");
        Panel_Principal.add(label_CreaBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 20));
        Panel_Principal.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 120, -1));

        jLabel12.setText("Tipo          ");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 20));
        Panel_Principal.add(txtPasajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, -1));

        panel_barra.setBackground(new java.awt.Color(53, 93, 127));

        label_boleto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_boleto.setForeground(new java.awt.Color(255, 255, 255));
        label_boleto.setText("Guardar informacion del boleto");

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
                .addComponent(label_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(497, Short.MAX_VALUE))
        );
        panel_barraLayout.setVerticalGroup(
            panel_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel_barraLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bttFlecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Principal.add(panel_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 60));

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
        Panel_Principal.add(bttGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 100, 30));

        jLabel13.setText("Pasajero          ");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        Panel_Principal.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        cbTipoPasajero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tipo de Pasajero --", "Niño", "Estudiante", "Adulto" }));
        Panel_Principal.add(cbTipoPasajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 35));

        label_ID.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_ID.setForeground(new java.awt.Color(153, 153, 153));
        label_ID.setText("ID           ");
        Panel_Principal.add(label_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        bttActualizar.setBackground(new java.awt.Color(53, 93, 127));
        bttActualizar.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        bttActualizar.setForeground(new java.awt.Color(255, 255, 255));
        bttActualizar.setText("Actualizar");
        bttActualizar.setBorderPainted(false);
        bttActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttActualizarActionPerformed(evt);
            }
        });
        Panel_Principal.add(bttActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 100, 30));

        jLabel4.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Selecciona tu ruta    :");
        Panel_Principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));
        Panel_Principal.add(Imagen_RutaRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 190, 120));

        label_CostoInicial.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        label_CostoInicial.setForeground(new java.awt.Color(102, 102, 102));
        label_CostoInicial.setText("Costo inicial :");
        Panel_Principal.add(label_CostoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, 30));

        txtCostoInicial.setEnabled(false);
        Panel_Principal.add(txtCostoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean camposValidos(){
        errores = new StringBuilder();
        if(!txtPasajero.getText().trim().matches("^([A-Z][a-záéíóúñ]+)(\\s[A-Z][a-zñáéíóú]+)*$")||txtPasajero.getText().isEmpty()){                       
            errores.append("El campo de nombre es invalido o esta vacio\n");
            txtPasajero.setText("");
        }
        if(cbTipoPasajero.getSelectedIndex() <= 0){
            errores.append("Seleccione un tipo de pasajero\n");
            cbTipoPasajero.setSelectedIndex(0);
        }
        if(viaje == null){
            errores.append("Seleccione un viaje\n");
        }
        if(NumAsiento == 0){
            errores.append("Seleccione un asiento\n");
        }
        return !(errores.length()>0);
    }
    
    private void bttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarActionPerformed
        if(camposValidos()){
            boleto = new Boleto();
            asientoViaje= new AsientosViaje();
            
            boleto.setNombre(txtPasajero.getText());
            boleto.setIndice(cbTipoPasajero.getSelectedItem().toString());
            boleto.setViaje(viaje);
            boleto.setIdAsiento(NumAsiento);
        
            asientoViaje.setIDViaje(viaje.getIdViaje());
            asientoViaje.setIDAsiento(NumAsiento);
            
            Window window = SwingUtilities.getWindowAncestor(this);
            Vista_Boleto vista_boleto = new Vista_Boleto(window,boleto);
            vista_boleto.setLocationRelativeTo(this);
            vista_boleto.setVisible(true);
            
            if(vista_boleto.getComprar() && controlador.cBoleto.insertarBoleto(boleto)){
                controlador.cBoleto.insertarMapBoleto(boleto);  
                controlador.cBoleto.insertarListAsientoViaje(asientoViaje);
                controlador.cBoleto.insertarTabla(tabla, boleto);
                controlador.cViaje.buscarViaje(viaje.getIdViaje()).setAsientosDispo(viaje.getAsientosDispo()-1);
                
                ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);
            }

        }else{
            JOptionPane.showMessageDialog(this, errores,"Campos invalidos",JOptionPane.ERROR_MESSAGE);
            controlador.cBoleto.habilitarAsientos(asientos, false);
        }
    }//GEN-LAST:event_bttGuardarActionPerformed

    
    private void bttActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttActualizarActionPerformed
        if(camposValidos()){
            
            asientoViaje= new AsientosViaje();
            Viaje viajeAnterior = boleto.getViaje();
            
            boleto.setNombre(txtPasajero.getText());
            boleto.setIndice(cbTipoPasajero.getSelectedItem().toString());
            boleto.setViaje(viaje);
            boleto.setIdAsiento(NumAsiento);
        
            asientoViaje.setIDViaje(viaje.getIdViaje());
            asientoViaje.setIDAsiento(NumAsiento);
            
            Window window = SwingUtilities.getWindowAncestor(this);
            Vista_Boleto vista_boleto = new Vista_Boleto(window,boleto);
            vista_boleto.setLocationRelativeTo(this);
            vista_boleto.setVisible(true);
            
            if(vista_boleto.getComprar() && controlador.cBoleto.actualizarBoleto(boleto)){
                tabla.setValueAt(boleto.getIdBoleto(), fila, 0);
                tabla.setValueAt(boleto.getNombre(), fila, 1);
                tabla.setValueAt(boleto.getIdAsiento(), fila, 2);
                tabla.setValueAt(boleto.getViaje().getIdViaje(), fila, 3);
                tabla.setValueAt(String.format("%.1f",boleto.costeBoleto()), fila, 4);
                
                controlador.cBoleto.insertarMapBoleto(boleto);  // el metodo put que contiene ese insertarMapBoleto tambien actualiza ese valor en el Hash
                controlador.cBoleto.insertarListAsientoViaje(asientoViaje);
                
                if(!viajeAnterior.equals(viaje)){
                    controlador.cViaje.buscarViaje(viaje.getIdViaje()).setAsientosDispo(viaje.getAsientosDispo()-1);
                    controlador.cViaje.buscarViaje(viajeAnterior.getIdViaje()).setAsientosDispo(viajeAnterior.getAsientosDispo()+1);
                }
                
                ((JDialog)SwingUtilities.getWindowAncestor(this)).setVisible(false);
            }
            
            
        }else{
            JOptionPane.showMessageDialog(this, errores,"Campos invalidos",JOptionPane.ERROR_MESSAGE);
            controlador.cBoleto.habilitarAsientos(asientos, false);
        }
    }//GEN-LAST:event_bttActualizarActionPerformed
    
    private void habilitarComponentesInfoRuta(boolean val){
        label_ReferenciaRuta.setVisible(val);
        label_CostoInicial.setVisible(val);
        txtCostoInicial.setVisible(val);
    }
    
    private void ItemcbRuta(ItemEvent e){
        
        if(cbRuta.getSelectedIndex()>0){
            
            controlador.cViaje.llenarTablaViajeRuta(tabla_ViajeAsiento, String.valueOf(cbRuta.getSelectedItem()));
            ponerImagen(Imagen_RutaRef,String.valueOf(cbRuta.getSelectedItem()),190,120);
            
            habilitarComponentesInfoRuta(true);

            Ruta rutaCombo = (Ruta)cbRuta.getSelectedItem();
            txtCostoInicial.setText("S/. "+rutaCombo.getCoste());
            
        }else{
            DefaultTableModel dt = (DefaultTableModel)tabla_ViajeAsiento.getModel();
            dt.setRowCount(0);
            Imagen_RutaRef.setIcon(null);  
            habilitarComponentesInfoRuta(false);
        }
        controlador.cBoleto.habilitarAsientos(asientos, false);
    }
    
    private void tabla_ViajeAsientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ViajeAsientoMousePressed
        int fila = tabla_ViajeAsiento.rowAtPoint(evt.getPoint()); //
        if(fila >= 0){
            viaje = controlador.cViaje.buscarViaje((Integer)tabla_ViajeAsiento.getValueAt(fila, 0));
            controlador.cBoleto.habilitarAsientos(asientos, true);
            controlador.cBoleto.llamarAsientosDeViaje(asientos,(Integer)(tabla_ViajeAsiento.getValueAt(fila, 0)));
        }
    }//GEN-LAST:event_tabla_ViajeAsientoMousePressed
    
    private JButton botonAnterior = null;
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton boton =(JButton)e.getSource();
        if(!boton.getBackground().equals(new Color(190,0,0))){
            if (botonAnterior != null) {
                botonAnterior.setBackground(Color.WHITE);
                botonAnterior.setForeground(Color.BLACK);
            }

            boton.setBackground(new Color(153,153,153));
            boton.setForeground(Color.WHITE);

            botonAnterior = boton;

            NumAsiento = Integer.parseInt(boton.getText());
        }
    }
    
    public JPanel getPanel_barra() {
        return panel_barra;
    }

    public void setPanel_barra(JPanel panel_barra) {
        this.panel_barra = panel_barra;
    }

    public JButton getBttFlecha() {
        return bttFlecha;
    }

    public void setBttFlecha(JButton bttFlecha) {
        this.bttFlecha = bttFlecha;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Chofer;
    private javax.swing.JLabel Imagen_RutaRef;
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JLabel Salida;
    private javax.swing.JButton bttActualizar;
    private javax.swing.JButton bttFlecha;
    private javax.swing.JButton bttGuardar;
    private javax.swing.JComboBox<String> cbTipoPasajero;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_CostoInicial;
    private javax.swing.JLabel label_CreaBoleto;
    private javax.swing.JLabel label_ID;
    private javax.swing.JLabel label_ReferenciaRuta;
    private javax.swing.JLabel label_boleto;
    private javax.swing.JPanel panel_asiento;
    private javax.swing.JPanel panel_barra;
    private javax.swing.JTable tabla_ViajeAsiento;
    private javax.swing.JTextField txtCostoInicial;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPasajero;
    // End of variables declaration//GEN-END:variables
}
