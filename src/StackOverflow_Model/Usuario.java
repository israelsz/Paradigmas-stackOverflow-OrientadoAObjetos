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

    /**
     *
     * @return El nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return La contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return La reputacion
     */
    public Integer getReputacion() {
        return reputacion;
    }

    /**
     *
     * @return ArrayList con preguntas realizadas.
     */
    public ArrayList<Pregunta> getPreguntasRealizadas() {
        return preguntasRealizadas;
    }

    /**
     *
     * @return ArrayLisy con respuestas realizadas.
     */
    public ArrayList<Respuesta> getRespuestasRealizadas() {
        return respuestasRealizadas;
    }

    //Setters

    /**
     *
     * @param username el nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param password La contraseña
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param reputacion la nueva reputacion del usuario
     */
    public void setReputacion(Integer reputacion) {
        this.reputacion = reputacion;
    }

    /**
     *
     * @param preguntasRealizadas ArrayList con preguntas realizadas
     */
    public void setPreguntasRealizadas(ArrayList<Pregunta> preguntasRealizadas) {
        this.preguntasRealizadas = preguntasRealizadas;
    }

    /**
     *
     * @param respuestasRealizadas ArrayList con respuestas realizadas
     */
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
