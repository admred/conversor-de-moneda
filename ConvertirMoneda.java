import java.util.Map;
import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;


class  ConvertirMoneda extends AbstractConvertidor {
    private static final long serialVersionUID=1L;

    private String saveInput="";
    private String inputUnit;
    private String outputUnit;
    private static final Map<String,Double> monedas=new HashMap<String,Double>(){{
            put("",-1.0);
            put("Peso",0.0051);
            put("Dolar",1.0);
            put("Euro",1.0687);
            put("Libra Esterlina",1.2122);
            put("Won sur-coreano",0.00076);
            put("Yen japones",0.0073);
        }};

    public ConvertirMoneda() {
        super("Moneda",monedas.keySet().toArray(String[]::new));
        inputUnit="";
        outputUnit="";
    }


    @SuppressWarnings("unchecked")
    @Override
    public void itemStateChanged(ItemEvent e){
        // just filter SELECTED type
        if(e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        String key=(String)e.getItem();
        // check if ComboBox to unset
        if(key.equals("") || "".equals(getInput()) ) {
            setOutput("");
        }

        JComboBox<String> cb=(JComboBox<String>)e.getSource();
        String name=cb.getName();
        // guess the source
        if(name.equals("inputCombo")  ) {
            inputUnit=key;
        }
        if(name.equals("outputCombo") ) {
            outputUnit=key;
        }
        System.out.println(name+" : "+monedas.get(key)+" "+key);
        updateResult();

    }

    @Override
    public void keyTyped(KeyEvent e){
        /* not used */
    }

    @Override
    public void keyPressed(KeyEvent e){
        /* not used */
    }

    @Override
    public void keyReleased(KeyEvent e){

        if(getInput().isBlank()){
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
    public boolean validateInput(){
        return getInput().matches("\\d+(\\.\\d+)?");
    }

    public void updateResult(){
        double inputQuote=monedas.get(inputUnit);
        double outputQuote=monedas.get(outputUnit);
        String input=getInput();
        if(inputUnit.equals("") || outputUnit.equals("") || isErrorSet()){
            return;
        }
        if(getInput().isBlank()){
            return;
        }
        setOutput(String.format("%f",Double.valueOf(input)*inputQuote/outputQuote));
    }
}
