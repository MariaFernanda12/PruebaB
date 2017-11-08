package Modelo;

public class prestamo {

    public int etiquetaInv;
    public String identificadorSol;
    public String fechaDev;
    public String fechaActual;
    public int cantidadPrestamo;
    public String estado;

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

    public int getCantidadPrestamo() {
        return cantidadPrestamo;
    }

    public void setCantidadPrestamo(int cantidadPrestamo) {
        this.cantidadPrestamo = cantidadPrestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEtiquetaInv() {
        return etiquetaInv;
    }

    public void setEtiquetaInv(int etiquetaInv) {
        this.etiquetaInv = etiquetaInv;
    }

    public String getIdentificadorSol() {
        return identificadorSol;
    }

    public void setIdentificadorSol(String identificadorSol) {
        this.identificadorSol = identificadorSol;
    }

    @Override
    public String toString() {
        return "prestamo{" + "etiquetaInv=" + etiquetaInv + ", identificadorSol=" + identificadorSol + ", fechaDev=" + fechaDev + ", fechaActual=" + fechaActual + ", cantidadPrestamo=" + cantidadPrestamo + ", estado=" + estado + '}';
    }

    

}
