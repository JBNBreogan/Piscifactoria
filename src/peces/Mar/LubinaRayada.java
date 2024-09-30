package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LubinaRayada extends Pez{

    public LubinaRayada(char Sexo){
        this.Nombre = AlmacenPropiedades.LUBINA_RAYADA.getNombre();
        this.Cientifico = AlmacenPropiedades.LUBINA_RAYADA.getCientifico();
        this.Ciclo = AlmacenPropiedades.LUBINA_RAYADA.getCiclo();
        this.Coste = AlmacenPropiedades.LUBINA_RAYADA.getCoste();
        this.Huevos = AlmacenPropiedades.LUBINA_RAYADA.getHuevos();
        this.Madurez = AlmacenPropiedades.LUBINA_RAYADA.getMadurez();
        this.Monedas = AlmacenPropiedades.LUBINA_RAYADA.getMonedas();
        this.Optimo = AlmacenPropiedades.LUBINA_RAYADA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.LUBINA_RAYADA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.LUBINA_RAYADA.getPropiedades();
        this.Tipo = AlmacenPropiedades.LUBINA_RAYADA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
