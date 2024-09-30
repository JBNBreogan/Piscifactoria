package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class ArenqueDelAtlantico extends Pez{

    public ArenqueDelAtlantico(char Sexo){
        this.Nombre = AlmacenPropiedades.ARENQUE_ATLANTICO.getNombre();
        this.Cientifico = AlmacenPropiedades.ARENQUE_ATLANTICO.getCientifico();
        this.Ciclo = AlmacenPropiedades.ARENQUE_ATLANTICO.getCiclo();
        this.Coste = AlmacenPropiedades.ARENQUE_ATLANTICO.getCoste();
        this.Huevos = AlmacenPropiedades.ARENQUE_ATLANTICO.getHuevos();
        this.Madurez = AlmacenPropiedades.ARENQUE_ATLANTICO.getMadurez();
        this.Monedas = AlmacenPropiedades.ARENQUE_ATLANTICO.getMonedas();
        this.Optimo = AlmacenPropiedades.ARENQUE_ATLANTICO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.ARENQUE_ATLANTICO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.ARENQUE_ATLANTICO.getPropiedades();
        this.Tipo = AlmacenPropiedades.ARENQUE_ATLANTICO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
