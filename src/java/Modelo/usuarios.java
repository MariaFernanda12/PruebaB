package Modelo;

public class usuarios {

    public String identificador;/*Número de identificación*/
    public String nombreSol;/*Nombre del solicitante*/
    public String tipo;/*Si es estudiante o docente*/
    public String cursoArea;/*Si es estudiante se pone el curso, si es docente se pone el area del docente, si es administrador pone el cargo*/
    public String colegio;/*Colegio al que pertenece el estudiante*/
    public String clave;/*Clave para el inicio de sesión*/
    public String imagen;/*Imagen personalizada del usuario*/
    public String correo;/*Correo*/
    public String estado;/*Estado de verificación*/

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombreSol() {
        return nombreSol;
    }

    public void setNombreSol(String nombreSol) {
        this.nombreSol = nombreSol;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCursoArea() {
        return cursoArea;
    }

    public void setCursoArea(String cursoArea) {
        this.cursoArea = cursoArea;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public usuarios(String identificador, String nombreSol, String tipo, String cursoArea, String colegio, String clave, String imagen, String correo, String estado) {
        this.identificador = identificador;
        this.nombreSol = nombreSol;
        this.tipo = tipo;
        this.cursoArea = cursoArea;
        this.colegio = colegio;
        this.clave = clave;
        this.imagen = imagen;
        this.correo = correo;
        this.estado = estado;
    }

}
