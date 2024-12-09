package saves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piscifactoria.Piscifactoria;
import simulador.Simulador;

public class DTOSimulador {
    List<String> implementados = List.of("Dorada", "Trucha arcoíris", "Abadejo", "Besugo", "Caballa", "Rodaballo",
                                        "Sargo", "Carpa", "Carpa plateada", "Lucio del norte", "Pejerrey", "Tilapia del nilo");
    private String empresa;
    private int dia;
    private int monedas;
    private Map<String, Object> edificios;
    private List<DTOPiscifactoria> piscifactorias;
    
    
    public DTOSimulador(Simulador sim){
        this.empresa = sim.getNombreEmpresa();
        this.dia = sim.getDias();
        this.monedas = sim.getMonedero().getMonedas();
        this.edificios = new HashMap<String,Object>();
        this.edificios.put("Almacen", new DTOAlmacen(sim.getAlmacenCentral()));
        
        this.piscifactorias = new ArrayList<DTOPiscifactoria>();
        for (Piscifactoria pisc : sim.getPiscifactorias()) {
            piscifactorias.add(new DTOPiscifactoria(pisc));
        }
    }

    public int getDia() {
        return dia;
    }

    public Map<String, Object> getEdificios() {
       return edificios;
    }

    public int getMonedas() {
        return monedas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public List<DTOPiscifactoria> getPiscifactorias() {
        return piscifactorias;
    }
}
