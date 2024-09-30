package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class TruchaArcoiris extends Pez{

    public TruchaArcoiris(char Sexo){
        this.Nombre = AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre();
        this.Cientifico = AlmacenPropiedades.TRUCHA_ARCOIRIS.getCientifico();
        this.Ciclo = AlmacenPropiedades.TRUCHA_ARCOIRIS.getCiclo();
        this.Coste = AlmacenPropiedades.TRUCHA_ARCOIRIS.getCoste();
        this.Huevos = AlmacenPropiedades.TRUCHA_ARCOIRIS.getHuevos();
        this.Madurez = AlmacenPropiedades.TRUCHA_ARCOIRIS.getMadurez();
        this.Monedas = AlmacenPropiedades.TRUCHA_ARCOIRIS.getMonedas();
        this.Optimo = AlmacenPropiedades.TRUCHA_ARCOIRIS.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.TRUCHA_ARCOIRIS.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.TRUCHA_ARCOIRIS.getPropiedades();
        this.Tipo = AlmacenPropiedades.TRUCHA_ARCOIRIS.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
