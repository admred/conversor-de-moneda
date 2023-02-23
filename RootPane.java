import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


public class RootPane extends JPanel implements ActionListener {
    private JButton next;
    private JButton previous;
    private JPanel actions;
    private JPanel center;
    private CardLayout cards;
    private int cur=0;
    private int count=0;

    public void addCard(Component comp){
        center.add(comp);
        count++;
    }

    public RootPane(){
        super(new BorderLayout());

        cards=new CardLayout(10,10);
        center=new JPanel(cards );
        //addCard(new JLabel("Elegir tipo Convertidor"));
        addCard(new ElegirConversor());
        addCard(new ConvertirMoneda());
        addCard(new JLabel("Resultado"));
        addCard(new JLabel("Desea continuar?"));
        addCard(new JLabel("Programa terminado"));
        add(center,BorderLayout.CENTER);


        // Barra inferior de botones
        next=new JButton("Siguiente");
        next.setName("next");
        next.addActionListener(this);

        previous=new JButton("Volver");
        previous.setName("previous");
        previous.addActionListener(this);

        actions=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.add(previous);
        actions.add(next);
        add(actions,BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent event){
        Object source=event.getSource();
        if(source == null){
            System.err.println("source = null");
            return;
        }

        if(source instanceof JButton) {
            JButton button=(JButton)source;
            if ( "next".equals(button.getName()) &&  cur < count-1 ) {
                cards.next(center);
                cur++;
            }else if( "previous".equals(button.getName()) && cur > 0  ) {
                cards.previous(center);
                cur-- ;
            }
        }
    }
}
