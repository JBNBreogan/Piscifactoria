package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LenguadoEuropeo extends Pez{

    public LenguadoEuropeo(char Sexo){
        this.Nombre = AlmacenPropiedades.LENGUADO_EUROPEO.getNombre();
        this.Cientifico = AlmacenPropiedades.LENGUADO_EUROPEO.getCientifico();
        this.Ciclo = AlmacenPropiedades.LENGUADO_EUROPEO.getCiclo();
        this.Coste = AlmacenPropiedades.LENGUADO_EUROPEO.getCoste();
        this.Huevos = AlmacenPropiedades.LENGUADO_EUROPEO.getHuevos();
        this.Madurez = AlmacenPropiedades.LENGUADO_EUROPEO.getMadurez();
        this.Monedas = AlmacenPropiedades.LENGUADO_EUROPEO.getMonedas();
        this.Optimo = AlmacenPropiedades.LENGUADO_EUROPEO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.LENGUADO_EUROPEO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.LENGUADO_EUROPEO.getPropiedades();
        this.Tipo = AlmacenPropiedades.LENGUADO_EUROPEO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
