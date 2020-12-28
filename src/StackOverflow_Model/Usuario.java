package StackOverflow_Model;


import java.util.ArrayList;

public class Usuario {
    //Atributos
    private String username;
    private String password;
    private ArrayList<Pregunta> preguntasRealizadas;
    private ArrayList<Respuesta> respuestasRealizadas;
    private int reputacion;

    //Constructor
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

    public int getReputacion() {
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

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public void setPreguntasRealizadas(ArrayList<Pregunta> preguntasRealizadas) {
        this.preguntasRealizadas = preguntasRealizadas;
    }

    public void setRespuestasRealizadas(ArrayList<Respuesta> respuestasRealizadas) {
        this.respuestasRealizadas = respuestasRealizadas;
    }

}
