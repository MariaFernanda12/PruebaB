package Modelo;

public class reserva {

    public String idElemento;
    public String fechaActual;
    public String fechaReserva;
    public String idSol;
    public String cantidad;
    public String estado;

    public String getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(String idElemento) {
        this.idElemento = idElemento;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getIdSol() {
        return idSol;
    }

    public void setIdSol(String idSol) {
        this.idSol = idSol;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "reserva{" + "idElemento=" + idElemento + ", fechaActual=" + fechaActual + ", fechaReserva=" + fechaReserva + ", idSol=" + idSol + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }

    public reserva(String idSol) {
        this.idElemento = null;
        this.fechaActual = null;
        this.fechaReserva = null;
        this.idSol = idSol;
        this.cantidad = null;
        this.estado = null;
    }

    

}
