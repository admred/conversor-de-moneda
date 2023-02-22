import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


public class RootPane extends JPanel implements ActionListener {
    private int count=0;
    private JLabel label;
    private JButton button;

    public RootPane(){
        super();
        label=new JLabel("Count");
        add(label);
        button=new JButton("Press");
        button.setName("PressButton1");
        button.addActionListener(this);
        add(button);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() instanceof JButton && button.getName() == "PressButton1") {
            count++;
            label.setText("Count "+count);
            System.out.println("Count : "+count);
        }
    }
}
