
package Modelo;


public class PrestamoM {
    int etiquetaInv;
    int identificadorsol;
    String fechaDev;
    String fechaActual;
    int cantidadPrestamo;    
    String estado;

    public int getEtiquetaInv() {
        return etiquetaInv;
    }

    public void setEtiquetaInv(int etiquetaInv) {
        this.etiquetaInv = etiquetaInv;
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

    public int getIdentificadorsol() {
        return identificadorsol;
    }

    public void setIdentificadorsol(int identificadorsol) {
        this.identificadorsol = identificadorsol;
    }

  

    @Override
    public String toString() {
        return "PrestamoM{" + "etiquetaInv=" + etiquetaInv + ", identificadorsol=" + identificadorsol + ", fechaDev=" + fechaDev + ", fechaActual=" + fechaActual + ", cantidadPrestamo=" + cantidadPrestamo + ", estado=" + estado + '}';
    }

    

    
    
    
    
    
}
