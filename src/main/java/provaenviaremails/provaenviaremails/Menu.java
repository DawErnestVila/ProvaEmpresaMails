/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaenviaremails.provaenviaremails;

import static java.lang.System.exit;

/**
 *
 * @author ernest
 */
public class Menu {

    public static void mostrarMenu() {
        int opcio;

        opcio = ComprovacioInput.llegirInt("Selecciona una opció\n\n 1.Enviar Correu\n 2.Gestionar Persones\n 3.Sortir");
        switch (opcio) {
            case 1:
                submenuCorreu(opcio);
                break;
            case 2:

                break;
            case 3:
                exit(0);
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuCorreu(int opcio) {
        opcio = ComprovacioInput.llegirInt("Que vols fer?\n\n 1.Enviar Correu a Clients\n 2.Enviar Correu a Proveïdors\n 3.Enviar Correu a Potencials");
        switch (opcio) {
            case 1:
                MailController.selectUsr(opcio, Dades.getClients());
                break;
            case 2:
                MailController.selectUsr(opcio, Dades.getProveidors());
                break;
            case 3:
                MailController.selectUsr(opcio, Dades.getPotencials());
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

}
