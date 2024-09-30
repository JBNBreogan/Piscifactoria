package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Cobia extends Pez{

    public Cobia(char Sexo){
        this.Nombre = AlmacenPropiedades.COBIA.getNombre();
        this.Cientifico = AlmacenPropiedades.COBIA.getCientifico();
        this.Ciclo = AlmacenPropiedades.COBIA.getCiclo();
        this.Coste = AlmacenPropiedades.COBIA.getCoste();
        this.Huevos = AlmacenPropiedades.COBIA.getHuevos();
        this.Madurez = AlmacenPropiedades.COBIA.getMadurez();
        this.Monedas = AlmacenPropiedades.COBIA.getMonedas();
        this.Optimo = AlmacenPropiedades.COBIA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.COBIA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.COBIA.getPropiedades();
        this.Tipo = AlmacenPropiedades.COBIA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
