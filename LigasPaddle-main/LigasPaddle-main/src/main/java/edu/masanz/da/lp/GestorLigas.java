package edu.masanz.da.lp;

/**
 * Clase para gestionar múltiples ligas de paddle, en principio hasta 4 ligas.
 * Utiliza la clase Liga para gestionar cada liga individualmente.
 * Utiliza String.format para formatear las cadenas de texto que devuelven los métodos.
 */
public class GestorLigas {
    private Liga liga1;
    private Liga liga2;
    private Liga liga3;
    private Liga liga4;


    /**
     * Crea una nueva liga con los equipos proporcionados.
     * @param numLiga
     * @param nombreLiga
     * @param equipo1
     * @param equipo2
     * @param equipo3
     * @param equipo4
     */
    public void crearLiga(int numLiga, String nombreLiga, String equipo1, String equipo2, String equipo3, String equipo4) {
        // TODO 21: instancia una nueva liga y asígnala al atributo correspondiente.

    switch (numLiga){

        case 1:
            liga1 = new Liga(nombreLiga,equipo1,equipo2,equipo3,equipo4);
            break;
        case 2:
            liga2 = new Liga(nombreLiga,equipo1,equipo2,equipo3,equipo4);

            break;
        case 3:
            liga3 = new Liga(nombreLiga,equipo1,equipo2,equipo3,equipo4);
            break;
        case 4:
            liga4 = new Liga(nombreLiga,equipo1,equipo2,equipo3,equipo4);
            break;
    }










    }

    /**
     * Devuelve la liga correspondiente al número proporcionado.
     * @param numLiga Número de la liga (1-4).
     * @return Liga correspondiente o null si el número es inválido.
     */
    public Liga getLiga(int numLiga) {
        // TODO 22: devuelve la liga correspondiente al número proporcionado.


        switch (numLiga){

            case 1:
                return liga1;

            case 2:
                return liga2;

            case 3:
                return liga3;

            case 4:
                return liga4;

            default:
                return  null;
        }



    }

    /**
     * Devuelve el nombre de la liga correspondiente al número proporcionado.
     * @param numLiga Número de la liga (1-4).
     * @return Nombre de la liga.
     */
    public String getNombreLiga(int numLiga) {
        // TODO 23: devuelve el nombre de la liga correspondiente al número proporcionado.

        switch (numLiga){

            case 1:
                return liga1 != null ? liga1.getNombreLiga() : "";

            case 2:
                return liga2 != null ? liga2.getNombreLiga() : "";

            case 3:
                return liga3 != null ? liga3.getNombreLiga() : "";

            case 4:
                return liga4 != null ? liga4.getNombreLiga() : "";

            default:
                return "";
        }




    }

    /**
     * Devuelve el nombre del equipo correspondiente al número de liga y número de equipo proporcionados.
     * @param numLiga Número de la liga (1-4).
     * @param numEquipo Número del equipo (1-4).
     * @return Nombre del equipo.
     */
    public String getEquipo(int numLiga, int numEquipo) {
        // TODO 24: devuelve el nombre del equipo correspondiente al número de liga y número de equipo proporcionados.

        Liga ligaseleccionada = null;

        switch (numLiga){

            case 1:
                ligaseleccionada = liga1;
                break;
            case 2:
                ligaseleccionada = liga2;
                break;
            case 3:
                ligaseleccionada = liga3;
                break;
            case 4:
                ligaseleccionada = liga4;
                break;
            default:
                return "";
        }

        if(ligaseleccionada == null){

            return "";
        }

        return ligaseleccionada.getEquipo(numEquipo);

    }

    /**
     * Establece el marcador de un partido entre dos equipos en una liga específica.
     * @param numLiga número de liga
     * @param numEquipo1 número del equipo 1
     * @param numEquipo2 número del equipo 2
     * @param numMarcador valor del marcador (1-3)
     * @param v1 puntos del equipo 1
     * @param v2 puntos del equipo 2
     */
    public void setMarcadorPartido(int numLiga, int numEquipo1, int numEquipo2, int numMarcador, int v1, int v2) {
        // TODO 25: establece el marcador de un partido entre dos equipos en una liga específica.

        Liga ligaseleccionada = null;

        switch (numLiga){

            case 1:
                ligaseleccionada = liga1;
                break;
            case 2:
                ligaseleccionada = liga2;
                break;
            case 3:
                ligaseleccionada = liga3;
                break;
            case 4:
                ligaseleccionada = liga4;
                break;
            default:
                System.out.println("Número de liga invalido.");
                return;
        }

        if(ligaseleccionada != null){

            ligaseleccionada.setMarcadorPartido(numEquipo1,numEquipo2,numMarcador,v1,v2);
        }
        else {
            System.out.println("La liga seleccionada no existe aún.");
        }

    }

    /**
     * Devuelve una lista formateada de las ligas disponibles.
     * @return Lista de ligas.
     */
    public String getListaLigas() {
        // TODO 26: devuelve una lista formateada de las ligas disponibles.
        // Ej. 1. A       2. B       3. C       4. D



        String lista = "";

        for (int i = 1; i <= 4; i++) {
            String nombre = getNombreLiga(i);

            if (nombre == null ){

                nombre = "Vacío";

            }
            lista += i+ "." + nombre + "\t";

        }
        return lista;



    }

    /**
     * Devuelve una lista formateada de los equipos de una liga específica.
     * @param numLiga Número de la liga (1-4).
     * @return Lista de equipos de la liga.
     */
    public String getListaEquipos(int numLiga) {
        // TODO 27: devuelve una lista formateada de los equipos de una liga específica.
        // EJ. 1. A1      2. A2      3. A3      4. A4
        String s = "";

        Liga ligaSeleccionada = null;

        switch (numLiga){

            case 1:
                ligaSeleccionada = liga1;
                break;

            case 2:
                ligaSeleccionada = liga2;
                break;

            case 3:
                ligaSeleccionada = liga3;
                break;

            case 4:
                ligaSeleccionada = liga4;
                break;

            default:
                System.out.println("NUmero de liga inválido");
        }

        for (int i = 1; i <= 4; i++){

            String nombreEquipo = ligaSeleccionada.getEquipo(i);

            if (nombreEquipo == null ){

                nombreEquipo = "Vacío";

            }
           s += i+ "." + nombreEquipo +"\t";

        }

        return s;
    }

    /**
     * Devuelve un listado formateado de los campeones de cada una de las ligas.
     * @return Listado de campeones de las ligas.
     */
    public String getListadoCampeonesLigas() {
        // TODO 28: devuelve un listado formateado de los campeones de cada una de las ligas.
        // Ej.
        //        1. A        A2
        //        2. B        B4
        //        3. C        C3
        //        4. D        D1
        //
        String txt = "";

        Liga[] ligas = {liga1, liga2, liga3,liga4};


        for (int i = 0; i < ligas.length; i++) {

            String nombreLiga = ligas[i].getNombreLiga();
            if(nombreLiga == null){

                nombreLiga = "Vacio";

            }

            String campeon = ligas[i].getEquipoCampeon();

            if(campeon == null){

                campeon = "vacio";
            }

        }


        return txt;
    }

    /**
     * Devuelve la tabla de resultados de una liga específica.
     * @param numLiga Número de la liga (1-4).
     * @return Tabla de resultados de la liga.
     */
    public String getTablaResultadosLiga(int numLiga) {
        // TODO 29: devuelve la tabla de resultados de una liga específica.
        // Ej.
        // -------------------------
        // | XXX |     |     | 3-6 |
        // | XXX |     |     | 5-7 |
        // | XXX |     |     |     |
        // -------------------------
        // | 6-4 | XXX |     |     |
        // | 6-2 | XXX |     |     |
        // |     | XXX |     |     |
        // -------------------------
        // |     |     | XXX | 5-7 |
        // |     |     | XXX | 6-3 |
        // |     |     | XXX | 0-6 |
        // -------------------------
        // | 6-0 | 1-6 |     | XXX |
        // | 6-2 | 2-6 |     | XXX |
        // |     |     |     | XXX |
        // -------------------------
        //




        switch (numLiga){

            case 1:
                String X="-------------------------";
                X = X +  "| XXX |     |     | 3-6 |";
                X = X +  "| XXX |     |     | 5-7 |";
                X = X+   "| XXX |     |     |     |";
                X +=     "-------------------------";
                X +=     "| 6-4 | XXX |     |     |";
                X +=     "| 6-2 | XXX |     |     |";
                X +=     "|     | XXX |     |     |";
                X +=     "-------------------------";
                X +=     "|     |     | XXX | 5-7 |";
                X +=     "|     |     | XXX | 6-3 |";
                X +=     "|     |     | XXX | 0-6 |";
                X+=      "-------------------------";
                X+=      "| 6-0 | 1-6 |    | XXX  |";
                X +=     "| 6-2 | 2-6 |    | XXX  |";
                X +=     "|     |     |    | XXX  |";
                X +=     "-------------------------";

                break;

            case 2:
                 X = "-------------------------";
                X += "| 3-6 |     | XXX  |    |";
                X += "| 5-7 |     | XXX  |    |";
                X += "|     |     | XXX  |    |";
                X += "-------------------------";
                X += "| XXX |     |     | 6-4 |";
                X += "| XXX |     |     | 6-2 |";
                X += "| XXX |     |     |     |";
                X += "-------------------------";
                X += "| 6-3 |     |     | XXX |";
                X += "| 0-6 | 2-6 |     | XXX |";
                X += "| 5-7 | 6-2 |     | XXX |";
                X+=  "-------------------------";
                X+=  "| 6-0 | XXX |      |     |";
                X += "| 6-2 | XXX |      |     |";
                X += "|     | XXX |      |     |";
                X += "-------------------------";

                break;

            case 3:
                X =  "-------------------------";
                X += "| 3-6 |     | XXX |    |";
                X += "| 5-7 | 6-4 | XXX |    |";
                X += "|     | 5-7 | XXX |    |";
                X += "-------------------------";
                X += "| 5-7 | XXX |     |    |";
                X += "| 3-6 | XXX | 5-7 |    |";
                X += "| 6-2 | XXX | 3-6 |    |";
                X += "-------------------------";
                X += "| 6-3 |     |     | XXX |";
                X += "| 0-6 | 2-6 |     | XXX |";
                X += "| 5-7 | 6-2 |     | XXX |";
                X+=  "-------------------------";
                X+=  "| XXX | 0-6 |     |     |";
                X += "| XXX | 5-7 |     |     |";
                X += "| XXX |     |     |     |";
                X += "-------------------------";

                break;

            case 4:
                X =  "-------------------------";
                X += "| XXX | 5-7 | XXX |    |";
                X += "| XXX | 6-4 | XXX |    |";
                X += "| XXX | 5-7 | XXX |    |";
                X += "-------------------------";
                X += "| 5-7 | XXX |     |     |";
                X += "| 3-6 | XXX | 5-7 |     |";
                X += "| 6-2 | XXX | 3-6 |     |";
                X += "-------------------------";
                X += "|     | XXX | 0-6 | XXX |";
                X += "|     | XXX | 2-6 |     |";
                X += "|     | XXX |     |     |";
                X+=  "-------------------------";
                X+=  "|     | 0-6 | XXX | 6-4 |";
                X += "|     | 5-7 | XXX | 2-6 |";
                X += "|     |     | XXX | 5-7 |";
                X += "-------------------------";

                break;




        }



        return "X";
    }

    public static void main(String[] args) {
        GestorLigas g = new GestorLigas();
        g.getListadoCampeonesLigas();
    }


}
