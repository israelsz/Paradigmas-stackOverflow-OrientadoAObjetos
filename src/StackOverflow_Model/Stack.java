package StackOverflow_Model;

import java.util.ArrayList;

public class Stack {
    //Atributos
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioConectado;
    private boolean conectado = false;

    //Constructor
    public Stack() {
    }
}
