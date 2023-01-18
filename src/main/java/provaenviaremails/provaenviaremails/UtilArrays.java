/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaenviaremails.provaenviaremails;

/**
 *
 * @author ernest
 */
public class UtilArrays {

    /**
     * Funció que serveix per afegir la informació de una array de una dimensió a la ultima posició de una array bidimensional
     *
     * @param ArrayObjecte Array 1D amb la informació a afegir
     * @param ArrayObjectesAux Array 2D on s'afegirà la nova informació
     * @return Retorna l'array amb la nova informació ja afegida
     */
    public static String[][] afegirObjecte(String[] ArrayObjecte, String[][] ArrayObjectesAux) {
        //Recorrem la 2a dimensió de l'array dels objectes auxiliar
        for (int i = 0; i < ArrayObjectesAux[0].length; i++) {
            //Assignem a la ultima posició el nou objecte a afegir
            ArrayObjectesAux[ArrayObjectesAux.length - 1][i] = ArrayObjecte[i];
        }
        //Retornem l'array auxiliar
        return ArrayObjectesAux;
    }

    /**
     * Funció que serveix per copiar la informació de un array a un altre
     *
     * @param ArrayObjectesAux Array auxiliar on es copiarà la informació
     * @param ArrayObjectes Array de on hi ha la informació
     * @return Es retorna l'array auxiliar amb la informació ja copiada
     */
    public static String[][] copiarObjectes(String[][] ArrayObjectesAux, String[][] ArrayObjectes) {
        //Recorrem la 1a dimensió de l'array dels objectes
        for (int i = 0; i < ArrayObjectes.length; i++) {
            //Recorrem la 2a dimensió de l'array dels objectes
            for (int j = 0; j < ArrayObjectes[0].length; j++) {
                //Assignem a l'array auxiliar les dades de l'array
                ArrayObjectesAux[i][j] = ArrayObjectes[i][j];
            }
        }
        //Retornem l'array auxiliar
        return ArrayObjectesAux;
    }

    /**
     * Funció que serveix per borrar un objecte dins una array, s'ha d'utilitzar dins bucles
     *
     * @param i Posició i del bucle
     * @param j Posició j del bucle
     * @param ArrayObjectesAux Array auxiliar on es copiarà la informació
     * @param ArrayObjectes Array de on hi ha la informació
     * @return Retorna l'array auxiliar amb l'objecte ja eliminat
     */
    public static String[][] delObjecte(int i, int j, String[][] ArrayObjectesAux, String[][] ArrayObjectes) {
        //Recorrem la 1a dimensió de l'array dels objectes
        for (int k = 0; k < ArrayObjectes.length; k++) {
            //Recorrem la 2a dimensió de l'array dels objectes
            for (int l = 0; l < ArrayObjectes[0].length; l++) {
                //Assignem a l'array auxiliar les dades de l'array
                ArrayObjectesAux[j][l] = ArrayObjectes[i][l];
            }
        }
        //Retornem l'array auxiliar
        return ArrayObjectesAux;
    }

    /**
     * Funció que serveix per editar un objecte que ja existeix
     *
     * @param id ID de l'objecte a editar
     * @param ArrayObjecte Array amb la informació del objecte a editar
     * @param ArrayObjectesAux Array auxiliar on hi ha la informació
     * @return Retorna la array amb l'objecte ja canviat
     */
    public static String[][] editarObjecte(int id, String[] ArrayObjecte, String[][] ArrayObjectesAux) {
        //Recorrem la 2a dimensió de l'array dels objectes
        for (int i = 1; i < ArrayObjectesAux[0].length; i++) {
            //Assignem a l'array auxiliar les dades de l'array
            ArrayObjectesAux[id][i] = ArrayObjecte[i];
        }
        //Retornem l'array auxiliar
        return ArrayObjectesAux;
    }

    public static int getPositionbyId(String[][] persones) {
        int posicio = -1, id = -1;
        boolean trobat;
        trobat = false;
        //Fem un bucle mentres no trobem el producte
        while (!trobat) {
            //Es demana la id del producte a l'usuari
            id = ComprovacioInput.llegirInt("Selecciona un usuari");
            //Recorrem l'array de productes
            for (int i = 0; i < persones.length; i++) {
                //Comprovem si la ID que ha entrat l'usuari coincideix amb la ID del producte dins l'array
                if (id == Integer.parseInt(persones[i][0])) {
                    //Si és aixi canviem el trobat a true i assignem a la posició el valor de i
                    trobat = true;
                    posicio = i;
                    break;
                }
            }
        }
        //Retornem la posició del producte
        return posicio;
    }

    static String[] ferCreixerArray(String[] idEnviar) {
        String[] aux = new String[idEnviar.length + 1];
        for (int i = 0; i < idEnviar.length; i++) {
            aux[i] = idEnviar[i];
        }
        return aux;
    }
}
