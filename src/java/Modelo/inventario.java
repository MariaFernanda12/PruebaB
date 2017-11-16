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

    
    public inventario() {
    }

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

    public String getetiqueta() {
        return etiqueta;
    }

    public void setetiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

   
    


    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcantidadDisponible() {
        return cantidadDisponible;
    }

    public void setcantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getubicacion() {
        return ubicacion;
    }

    public void setubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getpropiedad() {
        return propiedad;
    }

    public void setpropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getresponsable() {
        return responsable;
    }

    public void setresponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getarea() {
        return area;
    }

    public void setarea(String area) {
        this.area = area;
    }

    public String getcolegio() {
        return colegio;
    }

    public void setcolegio(String colegio) {
        this.colegio = colegio;
    }

    

}
