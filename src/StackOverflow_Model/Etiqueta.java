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

    /**
     *
     * @return El nombre de la etiqueta.
     */
    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    /**
     *
     * @return La descripcion de la etiqueta.
     */
    public String getDescripcionEtiqueta() {
        return descripcionEtiqueta;
    }

    //Setters

    /**
     *
     * @param nombreEtiqueta El nuevo nombre para la etiqueta.
     */
    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    /**
     *
     * @param descripcionEtiqueta La nueva descripcion para la etiqueta.
     */
    public void setDescripcionEtiqueta(String descripcionEtiqueta) {
        this.descripcionEtiqueta = descripcionEtiqueta;
    }
}
