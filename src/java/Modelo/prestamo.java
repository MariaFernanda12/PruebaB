package Modelo;

public class prestamo {

    public String etiquetaInv;
    public String identificadorSol;
    public String fechaDev;
    public String fechaActual;
    public String cantidadPrestamo;
    public String estado;

    public String getEtiquetaInv() {
        return etiquetaInv;
    }

    public void setEtiquetaInv(String etiquetaInv) {
        this.etiquetaInv = etiquetaInv;
    }

    public String getIdentificadorSol() {
        return identificadorSol;
    }

    public void setIdentificadorSol(String identificadorSol) {
        this.identificadorSol = identificadorSol;
    }

    public String getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(String fechaDev) {
        this.fechaDev = fechaDev;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getCantidadPrestamo() {
        return cantidadPrestamo;
    }

    public void setCantidadPrestamo(String cantidadPrestamo) {
        this.cantidadPrestamo = cantidadPrestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
