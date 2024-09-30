package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SiluroEuropeo extends Pez{

    public SiluroEuropeo(char Sexo){
        this.Nombre = AlmacenPropiedades.SILURO_EUROPEO.getNombre();
        this.Cientifico = AlmacenPropiedades.SILURO_EUROPEO.getCientifico();
        this.Ciclo = AlmacenPropiedades.SILURO_EUROPEO.getCiclo();
        this.Coste = AlmacenPropiedades.SILURO_EUROPEO.getCoste();
        this.Huevos = AlmacenPropiedades.SILURO_EUROPEO.getHuevos();
        this.Madurez = AlmacenPropiedades.SILURO_EUROPEO.getMadurez();
        this.Monedas = AlmacenPropiedades.SILURO_EUROPEO.getMonedas();
        this.Optimo = AlmacenPropiedades.SILURO_EUROPEO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.SILURO_EUROPEO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.SILURO_EUROPEO.getPropiedades();
        this.Tipo = AlmacenPropiedades.SILURO_EUROPEO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
