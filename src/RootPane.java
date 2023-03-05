import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RootPane extends JPanel {
    private static final long serialVersionUID=1L;

    public RootPane(){
        super();
        JTabbedPane tabbedPane=new JTabbedPane();
        tabbedPane.add("Moneda",new MonedaConvertidor());
        tabbedPane.add("Temperatura",new TemperaturaConvertidor());

        add(tabbedPane);
    }
}
