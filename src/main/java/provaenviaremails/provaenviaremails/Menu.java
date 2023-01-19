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

        opcio = ComprovacioInput.llegirInt("Selecciona una opció\n\n 1.Enviar Correu\n 2.Gestionar Persones\n 0.Sortir");
        switch (opcio) {
            case 1:
                submenuCorreu(opcio);
                break;
            case 2:
                submenuPersones(opcio);
                break;
            case 0:
                exit(0);
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuCorreu(int opcio) {
        opcio = ComprovacioInput.llegirInt("Que vols fer?\n\n 1.Enviar Correu a Clients\n 2.Enviar Correu a Proveïdors\n 3.Enviar Correu a Potencials\n 0.Cancel·lar");
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
            case 0:
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuPersones(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nQuè vols fer?\n 1.Afegir Persona\n 2.Eliminar Persona\n 3.Editar Persona\n 4.Mostrar Persones\n 0.Cancel·lar");
        switch (opcio) {
            case 1:
                submenuAfegir(opcio);
                break;
            case 2:
                submenuEliminar(opcio);
                break;
            case 3:
                submenuEditar(opcio);
                break;
            case 4:
                submenuMostrar(opcio);
                break;
            case 0:
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuAfegir(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nA què li vols afegir?\n 1.Clients\n 2.Proveidors\n 3.Potencials");
        switch (opcio) {
            case 1:
                Dades.setClients(PersonesController.afegirPersona(Dades.getClients()));
                break;
            case 2:
                Dades.setProveidors(PersonesController.afegirPersona(Dades.getProveidors()));
                break;
            case 3:
                Dades.setPotencials(PersonesController.afegirPersona(Dades.getPotencials()));
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuEliminar(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nA què li vols eliminar?\n 1.Clients\n 2.Proveidors\n 3.Potencials");
        switch (opcio) {
            case 1:
                Dades.setClients(PersonesController.eliminarPersona(Dades.getClients(), opcio));
                break;
            case 2:
                Dades.setProveidors(PersonesController.eliminarPersona(Dades.getProveidors(), opcio));
                break;
            case 3:
                Dades.setPotencials(PersonesController.eliminarPersona(Dades.getPotencials(), opcio));
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuEditar(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nQuè li vols editar?\n 1.Clients\n 2.Proveidors\n 3.Potencials");
        switch (opcio) {
            case 1:
                Dades.setClients(PersonesController.editarPersones(Dades.getClients(), opcio));
                break;
            case 2:
                Dades.setProveidors(PersonesController.editarPersones(Dades.getProveidors(), opcio));
                break;
            case 3:
                Dades.setPotencials(PersonesController.editarPersones(Dades.getPotencials(), opcio));
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

    private static void submenuMostrar(int opcio) {
        opcio = ComprovacioInput.llegirInt("\nQuè vols mostrar?\n 1.Clients\n 2.Proveidors\n 3.Potencials");
        switch (opcio) {
            case 1:
                PersonesController.mostrarPersones(Dades.getClients());
                break;
            case 2:
                PersonesController.mostrarPersones(Dades.getProveidors());
                break;
            case 3:
                PersonesController.mostrarPersones(Dades.getPotencials());
                break;
            default:
                System.out.println("Error, entra una opció correcte");
        }
    }

}
