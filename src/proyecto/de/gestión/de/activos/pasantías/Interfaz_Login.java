/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.de.gestión.de.activos.pasantías;

import proyecto.de.gestión.de.activos.pasantías.Database.ConexionPostgresql;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import proyecto.de.gestión.de.activos.pasantías.Modelos.Usuario;

/**
 *
 * @author JUNIORCEDE
 */
public class Interfaz_Login extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_Login
     */
    public Interfaz_Login() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this, false);
        
        ImageIcon img = new ImageIcon("src/img/userlogin.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(IconLogin.getWidth(), IconLogin.getHeight(), Image.SCALE_DEFAULT));
        IconLogin.setIcon(icono);
        Cargando.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        LoginPanel = new javax.swing.JPanel();
        Login = new rojeru_san.RSButton();
        txtUser = new rojeru_san.RSMTextFull();
        txtPassword = new rojeru_san.RSMPassView();
        jLabel1 = new javax.swing.JLabel();
        Close = new rojeru_san.RSButton();
        IconLogin = new javax.swing.JLabel();
        Cargando = new rojerusan.componentes.RSProgressBarAnimated();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("FrameLogin"); // NOI18N

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoginPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(186, 189, 190)));

        Login.setText("Iniciar Sesion");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        txtUser.setToolTipText("");
        txtUser.setPlaceholder("Usuario");

        txtPassword.setPlaceholder("Contraseña");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 112, 192));
        jLabel1.setText("Iniciar Sesion");

        Close.setBackground(new java.awt.Color(213, 0, 0));
        Close.setText("X");
        Close.setColorHover(new java.awt.Color(255, 81, 49));
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        IconLogin.setText("   ");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(LoginPanelLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Cargando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 208, Short.MAX_VALUE))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(246, 246, 246))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(IconLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cargando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        rSPanelShadow1.add(LoginPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
        Confirmacion confirm = new Confirmacion();
        confirm.setVisible(true);
        confirm.textMsg.setText("¿Está seguro de salir del sistema?");
        confirm.clase = this.getClass();
        confirm.method = "stopAplication";
        confirm.Evento = evt;
        //System.exit(0); 
    }//GEN-LAST:event_CloseActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        
        Cargando.setVisible(true);
        Login.setVisible(false);
        ConexionPostgresql Postgres = new ConexionPostgresql().conectar();
        FuncionesUtiles utils = new FuncionesUtiles();
        String nom = txtUser.getText();
        String passDescript = txtPassword.getText();
        String pass = utils.Encriptar(passDescript);
        ResultSet login = Postgres.Consulta("Select * from usuarios where usuario like '"+nom+
                "' and pass LIKE '"+pass+"'");
        try {
            if (utils.CountResultSet(login)>0) {
                ResultSet rs = Postgres.Consulta("Select * from usuarios where usuario like '"+nom+
                "' and pass LIKE '"+pass+"'");
                Usuario user =  null;
                while(rs.next()){
                    user = new Usuario(rs.getString("usuario"),rs.getString("tipo"));
                    break;
                }
                if (user != null) {
                    System.out.println(user.getTipo());
                    if (user.getTipo().equals("UnidadE")) {
                        MenuUnidadE menu = new MenuUnidadE();
                        menu.setVisible(true);
                        JComponent comp = (JComponent) evt.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
                        Cargando.setVisible(false);
                        Login.setVisible(true);
                    }
                    else{
                        if (user.getTipo().equals("Congregacion")) {
                            MenuCongregacion menu = new MenuCongregacion();
                            menu.setVisible(true);
                            JComponent comp = (JComponent) evt.getSource();
                            Window win = SwingUtilities.getWindowAncestor(comp);
                            win.dispose();
                            Cargando.setVisible(false);
                            Login.setVisible(true);
                        }
                        else{
                            Cargando.setVisible(false);
                            Login.setVisible(true);
                        }
                    }
                }
                else{
                    System.out.println("Datos incorrectos");
                    Cargando.setVisible(false);
                    Login.setVisible(true);
                }
            }
            else {
                //JOptionPane.showMessageDialog(null, "Datos incorrectos\nVerifique e intente nuevamente.");
                System.out.println("Datos incorrectos");
                Cargando.setVisible(false);
                Login.setVisible(true);
            }
         } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Login.class.getName()).log(Level.SEVERE, null, ex);
            Cargando.setVisible(false);
            Login.setVisible(true);
         }
        /*
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();*/
    }//GEN-LAST:event_LoginActionPerformed
    
    public static void ConfirmAction(String method, Boolean Confirm,java.awt.event.ActionEvent evt){
        if (Confirm) {
            if (method == "stopAplication"){
                System.exit(0); 
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.componentes.RSProgressBarAnimated Cargando;
    private rojeru_san.RSButton Close;
    private javax.swing.JLabel IconLogin;
    private rojeru_san.RSButton Login;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel jLabel1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojeru_san.RSMPassView txtPassword;
    private rojeru_san.RSMTextFull txtUser;
    // End of variables declaration//GEN-END:variables
}
