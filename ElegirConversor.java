import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ElegirConversor extends JPanel {
    private String[] opts={"Conversor de Moneda","Conversor de Temperatura"};
    public ElegirConversor() {
        add(new JLabel("Elija opcion para convertir"));
        add(new JComboBox<String>(opts));
    }
}


