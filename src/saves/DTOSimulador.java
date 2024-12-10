package saves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import estadisticas.Estadisticas;
import piscifactoria.Piscifactoria;
import propiedades.AlmacenPropiedades;
import simulador.Simulador;

/**
 * Clase que guarda la información del simulador
 * @author Breogan
 */
public class DTOSimulador {
    /** Lista de peces implementados */
    List<String> implementados = List.of("Dorada", "Trucha arcoíris", "Abadejo", "Besugo", "Caballa", "Rodaballo",
                                        "Sargo", "Carpa", "Carpa plateada", "Lucio del norte", "Pejerrey", "Tilapia del nilo");

    /** Lista de nombres pero en array, necesario para trabajar con la librería */
    private transient String[] nombres = implementados.toArray(new String[0]);
    
    /** Instancia de estadísticas */
    private transient estadisticas.Estadisticas stats=new Estadisticas(new String[]{
        AlmacenPropiedades.LUCIO_NORTE.getNombre(),
        AlmacenPropiedades.CARPA_PLATEADA.getNombre(),
        AlmacenPropiedades.CARPA.getNombre(),
        AlmacenPropiedades.TILAPIA_NILO.getNombre(),
        AlmacenPropiedades.PEJERREY.getNombre(),
        AlmacenPropiedades.RODABALLO.getNombre(),
        AlmacenPropiedades.CABALLA.getNombre(),
        AlmacenPropiedades.BESUGO.getNombre(),
        AlmacenPropiedades.ABADEJO.getNombre(),
        AlmacenPropiedades.SARGO.getNombre(),
        AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre(),
        AlmacenPropiedades.DORADA.getNombre()
    });  

    /** Nombre de empresa */
    private String empresa;

    /** Dia del simulador */
    private int dia;

    /** Monedas disponibles */
    private int monedas;

    /** Estadísticas de venta, nacimientos y demás */
    private String orca;

    /** Edificios disponibles */
    private Map<String, Object> edificios;

    /** Piscifactorías de la partida */
    private List<DTOPiscifactoria> piscifactorias;
    
    /**
     * Constructor
     * @param sim Simulador de donde se sacan los datos
     */
    public DTOSimulador(Simulador sim){
        this.empresa = sim.getNombreEmpresa();
        this.dia = sim.getDias();
        this.monedas = sim.getMonedero().getMonedas();
        this.orca = stats.exportarDatos(nombres);
        this.edificios = new HashMap<String,Object>();
        this.edificios.put("Almacen", new DTOAlmacen(sim.getAlmacenCentral()));
        
        this.piscifactorias = new ArrayList<DTOPiscifactoria>();
        for (Piscifactoria pisc : sim.getPiscifactorias()) {
            piscifactorias.add(new DTOPiscifactoria(pisc));
        }
    }

    /**
     * Getter de día
     * @return El día
     */
    public int getDia() {
        return dia;
    }

    /**
     * Getter de edificios
     * @return Edificios en formato clave-valor
     */
    public Map<String, Object> getEdificios() {
       return edificios;
    }

    /**
     * Getter de monedas
     * @return Las monedas
     */
    public int getMonedas() {
        return monedas;
    }

    /**
     * Getter del nombre de empresa
     * @return El nombre de la empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Getter de las piscifactorías
     * @return
     */
    public List<DTOPiscifactoria> getPiscifactorias() {
        return piscifactorias;
    }

    /**
     * Getter de las stats de peces
     * @return Estadisticas de ventas y demás
     */
    public String getOrca() {
        return orca;
    }

    /**
     * Getter de los peces implementados
     * @return Lista de nombres de peces implementados
     */
    public List<String> getImplementados() {
        return implementados;
    }
}
