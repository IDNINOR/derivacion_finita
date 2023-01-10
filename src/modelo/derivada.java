/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class derivada {
    
    private String funcion = "";
    private String fDerivada = "";

    //Llamamos clases de la librerias//
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;

    public derivada() {
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public String getfDerivada() {
        return fDerivada;
    }

    public void setfDerivada(String fDerivada) {
        this.fDerivada = fDerivada;
    }

    public void derivar() {

        try {
            this.djep = new DJep();
            //Agregar funciones estandarares//
            this.djep.addStandardFunctions();
            //Agregar constante en la funciones//
            this.djep.addStandardConstants();
            //Agregar funciones complejas//
            this.djep.addComplex();
            //Agregar una función de no declarar varibles//
            this.djep.setAllowUndeclared(true);
            //Permite asignaciones en la funciones//
            this.djep.setAllowAssignment(true);
            //Permite hace operaciones//
            this.djep.setImplicitMul(true);
            //Añadir diferenciales//
            this.djep.addStandardDiffRules();
            //Recibe la función con nodoFuncion//
            this.nodoFuncion = this.djep.parse(this.funcion);
            //Se crea un Node para operar la derivada respecto a una variable especifica//
            Node diff = this.djep.differentiate(nodoFuncion, "x");
            //Aca hace la derivada//
            this.nodoDerivada = this.djep.simplify(diff);
            //la derivada hecha la retorna en un String//
            this.fDerivada = this.djep.toString(this.nodoDerivada);

        } catch (ParseException e) {
            System.out.println("Error : " + e);

        }
    }

    @Override
    public String toString() {
        return "derivada{" + "funcion=" + funcion + '}';
    }

    
}
