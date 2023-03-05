import java.util.Map;
import java.util.HashMap;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;

public class RootPane extends JPanel implements ActionListener {
    private static final long serialVersionUID=1L;

    public RootPane(){
        super();
        JTabbedPane tabbedPane=new JTabbedPane();
        tabbedPane.add("Moneda",new MonedaConvertidor());
        tabbedPane.add("Temperatura",new TemperaturaConvertidor());

        add(tabbedPane);
    }

    public void actionPerformed(ActionEvent event){
        Object source=event.getSource();
    }
}
