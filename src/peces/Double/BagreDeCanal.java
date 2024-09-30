package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class BagreDeCanal extends Pez{
    
    public BagreDeCanal(char Sexo){
        this.Nombre = AlmacenPropiedades.BAGRE_CANAL.getNombre();
        this.Cientifico = AlmacenPropiedades.BAGRE_CANAL.getCientifico();
        this.Ciclo = AlmacenPropiedades.BAGRE_CANAL.getCiclo();
        this.Coste = AlmacenPropiedades.BAGRE_CANAL.getCoste();
        this.Huevos = AlmacenPropiedades.BAGRE_CANAL.getHuevos();
        this.Madurez = AlmacenPropiedades.BAGRE_CANAL.getMadurez();
        this.Monedas = AlmacenPropiedades.BAGRE_CANAL.getMonedas();
        this.Optimo = AlmacenPropiedades.BAGRE_CANAL.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.BAGRE_CANAL.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.BAGRE_CANAL.getPropiedades();
        this.Tipo = AlmacenPropiedades.BAGRE_CANAL.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }

    //TODO todo el pez
}
