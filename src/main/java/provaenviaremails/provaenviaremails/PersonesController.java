/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaenviaremails.provaenviaremails;

/**
 *
 * @author ernes
 */
public class PersonesController {

    public static void mostrarPersonesEmail(String[][] persones) {
        System.out.printf("%3s    %-40s %-30s\n", "ID", "Nom", "Email");
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < persones.length; i++) {
            System.out.printf("%3s.   %-40s %-40s\n", persones[i][0], persones[i][1], persones[i][2]);
        }
    }

    public static void mostrarPersones(String[][] persones) {
        System.out.printf("%3s    %-40s     %-30s\n", "ID", "Nom", "Email");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < persones.length; i++) {
            System.out.printf("%3s.   %-40s %-40s\n", persones[i][0], persones[i][1], persones[i][2]);
        }
    }

    /**
     * Funció que serveix per demanar tota la informació del producte
     *
     * @param persona Array 1D on es guardarà la informació del producte
     * @param persones Array on hi han tots els productes
     * @param categories Array on hi han les categories
     * @param seguir Bool que mentres sigui fals va demanant el nom del producte
     * @return Retorna l'array 1D amb tota la info del producte
     */
    private static String[] demanarInfoPersona(String[] persona, String[][] persones) {
        boolean seguir;
        //Fem un doWhile mentres seguir sigui fals
        do {
            //Li demanem el nom del producte
            persona[1] = ComprovacioInput.llegirString("Entra el nom de la persona");
            seguir = true;
            //Recorrem l'array de productes
            for (int i = 0; i < persones.length && seguir; i++) {
                //Comprovem si ja existeix un producte el nom del nou producte
                if (persones[i][1].equalsIgnoreCase(persona[1])) {
                    //Si existeix li diem que ja existeix i li tornem a demanar
                    seguir = false;
                    System.out.println("El nom de la persona ja existeix");
                    break;
                } else {
                    //Si no existeix canviem el bool de seguir a true per sortir del bucle
                    seguir = true;
                }
            }
        } while (!seguir);

        //Fem un doWhile mentres seguir sigui fals
        do {
            //Li demanem l'stock que hi ha
            persona[2] = ComprovacioInput.llegirEmail("Entra l'email");
            seguir = true;
            //Recorrem l'array de productes
            for (int i = 0; i < persones.length && seguir; i++) {
                //Comprovem si ja existeix un producte el nom del nou producte
                if (persones[i][2].equalsIgnoreCase(persona[2])) {
                    //Si existeix li diem que ja existeix i li tornem a demanar
                    seguir = false;
                    System.out.println("Aquest correu ja existeix");
                    break;
                } else {
                    //Si no existeix canviem el bool de seguir a true per sortir del bucle
                    seguir = true;
                }
            }
        } while (!seguir);

        //Retornem l'array amb la informació del producte
        return persona;
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

    /**
     * Funció que serveix per eliminar un producte
     *
     * @param persones Array on hi han les persones
     * @param posicio La posició de la persona dins l'array
     * @return
     */
    public static String[][] eliminarPersona(String[][] persones, int posicio) {
        String[][] aux;
        mostrarPersones(persones);
        //Li demanem el producte a l'usuari
        switch (posicio) {
            case 1:
                posicio = getPositionbyId(Dades.getClients());
                break;
            case 2:
                posicio = getPositionbyId(Dades.getProveidors());
                break;
            case 3:
                posicio = getPositionbyId(Dades.getPotencials());
                break;
            default:
                System.out.println("ERROR");
        }
        //creem un nou array amb 1 posició menys
        aux = new String[persones.length - 1][persones[0].length];
        //copiem tots els elements
        for (int i = 0, j = 0; i < persones.length; i++) {
            if (i != posicio) {
                UtilArrays.delObjecte(i, j, aux, persones);
                j++;
            }
        }
        //intercanviem valors
        persones = aux;
        return persones;
    }

    /**
     * Funció que serveix per afegir un nou producte
     *
     * @param persones Array on hi han els productes
     * @return Retorna l'array de prodcutes amb el nou producte afegit
     */
    public static String[][] afegirPersona(String[][] persones) {
        String[] persona = new String[3];
        String[][] aux;

        //Comprovem si hi han productes a l'array de productes
        if (persones.length == 0) {
            //Si no n'hi han assignem la ID del producte a 0
            persona[0] = "0";
        } else {
            //Si n'hi han agafem la ultima ID i li sumem 1 i li assignem
            persona[0] = String.valueOf(Integer.parseInt(persones[persones.length - 1][0]) + 1);
        }
        //Li demanem la informació del producte
        persona = demanarInfoPersona(persona, persones);
        //Creem una array auxiliar amb 1 posició més
        aux = new String[persones.length + 1][3];
        //Copiem els valors
        aux = UtilArrays.copiarObjectes(aux, persones);
        //Afegim el nou producte
        aux = UtilArrays.afegirObjecte(persona, aux);
        //Intercanviem els valors
        persones = aux;
        //Retornem l'array de productes amb el nou producte afegit
        return persones;
    }

    /**
     * Funció que serviex per editat tota la informació del producte
     *
     * @param persones Array on hi han els productes
     * @param posicio La posició dins l'array del producte que selecciona l'usuari
     * @return Retorna l'array de productes amb el producte editat
     */
    public static String[][] editarPersones(String[][] persones, int posicio) {
        String[] persona = new String[3];
        String[][] aux;

        mostrarPersones(persones);
        //Li demanem quin producte vol editar
        posicio = getPositionbyId(Dades.getClients());
        //Li demanem la informació del producte
        persona = demanarInfoPersona(persona, persones);
        //Assignem la ID actual al array de informació
        persona[0] = persones[posicio][0];
        //Recorrem l'array de informació
        for (int i = 0; i < persona.length; i++) {
            //Assignem a cada posició la nova informació
            persones[posicio][i] = persona[i];
        }
        //Retornem l'array de productes amb el producte editat
        return persones;
    }
}
