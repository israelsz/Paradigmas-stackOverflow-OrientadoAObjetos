package StackOverflow_View;

import StackOverflow_Controller.Controlador;
import StackOverflow_Model.Etiqueta;
import StackOverflow_Model.Pregunta;
import StackOverflow_Model.Respuesta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase correspondiente a la parte del Visor.
 * Corresponde al menu principal del programa
 * Mediante el cual el usuario interactuara con el programa.
 * @author Israel Arias Panez
 */
public class Menu {
    //Atributos
    //Como atributo el menu tendra al controlador, para poder acceder a sus metodos
    private Controlador controller;

    //Constructor

    /**
     * Crea un menu, usando el controlador.
     * @param controller Instancia del controlador.
     */
    public Menu(Controlador controller){
        this.controller = controller;
    }

    //Getter

    public Controlador getController() {
        return controller;
    }

    //Metodos

    /**
     * Inicia el menú, entonces el programa inicia su ejecución.
     */
    public void iniciarMenu(){
        Scanner input = new Scanner(System.in);
        boolean salirMenu = false;
        int opcion;
        String username;
        String password;
        Controlador controlador = getController();
        while(!salirMenu){
            if(!controlador.isUsuarioConectado()){
                System.out.println("### Sistema de foro StackOverflow ###");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. Conectarse a su cuenta");
                System.out.println("2. Registrar una nueva cuenta");
                System.out.println("3. Salir del programa");

                try {
                    System.out.println("Introduzca su opción: ");
                    opcion = input.nextInt();
                    switch (opcion){
                        case 1: //Conectarse a su cuenta
                            System.out.println("Eligió conectarse a su cuenta");
                            System.out.println("Ingrese su nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese su contraseña:");
                            password = input.nextLine();
                            controlador.login(username,password);
                            break;
                        case 2: //Registrar una nueva cuenta
                            System.out.println("Eligió registrar una nueva cuenta");
                            System.out.println("Ingrese su nombre de usuario: ");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese su contraseña:");
                            password = input.nextLine();
                            controlador.register(username,password);
                            break;
                        case 3: //Salir del programa
                            System.out.println("Elegiste salir del programa");
                            salirMenu = true;
                            break;
                        default:
                            System.out.println("Debe seleccionar una de las opciones presentadas !");
                            break;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Solo puede ingresar números dentro del menú");
                    input.next();
                }
            } else {
                System.out.println("### Sistema de foro StackOverflow ###");
                System.out.println("## Registrado como: "+ controlador.usuarioConectado().getUsername() + " ##");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. Agregar nueva pregunta");
                System.out.println("2. Responder pregunta");
                System.out.println("3. Dar recompensa");
                System.out.println("4. Aceptar respuesta");
                System.out.println("5. Votar a una pregunta o respuesta");
                System.out.println("6. Mostrar todas las preguntas, respuestas y usuarios del foro por pantalla");
                System.out.println("7. Cerrar sesión");
                System.out.println("8. Salir del programa");

                try {
                    System.out.println("Introduzca su opción: ");
                    opcion = input.nextInt();
                    switch (opcion){
                        case 1: //Agregar nueva pregunta
                            System.out.println("Elegió hacer una pregunta:");
                            System.out.println("Ingrese el título de su pregunta:");
                            input.nextLine();
                            String titulo = input.nextLine();
                            System.out.println("Ingrese el contenido de su pregunta:");
                            String contenido = input.nextLine();
                            //Se llama al metodo para crear las etiquetas que tendra la pregunta
                            ArrayList<Etiqueta> listaEtiquetas = controlador.elegirEtiquetas();
                            //Se llama a ask:
                            controlador.ask(titulo,contenido,listaEtiquetas);
                            break;
                        case 2:
                            System.out.println("Elegió responder una pregunta: ");
                            Pregunta preguntaElegida = controlador.elegirPregunta();
                            System.out.println("Ingrese el contenido de la respuesta:");
                            input.nextLine();
                            String contenidoRespuesta = input.nextLine();
                            //Se llama al metodo Answer
                            controlador.answer(preguntaElegida,contenidoRespuesta);
                            break;
                        case 3:
                            System.out.println("Elegió dar una recompensa");
                            preguntaElegida = controlador.elegirPregunta();
                            System.out.println("Usted tiene " + controlador.usuarioConectado().getReputacion() +" de recompensa");
                            System.out.println("¿Cuanta recompensa desea ofrecer a la pregunta?");
                            Integer recompensaOfrecida = input.nextInt();
                            if(recompensaOfrecida > controlador.usuarioConectado().getReputacion()){
                                System.out.println("No puede dar más recompensa de la que usted tiene !");
                                break;
                            }
                            //Se llama a reward
                            controlador.reward(preguntaElegida,recompensaOfrecida);
                            break;
                        case 4:
                            System.out.println("Eligió aceptar una respuesta");
                            Integer cantidadPreguntasUsuario = controlador.mostrarPreguntasYRespuestasDelUsuario();
                            if(cantidadPreguntasUsuario != 0){
                                preguntaElegida = controlador.elegirPreguntaAccept();
                                Respuesta respuestaElegida = controlador.elegirRespuestaAccept(preguntaElegida);
                                //Se llama a accept
                                controlador.accept(preguntaElegida,respuestaElegida);
                                break;
                            } else {
                                System.out.println("Usted no tiene preguntas o todas sus preguntas se encuentran cerradas");
                            }
                            break;
                        case 5:
                            System.out.println("Elegió votar por una pregunta o respuesta");
                            controlador.mostrarPreguntasYRespuestasNoPertenecientesAlUsuario();
                            System.out.println("¿Desea elegir una pregunta o una respuesta para votar?");
                            System.out.println("1. Pregunta");
                            System.out.println("2. Respuesta");
                            Integer eleccionPreguntaRespuesta = input.nextInt();
                            //En caso de haber escogido una pregunta
                            if(eleccionPreguntaRespuesta == 1){
                                Pregunta preguntaEscogida = controlador.elegirPreguntaVote();
                                System.out.println("Desea votar positiva o negativamente por la pregunta?");
                                System.out.println("1. Positivamente");
                                System.out.println("2. Negativamente");
                                Integer tipoVoto = input.nextInt();
                                if(tipoVoto == 1){
                                    controlador.vote(preguntaEscogida,true);
                                } else {
                                    controlador.vote(preguntaEscogida, false);
                                }
                            //En caso de haber escogido una respuesta
                            } else{
                                Respuesta respuestaEscogida = controlador.elegirRespuestaVote();
                                System.out.println("Desea votar positiva o negativamente por la respuesta?");
                                System.out.println("1. Positivamente");
                                System.out.println("2. Negativamente");
                                Integer tipoVoto = input.nextInt();
                                if(tipoVoto == 1){
                                    controlador.vote(respuestaEscogida,true);
                                } else {
                                    controlador.vote(respuestaEscogida, false);
                                }
                            }
                            break;
                        case 6:
                            controlador.printStack();
                            break;
                        case 7:
                            System.out.println("Sesion cerrada.");
                            //Logout
                            controlador.logOut();
                            break;
                        case 8:
                            System.out.println("Elegiste salir del programa");
                            salirMenu = true;
                            break;
                        default:
                            System.out.println("Debe seleccionar una de las opciones presentadas !");
                            break;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Solo puede ingresar números dentro del menú");
                    input.next();
                }
            }
        }
    }
}
