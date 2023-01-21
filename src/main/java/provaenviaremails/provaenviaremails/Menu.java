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

        opcio = ComprovacioInput.llegirInt("\n\nSelecciona una opció\n\n 1.Enviar Correu\n 2.Gestionar Persones\n 0.Sortir");
        switch (opcio) {
            case 1: //Enviar Correu
                submenuCorreu(opcio);
                break;
            case 2: //Gestionar Persones
                submenuPersones(opcio);
                break;
            case 0: //Sortir
                exit(0);
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuCorreu(int opcio) {
        opcio = ComprovacioInput.llegirInt("Que vols fer?\n\n 1.Enviar Correu a Clients\n 2.Enviar Correu a Proveïdors\n 3.Enviar Correu a Potencials\n 0.Cancel·lar");
        switch (opcio) {
            case 1: //Enviar Correu a Clients
                MailController.selectUsr(opcio, Dades.getClients());
                break;
            case 2: //Enviar Correu a ProveÏdors
                MailController.selectUsr(opcio, Dades.getProveidors());
                break;
            case 3: //Enviar Correu a Potencials
                MailController.selectUsr(opcio, Dades.getPotencials());
                break;
            case 0: //Cancel·lar
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuPersones(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nQuè vols fer?\n 1.Afegir Persona\n 2.Eliminar Persona\n 3.Editar Persona\n 4.Mostrar Persones\n 0.Cancel·lar");
        switch (opcio) {
            case 1: //Afegir Persona
                submenuAfegir(opcio);
                break;
            case 2: //Eliminar Persona
                submenuEliminar(opcio);
                break;
            case 3: //Ediat Persona
                submenuEditar(opcio);
                break;
            case 4: //Mostrar les persones
                submenuMostrar(opcio);
                break;
            case 0: //Cancel·lar
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuAfegir(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nA què li vols afegir?\n 1.Clients\n 2.Proveidors\n 3.Potencials\n 0.Cancel·lar");
        switch (opcio) {
            case 1: //Afegir Client
                Dades.setClients(PersonesController.afegirPersona(Dades.getClients()));
                break;
            case 2: //Afegir ProveÏdor
                Dades.setProveidors(PersonesController.afegirPersona(Dades.getProveidors()));
                break;
            case 3: //Afegir Potencial
                Dades.setPotencials(PersonesController.afegirPersona(Dades.getPotencials()));
                break;
            case 0: //Cancel·lar
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuEliminar(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nA què li vols eliminar?\n 1.Clients\n 2.Proveidors\n 3.Potencials\n 0.Cancel·lar");
        switch (opcio) {
            case 1: //Eliminar Client
                Dades.setClients(PersonesController.eliminarPersona(Dades.getClients(), opcio));
                break;
            case 2: //Eliminar Proveïdor
                Dades.setProveidors(PersonesController.eliminarPersona(Dades.getProveidors(), opcio));
                break;
            case 3: //Eliminar Potencial
                Dades.setPotencials(PersonesController.eliminarPersona(Dades.getPotencials(), opcio));
                break;
            case 0: //Canel·lar
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuEditar(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nQuè li vols editar?\n 1.Clients\n 2.Proveidors\n 3.Potencials\n 0.Cancel·lar");
        switch (opcio) {
            case 1: //Editar Client
                Dades.setClients(PersonesController.editarPersones(Dades.getClients(), opcio));
                break;
            case 2: //Editar Proveïdor
                Dades.setProveidors(PersonesController.editarPersones(Dades.getProveidors(), opcio));
                break;
            case 3: //Editar Potencial
                Dades.setPotencials(PersonesController.editarPersones(Dades.getPotencials(), opcio));
                break;
            case 0: //Cancel·lar
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuMostrar(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nQuè vols mostrar?\n 1.Clients\n 2.Proveidors\n 3.Potencials\n 4.Tots\n 0.Cancel·lar");
        switch (opcio) {
            case 1: //Mostrar Clients
                PersonesController.mostrarPersones(Dades.getClients());
                break;
            case 2: //Mostrar Proveïdors
                PersonesController.mostrarPersones(Dades.getProveidors());
                break;
            case 3: //Mostrar Potencials
                PersonesController.mostrarPersones(Dades.getPotencials());
                break;
            case 4: //Mostrar Tots
                PersonesController.mostrarTots();
                break;
            case 0: //Cancel·lar
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

}
