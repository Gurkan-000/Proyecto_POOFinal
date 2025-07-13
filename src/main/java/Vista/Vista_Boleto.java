
package Vista;

/**
 *
 * @author RODRIGO
 */



import javax.swing.JDialog;
import Modelo.Boleto;
import Util.FechasHora;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Vista_Boleto extends JDialog {
    
    private boolean comprar;
    
    public Vista_Boleto(Window parent,Boleto boleto) {
        super(parent,"", ModalityType.APPLICATION_MODAL);
        initComponents();
        
        ponerImagen(Logo_Empresa, "bus_logo", 40, 29);
        llenarBoleto(boleto);
    }
    
    private void llenarBoleto(Boleto boleto){
        Nombre.setText(boleto.getNombre());
        Tipo.setText(boleto.getTipo());
        Ruta.setText(boleto.getViaje().getRuta().getNombre());
        FechaHora.setText(boleto.getViaje().getFecha()+" "+FechasHora.parseHora(boleto.getViaje().getHora()));
        Asiento.setText(String.valueOf(boleto.getIdAsiento()));
        label_MontoFinal.setText("S/."+boleto.costeBoleto());
    }

    private void ponerImagen(JLabel label, String URL,int ancho, int altura){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/"+URL+".png"));
        Image image = imageIcon.getImage().getScaledInstance(ancho,altura,Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    public boolean getComprar() {
        return comprar;
    }

    public void setComprar(boolean comprar) {
        this.comprar = comprar;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boleto = new javax.swing.JPanel();
        Barra_Superior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Logo_Empresa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Asiento = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Tipo = new javax.swing.JLabel();
        Ruta = new javax.swing.JLabel();
        FechaHora = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        bttComprar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        label_MontoFinal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Boleto.setBackground(new java.awt.Color(255, 255, 255));
        Boleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boleto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Barra_Superior.setBackground(new java.awt.Color(53, 93, 127));
        Barra_Superior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Barra_Superior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bus Express");
        Barra_Superior.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, 155, -1));
        Barra_Superior.add(Logo_Empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 12, 40, 29));

        Boleto.add(Barra_Superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("N° Asiento");
        Boleto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 90, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nombre");
        Boleto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Tipo");
        Boleto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 90, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Ruta");
        Boleto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 90, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Fecha/Hora");
        Boleto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 90, 20));

        Asiento.setBackground(new java.awt.Color(255, 255, 255));
        Asiento.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Asiento.setForeground(new java.awt.Color(153, 153, 153));
        Asiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Boleto.add(Asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 60, 50));

        Nombre.setBackground(new java.awt.Color(255, 255, 255));
        Nombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nombre.setForeground(new java.awt.Color(153, 153, 153));
        Boleto.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 20));

        Tipo.setBackground(new java.awt.Color(255, 255, 255));
        Tipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tipo.setForeground(new java.awt.Color(153, 153, 153));
        Boleto.add(Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, 20));

        Ruta.setBackground(new java.awt.Color(255, 255, 255));
        Ruta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Ruta.setForeground(new java.awt.Color(153, 153, 153));
        Boleto.add(Ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, 20));

        FechaHora.setBackground(new java.awt.Color(255, 255, 255));
        FechaHora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FechaHora.setForeground(new java.awt.Color(153, 153, 153));
        Boleto.add(FechaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 20));

        Editar.setBackground(new java.awt.Color(53, 93, 127));
        Editar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Boleto.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 90, -1));

        bttComprar.setBackground(new java.awt.Color(53, 93, 127));
        bttComprar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bttComprar.setForeground(new java.awt.Color(255, 255, 255));
        bttComprar.setText("Comprar");
        bttComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttComprarActionPerformed(evt);
            }
        });
        Boleto.add(bttComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 90, -1));
        Boleto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 460, 10));

        label_MontoFinal.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        label_MontoFinal.setForeground(new java.awt.Color(102, 102, 102));
        Boleto.add(label_MontoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 90, 20));

        jLabel8.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Costo final :");
        Boleto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 90, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Boleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Boleto, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttComprarActionPerformed

        comprar = true;
        this.dispose();
        
    }//GEN-LAST:event_bttComprarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        
        comprar = false;
        this.dispose();
        
    }//GEN-LAST:event_EditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asiento;
    private javax.swing.JPanel Barra_Superior;
    private javax.swing.JPanel Boleto;
    private javax.swing.JButton Editar;
    private javax.swing.JLabel FechaHora;
    private javax.swing.JLabel Logo_Empresa;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Ruta;
    private javax.swing.JLabel Tipo;
    private javax.swing.JButton bttComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_MontoFinal;
    // End of variables declaration//GEN-END:variables
}
