package neuronaand;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author dizan
 */
public class ControlViewNeuronaAND {
    
    ViewNeuronaAND viewNeuronaAnd;
    Neurona neurona1 = new Neurona();
    
    //Tabla
    valoresTabla TablaFila1 = new valoresTabla(1,1,1);
    valoresTabla TablaFila2 = new valoresTabla(1,0,0);
    valoresTabla TablaFila3 = new valoresTabla(0,1,0);
    valoresTabla TablaFila4 = new valoresTabla(0,0,0);
    
    ArrayList <valoresTabla> TablaVerdad = new ArrayList();
    
    //Perceptron
    Perceptron perceptron1 = new Perceptron();

    ControlViewNeuronaAND(ViewNeuronaAND viewNeuronaAnd) {
       this.viewNeuronaAnd = viewNeuronaAnd;
       
       this.viewNeuronaAnd.BotonIniciar.addActionListener(this::BotonIniciar);
       this.viewNeuronaAnd.BotonEntrenar_1.addActionListener(this::botonEntrenar_1);
       this.viewNeuronaAnd.BotonEntrenar_2.addActionListener(this::botonEntrenar_2);
       this.viewNeuronaAnd.BotonEntrenar_3.addActionListener(this::botonEntrenar_3);
       this.viewNeuronaAnd.BotonEntrenar_4.addActionListener(this::botonEntrenar_4);
       this.viewNeuronaAnd.BotonPrueba1.addActionListener(this::BotonPrueba1);
       this.viewNeuronaAnd.BotonPrueba2.addActionListener(this::BotonPrueba2);
       this.viewNeuronaAnd.BotonPrueba3.addActionListener(this::BotonPrueba3);
       this.viewNeuronaAnd.BotonPrueba4.addActionListener(this::BotonPrueba4);
       
       TablaVerdad.add(TablaFila1);
       TablaVerdad.add(TablaFila2);
       TablaVerdad.add(TablaFila3);
       TablaVerdad.add(TablaFila4);
       
    }
    
    public void obtenerDatos(){
       
    }
    
    private void BotonIniciar(ActionEvent e) {
        viewNeuronaAnd.BotonEntrenar_1.setEnabled(true);
        viewNeuronaAnd.BotonEntrenar_2.setEnabled(true);
        viewNeuronaAnd.BotonEntrenar_3.setEnabled(true);
        viewNeuronaAnd.BotonEntrenar_4.setEnabled(true);

        viewNeuronaAnd.TextUmbral.setText("0.24");
        perceptron1.setUmbral(0.24);
        viewNeuronaAnd.TextCoeficienteApre.setText("0.25");
        perceptron1.setCoeficienteAprendizaje(0.25);
       
        //Pesos iniciales aleatorios
         double [] Wi = new double[2];
//        for (int i = 0; i < Wi.length; i++) {
//            Wi[i] = fijarNumero(Math.random(), 2);
//        }

         Wi[0] = 0.50;
         Wi[1] = 0.20;
        //Enviar pesos a la interfaz        
        viewNeuronaAnd.TextValorW1.setText(""+Wi[0]);
        viewNeuronaAnd.TextValorW2.setText(""+Wi[1]);
        
        //Asignar pesos iniciales a neurona
        neurona1.setWi(Wi);
        neurona1.setUmbral(0.24);
    }

    private void botonEntrenar_1(ActionEvent e) {
        viewNeuronaAnd.TextValorX1.setText(""+TablaFila1.getX1());
        viewNeuronaAnd.TextValorX2.setText(""+TablaFila1.getX2());
       
        perceptron1.entrenar(TablaFila1,neurona1);
        viewNeuronaAnd.TextSumatoria.setText(""+neurona1.getWx());
        viewNeuronaAnd.TextSalidaActivada.setText(""+perceptron1.getSalidaRed());
        
        if (perceptron1.getErrorCometido() != 0) {
            viewNeuronaAnd.LabelEstadoFinal.setText("Error");
            neurona1.setWi(perceptron1.getWi());
            neurona1.setUmbral(perceptron1.getUmbral());
        }else{
            viewNeuronaAnd.LabelEstadoFinal.setText("Salida correcta");
        }
        
    }

    private void botonEntrenar_2(ActionEvent e) {
        
        viewNeuronaAnd.TextValorX1.setText(""+TablaFila2.getX1());
        viewNeuronaAnd.TextValorX2.setText(""+TablaFila2.getX2());
       
        perceptron1.entrenar(TablaFila2,neurona1);
        
        viewNeuronaAnd.TextSumatoria.setText(""+neurona1.getWx());
        viewNeuronaAnd.TextSalidaActivada.setText(""+perceptron1.getSalidaRed());
        
        if (perceptron1.getErrorCometido() != 0) {
            viewNeuronaAnd.LabelEstadoFinal.setText("Error");
            neurona1.setWi(perceptron1.getWi());
            neurona1.setUmbral(perceptron1.getUmbral());
        }else{
            viewNeuronaAnd.LabelEstadoFinal.setText("Salida correcta");
        }
      
    }

    private void botonEntrenar_3(ActionEvent e) {
        
        viewNeuronaAnd.TextValorX1.setText(""+TablaFila3.getX1());
        viewNeuronaAnd.TextValorX2.setText(""+TablaFila3.getX2());
       
        perceptron1.entrenar(TablaFila3,neurona1);
        
        viewNeuronaAnd.TextSumatoria.setText(""+neurona1.getWx());
        viewNeuronaAnd.TextSalidaActivada.setText(""+perceptron1.getSalidaRed());
        
        if (perceptron1.getErrorCometido() != 0) {
            viewNeuronaAnd.LabelEstadoFinal.setText("Error");
            neurona1.setWi(perceptron1.getWi());
            neurona1.setUmbral(perceptron1.getUmbral());
        }else{
            viewNeuronaAnd.LabelEstadoFinal.setText("Salida correcta");
        }
       
    }

    private void botonEntrenar_4(ActionEvent e) {
        
        viewNeuronaAnd.TextValorX1.setText(""+TablaFila4.getX1());
        viewNeuronaAnd.TextValorX2.setText(""+TablaFila4.getX2());
       
        perceptron1.entrenar(TablaFila4,neurona1);
        
        viewNeuronaAnd.TextSumatoria.setText(""+neurona1.getWx());
        viewNeuronaAnd.TextSalidaActivada.setText(""+perceptron1.getSalidaRed());
        
        if (perceptron1.getErrorCometido() != 0) {
            viewNeuronaAnd.LabelEstadoFinal.setText("Error");
            neurona1.setWi(perceptron1.getWi());
            neurona1.setUmbral(perceptron1.getUmbral());
        }else{
            viewNeuronaAnd.LabelEstadoFinal.setText("Salida correcta");
        }
       
    }

    private void BotonPrueba1(ActionEvent e) {
       
    }

    private void BotonPrueba2(ActionEvent e) {
       
    }

    private void BotonPrueba3(ActionEvent e) {
       
    }

    private void BotonPrueba4(ActionEvent e) {
       
    }

    
    public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }
    
}
