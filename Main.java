import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Main  extends JFrame {
    
    public static void main(String[] args ){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Main(new RootPane()).setVisible(true);
        }});
    }

    public Main(RootPane rootPane) {
        setTitle("Convertidor de monedas");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(rootPane);
        setLocationRelativeTo(null);
    }
}
