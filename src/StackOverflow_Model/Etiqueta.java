package StackOverflow_Model;

public class Etiqueta {
    //Atributos
    private String nombreEtiqueta;
    private String descripcionEtiqueta;

    //Constructor
    public Etiqueta(String nombreEtiqueta, String descripcionEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
        this.descripcionEtiqueta = descripcionEtiqueta;
    }

    //Getters
    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public String getDescripcionEtiqueta() {
        return descripcionEtiqueta;
    }

    //Setters
    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public void setDescripcionEtiqueta(String descripcionEtiqueta) {
        this.descripcionEtiqueta = descripcionEtiqueta;
    }
}
