package edu.masanz.da.lp;

import java.util.Scanner;

/**
 * Clase principal para ejecutar la aplicación de gestión de ligas de paddle.
 * Utiliza la clase GestorLigas para gestionar las ligas y la clase Gui para la interacción con el usuario.
 */
public class App {

    private GestorLigas gestorLigas;

    /**
     * Constructor de la clase App.
     */
    public App() {
        // TODO 11: instancia el GestorLigas e inicializa las ligas utilizando la clase Init

        GestorLigas nombreligas = new GestorLigas();
        Init ligas = new Init();

    }

    /**
     * Método principal para ejecutar la aplicación.
     */
    public void run() {
        // TODO 12: en un bucle muestra el menú, lee la opción y ejecuta la opción hasta que se elija salir.
//        Scanner teclado = new Scanner(System.in);
//        int numero= -1;

        while (true) {

            Gui.mostrarMenu();

            Scanner teclado = new Scanner(System.in);
            String texto = teclado.nextLine();

            int numero = Integer.parseInt(texto);

            if(numero==1 || numero==2 || numero==3 ||numero==4){

                ejecutarOpcion(numero);
            }else if (numero==0){
                salir();
                break;
            }else {
                opcionNoValida();
            }


        }





//            System.out.println("Introduce la opcion que quieras hacer, por favor:");
//           String texto = teclado.nextLine();
//           numero= Integer.parseInt(texto);

//           if(numero == 1){
//               gestorLigas.getListaLigas();
//           } else if (numero == 2) {
//               gestorLigas.getTablaResultadosLiga(1);
//
//           } else if (numero == 3) {
//               gestorLigas.getListadoCampeonesLigas();
//           } else if (numero == 4) {
//
//               gestorLigas.setMarcadorPartido(1,2,3,5,1,3);
//           } else if (numero == 0) {
//               System.out.println("Saliendo de la aplicación...");
//           }else {
//               System.out.println("Opcion no válida, inténtelo de nuevo");
//           }








    }

    /**
     * Ejecuta la opción seleccionada del menú.
     * @param numOpc Número de opción seleccionada.
     */
    private void ejecutarOpcion(int numOpc) {
        // TODO 13: implementa la ejecución de las opciones del menú utilizando un switch.
        // Llama a los métodos correspondientes para cada opción.

        switch (numOpc){

            case 1:
                listarEquiposLigas();
                break;
            case 2:
                mostrarTablaResultadosLiga();
                break;
            case 3:
                listarCampeonesLigas();
                break;
            case 4:
                anotarMarcadoresLiga();
                break;
            case 0:
                salir();
        }


















    }

    /**
     * Lista los equipos de las ligas disponibles.
     */
    private void listarEquiposLigas() {
        // TODO 14: muestra la lista de ligas, lee el número de liga y muestra la lista de equipos de la liga seleccionada.


        gestorLigas.getListaEquipos(1);



    }

    /**
     * Lista los campeones de las ligas.
     */
    private void listarCampeonesLigas() {
        // TODO 15: muestra el listado de campeones de todas las ligas.


        gestorLigas.getListadoCampeonesLigas();

    }

    /**
     * Muestra la tabla de resultados de una liga seleccionada.
     */
    private void mostrarTablaResultadosLiga() {
        // TODO 16: muestra la lista de ligas, lee el número de liga y muestra la tabla de resultados de la liga seleccionada.

    gestorLigas.getTablaResultadosLiga(1);

    }

    /**
     * Muestra la tabla de resultados de una liga específica.
     * @param numLiga Número de la liga.
     */
    private void mostrarTablaResultadosLiga(int numLiga) {
        // TODO 17: muestra la tabla de resultados de la liga indicada.

    gestorLigas.getTablaResultadosLiga(numLiga);

    }

    /**
     * Anota los marcadores de los partidos de una liga seleccionada.
     */
    private void anotarMarcadoresLiga() {
        // TODO 18: Para anotar los marcadores de los partidos de una liga seleccionada,
        // muestra la lista de ligas, lee el número de liga, muestra la lista de equipos,
        // permite al usuario seleccionar dos equipos y anotar los marcadores de sus partidos.
        // Muestra la tabla de resultados antes y después de anotar los marcadores.
        // Permite repetir el proceso hasta que el usuario decida salir.

        Scanner teclado = new Scanner(System.in);
        int opcion= -1;
        while (opcion != 0) {

            System.out.println("||| LIGAS DISPONIBLES |||");
            System.out.println(gestorLigas.getListaLigas());

            System.out.println("Selecciona el número de liga (0 para salir): ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if(opcion == 0){
                salir();
            }

            System.out.println("||| EQUIPOS DE LA LIGA " + opcion+ "|||");

            System.out.println(gestorLigas.getListaEquipos(opcion));

            System.out.println("||| TABLA ANTES DEL PARTIDO |||");
            System.out.println(gestorLigas.getTablaResultadosLiga(opcion));

            System.out.println("Selecciona el número del primer equipo: ");
            int numEquipo1 = teclado.nextInt();

            System.out.println("Selecciona el número del segundo equipo: ");
            int numEquipo2 = teclado.nextInt();

            System.out.println("Introduce los puntos del primer equipo");
            int puntos1 = teclado.nextInt();

            System.out.println("Introduce los puntos del suegundo equipo: ");
            int puntos2 = teclado.nextInt();


            gestorLigas.setMarcadorPartido(opcion,numEquipo1,numEquipo2,1,puntos1,puntos2);

            System.out.println("||| TABLA DESPUÉS DEL PARTIDO |||");
            System.out.println(gestorLigas.getTablaResultadosLiga(opcion));

            System.out.println("¿Deseas registrar otro partido? 1 = si, 0 = salir");
            opcion = teclado.nextInt();

        }






    }

    /**
     * Muestra un mensaje de salida: "Saliendo...".
     */
    private void salir() {
        Gui.mostrarTexto("Saliendo...");
    }

    /**
     * Muestra un mensaje de opción no válida: "Opción no válida".
     */
    private void opcionNoValida() {
        Gui.mostrarTexto("Opción no válida");
    }

    public static void main(String[] args) {
        App a = new App();
        a.anotarMarcadoresLiga();
    }
}
