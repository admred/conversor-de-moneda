import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JButton;

class Moneda{
    String nombre;
    double valor;

    public Moneda(String a,double b){
        nombre=a;
        valor=b;
    }
}

public class ConvertirMoneda extends JPanel {


    private List<Moneda> monedasUS=Arrays.asList(
        new Moneda("Peso Argentino",193.988875),
        new Moneda("Euro",0.939472),
        new Moneda("Libra Esternila",0.826442),
        new Moneda("Yen Japonés",134.614163),
        new Moneda("Won sul-coreano",1303.277058)
    );
    private String[] monedas={
        "Peso Argentino",
        "Euro",
        "Libra Esternila",
        "Yen Japonés",
        "Won sul-coreano"
    };

    public ConvertirMoneda() {
        super();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(new JLabel("Convertir a pesos"));
        add(new JComboBox<String>(monedas));
        add(new JTextField());
    }

    public double getResultado() {

        return 0.0;
    }
}


