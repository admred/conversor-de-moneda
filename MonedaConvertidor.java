import java.util.Map;
import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;


class MonedaConvertidor extends AbstractConvertidor {
    private static final long serialVersionUID=1L;

    // https://www.google.com/finance/markets/currencies
    private static final Map<String,Double> monedas=new HashMap<String,Double>(){{
            put("",-1.0);
            put("Peso",0.0051);
            put("Dolar",1.0);
            put("Euro",1.0687);
            put("Libra Esterlina",1.2122);
            put("Won sur-coreano",0.00076);
            put("Yen japones",0.0073);
        }};

    public MonedaConvertidor() {
        super("Moneda",monedas.keySet().toArray(String[]::new));
    }

    @Override
    public void updateResult(){
        double inputQuote=monedas.get(getInputUnit());
        double outputQuote=monedas.get(getOutputUnit());
        String input=getInput();
        if(getInputUnit().equals("") || getOutputUnit().equals("") || getErrorStatus() || input.isBlank()){
            return;
        }
        setOutput(String.format("%f",Double.valueOf(input)*inputQuote/outputQuote));
    }
}
