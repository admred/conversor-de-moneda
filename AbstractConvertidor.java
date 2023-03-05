import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;


abstract class  AbstractConvertidor extends JPanel implements ItemListener,KeyListener {
    private static final long serialVersionUID=1L;
    private String title;
    private String[] units;
    private boolean error;
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> inputCombo;
    private JComboBox<String> outputCombo;


    public AbstractConvertidor(String title,String[] units) {
        super();
        this.title=title;
        this.units=units;
        this.error=false;

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createTitledBorder(title));

        add(Box.createVerticalStrut(20));

        inputField=new JTextField(20);
        inputField.setName("inputField");
        inputField.addKeyListener(this);
        inputCombo=new JComboBox<String>(units);
        inputCombo.addItemListener(this);
        inputCombo.setName("inputCombo");
        addEntry("Ingresar cantidad que desea convertir",inputField,inputCombo);

        outputField=new JTextField(20);
        outputField.addKeyListener(this);
        outputField.setName("outputField");
        outputField.setEditable(false);
        outputCombo=new JComboBox<String>(units);
        outputCombo.addItemListener(this);
        outputCombo.setName("outputCombo");
        addEntry("Resultado",outputField,outputCombo);
    }

    private void addEntry(String title,JTextField textField,JComboBox<String> comboBox){
        Box vbox=Box.createVerticalBox();
        Box hbox;

        hbox=Box.createHorizontalBox();
        textField.setBorder(BorderFactory.createEmptyBorder());
        hbox.add(textField);


        hbox.add(comboBox);
        hbox.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        JPanel titleWrap=new JPanel();

        titleWrap.setBorder(BorderFactory.createTitledBorder(title));
        titleWrap.add(hbox);
        vbox.add(titleWrap);

        vbox.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
        add(vbox);
    }

    public String getInput(){
        return inputField.getText();
    }

    public void setInput(String text){
        inputField.setText(text);
    }

    public String getOutput(){
        return outputField.getText();
    }

    public void setOutput(String text){
        outputField.setText(text);
    }

    public void clearErrorStatus(){
        inputField.setBorder(BorderFactory.createEmptyBorder());
        error=false;
        //setOutput("");
    }

    public void setErrorStatus(){
        inputField.setBorder(BorderFactory.createLineBorder(Color.RED));
        error=true;
        setOutput("");
    }

    public boolean getErrorStatus(){
        return error;
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }
        String key=(String)e.getItem();

        if(key.equals("") ||  inputField.getText().equals("") ) {
            outputField.setText("");
        }
        updateResult();
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(inputField.getText().isBlank()){
            clearErrorStatus();
            return;
        }
        if(validateInput()){
            clearErrorStatus();
            updateResult();
        } else {
            setErrorStatus();
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        /* not used */
    }

    @Override
    public void keyTyped(KeyEvent e){
        /* not used */
    }

    public String getInputUnit(){
        return (String)inputCombo.getSelectedItem();
    }

    public String getOutputUnit(){
        return (String)outputCombo.getSelectedItem();
    }

    public boolean validateInput(){
         return getInput().matches("\\d+(\\.\\d+)?");
    }

    public abstract void updateResult();
}
