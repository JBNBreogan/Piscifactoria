package dtos;

public class DTOPedido {
    private int referencia;

    private String nombreCliente;

    private int cantidadPedida;
    
    private int cantidadEnviada;

    private String nombrePez;

    public DTOPedido(int referencia, String nombreCliente, int cantidadPedida, int cantidadEnviada, String nombrePez){
        this.referencia = referencia;
        this.nombreCliente = nombreCliente;
        this.cantidadPedida = cantidadPedida;
        this.cantidadEnviada = cantidadEnviada;
        this.nombrePez = nombrePez;
    }

    public int getCantidadEnviada() {
        return cantidadEnviada;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombrePez() {
        return nombrePez;
    }

    public int getReferencia() {
        return referencia;
    }
}
