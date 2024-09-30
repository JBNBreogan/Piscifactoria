package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class CarpaPlateada extends Pez{

    public CarpaPlateada(char Sexo){
        this.Nombre = AlmacenPropiedades.CARPA_PLATEADA.getNombre();
        this.Cientifico = AlmacenPropiedades.CARPA_PLATEADA.getCientifico();
        this.Ciclo = AlmacenPropiedades.CARPA_PLATEADA.getCiclo();
        this.Coste = AlmacenPropiedades.CARPA_PLATEADA.getCoste();
        this.Huevos = AlmacenPropiedades.CARPA_PLATEADA.getHuevos();
        this.Madurez = AlmacenPropiedades.CARPA_PLATEADA.getMadurez();
        this.Monedas = AlmacenPropiedades.CARPA_PLATEADA.getMonedas();
        this.Optimo = AlmacenPropiedades.CARPA_PLATEADA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.CARPA_PLATEADA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.CARPA_PLATEADA.getPropiedades();
        this.Tipo = AlmacenPropiedades.CARPA_PLATEADA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
