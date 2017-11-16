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

    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public String getclave() {
        return clave;
    }

    public String getimagen() {
        return imagen;
    }

    public void setimagen(String imagen) {
        this.imagen = imagen;
    }

    public void setclave(String clave) {
        this.clave = clave;
    }

    public String getidentificador() {
        return identificador;
    }

    public void setidentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getnombreSol() {
        return nombreSol;
    }

    public void setnombreSol(String nombreSol) {
        this.nombreSol = nombreSol;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getcursoArea() {
        return cursoArea;
    }

    public void setcursoArea(String cursoArea) {
        this.cursoArea = cursoArea;
    }

    public String getcolegio() {
        return colegio;
    }

    public void setcolegio(String colegio) {
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

    public usuarios() {
    }
    

}
