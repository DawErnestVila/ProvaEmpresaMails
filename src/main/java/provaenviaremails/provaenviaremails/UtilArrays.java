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

    public static String[][] afegirObjecte(String[] ArrayObjecte, String[][] ArrayObjectesAux) {
        //Recorrem la 2a dimensió de l'array dels objectes auxiliar
        for (int i = 0; i < ArrayObjectesAux[0].length; i++) {
            //Assignem a la ultima posició el nou objecte a afegir
            ArrayObjectesAux[ArrayObjectesAux.length - 1][i] = ArrayObjecte[i];
        }
        //Retornem l'array auxiliar
        return ArrayObjectesAux;
    }

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

    public static String[][] editarObjecte(int id, String[] ArrayObjecte, String[][] ArrayObjectesAux) {
        //Recorrem la 2a dimensió de l'array dels objectes
        for (int i = 1; i < ArrayObjectesAux[0].length; i++) {
            //Assignem a l'array auxiliar les dades de l'array
            ArrayObjectesAux[id][i] = ArrayObjecte[i];
        }
        //Retornem l'array auxiliar
        return ArrayObjectesAux;
    }

    static String[] ferCreixerArray(String[] idEnviar) {
        //Creem una array auxiliar amb una poscició més
        String[] aux = new String[idEnviar.length + 1];
        //Recorrem l'array copiant els valors a l'array auxiliar
        for (int i = 0; i < idEnviar.length; i++) {
            aux[i] = idEnviar[i];
        }
        //Retornem l'array auxiliar amb els valors copiats i un espai buit al final
        return aux;
    }
}
