package Modelo;

public class inventario {

    public String etiqueta;/*Número de identificación del libro o el elemento*/
    public String nombre;/*Nombre del libro o del elemento*/
    public String cantidadDisponible;/*Si la cantidad disponible es <= 0 entonces no se puede prestar*/
    public String ubicacion;/*Puede ser en aulas de clase biblioteca o incluso otra sede*/
    public String propiedad;/*Colegio o Alcaldia*/
    public String responsable;/*Bibliotecólogo o docentes*/
    public String area;/*Area o tipo de elemento*/
    public String colegio;

    public inventario(String etiqueta, String nombre, String cantidadDisponible, String ubicacion, String propiedad, String responsable, String area, String colegio) {
        this.etiqueta = etiqueta;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.ubicacion = ubicacion;
        this.propiedad = propiedad;
        this.responsable = responsable;
        this.area = area;
        this.colegio = colegio;
    }

    public inventario() {
    }
    

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    @Override
    public String toString() {
        return "inventario{" + "etiqueta=" + etiqueta + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible + ", ubicacion=" + ubicacion + ", propiedad=" + propiedad + ", responsable=" + responsable + ", area=" + area + ", colegio=" + colegio + '}';
    }

}
