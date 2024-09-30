package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class TilapiaDelNilo extends Pez{

    public TilapiaDelNilo(char Sexo){
        this.Nombre = AlmacenPropiedades.TILAPIA_NILO.getNombre();
        this.Cientifico = AlmacenPropiedades.TILAPIA_NILO.getCientifico();
        this.Ciclo = AlmacenPropiedades.TILAPIA_NILO.getCiclo();
        this.Coste = AlmacenPropiedades.TILAPIA_NILO.getCoste();
        this.Huevos = AlmacenPropiedades.TILAPIA_NILO.getHuevos();
        this.Madurez = AlmacenPropiedades.TILAPIA_NILO.getMadurez();
        this.Monedas = AlmacenPropiedades.TILAPIA_NILO.getMonedas();
        this.Optimo = AlmacenPropiedades.TILAPIA_NILO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.TILAPIA_NILO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.TILAPIA_NILO.getPropiedades();
        this.Tipo = AlmacenPropiedades.TILAPIA_NILO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
