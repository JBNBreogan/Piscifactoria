package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Pejerrey extends Pez{

    public Pejerrey(char Sexo){
        this.Nombre = AlmacenPropiedades.PEJERREY.getNombre();
        this.Cientifico = AlmacenPropiedades.PEJERREY.getCientifico();
        this.Ciclo = AlmacenPropiedades.PEJERREY.getCiclo();
        this.Coste = AlmacenPropiedades.PEJERREY.getCoste();
        this.Huevos = AlmacenPropiedades.PEJERREY.getHuevos();
        this.Madurez = AlmacenPropiedades.PEJERREY.getMadurez();
        this.Monedas = AlmacenPropiedades.PEJERREY.getMonedas();
        this.Optimo = AlmacenPropiedades.PEJERREY.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.PEJERREY.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.PEJERREY.getPropiedades();
        this.Tipo = AlmacenPropiedades.PEJERREY.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
