class MonedaConvertidor extends AbstractConvertidor {

    private Moneda[] monedas=monedas=new Moneda[]{
            new Moneda("Dolar"),
            new Moneda("Euro"),
            new Moneda("Libras Esternilas"),
            new Moneda("Yen Japones"),
            new Moneda("Won sul-coreano")
        };
    public MonedaConvertidor(){
        super("Moneda",monedas);

    }
}
