package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SalmonAtlantico extends Pez{

    public SalmonAtlantico(char Sexo){
        this.Nombre = AlmacenPropiedades.SALMON_ATLANTICO.getNombre();
        this.Cientifico = AlmacenPropiedades.SALMON_ATLANTICO.getCientifico();
        this.Ciclo = AlmacenPropiedades.SALMON_ATLANTICO.getCiclo();
        this.Coste = AlmacenPropiedades.SALMON_ATLANTICO.getCoste();
        this.Huevos = AlmacenPropiedades.SALMON_ATLANTICO.getHuevos();
        this.Madurez = AlmacenPropiedades.SALMON_ATLANTICO.getMadurez();
        this.Monedas = AlmacenPropiedades.SALMON_ATLANTICO.getMonedas();
        this.Optimo = AlmacenPropiedades.SALMON_ATLANTICO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.SALMON_ATLANTICO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.SALMON_ATLANTICO.getPropiedades();
        this.Tipo = AlmacenPropiedades.SALMON_ATLANTICO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
