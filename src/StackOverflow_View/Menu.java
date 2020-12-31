package StackOverflow_View;

import StackOverflow_Controller.Controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //Atributos
    //Como atributo el menu tendra al controlador, para poder acceder a sus metodos
    private Controlador controller;

    //Constructor
    public Menu(Controlador controller){
        this.controller = controller;
    }

    //Getter
    public Controlador getController() {
        return controller;
    }

    //Metodos
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
                        case 1:
                            System.out.println("Eligió conectarse a su cuenta");
                            break;
                        case 2:
                            System.out.println("Eligió registrar una nueva cuenta");
                            break;
                        case 3:
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
                System.out.println("## Registrado como: "+ controlador.usernameUsuarioConectado() + " ##");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. Agregar nueva pregunta");
                System.out.println("2. Responder pregunta");
                System.out.println("3. Dar recompensa");
                System.out.println("4. Aceptar respuesta");
                System.out.println("5. Cerrar sesión");
                System.out.println("6. Votar a una pregunta o respuesta");
                System.out.println("7. Salir del programa");

                try {
                    System.out.println("Introduzca su opción: ");
                    opcion = input.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("Elegió hacer una pregunta:");
                            break;
                        case 2:
                            System.out.println("Elegió responder una pregunta: ");
                            break;
                        case 3:
                            System.out.println("Elegiste la opcion 3 del menu 2");
                            break;
                        case 4:
                            System.out.println("Elegiste la opcion 4 del menu 2");
                            break;
                        case 5:
                            System.out.println("Sesion cerrada.");
                            //Logout
                            controlador.logOut();
                            break;
                        case 6:
                            System.out.println("Elegiste votar por una pregunta o respuesta");
                            break;
                        case 7:
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
