import java.util.regex.Pattern;
import java.util.regex.Matcher;
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
    private final static Pattern pat=Pattern.compile("\\d+(\\.\\d+)?");
    private final static Map<String,Double> monedas=new HashMap<String,Double>(){{
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
        if(e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        String key=(String)e.getItem();

        if(key.equals("") || "".equals(getInput()) ) {
            setOutput("");
        }

        JComboBox<String> cb=(JComboBox<String>)e.getSource();
        String name=cb.getName();
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

        if("".equals(getInput())){
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
        return pat.matcher(getInput()).matches();
    }

    public void updateResult(){
        double inputQuote=monedas.get(inputUnit);
        double outputQuote=monedas.get(outputUnit);
        if(inputUnit.equals("") || outputUnit.equals("") || isErrorSet()){
            return;
        }
        setOutput(String.format("%f",Double.valueOf(getInput())*inputQuote/outputQuote));
    }
}
