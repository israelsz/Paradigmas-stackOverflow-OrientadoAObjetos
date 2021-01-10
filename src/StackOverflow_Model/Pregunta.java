package StackOverflow_Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Pregunta, pertenciente al modelo, contiene todas la estructura de una pregunta.
 * @author Israel Arias Panez
 */
public class Pregunta {
    //Atributos
    private static Integer idContador = 0;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<Etiqueta> etiquetas;
    private String titulo;
    private String contenido;
    private String fecha;
    private Usuario autor;
    private String estado;
    private Integer recompensa;
    private Integer id;
    private Integer votos;

    //Constructor

    /**
     * Constructor de una pregunta
     * @param titulo titulo de una pregunta
     * @param contenido contenido de una pregunta
     * @param etiquetas la etiqueta de una pregunta
     */
    public Pregunta(String titulo, String contenido, ArrayList<Etiqueta> etiquetas) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.recompensa = 0;
        this.estado = "abierta";
        this.respuestas = new ArrayList<>();
        this.etiquetas = etiquetas;
        idContador += 1;
        this.id = idContador;
        this.votos = 0;
        //Para conseguir la fecha:
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.fecha = formatoFecha.format(date);
        }

    //Getters

    /**
     *
     * @return ArrayList con respuestas
     */
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**
     *
     * @return ArrayList con etiquetas
     */
    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    /**
     *
     * @return El titulo de la pregunta
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return El contenido de una pregunta
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @return La fecha de la pregunta
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @return El autor de la pregunta
     */
    public Usuario getAutor() {
        return autor;
    }

    /**
     *
     * @return El estado de la pregunta, por ejemplo abierto o cerrado
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @return La recompensa de la pregunta
     */
    public Integer getRecompensa() {
        return recompensa;
    }

    /**
     *
     * @return el id de la pregunta
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return los votos que tiene la pregunta
     */
    public Integer getVotos() {
        return votos;
    }

    //Setters

    /**
     *
     * @param respuestas ArrayList con respuestas
     */
    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     *
     * @param etiquetas ArrayList con etiquetas
     */
    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     *
     * @param titulo titulo de la pregunta
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @param contenido Contenido de la pregunta
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @param fecha Fecha de la pregunta
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param autor Autor de la pregunta
     */
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    /**
     *
     * @param estado Estado de la pregunta
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @param recompensa Recompensa a asignar a la pregunta
     */
    public void setRecompensa(Integer recompensa) {
        this.recompensa = recompensa;
    }

    /**
     *
     * @param id id de la pregunta
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param votos nuevos votos para la pregunta
     */
    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    //Metodos:

    /**
     * Permite agregar una respuesta, se usa en la precarga del stack.
     * @param respuesta Una respuesta
     */
    public void agregarRespuesta(Respuesta respuesta){
        ArrayList<Respuesta> listaRespuestasAPregunta = getRespuestas();
        listaRespuestasAPregunta.add(respuesta);
        setRespuestas(listaRespuestasAPregunta);
    }



}
