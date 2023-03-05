import java.util.Arrays;
import java.util.List;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class RootPane extends JPanel implements ActionListener {
    private static final long serialVersionUID=1L;
    ConvertirMoneda monedaPanel;

    public RootPane(){
        super();

        monedaPanel=new ConvertirMoneda();
        add(monedaPanel);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    }

    public void actionPerformed(ActionEvent event){
        Object source=event.getSource();
    }
}
