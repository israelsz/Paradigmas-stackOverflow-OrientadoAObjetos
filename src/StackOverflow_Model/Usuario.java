package StackOverflow_Model;


import java.util.ArrayList;

/**
 * Clase Usuario perteneciente al modelo, contiene toda la estructura de un usuario.
 * @author Israel Arias Panez
 */
public class Usuario {
    //Atributos
    private String username;
    private String password;
    private ArrayList<Pregunta> preguntasRealizadas;
    private ArrayList<Respuesta> respuestasRealizadas;
    private Integer reputacion;

    //Constructor

    /**
     * Constructor de Usuario.
     * @param username El nombre de usuario
     * @param password La contraseña
     */
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.preguntasRealizadas = new ArrayList<>();
        this.respuestasRealizadas = new ArrayList<>();
        this.reputacion = 50;
    }
    //Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getReputacion() {
        return reputacion;
    }

    public ArrayList<Pregunta> getPreguntasRealizadas() {
        return preguntasRealizadas;
    }

    public ArrayList<Respuesta> getRespuestasRealizadas() {
        return respuestasRealizadas;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReputacion(Integer reputacion) {
        this.reputacion = reputacion;
    }

    public void setPreguntasRealizadas(ArrayList<Pregunta> preguntasRealizadas) {
        this.preguntasRealizadas = preguntasRealizadas;
    }

    public void setRespuestasRealizadas(ArrayList<Respuesta> respuestasRealizadas) {
        this.respuestasRealizadas = respuestasRealizadas;
    }
    //Metodos

    /**
     * Metodo que permite agregar una pregunta inicialmente en la precarga del stack.
     * @param pregunta Una pregunta.
     */
    public void agregarPregunta(Pregunta pregunta){
        ArrayList<Pregunta> listaPreguntas = getPreguntasRealizadas();
        listaPreguntas.add(pregunta);
        setPreguntasRealizadas(listaPreguntas);
    }

    /**
     * Metodo que permite agregar una respuesta inicialmente en la precarga del stack.
     * @param respuesta Una respuesta.
     */
    public void agregarRespuesta(Respuesta respuesta){
        ArrayList<Respuesta> listaRespuestas = getRespuestasRealizadas();
        listaRespuestas.add(respuesta);
        setRespuestasRealizadas(listaRespuestas);
    }

}
