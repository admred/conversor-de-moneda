import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


class Main  extends JFrame {

    public static void main(String[] args ){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new Main(new RootPane()).setVisible(true);
        }});
    }

    public Main(JPanel rootPane) {
        setTitle("Convertidor de monedas");
        //setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(rootPane);
        pack();
        setLocationRelativeTo(null);
    }
}
