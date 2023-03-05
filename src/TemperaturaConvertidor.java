
class TemperaturaConvertidor extends AbstractConvertidor {
    private static final long serialVersionUID=1L;

    private static final String[] units={"","Kelvin","Centigrados","Fahrenheit"};

    public TemperaturaConvertidor(){
        super("Temperatura",units);
    }


    @Override
    public void updateResult(){

        double result=0.0;
        double kelvin=0.0;
        double input=0.0;
        if(getInputUnit().equals("") || getOutputUnit().equals("") || getErrorStatus() || getInput().isBlank()){
            return;
        }
        input=Double.valueOf(getInput());

        // https://es.wikipedia.org/wiki/Temperatura
        switch(getInputUnit()){
            case "Kelvin":
                kelvin=input;
                break;
            case "Centigrados":
                kelvin=input+273.15;
                break;
            case "Fahrenheit":
                kelvin=(input+459.67)*5/9;
                break;
        }
        switch(getOutputUnit()){
            case "Kelvin":
                result=kelvin;
                break;
            case "Centigrados":
                result=kelvin-273.15;
                break;
            case "Fahrenheit":
                result=kelvin*9/5-459.67;
                break;
            }
        setOutput(String.format("%f",result));
    }
}
