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

    public void printStack() {
        getStack().printearStack();
    }

    public boolean isUsuarioConectado() {
        Stack stackActual = getStack();
        return stackActual.isConectado();
    }

    public Usuario usuarioConectado() {
        Stack stackActual = getStack();
        return stackActual.getUsuarioConectado();
    }

    //Login:
    public void login(String username, String password) {
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
    public void register(String username, String password) {
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
    public void logOut() {
        Stack stackActual = getStack();
        stackActual.setConectado(false);
    }

    // elegir etiquetas para una pregunta
    public ArrayList<Etiqueta> elegirEtiquetas() {
        int opcion;
        int cantidadEtiquetas;
        int idEtiqueta;
        boolean salirMenu = false;
        ArrayList<Etiqueta> listaEtiquetas = null;
        Scanner input = new Scanner(System.in);
        Stack stack = getStack();
        System.out.println("Las etiquetas existentes en el stack son las siguientes: ");
        ArrayList<Etiqueta> etiquetasStack = stack.getEtiquetas();
        for (int i = 1; i <= etiquetasStack.size(); i++) {
            System.out.println("Id etiqueta: " + i + ".");
            System.out.println("Nombre Etiqueta: " + etiquetasStack.get(i - 1).getNombreEtiqueta());
            System.out.println("Descripcion Etiqueta: ");
            System.out.println(etiquetasStack.get(i - 1).getDescripcionEtiqueta());
            System.out.print("\n");
        }

        try {
            System.out.println("¿Desea elegir etiquetas ya creadas o desea crear nuevas etiquetas para la pregunta?");
            System.out.println("1. Elegir etiquetas ya creadas");
            System.out.println("2. Crear nuevas etiquetas");
            System.out.println("Introduzca su opción: ");
            opcion = input.nextInt();
            switch (opcion) {
                case 1: //Elegir etiquetas ya creadas
                    System.out.println("Eligió escoger etiquetas ya existentes");
                    System.out.println("¿Cuantas etiquetas tendra la pregunta? ");
                    cantidadEtiquetas = input.nextInt();
                    listaEtiquetas = new ArrayList<>();
                    for (int i = 1; i <= cantidadEtiquetas; i++) {
                        System.out.println("Ingrese el id de la etiqueta del menu presentado anteriormente: " + i);
                        idEtiqueta = input.nextInt();
                        listaEtiquetas.add(etiquetasStack.get(i - 1));
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
                    for (int i = 1; i <= cantidadEtiquetas; i++) {
                        System.out.println("Ingrese el nombre de la etiqueta " + i + " :");
                        String nombreEtiqueta = input.nextLine();
                        System.out.println("Ingrese la descripción de la etiqueta " + i + " :");
                        String descripcionEtiqueta = input.nextLine();
                        //Se crea la etiqueta
                        Etiqueta etiqueta = new Etiqueta(nombreEtiqueta, descripcionEtiqueta);
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
        } catch (InputMismatchException e) {
            System.out.println("Solo puede ingresar números");
            input.next();
        }
        return listaEtiquetas;
    }

    //Ask:
    public void ask(String titulo, String contenido, ArrayList<Etiqueta> etiquetas) {
        Stack stack = getStack();
        //Se crea la pregunta
        Pregunta pregunta = new Pregunta(titulo, contenido, etiquetas);
        //Se consigue al autor y se le agrega a la pregunta
        pregunta.setAutor(stack.getUsuarioConectado());
        //Se agrega la pregunta creada al usuario
        stack.getUsuarioConectado().getPreguntasRealizadas().add(pregunta);
        //Se agrega la pregunta al stack
        stack.getPreguntas().add(pregunta);
        System.out.println("Pregunta agregada!");
    }

    //Elegir pregunta del stack
    public Pregunta elegirPregunta() {
        Stack stack = getStack();
        Scanner input = new Scanner(System.in);
        System.out.println("Las preguntas disponibles en el stack son: ");
        for (int i = 0; i < stack.getPreguntas().size(); i++) {
            System.out.println("Pregunta: " + stack.getPreguntas().get(i).getTitulo() + " Id: " + stack.getPreguntas().get(i).getId());
            System.out.println("Contenido: " + stack.getPreguntas().get(i).getContenido());
            System.out.println("Fecha :" + stack.getPreguntas().get(i).getFecha() + " Estado: " + stack.getPreguntas().get(i).getEstado() + " Autor: " + stack.getPreguntas().get(i).getAutor().getUsername());
            System.out.println("Recompensa: " + stack.getPreguntas().get(i).getRecompensa() + "\n");
        }
        System.out.println("Ingrese el id de la pregunta que desea escoger:");
        Integer idPregunta = input.nextInt();
        Pregunta preguntaElegida = null;
        //Se busca la pregunta que se eligio
        while (true) {
            for (int i = 0; i < stack.getPreguntas().size(); i++) {
                if (stack.getPreguntas().get(i).getId().equals(idPregunta)) {
                    preguntaElegida = stack.getPreguntas().get(i);
                    return preguntaElegida;
                }
            }

            //Si se termina el ciclo for sin encontrar la pregunta para el id ingresado:
            System.out.println("No se encontro el id de pregunta ingresado");
            System.out.println("Ingrese el id de la pregunta que desea escoger:");
            idPregunta = input.nextInt();
        }
    }

    //Answer:
    public void answer(Pregunta preguntaAResponder, String contenido) {
        Stack stack = getStack();
        //Se crea la respuesta
        Respuesta respuesta = new Respuesta(contenido);
        //Se consigue al autor de la respuesta y se le agrega a la respuesta
        respuesta.setAutor(stack.getUsuarioConectado());
        //Se agrega la respuesta creada al usuario
        stack.getUsuarioConectado().getRespuestasRealizadas().add(respuesta);
        //Se agrega la respuesta a la pregunta:
        preguntaAResponder.getRespuestas().add(respuesta);
        System.out.println("Respuesta agregada!");
    }

    //Reward
    public void reward(Pregunta preguntaARecompensar, Integer recompensa) {
        Stack stack = getStack();
        //En primer lugar se verificara que la pregunta se encuentre abierta
        if(preguntaARecompensar.getEstado().equals("abierta")){
            //Se consigue la recompensa de la pregunta
            Integer recompensaActual = preguntaARecompensar.getRecompensa();
            //Se suma la recompensa ofrecida por el usuario
            Integer nuevaRecompensa = recompensaActual + recompensa;
            //Se agrega la recompensa a la pregunta
            preguntaARecompensar.setRecompensa(nuevaRecompensa);
            //Ahora se descuenta la recompensa ofrecida por el usuario
            Integer reputacionUsuario = stack.getUsuarioConectado().getReputacion();
            reputacionUsuario = reputacionUsuario - recompensa;
            //Se descuenta la recompensa fijando la recompensa ya restada
            stack.getUsuarioConectado().setReputacion(reputacionUsuario);
            System.out.println("Recompensa añadida !");
        } else{
            System.out.println("No es posible dar recompensa a una pregunta que se encuentre cerrada");
        }

    }

    //Mostrar solo preguntas abiertas con las respuestas del usuario activo
    public Integer mostrarPreguntasYRespuestasDelUsuario() {
        Stack stack = getStack();
        Integer contadorPreguntas = 0;
        for (int i = 0; i < stack.getPreguntas().size(); i++) {
            //Si la respuesta pertenece al usuario y además no se encuentra cerrada
            if (stack.getUsuarioConectado().getUsername().equals(stack.getPreguntas().get(i).getAutor().getUsername()) && stack.getPreguntas().get(i).getEstado().equals("abierta")) {
                System.out.println("Pregunta: " + stack.getPreguntas().get(i).getTitulo() + " Id: " + stack.getPreguntas().get(i).getId());
                System.out.println("Contenido: " + stack.getPreguntas().get(i).getContenido());
                System.out.println("Fecha :" + stack.getPreguntas().get(i).getFecha() + " Estado: " + stack.getPreguntas().get(i).getEstado() + " Autor: " + stack.getPreguntas().get(i).getAutor().getUsername());
                System.out.println("Recompensa: " + stack.getPreguntas().get(i).getRecompensa() + "\n");
                for (int j = 0; j < stack.getPreguntas().get(i).getEtiquetas().size(); j++) {
                    System.out.println("Etiquetas: " + stack.getPreguntas().get(i).getEtiquetas().get(j).getNombreEtiqueta());
                }
                System.out.println("\nRespuestas a la pregunta: ");
                for (int j = 0; j < stack.getPreguntas().get(i).getRespuestas().size(); j++) {
                    System.out.println("Respuesta: " + stack.getPreguntas().get(i).getRespuestas().get(j).getContenido());
                    System.out.println(" Id: " + stack.getPreguntas().get(i).getRespuestas().get(j).getId() + " Fecha: " + stack.getPreguntas().get(i).getRespuestas().get(j).getFecha());
                    System.out.println(" Autor: " + stack.getPreguntas().get(i).getRespuestas().get(j).getAutor().getUsername() + " Estado: " + stack.getPreguntas().get(i).getRespuestas().get(j).getEstado() + "\n");
                }
                contadorPreguntas = contadorPreguntas+1;
            }
        }
        return contadorPreguntas;
    }

    //Elegir pregunta para accept
    public Pregunta elegirPreguntaAccept() {
        Stack stack = getStack();
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el id de la pregunta que desea escoger:");
        Integer idPregunta = input.nextInt();
        Pregunta preguntaElegida = null;
        //Se busca la pregunta que se eligio
        while (true) {
            for (int i = 0; i < stack.getPreguntas().size(); i++) {
                //Si cumple los requisitos de ser la pregunta buscada, además de haber sido realizada por el mismo usuario y estar en estado abierta
                if (stack.getPreguntas().get(i).getId().equals(idPregunta) && stack.getPreguntas().get(i).getAutor().getUsername().equals(stack.getUsuarioConectado().getUsername()) && stack.getPreguntas().get(i).getEstado().equals("abierta")) {
                    //Se elige la pregunta y la retorna
                    preguntaElegida = stack.getPreguntas().get(i);
                    return preguntaElegida;
                }
            }
            //Si se termina el ciclo for sin encontrar la pregunta para el id ingresado:
            System.out.println("No se encontro el id de pregunta ingresado");
            System.out.println("Ingrese el id de la pregunta que desea escoger:");
            idPregunta = input.nextInt();
        }
    }
    //Elegir respuesta para accept
    public Respuesta elegirRespuestaAccept(Pregunta pregunta){
        Stack stack = getStack();
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el id de la respuesta que desea aceptar:");
        Integer idRespuesta = input.nextInt();
        Respuesta respuestaElegida = null;
        //Se recorrera la lista de preguntas de la pregunta elegida con anterioridad
        while(true){
            for(int i = 0; i < pregunta.getRespuestas().size(); i++){
                //Si se encuentra la respuesta con el id elegido, la retorna
                if(pregunta.getRespuestas().get(i).getId().equals(idRespuesta)){
                    respuestaElegida = pregunta.getRespuestas().get(i);
                    return respuestaElegida;
                }
            }
            //Si se termina el ciclo for sin encontrar la Respuesta para el id ingresado:
            System.out.println("No se encontro el id de respuesta ingresado");
            System.out.println("Ingrese el id de la respuesta que desea aceptar:");
            idRespuesta = input.nextInt();
        }
    }

    //Accept
    public void accept(Pregunta pregunta, Respuesta respuesta){
        Stack stack = getStack();
        //En primer lugar se cambiaran los estados, tanto de la pregunta como la respuesta
        pregunta.setEstado("Cerrada");
        respuesta.setEstado("Aceptada");
        //Se le otorgara al usuario cuya respuesta fue aceptada, la recompensa de la pregunta
        Integer reputacionActualUsuario = respuesta.getAutor().getReputacion();
        //Se consigue la nueva reputacion, la cual es la reputacion anterior del usuario + la recompensa por la pregunta + 15 por haber sido su respuesta aceptada
        Integer nuevaReputacion = reputacionActualUsuario + pregunta.getRecompensa() + 15;
        //Se fija la nueva reputacion del usuario cuya respuesta fue aceptada
        respuesta.getAutor().setReputacion(nuevaReputacion);
        //Se reinicia la recompensa de la pregunta
        pregunta.setRecompensa(0);
        //Ahora se le otorgaran los 2 de recompensa al usuario que accepto la respuesta
        Integer reputacionUsuarioConectado = stack.getUsuarioConectado().getReputacion();
        //Se le suman dos de reputacion por haber aceptado una respuesta a una de sus preguntas
        Integer nuevaReputacionUsuarioConectado = reputacionUsuarioConectado + 2;
        //Se fija esa nueva reputacion
        stack.getUsuarioConectado().setReputacion(nuevaReputacionUsuarioConectado);
        System.out.println("Pregunta aceptada!");
    }

}
