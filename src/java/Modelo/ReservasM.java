
package Modelo;


public class ReservasM {
    int etiquetaInv;
    String identificadorsol;
    String fechaRes;
    String fechaActual;
    int cantidadRes;    
    String estado;

    public int getEtiquetaInv() {
        return etiquetaInv;
    }

    public void setEtiquetaInv(int etiquetaInv) {
        this.etiquetaInv = etiquetaInv;
    }

    public String getIdentificadorsol() {
        return identificadorsol;
    }

    public void setIdentificadorsol(String identificadorsol) {
        this.identificadorsol = identificadorsol;
    }

    public String getFechaRes() {
        return fechaRes;
    }

    public void setFechaRes(String fechaRes) {
        this.fechaRes = fechaRes;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    } 

    public int getCantidadRes() {
        return cantidadRes;
    }

    public void setCantidadRes(int cantidadRes) {
        this.cantidadRes = cantidadRes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservasM{" + "etiquetaInv=" + etiquetaInv + ", identificadorsol=" + identificadorsol + ", fechaRes=" + fechaRes + ", fechaActual=" + fechaActual + ", cantidadRes=" + cantidadRes + ", estado=" + estado + '}';
    }

    public void getIdentificadorsol(int idsol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
