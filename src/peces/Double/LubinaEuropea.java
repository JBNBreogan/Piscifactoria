package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LubinaEuropea extends Pez{

    public LubinaEuropea(char Sexo){
        this.Nombre = AlmacenPropiedades.LUBINA_EUROPEA.getNombre();
        this.Cientifico = AlmacenPropiedades.LUBINA_EUROPEA.getCientifico();
        this.Ciclo = AlmacenPropiedades.LUBINA_EUROPEA.getCiclo();
        this.Coste = AlmacenPropiedades.LUBINA_EUROPEA.getCoste();
        this.Huevos = AlmacenPropiedades.LUBINA_EUROPEA.getHuevos();
        this.Madurez = AlmacenPropiedades.LUBINA_EUROPEA.getMadurez();
        this.Monedas = AlmacenPropiedades.LUBINA_EUROPEA.getMonedas();
        this.Optimo = AlmacenPropiedades.LUBINA_EUROPEA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.LUBINA_EUROPEA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.LUBINA_EUROPEA.getPropiedades();
        this.Tipo = AlmacenPropiedades.LUBINA_EUROPEA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
