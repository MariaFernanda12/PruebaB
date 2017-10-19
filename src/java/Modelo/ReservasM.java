/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Mateo Ortiz
 */
public class ReservasM {
    int etiquetaInv;
    int identificadorsol;
    String fechaDev;
    String fechaActual;
    int cantidadPrestamo;
    String estado;
  

    public ReservasM(int etiquetaInv, int identificadorsol, String fechaDev, String fechaActual, int cantidadPrestamo, String estado) {
        this.etiquetaInv = etiquetaInv;
        this.identificadorsol = identificadorsol;
        this.fechaDev = fechaDev;
        this.fechaActual = fechaActual;
        this.cantidadPrestamo = cantidadPrestamo;
        this.estado = estado;
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

    public int getIdentificadorsol() {
        return identificadorsol;
    }

    public void setIdentificadorsol(int identificadorsol) {
        this.identificadorsol = identificadorsol;
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
    
    
    
    
}
