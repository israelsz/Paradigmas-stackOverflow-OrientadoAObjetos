package StackOverflow;

import StackOverflow_Controller.Controlador;
import StackOverflow_Model.Stack;
import StackOverflow_View.Menu;

public class Main {

        public static void main(String[] args) {
                //Se crea un modelo:
                Stack stack = new Stack();
                //Se crea el controlador:
                Controlador controller =  new Controlador(stack);
                //Se crea la vista:
                Menu menu = new Menu(controller);

                //Se inicializa el menu
                menu.iniciarMenu();
        }
}
