/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author is-da
 */
public class derivacionfinita {
    private String funcion = "";
    private String derivada = "";
    private double xActual = 0;
    private double xAnterior= 0;
    private double xAdelante= 0;
    private double h= 0;
    private double valorVerdadero= 0;
    private double fxActual= 0;
    private double fxAnterior= 0;
    private double fxAdelante= 0;
    private double haciaAtras= 0;
    private double haciaAdelante= 0;
    private double haciaCentrales= 0;
    private double errorAtras = 0;
    private double errorAdelante = 0;
    private double errorCentral = 0;
    private double resultadoX = 0;
    private double error = 0;

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getResultadoX() {
        return resultadoX;
    }

    public void setResultadoX(double resultadoX) {
        this.resultadoX = resultadoX;
    }

    public derivacionfinita() {
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getDerivada() {
        return derivada;
    }

    public void setDerivada(String derivada) {
        this.derivada = derivada;
    }

    public double getxActual() {
        return xActual;
    }

    public void setxActual(double xActual) {
        this.xActual = xActual;
    }

    public double getxAnterior() {
        return xAnterior;
    }

    public void setxAnterior(double xAnterior) {
        this.xAnterior = xAnterior;
    }

    public double getxAdelante() {
        return xAdelante;
    }

    public void setxAdelante(double xAdelante) {
        this.xAdelante = xAdelante;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getValorVerdadero() {
        return valorVerdadero;
    }

    public void setValorVerdadero(double valorVerdadero) {
        this.valorVerdadero = valorVerdadero;
    }

    public double getFxActual() {
        return fxActual;
    }

    public void setFxActual(double fxActual) {
        this.fxActual = fxActual;
    }

    public double getFxAnterior() {
        return fxAnterior;
    }

    public void setFxAnterior(double fxAnterior) {
        this.fxAnterior = fxAnterior;
    }

    public double getFxAdelante() {
        return fxAdelante;
    }

    public void setFxAdelante(double fxAdelante) {
        this.fxAdelante = fxAdelante;
    }

    public double getHaciaAtras() {
        return haciaAtras;
    }

    public void setHaciaAtras(double haciaAtras) {
        this.haciaAtras = haciaAtras;
    }

    public double getHaciaAdelante() {
        return haciaAdelante;
    }

    public void setHaciaAdelante(double haciaAdelante) {
        this.haciaAdelante = haciaAdelante;
    }

    public double getHaciaCentrales() {
        return haciaCentrales;
    }

    public void setHaciaCentrales(double haciaCentrales) {
        this.haciaCentrales = haciaCentrales;
    }

    public double getErrorAtras() {
        return errorAtras;
    }

    public void setErrorAtras(double errorAtras) {
        this.errorAtras = errorAtras;
    }

    public double getErrorAdelante() {
        return errorAdelante;
    }

    public void setErrorAdelante(double errorAdelante) {
        this.errorAdelante = errorAdelante;
    }

    public double getErrorCentral() {
        return errorCentral;
    }

    public void setErrorCentral(double errorCentral) {
        this.errorCentral = errorCentral;
    }
    
    public void Hallarx(double x, double h){
        this.xActual = x;
        this.xAdelante = x+h;
        this.xAnterior = x-h;     
    }
    
    public void haciaAtras(double xactual, double xanterior, double h){
        this.resultadoX = (xactual-xanterior)/h;
    }
    
    public void haciaAdelante(double xactual, double xadelante, double h){
        this.resultadoX = (xadelante-xactual)/h;
    }
    
    public void haciaCentro(double xadelante, double xanterior, double h){
        this.resultadoX = (xadelante-xanterior)/(2*h);
    }
    
    public void error(double vverdadero, double vaproximado){
        this.error = Math.abs((vverdadero-vaproximado)/vverdadero)*100;
    }
    
}
