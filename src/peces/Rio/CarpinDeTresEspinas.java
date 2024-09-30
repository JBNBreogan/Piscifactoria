package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class CarpinDeTresEspinas extends Pez{

    public CarpinDeTresEspinas(char Sexo){
        this.Nombre = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getNombre();
        this.Cientifico = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getCientifico();
        this.Ciclo = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getCiclo();
        this.Coste = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getCoste();
        this.Huevos = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getHuevos();
        this.Madurez = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getMadurez();
        this.Monedas = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getMonedas();
        this.Optimo = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getPropiedades();
        this.Tipo = AlmacenPropiedades.CARPIN_TRES_ESPINAS.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
