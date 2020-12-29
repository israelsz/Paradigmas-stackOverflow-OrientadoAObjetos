package StackOverflow_Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    //Constructor
    public Pregunta(String titulo, String contenido, ArrayList<Etiqueta> etiquetas) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.recompensa = 0;
        this.estado = "abierta";
        this.respuestas = new ArrayList<>();
        this.etiquetas = etiquetas;
        idContador += 1;
        this.id = idContador;
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

    //Metodos:
    public void agregarRespuesta(Respuesta respuesta){
        ArrayList<Respuesta> listaRespuestasAPregunta = getRespuestas();
        listaRespuestasAPregunta.add(respuesta);
        setRespuestas(listaRespuestasAPregunta);
    }



}
