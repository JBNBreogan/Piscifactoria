package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LucioDelNorte extends Pez{

    public LucioDelNorte(char Sexo){
        this.Nombre = AlmacenPropiedades.LUCIO_NORTE.getNombre();
        this.Cientifico = AlmacenPropiedades.LUCIO_NORTE.getCientifico();
        this.Ciclo = AlmacenPropiedades.LUCIO_NORTE.getCiclo();
        this.Coste = AlmacenPropiedades.LUCIO_NORTE.getCoste();
        this.Huevos = AlmacenPropiedades.LUCIO_NORTE.getHuevos();
        this.Madurez = AlmacenPropiedades.LUCIO_NORTE.getMadurez();
        this.Monedas = AlmacenPropiedades.LUCIO_NORTE.getMonedas();
        this.Optimo = AlmacenPropiedades.LUCIO_NORTE.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.LUCIO_NORTE.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.LUCIO_NORTE.getPropiedades();
        this.Tipo = AlmacenPropiedades.LUCIO_NORTE.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
