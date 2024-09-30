package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Corvina extends Pez{

    public Corvina(char Sexo){
        this.Nombre = AlmacenPropiedades.CORVINA.getNombre();
        this.Cientifico = AlmacenPropiedades.CORVINA.getCientifico();
        this.Ciclo = AlmacenPropiedades.CORVINA.getCiclo();
        this.Coste = AlmacenPropiedades.CORVINA.getCoste();
        this.Huevos = AlmacenPropiedades.CORVINA.getHuevos();
        this.Madurez = AlmacenPropiedades.CORVINA.getMadurez();
        this.Monedas = AlmacenPropiedades.CORVINA.getMonedas();
        this.Optimo = AlmacenPropiedades.CORVINA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.CORVINA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.CORVINA.getPropiedades();
        this.Tipo = AlmacenPropiedades.CORVINA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
