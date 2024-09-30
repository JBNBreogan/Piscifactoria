package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Abadejo extends Pez{
    
    public Abadejo(char Sexo){
        this.Nombre = AlmacenPropiedades.ABADEJO.getNombre();
        this.Cientifico = AlmacenPropiedades.ABADEJO.getCientifico();
        this.Ciclo = AlmacenPropiedades.ABADEJO.getCiclo();
        this.Coste = AlmacenPropiedades.ABADEJO.getCoste();
        this.Huevos = AlmacenPropiedades.ABADEJO.getHuevos();
        this.Madurez = AlmacenPropiedades.ABADEJO.getMadurez();
        this.Monedas = AlmacenPropiedades.ABADEJO.getMonedas();
        this.Optimo = AlmacenPropiedades.ABADEJO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.ABADEJO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.ABADEJO.getPropiedades();
        this.Tipo = AlmacenPropiedades.ABADEJO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
