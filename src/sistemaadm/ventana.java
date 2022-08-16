package sistemaadm;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ventana extends JFrame {

    usuario usuSistema[] = new usuario[10];
    JPanel panelInicioSesion = new JPanel();
    JPanel panelControl = new JPanel();
    JPanel panelCrearUsuario = new JPanel();
    int control = 2;
    cliente clientes[]= new cliente[100];
    int controlCliente = 0;
    JPanel panelControlClientes = new JPanel();

    public void crearAdmin() {
        usuSistema[0] = new usuario();
        usuSistema[0].nombreusuario = "admin";
        usuSistema[0].nombre = "administrador";
        usuSistema[0].contra = "123456";
        
        usuSistema[1] = new usuario();
        usuSistema[1].nombreusuario = "Juan";
        usuSistema[1].nombre = "Juan";
        usuSistema[1].contra = "12";
    }

    public ventana() {
        objetos();
        crearAdmin();

    }

    public void objetos() {
        
        this.getContentPane().add(panelInicioSesion);
        panelInicioSesion.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(20, 7, 100, 15);
        panelInicioSesion.add(lblLogin);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(60, 40, 100, 15);
        panelInicioSesion.add(lblUsuario);

        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(60, 100, 100, 15);
        panelInicioSesion.add(lblContra);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 40, 200, 25);
        panelInicioSesion.add(txtUsuario);

        JTextField txtContra = new JTextField();
        txtContra.setBounds(150, 100, 200, 25);
        panelInicioSesion.add(txtContra);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(120, 145, 180, 35);
        panelInicioSesion.add(btnIngresar);
        
        ActionListener ingresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtUsuario.getText().equals("") || txtContra.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                } else {
                    recorrerUsuarios(txtUsuario.getText(), txtContra.getText());

                }
            }
        };
        btnIngresar.addActionListener (ingresar);
        
        JButton btnCrearUsuario = new JButton("Registrarse");
        btnCrearUsuario.setBounds(120, 200, 180, 35);
        panelInicioSesion.add(btnCrearUsuario);
        ActionListener crearUsuario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              CrearUsuario();
              panelCrearUsuario.setVisible(true); 
            }
        };
        btnCrearUsuario.addActionListener(crearUsuario);
    }


    public void recorrerUsuarios(String nombreUsuario, String contra) {
        boolean encontrado = false;
        for (int i = 0; i < 10; i++) {  
            if(usuSistema[i] != null){
            
            if (usuSistema[i].nombreusuario.equals(nombreUsuario)&& usuSistema[i].contra.equals(contra)) {
                JOptionPane.showMessageDialog(null, "Bienvenido al sistema usuario" + nombreUsuario);
                panelControl();
                encontrado = true;
                break;

            } else {
                 encontrado = false;               
            
                 }
            }

        }
        if(encontrado == false){
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }
    public void panelControl(){       
        this.getContentPane().add(panelControl);
        panelControl.setLayout(null);
        this.setSize(700, 600);
        this.setTitle("Control principal");
        panelInicioSesion.setVisible(false);
        
        JButton btnAdminClientes = new JButton("Administración de clientes");
        btnAdminClientes.setBounds(150, 10, 250, 25);
        panelControl.add(btnAdminClientes);
        ActionListener administrarClientes = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelControlCli();
                panelControlClientes.setVisible(true);
            }
        
        };
        
        JButton btnAdminProductos = new JButton("Administración de productos");
        btnAdminProductos.setBounds(150, 80, 250, 25);
        panelControl.add(btnAdminProductos);
        
        JButton btnReportes = new JButton("Reportes");
        btnReportes.setBounds(150, 150, 250, 25);
        panelControl.add(btnReportes);
    }
    
    public void CrearUsuario(){
        this.getContentPane().add(panelCrearUsuario);
        panelCrearUsuario.setLayout(null);
        this.setSize(500, 450);
        this.setTitle("Registro de nuevo usuario");
        panelInicioSesion.setVisible(false);
        
        JLabel lblRegistro = new JLabel ("Registro de usuario");
        lblRegistro.setBounds(20, 20, 150, 20);
        panelCrearUsuario.add(lblRegistro);
        
        JLabel lblUsuario = new JLabel ("Usuario");
        lblUsuario.setBounds(50, 50, 150, 20);
        panelCrearUsuario.add(lblUsuario);
        
        JLabel lblNombre = new JLabel ("Nombre");
        lblNombre.setBounds(50, 100, 150, 20);
        panelCrearUsuario.add(lblNombre);
        
        JLabel lblContra = new JLabel ("Contraseña");
        lblRegistro.setBounds(50, 150, 150, 20);
        panelCrearUsuario.add(lblContra);
        
        JLabel lblConfirmar = new JLabel ("Confirmar Contraseña");
        lblConfirmar.setBounds(50, 200, 150, 20);
        panelCrearUsuario.add(lblConfirmar);
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(200, 50, 150, 20);
        panelCrearUsuario.add(txtUsuario);
        
        JTextField txtNombreUsuario = new JTextField();
        txtNombreUsuario.setBounds(200, 100, 150, 20);
        panelCrearUsuario.add(txtNombreUsuario);
        
        JTextField txtContra = new JTextField();
        txtContra.setBounds(200, 150, 150, 20);
        panelCrearUsuario.add(txtContra);
        
        JTextField txtConfContra = new JTextField();
        txtConfContra.setBounds(200, 200, 150, 20);
        panelCrearUsuario.add(txtConfContra);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(130, 280, 200, 35);
        panelCrearUsuario.add(btnRegistrar);
        ActionListener registro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              if(txtUsuario.getText().equals("")|| txtNombreUsuario.getText().equals("") || txtContra.getText().equals("") || txtConfContra.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos");
              }else{
                  if(txtContra.getText().equals(txtConfContra.getText())){
                      guardarUsuario( txtUsuario.getText(),txtNombreUsuario.getText(), txtContra.getText());
                      txtUsuario.setText("");
                      txtNombreUsuario.setText("");
                      txtContra.setText("");
                      txtConfContra.setText("");
                  }else{
                      JOptionPane.showMessageDialog(null, "Las contraseñas NO coinciden");
                  }
              }
            }
        };
        btnRegistrar.addActionListener(registro);
        
        JButton btnVolver = new JButton("Volver al inicio");
        btnVolver.setBounds(130, 350, 200, 35);
        panelCrearUsuario.add(btnVolver);
        ActionListener volverInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelInicioSesion.setVisible(true);
                panelCrearUsuario.setVisible(false);
                volverInicio();
            }
        
        };
        btnVolver.addActionListener(volverInicio);
    }
    public void volverInicio(){
        this.setTitle("Sistema administrativo de clientes y recursos");
        this.setSize(450, 350);
    }
    
    public void guardarUsuario(String nombre, String nombreUsuario, String contra){
        int posicion = 0;
        if (control < 10){    
        for (int i = 0; i < 9; i++) {
            if (usuSistema[i] == null) {
                posicion = i;
                break;
            }
        }
         //System.out.println("La posición libre es " + posicion);
        usuSistema[posicion] = new usuario();
        usuSistema[posicion].nombreusuario = nombre;
        usuSistema[posicion].nombre = nombreUsuario;
        usuSistema[posicion].contra = contra;
        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente, total de usuarios " + control);
        control = control + 1;
        }else{
            JOptionPane.showMessageDialog(null, "No se puede registrar mas usuarios");
        }
       

    }
    
    public void panelControlCli(){
        PopupMenu panelControlClientes = null;
        this.getContentPane().add(panelControlClientes);
        panelControlClientes.setLabel(null);
        this.setSize(600, 500);
        this.setTitle("Administración de clientes");
        panelControl.setVisible(false);
                
    }

}
