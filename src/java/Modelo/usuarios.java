package Modelo;

public class usuarios {

    String identificador;/*Número de identificación*/
    String nombreSol;/*Nombre del solicitante*/
    String tipo;/*Si es estudiante o docente*/
    String cursoArea;/*Si es estudiante se pone el curso, si es docente se pone el area del docente, si es administrador pone el cargo*/
    String colegio;/*Colegio al que pertenece el estudiante*/
    String clave;/*Clave para el inicio de sesión*/
    String imagenUsuario; /*Imagen personalizada del usuario*/
    String correo; /*Correo*/
    String estado; /*Estado de verificación*/

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

    public String getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
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

    @Override
    public String toString() {
        return "Usuario{" + "identificador=" + identificador + ", nombreSol=" + nombreSol + ", tipo=" + tipo + ", cursoArea=" + cursoArea + ", colegio=" + colegio + ", clave=" + clave + ", imagenUsuario=" + imagenUsuario + '}';
    }

}
