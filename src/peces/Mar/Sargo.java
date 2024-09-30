package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Sargo extends Pez{

    public Sargo(char Sexo){
        this.Nombre = AlmacenPropiedades.SARGO.getNombre();
        this.Cientifico = AlmacenPropiedades.SARGO.getCientifico();
        this.Ciclo = AlmacenPropiedades.SARGO.getCiclo();
        this.Coste = AlmacenPropiedades.SARGO.getCoste();
        this.Huevos = AlmacenPropiedades.SARGO.getHuevos();
        this.Madurez = AlmacenPropiedades.SARGO.getMadurez();
        this.Monedas = AlmacenPropiedades.SARGO.getMonedas();
        this.Optimo = AlmacenPropiedades.SARGO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.SARGO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.SARGO.getPropiedades();
        this.Tipo = AlmacenPropiedades.SARGO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
