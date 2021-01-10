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
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getRecompensa() {
        return recompensa;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVotos() {
        return votos;
    }

    //Setters
    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRecompensa(Integer recompensa) {
        this.recompensa = recompensa;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
