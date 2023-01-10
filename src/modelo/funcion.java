/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//-0.1*x^4-0.15*x^3-0.5*x^2-0.25*x+1.2
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.nfunk.jep.JEP;

/**
 *
 * @author is-da
 */
public class funcion {
    private String funcion = "";
    private double resultado = 0.0;
    private double valorX = 0.0;  
    private String error ="";
    
    JEP jep;

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public void evaluar(double x){
        this.valorX = x;
        jep = new JEP();
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funcion);
        this.resultado = this.jep.getValue();
        this.error = (this.jep.hasError())? "Error":"No hay Error";
    }
}
