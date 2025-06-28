
package Vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Modelo.Usuario;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMaterialLighterIJTheme;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

import Controlador.C_Usuario;


/**
 *
 * @author RODRIGO
 */
public class Login_Formulario extends JFrame {

    private Usuario usuario;
    private C_Usuario controlUsu = new C_Usuario();
    private StringBuilder errores;
    
    private int x;
    private int y;
    
            
    public Login_Formulario() {
        initComponents();
        ponerImagen(label_imagen, "bus_logo");
        EstiloComponentes();
        
        this.setSize(500, 420);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        SwingUtilities.invokeLater(() -> {
    
            bttIngresar.requestFocusInWindow();
        
            txtUsuario.setCaretPosition(0);
            txtContraseña.setCaretPosition(0);
            
        });
        
    }

    private void ponerImagen(JLabel label, String URL){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(label_imagen.getWidth(),label_imagen.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    private void EstiloComponentes(){
        bttIngresar.putClientProperty( "JButton.buttonType", "roundRect" );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        panel_borde = new javax.swing.JPanel();
        label_imagen = new javax.swing.JLabel();
        label_Titulo = new javax.swing.JLabel();
        panel_superior = new javax.swing.JPanel();
        panel_cerrar = new javax.swing.JPanel();
        label_cerrar = new javax.swing.JLabel();
        bttIngresar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 170, 10));

        jLabel2.setFont(new java.awt.Font("JetBrains Mono ExtraBold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 170, 10));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Iniciar Sesion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        panel_borde.setBackground(new java.awt.Color(53, 93, 127));

        label_Titulo.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        label_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        label_Titulo.setText("Bus Express");

        javax.swing.GroupLayout panel_bordeLayout = new javax.swing.GroupLayout(panel_borde);
        panel_borde.setLayout(panel_bordeLayout);
        panel_bordeLayout.setHorizontalGroup(
            panel_bordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bordeLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panel_bordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bordeLayout.createSequentialGroup()
                        .addComponent(label_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bordeLayout.createSequentialGroup()
                        .addComponent(label_Titulo)
                        .addGap(33, 33, 33))))
        );
        panel_bordeLayout.setVerticalGroup(
            panel_bordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bordeLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(label_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(label_Titulo)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel1.add(panel_borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 190, 420));

        panel_superior.setBackground(new java.awt.Color(255, 255, 255));
        panel_superior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel_superiorMouseDragged(evt);
            }
        });
        panel_superior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel_superiorMousePressed(evt);
            }
        });
        panel_superior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_cerrar.setBackground(new java.awt.Color(255, 255, 255));

        label_cerrar.setBackground(new java.awt.Color(0, 0, 0));
        label_cerrar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 20)); // NOI18N
        label_cerrar.setForeground(new java.awt.Color(0, 0, 0));
        label_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_cerrar.setText("X");
        label_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_cerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_cerrarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panel_cerrarLayout = new javax.swing.GroupLayout(panel_cerrar);
        panel_cerrar.setLayout(panel_cerrarLayout);
        panel_cerrarLayout.setHorizontalGroup(
            panel_cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );
        panel_cerrarLayout.setVerticalGroup(
            panel_cerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_cerrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_superior.add(panel_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(panel_superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 40));

        bttIngresar.setBackground(new java.awt.Color(53, 93, 127));
        bttIngresar.setFont(new java.awt.Font("MS UI Gothic", 1, 16)); // NOI18N
        bttIngresar.setForeground(new java.awt.Color(255, 255, 255));
        bttIngresar.setText("Ingresar");
        bttIngresar.setBorderPainted(false);
        bttIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(bttIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 130, 50));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 162, 170, 30));

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setText("********");
        txtContraseña.setBorder(null);
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusLost(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 252, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void label_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cerrarMouseEntered
        panel_cerrar.setBackground(Color.RED);
        label_cerrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_label_cerrarMouseEntered

    private void label_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cerrarMouseExited
        panel_cerrar.setBackground(Color.WHITE);
        label_cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_label_cerrarMouseExited

    private void label_cerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cerrarMousePressed
         panel_cerrar.setBackground(new Color(190,0,0));
         label_cerrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_label_cerrarMousePressed

    private void label_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_label_cerrarMouseClicked
    
    private boolean ValidarCampos(){
        
        errores = new StringBuilder();
        
        if(txtUsuario.getText().trim().isEmpty() || !txtUsuario.getText().trim().matches("[a-zA-Z]+")){
            errores.append("Campo de usuario invalido\n");
        }
        
        if(txtContraseña.getText().trim().isEmpty() || !txtContraseña.getText().trim().matches("[a-zA-Z0-9*]+")){
            errores.append("Campo de contraseña invalido");
        }

        return errores.length()>0;
    }
    
    private void bttIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttIngresarActionPerformed
        
        if(!ValidarCampos()){ 
            
            usuario = new Usuario();
            usuario.setUsuario(txtUsuario.getText());
            usuario.setContraseña(txtContraseña.getText());
            
            if(controlUsu.buscarUsuario(usuario)){
                Formulario_Viaje viaje = new Formulario_Viaje();
                viaje.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, 
                                      "No existe usuario o contraseña con esas credencciales", 
                                      "Credenciales incorrectas", 
                                      JOptionPane.ERROR_MESSAGE);
                limpiarCampo();
            }
            
        }else{
            JOptionPane.showMessageDialog(this, 
                                      errores, 
                                      "Campos invalidos", 
                                      JOptionPane.ERROR_MESSAGE);
            limpiarCampo();
        }

    }//GEN-LAST:event_bttIngresarActionPerformed

    private void limpiarCampo(){
        txtUsuario.setForeground(new Color(204,204,204));
        txtContraseña.setForeground(new Color(204,204,204));
        txtUsuario.setText("Usuario");
        txtContraseña.setText("********");
    }
    
    private void panel_superiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_superiorMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panel_superiorMousePressed

    private void panel_superiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_superiorMouseDragged
        int xScreen = evt.getXOnScreen();
        int yScreen = evt.getYOnScreen();
        this.setLocation(xScreen-x, yScreen-y);
    }//GEN-LAST:event_panel_superiorMouseDragged

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        if(txtUsuario.getText().equals("Usuario")){
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if(txtUsuario.getText().trim().isEmpty()){
            txtUsuario.setForeground(new Color(204,204,204));
            txtUsuario.setText("Usuario");
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusGained
        if(txtContraseña.getText().equals("********")){
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtContraseñaFocusGained

    private void txtContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusLost
        if(txtContraseña.getText().isEmpty()){
            txtContraseña.setForeground(new Color(204,204,204));
            txtContraseña.setText("********");
        }
    }//GEN-LAST:event_txtContraseñaFocusLost
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatMTMaterialLighterIJTheme.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_Titulo;
    private javax.swing.JLabel label_cerrar;
    private javax.swing.JLabel label_imagen;
    private javax.swing.JPanel panel_borde;
    private javax.swing.JPanel panel_cerrar;
    private javax.swing.JPanel panel_superior;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
