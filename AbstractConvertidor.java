import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

/**
 *  Convertidor de moneda,temperatura, y otras unidades en una abstraccion
 *
 * */

abstract class  AbstractConvertidor extends JPanel implements ItemListener,KeyListener {
    private static final long serialVersionUID=1L;
    private String[] comboModel;
    private String title;
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> inputCombo;
    private JComboBox<String> outputCombo;
    private String[] units;
    private boolean error=false;

    public AbstractConvertidor(String title,String[] units) {
        super();
        this.title=title;
        this.units=units;
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        setBorder(BorderFactory.createTitledBorder(title));
        add(Box.createVerticalStrut(10));

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
        Box vbox;
        Box hbox;

        vbox=Box.createVerticalBox();
        // label
        hbox=Box.createHorizontalBox();
        hbox.add(new JLabel(title));
        hbox.add(Box.createHorizontalGlue());
        vbox.add(hbox);

        // textfield + combobox
        hbox=Box.createHorizontalBox();
        hbox.add(textField);
        hbox.add(comboBox);

        vbox.add(hbox);
        vbox.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
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
    public void setErrorStatus(){
        inputField.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        setOutput("");
        error=true;
    }
    public void clearErrorStatus(){
        inputField.setBorder(BorderFactory.createEmptyBorder());
        error=false;
        setOutput("");
    }
    public boolean isErrorSet(){
        return error;
    }
    public void setUnits(String[] units){
        this.units=units;
    }
}
