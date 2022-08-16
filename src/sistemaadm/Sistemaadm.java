package sistemaadm;

import javax.swing.JFrame;

public class Sistemaadm {

    public static void main(String[] args) {

        
        ventana marco = new ventana();
        marco.setVisible(true);
        marco.setTitle("Sistema administarativo de clientes y recursos");
        marco.setSize(450, 350);
        marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
