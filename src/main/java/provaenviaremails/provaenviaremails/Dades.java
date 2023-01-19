/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaenviaremails.provaenviaremails;

/**
 *
 * @author ernes
 */
public class Dades {

    //Posicions: 0.ID, 1.Nom, 3.Email
    private static String[][] clients = {
        {"0", "Client A", "ernest.vila@cirvianum.cat"},
        {"3", "Client B", "ernestvilacasas@gmail.com"},
        {"4", "Client C", "ernestvilac@gmail.com"}};

    public static String[][] getClients() {
        return clients;
    }

    public static void setClients(String[][] clientsIn) {
        clients = clientsIn;
    }

    //Posicions: 0.ID, 1.Nom, 3.email
    private static String[][] proveidors = {
        {"0", "Proveidor A", "ernest.vila@cirvianum.cat"},
        {"3", "Proveidor B", "ernestvilacasas@gmail.com"},
        {"4", "Proveidor C", "ernestvilac@gmail.com"}};

    public static String[][] getProveidors() {
        return proveidors;
    }

    public static void setProveidors(String[][] proveidorsIn) {
        proveidors = proveidorsIn;
    }

    //Posicions: 0.ID, 1.Nom, 3.email
    private static String[][] potencials = {
        {"0", "Potencial A", "ernest.vila@cirvianum.cat"},
        {"3", "Potencial B", "ernestvilacasas@gmail.com"},
        {"4", "Potencial C", "ernestvilac@gmail.com"}};

    public static String[][] getPotencials() {
        return potencials;
    }

    public static void setPotencials(String[][] potencialsIn) {
        potencials = potencialsIn;
    }
}
