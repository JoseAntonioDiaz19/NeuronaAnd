package neuronaand;
/**
 * @author dizan
 */
public class Neurona {

    private double [] wi;
    private double wx;
    private double umbral;
    
     public Neurona(double [] wi) {
        this.wi = wi;
    }
    
    public Neurona(){
    }

    public int getY1(valoresTabla valoresFila) {
        double y1;
        int activacion = 0;
        wx = (valoresFila.getX1() * wi[0]) + (valoresFila.getX2() * wi[1])- umbral; //Función propagación
        y1 = Math.tanh(getWx()); //Salida
       
        if (y1>=0) {
            activacion = 1;
        }
        if (y1 < 0) {
            activacion = 0;
        }
        
        System.out.println("");
        System.out.println((valoresFila.getX1() +" * "+ wi[0]));
        System.out.println((valoresFila.getX2() +" *  "+ wi[1]));
        System.out.println("Sumatoria: " + wx);
        System.out.println("Tanjente hiperbólica de la sumatoria: " + y1);
        
        return activacion;
    }
    
    /**
     * @return the wi
     */
    public double[] getWi() {
        return wi;
    }

    /**
     * @param wi the wi to set
     */
    public void setWi(double[] wi) {
        this.wi = wi;
    }

    /**
     * @return the wx
     */
    public double getWx() {
        return wx;
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
}
