package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.derivacionfinita;
import modelo.derivada;
import modelo.funcion;
import vista.formularioPrincipal;

/**
 *
 * @author is-da
 */
public class controlador implements ActionListener {

    derivada Derivada = new derivada();
    funcion Funcion = new funcion();
    derivacionfinita metodo = new derivacionfinita();
    formularioPrincipal vista = new formularioPrincipal();

    public controlador() {
        vista.getBtn_derivar().addActionListener(this);
    }

    public void iniciarPrograma() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtn_derivar()) {
            calcularDerivada();
            metodo.setValorVerdadero(Double.parseDouble(vista.getTxt_verdadero().getText()));
            metodo.setFuncion(vista.getTxt_funcion().getText());
            String funcion = metodo.getFuncion();
            //Capturar x//
            metodo.setxActual(Double.parseDouble(vista.getTxt_x().getText()));
            metodo.setH(Double.parseDouble(vista.getTxt_h().getText()));
            metodo.Hallarx(metodo.getxActual(), metodo.getH());
            vista.getTxt_x0().setText(" " + metodo.getxAnterior());
            vista.getTxt_x1().setText("" + metodo.getxActual());
            vista.getTxt_x3().setText("" + metodo.getxAdelante());

            //Calcular imagenes//
            double xanterior = metodo.getxAnterior();
            double xactual = metodo.getxActual();
            double xadelante = metodo.getxAdelante();

            metodo.setFxAnterior(calcularImagenes(xanterior));
            metodo.setFxActual(calcularImagenes(xactual));
            metodo.setFxAdelante(calcularImagenes(xadelante));
            vista.getTxt_fx0().setText(""+metodo.getFxAnterior());
            vista.getTxt_fx1().setText(""+metodo.getFxActual());
            vista.getTxt_fx2().setText(""+metodo.getFxAdelante());
            
            
            //Metodo para hallar Hacia atras//
            double xactual0 = metodo.getFxActual();
            double xanterior0 = metodo.getFxAnterior();
            double xadelante0 = metodo.getFxAdelante();
            double h = metodo.getH();
            double vv = metodo.getValorVerdadero();
            metodo.haciaAtras(xactual0, xanterior0,h);
            vista.getTxt_atras().setText(""+metodo.getResultadoX());
            double vaproximado = metodo.getResultadoX();
            metodo.error(vv, vaproximado);
            vista.getTxt_erroratras().setText(""+metodo.getError());
            System.out.println("V. verdadero"+metodo.getValorVerdadero());
            
            //Metodo hacia adelante//
            metodo.haciaAdelante(xactual0, xadelante0, h);
            double vaproximado1 = metodo.getResultadoX();
            metodo.error(vv, vaproximado1);
            vista.getTxt_adelante().setText(""+metodo.getResultadoX());
            vista.getTxt_erroradelante().setText(""+metodo.getError());
            
            //Metodo hacia el centro//
            metodo.haciaCentro(xadelante0, xanterior0, h);
            double vaproximado2 = metodo.getResultadoX();
            metodo.error(vv, vaproximado2);
            vista.getTxt_centrales().setText(""+metodo.getResultadoX());
            vista.getTxt_errorcentrales().setText(""+metodo.getError());
        }
    }

    public void calcularDerivada() {
        //Calcula la derivada//
        Derivada.setFuncion(vista.getTxt_funcion().getText());
        Derivada.derivar();
        metodo.setxActual(Double.parseDouble(vista.getTxt_x().getText()));
        String expresionDerivada = Derivada.getfDerivada();
        double xAuxiliar = metodo.getxActual();
        vista.getTxt_fDerivada().setText("" + Derivada.getfDerivada());
        //Evaluar en la funcion//
        Funcion.setFuncion(expresionDerivada);
        Funcion.setValorX(xAuxiliar);
        Funcion.evaluar(xAuxiliar);
        vista.getTxt_verdadero().setText("" + Funcion.getResultado());
        metodo.setDerivada(vista.getTxt_fDerivada().getText());
       
        
    }

    public double calcularImagenes(double x) {
        double imagen;
        Funcion.setFuncion(metodo.getFuncion());
        Funcion.setValorX(x);
        Funcion.evaluar(x);
        imagen = Funcion.getResultado();
        return imagen;
    }

}
