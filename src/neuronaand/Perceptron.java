package neuronaand;
/**
 * @author dizan
 */
public class Perceptron {
    private int errorCometido;
    private int salidaDeseada;
    private int salidaRed;
    private double coeficienteAprendizaje;
    private double umbral;
    private Neurona neurona;
    private int [] xi;
    private double [] Wi;
    private double[] deltai = new double[2];;
    boolean aprendizajeFinalizado = false;
    valoresTabla valoresFila;
    
     public Perceptron(double umbral, 
                       double coeficienteAprendizaje) {
         
        this.umbral = umbral;
        this.coeficienteAprendizaje = coeficienteAprendizaje;
    }

    public Perceptron() {
        
        
    }
     
    public Neurona entrenar( valoresTabla valoresFila, Neurona neurona) {
      this.neurona = neurona;
      this.valoresFila = valoresFila;
      this.Wi = neurona.getWi();
      salidaRed = neurona.getY1(valoresFila);
      System.out.println("Salida de la red: " + salidaRed);
      errorCometido();
      
        if (errorCometido != 0) {
            //Calcular delta
            calcularDeltas(xi);
            //Calcular nuevos pesos
            calcularNuevosPesos(Wi, deltai);
            //Calcular nuevo umbral
            calcularNuevoUmbral();
        }
        neurona.setWi(Wi);
        return neurona;
    }

    public int errorCometido() {
        errorCometido = valoresFila.getY() - salidaRed;
        System.out.println("Salida deseada " + valoresFila.getY());
        System.out.println("Error cometido: " + errorCometido);
        return errorCometido;
    }

    public void calcularDeltas(int [] xi) {
        deltai[0] = coeficienteAprendizaje * errorCometido * valoresFila.getX1();
        deltai[1] = coeficienteAprendizaje * errorCometido * valoresFila.getX2();
    }

    public void calcularNuevosPesos(double[]wi, double [] deltai) {
          for (int i = 0; i < wi.length; i++) {
            Wi[i] = wi[i] + deltai[i];
        }
    }

    public void calcularNuevoUmbral() {
        umbral = umbral - coeficienteAprendizaje * errorCometido;
    }

    /**
     * @return the errorCometido
     */
    public int getErrorCometido() {
        return errorCometido;
    }

    /**
     * @param errorCometido the errorCometido to set
     */
    public void setErrorCometido(int errorCometido) {
        this.errorCometido = errorCometido;
    }

    /**
     * @return the salidaDeseada
     */
    public int getSalidaDeseada() {
        return salidaDeseada;
    }

    /**
     * @param salidaDeseada the salidaDeseada to set
     */
    public void setSalidaDeseada(int salidaDeseada) {
        this.salidaDeseada = salidaDeseada;
    }

    /**
     * @return the salidaRed
     */
    public int getSalidaRed() {
        return salidaRed;
    }

    /**
     * @param salidaRed the salidaRed to set
     */
    public void setSalidaRed(int salidaRed) {
        this.salidaRed = salidaRed;
    }

    /**
     * @return the coeficienteAprendizaje
     */
    public double getCoeficienteAprendizaje() {
        return coeficienteAprendizaje;
    }

    /**
     * @param coeficienteAprendizaje the coeficienteAprendizaje to set
     */
    public void setCoeficienteAprendizaje(double coeficienteAprendizaje) {
        this.coeficienteAprendizaje = coeficienteAprendizaje;
    }

    /**
     * @return the umbral
     */
    public double getUmbral() {
        return umbral;
    }

    /**
     * @param umbral the umbral to set
     */
    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    /**
     * @return the neurona
     */
    public Neurona getNeurona() {
        return neurona;
    }

    /**
     * @param neurona the neurona to set
     */
    public void setNeurona(Neurona neurona) {
        this.neurona = neurona;
    }

    /**
     * @return the xi
     */
    public int[] getXi() {
        return xi;
    }

    /**
     * @param xi the xi to set
     */
    public void setXi(int[] xi) {
        this.xi = xi;
    }

    /**
     * @return the WiActual
     */
    public double[] getWiActual() {
        return Wi;
    }

    /**
     * @param WiActual the WiActual to set
     */
    public void setWiActual(double[] WiActual) {
        this.Wi = WiActual;
    }

    /**
     * @return the WiNuevo
     */
    public double[] getWi() {
        return Wi;
    }

    /**
     * @param WiNuevo the WiNuevo to set
     */
    public void setWi(double[] WiNuevo) {
        this.Wi = WiNuevo;
    }

    /**
     * @return the deltai
     */
    public double[] getDeltai() {
        return deltai;
    }

    /**
     * @param deltai the deltai to set
     */
    public void setDeltai(double[] deltai) {
        this.deltai = deltai;
    }

   
    
}
