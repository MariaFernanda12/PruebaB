package Modelo;

public class prestamo {

    public String etiquetaInv;
    public String identificadorSol;
    public String fechaDev;
    public String fechaActual;
    public String cantidadPrestamo;
    public String estado;

    public String getetiquetaInv() {
        return etiquetaInv;
    }

    public void setetiquetaInv(String etiquetaInv) {
        this.etiquetaInv = etiquetaInv;
    }

    public String getidentificadorSol() {
        return identificadorSol;
    }

    public void setidentificadorSol(String identificadorSol) {
        this.identificadorSol = identificadorSol;
    }

    public String getfechaDev() {
        return fechaDev;
    }

    public void setfechaDev(String fechaDev) {
        this.fechaDev = fechaDev;
    }

    public String getfechaActual() {
        return fechaActual;
    }

    public void setfechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getcantidadPrestamo() {
        return cantidadPrestamo;
    }

    public void setcantidadPrestamo(String cantidadPrestamo) {
        this.cantidadPrestamo = cantidadPrestamo;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

}
