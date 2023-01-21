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

    public static void mostrarTots() {

        //Assignem a l'array de persones l'array de clients i mostrem els clients amb format
        String[][] persones = Dades.getClients();
        System.out.println("    #############");
        System.out.println("       CLIENTS");
        System.out.println("    #############");
        mostrarPersones(persones);
        System.out.println("\n");

        //Assignem a l'array de persones l'array de proveïdors i mostrem els proveïdors amb format
        persones = Dades.getProveidors();
        System.out.println("    ##############");
        System.out.println("      PROVEÏDORS");
        System.out.println("    ##############");
        mostrarPersones(persones);
        System.out.println("\n");

        //Assignem a l'array de persones l'array de potencials i mostrem els potencials amb format
        persones = Dades.getPotencials();
        System.out.println("    ##############");
        System.out.println("      POTENCIALS");
        System.out.println("    ##############");
        mostrarPersones(persones);
    }

    public static void mostrarPersones(String[][] persones) {
        //Mostrem les persones de l'array amb format
        System.out.printf("%3s    %-40s     %-30s\n", "ID", "Nom", "Email");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < persones.length; i++) {
            System.out.printf("%3s.   %-40s %-40s\n", persones[i][0], persones[i][1], persones[i][2]);
        }
    }

    private static String[] demanarInfoPersona(String[] persona, String[][] persones) {
        boolean seguir;
        //Fem un doWhile mentres seguir sigui fals
        do {
            //Li demanem el nom de la persona
            persona[1] = ComprovacioInput.llegirString("Entra el nom de la persona");
            seguir = true;
            //Recorrem l'array de persones
            for (int i = 0; i < persones.length && seguir; i++) {
                //Comprovem si ja existeix una persona el nom de la nova persona
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
            //Li demanem l'email de la persona
            persona[2] = ComprovacioInput.llegirEmail("Entra l'email");
            seguir = true;
            //Recorrem l'array de persones
            for (int i = 0; i < persones.length && seguir; i++) {
                //Comprovem si ja existeix una persona l'email de la nova persona
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

        //Retornem l'array amb la informació de la nova persona
        return persona;
    }

    public static int getPositionbyId(String[][] persones) {
        int posicio = -1, id = -1;
        boolean trobat;
        trobat = false;
        //Fem un bucle mentres no trobem la persona
        while (!trobat) {
            //Es demana la id de la persona a l'usuari
            id = ComprovacioInput.llegirInt("Selecciona un usuari (-1 per cançel·lar)");
            //Comprovem si la id que ha entrat és -1
            if (id == -1) {
                //Si ho és assignem la id a la posicioó i sortim del bucle
                System.out.println("Cacelant...");
                posicio = id;
                break;
            } else {
                //Si no és -1 recorrem l'array de persones
                for (int i = 0; i < persones.length; i++) {
                    //Comprovem si la ID que ha entrat l'usuari coincideix amb la ID de la persona dins l'array
                    if (id == Integer.parseInt(persones[i][0])) {
                        //Si és aixi canviem el trobat a true i assignem a la posició el valor de i
                        trobat = true;
                        posicio = i;
                        break;
                    }
                }
            }
        }
        //Retornem la posició de la persona
        return posicio;
    }

    public static String[][] eliminarPersona(String[][] persones, int posicio) {
        String[][] aux;
        //Mostrem les persones
        mostrarPersones(persones);
        //Li demanem la persona a l'usuari
        posicio = getPositionbyId(persones);
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

    public static String[][] afegirPersona(String[][] persones) {
        String[] persona = new String[3];
        String[][] aux;

        //Comprovem si hi han persones a l'array de persones
        if (persones.length == 0) {
            //Si no n'hi han assignem la ID de la persona a 0
            persona[0] = "0";
        } else {
            //Si n'hi han agafem la ultima ID, li sumem 1 i li assignem
            persona[0] = String.valueOf(Integer.parseInt(persones[persones.length - 1][0]) + 1);
        }
        //Li demanem la informació de la persona
        persona = demanarInfoPersona(persona, persones);
        //Creem una array auxiliar amb 1 posició més
        aux = new String[persones.length + 1][3];
        //Copiem els valors
        aux = UtilArrays.copiarObjectes(aux, persones);
        //Afegim la nova persona
        aux = UtilArrays.afegirObjecte(persona, aux);
        //Intercanviem els valors
        persones = aux;
        //Retornem l'array de persona amb la nova persona afegid
        return persones;
    }

    public static String[][] editarPersones(String[][] persones, int posicio) {
        String[] persona = new String[3];
        String[][] aux;

        mostrarPersones(persones);
        //Li demanem quina persona vol editar
        posicio = getPositionbyId(Dades.getClients());
        if (posicio != -1) {
            //Li demanem la informació de la persona
            persona = demanarInfoPersona(persona, persones);
            //Assignem la ID actual al array de informació
            persona[0] = persones[posicio][0];
            //Recorrem l'array de informació
            for (int i = 0; i < persona.length; i++) {
                //Assignem a cada posició la nova informació
                persones[posicio][i] = persona[i];
            }
        } else {
            System.out.println("Cancel·lat");
        }
        //Retornem l'array de productes amb el producte editat
        return persones;
    }

    public static boolean comprovarSeleccionat(String[] persones, int id, boolean hiEs) {
        //Comprovem si l'array de persones és superior a 0
        if (persones.length > 0) {
            //Si ho és recorrem l'array de persones
            for (int i = 0; i < persones.length; i++) {
                //Comprovem si la id que ha seleccionat l'usuari està a l'array
                if (String.valueOf(id).equalsIgnoreCase(persones[i])) {
                    //Si ho és canviem el bool de hiEs a true i sortim del bucle
                    hiEs = true;
                    break;
                } else {
                    //Si no canviem el bool de hiEs a false
                    hiEs = false;
                }
            }
        } else {
            //Si l'array de persones no és superior a 0 canviem el bool de hiEs a false
            hiEs = false;
        }
        return hiEs;
    }
}
