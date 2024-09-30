package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Dorada extends Pez{

    public Dorada(char Sexo){
        this.Nombre = AlmacenPropiedades.DORADA.getNombre();
        this.Cientifico = AlmacenPropiedades.DORADA.getCientifico();
        this.Ciclo = AlmacenPropiedades.DORADA.getCiclo();
        this.Coste = AlmacenPropiedades.DORADA.getCoste();
        this.Huevos = AlmacenPropiedades.DORADA.getHuevos();
        this.Madurez = AlmacenPropiedades.DORADA.getMadurez();
        this.Monedas = AlmacenPropiedades.DORADA.getMonedas();
        this.Optimo = AlmacenPropiedades.DORADA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.DORADA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.DORADA.getPropiedades();
        this.Tipo = AlmacenPropiedades.DORADA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
