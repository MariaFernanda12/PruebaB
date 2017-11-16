package Modelo;

public class reserva {

    public String idElemento;
    public String fechaActual;
    public String fechaReserva;
    public String idSol;
    public String cantidad;
    public String estado;

    public String getidElemento() {
        return idElemento;
    }

    public void setidElemento(String idElemento) {
        this.idElemento = idElemento;
    }

    public String getfechaActual() {
        return fechaActual;
    }

    public void setfechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getfechaReserva() {
        return fechaReserva;
    }

    public void setfechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getidSol() {
        return idSol;
    }

    public void setidSol(String idSol) {
        this.idSol = idSol;
    }

    public String getcantidad() {
        return cantidad;
    }

    public void setcantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public reserva(String idElemento, String fechaActual, String fechaReserva, String idSol, String cantidad, String estado) {
        this.idElemento = idElemento;
        this.fechaActual = fechaActual;
        this.fechaReserva = fechaReserva;
        this.idSol = idSol;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public reserva() {
    }

    
    

}
