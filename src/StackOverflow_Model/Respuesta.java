package StackOverflow_Model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Usuario getAutor() {
        return autor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVotos() {
        return votos;
    }

    //Setters
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setVotos(Integer votos) {
        this.votos = votos;
    }

}
