package StackOverflow_Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Respuesta perteneciente al modelo, contiene la estructura de la respuesta.
 * @author Israel Arias Panez
 */

public class Respuesta {
    //Atributos
    private static Integer idContador = 0;
    private Usuario autor;
    private String fecha;
    private String contenido;
    private String estado;
    private Integer id;
    private Integer votos;

    //Constructor

    /**
     * Constructor de respuesta.
     * @param contenido El contenido de la respuesta
     */
    public Respuesta(String contenido) {
        this.contenido = contenido;
        this.estado = "pendiente";
        idContador += 1;
        this.id = idContador;
        //Para conseguir la fecha:
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.fecha = formatoFecha.format(date);
        this.votos = 0;
    }

    //Getters

    /**
     *
     * @return el autor de la respuesta.
     */
    public Usuario getAutor() {
        return autor;
    }

    /**
     *
     * @return La fecha de publicación de la respuesta.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @return El contenido de la respuesta.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @return El estado de la respuesta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @return el id de la respuesta.
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return Los votos de la respuesta
     */
    public Integer getVotos() {
        return votos;
    }

    //Setters

    /**
     *
     * @param autor El nuevo autor de la respuesta.
     */
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    /**
     *
     * @param fecha la nueva fecha de la respuesta.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param contenido El nuevo contenido de la respuesta.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @param estado El nuevo estado de la respuesta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @param id El nuevo id de la respuesta.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param votos La nueva cantidad de votos de la respuesta.
     */
    public void setVotos(Integer votos) {
        this.votos = votos;
    }

}
