package StackOverflow_Controller;

import StackOverflow_Model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


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

    // elegir etiquetas para una pregunta
    public ArrayList<Etiqueta> elegirEtiquetas(){
        int opcion;
        int cantidadEtiquetas;
        int idEtiqueta;
        boolean salirMenu = false;
        ArrayList<Etiqueta> listaEtiquetas = null;
        Scanner input = new Scanner(System.in);
        Stack stack = getStack();
        System.out.println("Las etiquetas existentes en el stack son las siguientes: ");
        ArrayList<Etiqueta> etiquetasStack = stack.getEtiquetas();
        for(int i = 1; i<= etiquetasStack.size(); i++){
            System.out.println("Id etiqueta: "+ i + ".");
            System.out.println("Nombre Etiqueta: " + etiquetasStack.get(i-1).getNombreEtiqueta());
            System.out.println("Descripcion Etiqueta: ");
            System.out.println(etiquetasStack.get(i-1).getDescripcionEtiqueta());
            System.out.print("\n");
        }

        try {
            System.out.println("¿Desea elegir etiquetas ya creadas o desea crear nuevas etiquetas para la pregunta?");
            System.out.println("1. Elegir etiquetas ya creadas");
            System.out.println("2. Crear nuevas etiquetas");
            System.out.println("Introduzca su opción: ");
            opcion = input.nextInt();
            switch (opcion){
                case 1: //Elegir etiquetas ya creadas
                    System.out.println("Eligió escoger etiquetas ya existentes");
                    System.out.println("¿Cuantas etiquetas tendra la pregunta? ");
                    cantidadEtiquetas = input.nextInt();
                    listaEtiquetas = new ArrayList<>();
                    for (int i = 1; i <= cantidadEtiquetas; i++){
                        System.out.println("Ingrese el id de la etiqueta del menu presentado anteriormente: " + i);
                        idEtiqueta = input.nextInt();
                        listaEtiquetas.add(etiquetasStack.get(i-1));
                    }
                    System.out.println("Etiquetas agregadas");
                    return listaEtiquetas;
                case 2: //Crear nuevas etiquetas
                    System.out.println("Eligió crear nuevas etiquetas");
                    System.out.println("¿Cuantas etiquetas tendra la pregunta? ");
                    cantidadEtiquetas = input.nextInt();
                    input.nextLine();
                    listaEtiquetas = new ArrayList<>();
                    //A continuacion se pide que el usuario ingrese la informacion de las etiquetas:
                    for(int i = 1;i<=cantidadEtiquetas;i++){
                        System.out.println("Ingrese el nombre de la etiqueta " + i +" :");
                        String nombreEtiqueta = input.nextLine();
                        System.out.println("Ingrese la descripción de la etiqueta " + i +" :");
                        String descripcionEtiqueta = input.nextLine();
                        //Se crea la etiqueta
                        Etiqueta etiqueta = new Etiqueta(nombreEtiqueta,descripcionEtiqueta);
                        //Se agrega la etiqueta a la lista de etiquetas
                        listaEtiquetas.add(etiqueta);
                        //Se agrega la etiqueta a la lista de etiquetas del stack
                        stack.getEtiquetas().add(etiqueta);
                    }
                    System.out.println("Etiquetas agregadas");
                    return listaEtiquetas;
                default:
                    System.out.println("Debe seleccionar una de las opciones presentadas !");
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("Solo puede ingresar números");
            input.next();
        }
        return listaEtiquetas;
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
