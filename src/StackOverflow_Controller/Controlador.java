package StackOverflow_Controller;

import StackOverflow_Model.*;
import StackOverflow_View.Menu;


public class Controlador {
    //Atributos

    //El controlador tendra como atributos las clases del modelo:

    //Modelo
    private Stack stack;

    //Constructor
    public Controlador(Stack stack) {
        this.stack = stack;
    }

    //Getter
    public Stack getStack() {
        return stack;
    }

    //Metodos
    public boolean isUsuarioConectado(){
        Stack stackActual = getStack();
        return stackActual.isConectado();
    }

    public String usernameUsuarioConectado(){
        Stack stackActual = getStack();
        return stackActual.getUsuarioConectado().getUsername();
    }

    //Logout:
    public void logOut(){
        Stack stackActual = getStack();
        stackActual.setConectado(false);
    }

}
