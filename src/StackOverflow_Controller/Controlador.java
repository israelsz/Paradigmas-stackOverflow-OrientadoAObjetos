package StackOverflow_Controller;

import StackOverflow_Model.*;

import java.util.ArrayList;


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

    //Metodos:

    public void printStack(){
        getStack().printearStack();
    }
    public boolean isUsuarioConectado(){
        Stack stackActual = getStack();
        return stackActual.isConectado();
    }

    public String usernameUsuarioConectado(){
        Stack stackActual = getStack();
        return stackActual.getUsuarioConectado().getUsername();
    }

    //Login:
    public void login(String username, String password){
        Stack stack = getStack();
        for (int i = 0; i < stack.getUsuarios().size(); i++) {
            //Si se encuentra al usuario dentro de la Arraylist con su correspondiente username y password
            if (stack.getUsuarios().get(i).getUsername().equals(username) && stack.getUsuarios().get(i).getPassword().equals(password)) {
                //Se establece al usuario como conectado
                stack.setUsuarioConectado(stack.getUsuarios().get(i));
                stack.setConectado(true);
                return;
            }
        }
        //En caso de no haber encontrado al usuario o password incorrecta
        System.out.println("Usuario no encontrado o contraseña incorrecta, revise sus datos de ingreso");
    }

    //Register:
    public void register(String username, String password){
        Stack stack = getStack();
        for (int i = 0; i < stack.getUsuarios().size(); i++) {
            if (stack.getUsuarios().get(i).getUsername().equals(username)) {
                System.out.println("No es posible registar, el usuario ya se encuentra registrado !");
                return;
            }
        }
        Usuario nuevoUsuario = new Usuario(username, password);
        stack.getUsuarios().add(nuevoUsuario);
        System.out.println("Nuevo usuario registrado !");
    }

    //Logout:
    public void logOut(){
        Stack stackActual = getStack();
        stackActual.setConectado(false);
    }

    //Ask:
    public void ask(String titulo, String contenido, ArrayList<Etiqueta> etiquetas){
        Stack stack = getStack();
        //Se crea la pregunta
        Pregunta pregunta = new Pregunta(titulo,contenido,etiquetas);
        //Se consigue al autor y se le agrega a la pregunta
        pregunta.setAutor(stack.getUsuarioConectado());
        //Se agrega la pregunta creada al usuario
        stack.getUsuarioConectado().getPreguntasRealizadas().add(pregunta);
        //Se agrega la pregunta al stack
        stack.getPreguntas().add(pregunta);
        System.out.println("Pregunta agregada!");
    }
}
