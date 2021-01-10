package StackOverflow_Model;

/**
 * Clase etiqueta, perteneciente al modelo, contiene la estructura de una etiqueta.
 * @author Israel Arias Panez
 */
public class Etiqueta {
    //Atributos
    private String nombreEtiqueta;
    private String descripcionEtiqueta;

    //Constructor

    /**
     * Constructor de la etiqueta.
     * @param nombreEtiqueta Nombre de la etiqueta.
     * @param descripcionEtiqueta Descripcion de la etiqueta.
     */
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
