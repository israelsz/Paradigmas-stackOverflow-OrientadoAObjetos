package StackOverflow_Controller;

import StackOverflow_Model.*;
import StackOverflow_View.Menu;


public class Controlador {
    //Atributos

    //El controlador tendra como atributos la vista y  las clases del modelo:
    //Vista
    private Menu menu;
    //Modelo
    private Etiqueta etiqueta;
    private Pregunta pregunta;
    private Respuesta respuesta;
    private Stack stack;
    private Usuario usuario;

    //Constructor
    public Controlador(Menu menu, Etiqueta etiqueta, Pregunta pregunta, Respuesta respuesta, Stack stack, Usuario usuario) {
        this.menu = menu;
        this.etiqueta = etiqueta;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.stack = stack;
        this.usuario = usuario;
    }

    //Getters
    public Menu getMenu() {
        return menu;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public Stack getStack() {
        return stack;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Metodos
    public boolean getIsConectado(){
        boolean conectado = getStack().isConectado();
        return conectado;
    }
}
