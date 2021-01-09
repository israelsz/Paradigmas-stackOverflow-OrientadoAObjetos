package StackOverflow_Model;

import java.util.ArrayList;

public class Stack {

    //Atributos
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioConectado;
    private boolean conectado = false;
    private ArrayList<Etiqueta> etiquetas;


    //Constructor
    public Stack() {
        this.preguntas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.etiquetas = new ArrayList<>();

        Etiqueta etiqueta1 = new Etiqueta("Python","python es un lenguaje interpretado, multiparadigma que busca favorecer un codigo legible");
        ArrayList<Etiqueta> listaEtiqueta1 = new ArrayList<>();
        etiquetas.add(etiqueta1);
        listaEtiqueta1.add(etiqueta1);
        Etiqueta etiqueta2 = new Etiqueta("C","C es un lenguaje de alto rendimiento de proposito general fuertemente tipado");
        ArrayList<Etiqueta> listaEtiqueta2 = new ArrayList<>();
        etiquetas.add(etiqueta2);
        listaEtiqueta2.add(etiqueta2);
        Etiqueta etiqueta3 = new Etiqueta("Java","Java es un lenguaje de programacion de proposito general, que soporta la orientacion a objetos");
        ArrayList<Etiqueta> listaEtiqueta3 = new ArrayList<>();
        etiquetas.add(etiqueta3);
        listaEtiqueta3.add(etiqueta3);

        Pregunta pregunta1 = new Pregunta("Como hacer hola mundo en python",
                "Como el titulo dice, no conozco la funcion necesaria para poder mostrar hola mundo por pantalla en python",
                listaEtiqueta1);
        //Fecha 16/11/2020
        Pregunta pregunta2 = new Pregunta("Asignar memoria a un arreglo en C",
                "En C ¿como puedo asignar memoria a un arreglo?",
                listaEtiqueta2);
        //Fecha 16/11/2020
        Pregunta pregunta3 = new Pregunta("como printear cosas en java ?",
                "Hola soy nuevo al lenguaje java, que metodo puedo usar para printear una string por ejemplo ?",
                listaEtiqueta3);
        //Fecha 16/11/2020
        Pregunta pregunta4 = new Pregunta("librerias en python",
                "Hola como puedo instalar una libreria en python?",
                listaEtiqueta1);
        //Fecha 17/11/2020
        Pregunta pregunta5 = new Pregunta("definir clases en java",
                "¿Como puedo crear una nueva clase en java?",
                listaEtiqueta3);
        //Fecha 17/11/2020
        Usuario usuario1 = new Usuario("israel","qwerty");
        Usuario usuario2 = new Usuario("pedro","123");
        Usuario usuario3 = new Usuario("juan","asd");
        Usuario usuario4 = new Usuario("maria","hola123");



        Respuesta respuesta1 = new Respuesta("Hola, puedes usar malloc para asignarle memoria");
        //Fecha 18/11/2020
        Respuesta respuesta2 = new Respuesta("Intenta usar print(Hola mundo)");
        //Fecha 18/11/2020
        Respuesta respuesta3 = new Respuesta("Tambien puedes asignar la cantidad de elementos del arreglo, como int *arreglo[100]");
        //Fecha 18/11/2020
        Respuesta respuesta4 = new Respuesta("public class *nombre clase*, puedes cambiar el public a privado o al que necesites");
        //Fecha 19/11/2020
        Respuesta respuesta5 = new Respuesta("en la cmd usa el comando pip install *nombreLibreria*");
        //Fecha 19/11/2020
        Respuesta respuesta6 = new Respuesta("debes indicar la visibilidad el tipo de clase (public,private,abstract,etc) y su nombre");
        //Fecha 19/11/2020
        Respuesta respuesta7 = new Respuesta("el metodo  System.out.println(); deberia cumplir lo que quieres");
        //Fecha 19/11/2020
        Respuesta respuesta8 = new Respuesta("aportando a la respuesta anterior, dentro de los parentesis debes indicar lo que quieres imprimir");
        //Fecha 20/11/2020
        Respuesta respuesta9 = new Respuesta("Un ejemplo puede ser public class nuevaClase { }");
        //Fecha 20/11/2020
        Respuesta respuesta10 = new Respuesta("podrias usar print, muestra cosas por pantalla");
        //Fecha 20/11/2020

        pregunta1.setAutor(usuario1);
        pregunta1.setFecha("16/11/2020");
        pregunta1.agregarRespuesta(respuesta2);

        respuesta2.setAutor(usuario2);
        respuesta2.setFecha("18/11/2020");
        usuario2.agregarRespuesta(respuesta2);

        pregunta1.agregarRespuesta(respuesta10);
        respuesta10.setAutor(usuario3);
        respuesta10.setFecha("20/11/2020");
        usuario3.agregarRespuesta(respuesta10);
        usuario1.agregarPregunta(pregunta1);


        pregunta2.setFecha("16/11/2020");
        pregunta2.setAutor(usuario2);

        pregunta2.agregarRespuesta(respuesta1);
        respuesta1.setAutor(usuario1);
        respuesta1.setFecha("18/11/2020");
        usuario1.agregarRespuesta(respuesta1);

        pregunta2.agregarRespuesta(respuesta3);
        respuesta3.setAutor(usuario4);
        respuesta3.setFecha("18/11/2020");
        usuario4.agregarRespuesta(respuesta3);
        usuario2.agregarPregunta(pregunta2);


        pregunta3.setFecha("16/11/2020");
        pregunta3.setAutor(usuario3);

        pregunta3.agregarRespuesta(respuesta7);
        respuesta7.setAutor(usuario1);
        respuesta7.setFecha("19/11/2020");
        usuario1.agregarRespuesta(respuesta7);

        pregunta3.agregarRespuesta(respuesta8);
        respuesta8.setAutor(usuario4);
        respuesta8.setFecha("20/11/2020");
        usuario4.agregarRespuesta(respuesta8);
        usuario3.agregarPregunta(pregunta3);


        pregunta4.setFecha("17/11/2020");
        pregunta4.setAutor(usuario4);

        pregunta4.agregarRespuesta(respuesta5);
        respuesta5.setAutor(usuario1);
        respuesta5.setFecha("19/11/2020");
        usuario1.agregarRespuesta(respuesta5);
        usuario4.agregarPregunta(pregunta4);


        pregunta5.setFecha("17/11/2020");
        pregunta5.setAutor(usuario3);

        pregunta5.agregarRespuesta(respuesta4);
        respuesta4.setAutor(usuario4);
        respuesta4.setFecha("19/11/2020");
        usuario4.agregarRespuesta(respuesta4);

        pregunta5.agregarRespuesta(respuesta6);
        respuesta6.setAutor(usuario1);
        respuesta6.setFecha("19/11/2020");
        usuario1.agregarRespuesta(respuesta6);

        pregunta5.agregarRespuesta(respuesta9);
        respuesta9.setAutor(usuario2);
        respuesta9.setFecha("20/11/2020");
        usuario2.agregarRespuesta(respuesta9);
        usuario3.agregarPregunta(pregunta5);

        //Se agregan las preguntas y usuarios al stack

        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);
        preguntas.add(pregunta4);
        preguntas.add(pregunta5);

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
    }

    //Getters

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioConectado() {
        return usuarioConectado;
    }

    public boolean isConectado() {
        return conectado;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    //Setters

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuarioConectado(Usuario usuarioConectado) {
        this.usuarioConectado = usuarioConectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    //Metodos:

    //Muestra el stack por pantalla.
    public void printearStack(){

        ArrayList<Pregunta> listaPreguntas = getPreguntas();
        ArrayList<Usuario> listaUsuarios = getUsuarios();

        for(int i = 0; i < listaPreguntas.size();i++) {
            System.out.println("Pregunta: " + listaPreguntas.get(i).getTitulo() + "    Id: " + listaPreguntas.get(i).getId());
            System.out.println("Contenido: " + listaPreguntas.get(i).getContenido());
            System.out.println("Fecha :" + listaPreguntas.get(i).getFecha() + "    Estado: " + listaPreguntas.get(i).getEstado() + "    Autor: " + listaPreguntas.get(i).getAutor().getUsername() + "    Recompensa: " + listaPreguntas.get(i).getRecompensa() + "   Votos: " + listaPreguntas.get(i).getVotos());
            for (int j = 0; j < listaPreguntas.get(i).getEtiquetas().size(); j++) {
                System.out.println("Etiquetas: " + listaPreguntas.get(i).getEtiquetas().get(j).getNombreEtiqueta());
            }
            System.out.println("\nRespuestas a la pregunta: ");
            for (int j = 0; j < listaPreguntas.get(i).getRespuestas().size(); j++) {
                System.out.println("Respuesta: " + listaPreguntas.get(i).getRespuestas().get(j).getContenido());
                System.out.println(" Id: " + listaPreguntas.get(i).getRespuestas().get(j).getId() + "    Fecha: " + listaPreguntas.get(i).getRespuestas().get(j).getFecha());
                System.out.println(" Autor: " + listaPreguntas.get(i).getRespuestas().get(j).getAutor().getUsername() + "    Estado: " + listaPreguntas.get(i).getRespuestas().get(j).getEstado() + "    Votos: " + listaPreguntas.get(i).getRespuestas().get(j).getVotos() + "\n");
            }
        }
        System.out.println("\n Usuarios Registrados: ");
        for(int j = 0 ; j < listaUsuarios.size();j++){
            System.out.println("Nombre Usuario: "+ listaUsuarios.get(j).getUsername());
            System.out.println("Preguntas Realizadas(Id's): ");
            for(int k=0; k < listaUsuarios.get(j).getPreguntasRealizadas().size();k++){
                System.out.println(listaUsuarios.get(j).getPreguntasRealizadas().get(k).getId());
            }
            System.out.println("Respuestas realizadas(Id's): ");
            for(int k=0; k < listaUsuarios.get(j).getRespuestasRealizadas().size();k++){
                System.out.println(listaUsuarios.get(j).getRespuestasRealizadas().get(k).getId());
            }
            System.out.println("Reputacion: "+ listaUsuarios.get(j).getReputacion() + "\n");
        }
    }
}
