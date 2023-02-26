import java.util.stream.Collectors;

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

class ConvertirMoneda extends JPanel {


    private List<Moneda> monedas=new ArrayList<Moneda>(){{
        add(new Moneda("Peso Argentino",193.988875));
        add(new Moneda("Euro",0.939472));
        add(new Moneda("Libra Esternila",0.826442));
        add(new Moneda("Yen Japonés",134.614163));
        add(new Moneda("Won sul-coreano",1303.277058));
    }};
    private String[] monedasN={
        "Peso Argentino",
        "Euro",
        "Libra Esternila",
        "Yen Japonés",
        "Won sul-coreano"
    };

    public ConvertirMoneda() {
        super();
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        add(new JLabel("De moneda extrangera a pesos"));
        add(new JLabel("De pesos a moneda extrangera"));

        add(new JComboBox<String>(monedas.stream().map(Moneda::getNombre).toArray(String[]::new)));
        add(new JTextField());
    }

    public double getResultado() {

        return 0.0;
    }
}


