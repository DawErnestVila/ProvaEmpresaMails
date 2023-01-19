/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaenviaremails.provaenviaremails;

import java.util.Scanner;

/**
 *
 * @author ernes
 */
public class ComprovacioInput {

    private static Scanner lector = new Scanner(System.in);

    /**
     * Funció que serveix per comprovar si l'usuari entra un Integer
     *
     * @param missatge Missatge que es mostrarà per pantalla abans que l'usuari entri el numero
     * @return Retorna l'usuari un cop comprovat que és un Integer
     */
    public static int llegirInt(String missatge) {
        //Mostrem el missatge
        System.out.println(missatge);
        //Fem un bucle fins que l'usuari entri un numero enter
        while (!lector.hasNextInt()) {
            //Si no entra un numero enter tornem a mostrar el missatge i a demanar que entri un nou numero
            System.out.println(missatge);
            lector.nextLine();
        }
        //Retornem el número que ha entrat
        return lector.nextInt();
    }

    /**
     * Funció que serveix per comprovar si l'usuari entra el text que coincideixi amb l'expressió regular
     *
     * @param missatge Missatge que es mostrarà per pantalla abans que l'usuari entri el text
     * @return Retorna el missatge
     */
    public static String llegirString(String missatge) {
        String COMPROVAR_TEXT = "^[a-zA-Z0-9\s]{3,40}$", text;
        //Mostrem el missatge
        System.out.println(missatge);
//        lector.nextLine();
        //Guardem el text a comprovar
        text = lector.nextLine();
        //Fem un bucle fins que l'usuari entri un text que coincideix amb l'expressió regular
        while (!text.matches(COMPROVAR_TEXT)) {
            //Si no el text no coincideix li diem el que pot contenir i li tornem a demanar
            System.out.println("Només pots posar lletres, numeros i espais en blanc, entre 3 i 40 caràcters");
            text = lector.nextLine();
        }
        //Retornem l'string
        return text;
    }

    /**
     * Funció que serveix per comprovar si l'usuari entra el text que coincideixi amb l'expressió regular
     *
     * @param missatge Missatge que es mostrarà per pantalla abans que l'usuari entri el text
     * @return Retorna el missatge
     */
    public static String llegirEmail(String missatge) {
        String COMPROVAR_TEXT = "([A-Za-z0-9!#-'*+\\-/=?^_`{-~\\xA0-\\x{10FFFF}]+(?:\\.[A-Za-z0-9!#-'*+\\-/=?^_`{-~\\xA0-\\x{10FFFF}])|(?:[ !#-\\[\\]-~\\xA0-\\x{10FFFF}]|\\\\[ -~])*)@((?:[A-Za-z0-9](?:[A-Za-z0-9\\-]*[A-Za-z0-9])?|[\\x00-\\x{10FFFF}]*[\\x80-\\x{10FFFF}]+[\\x00-\\x{10FFFF}]*)(?:\\.(?:[A-Za-z0-9](?:[A-Za-z0-9\\-]*[A-Za-z0-9])?|[\\x00-\\x{10FFFF}]*[\\x80-\\x{10FFFF}]+[\\x00-\\x{10FFFF}]*))*)", text;
        //Mostrem el missatge
        System.out.println(missatge);
        //Guardem el text a comprovar
        text = lector.nextLine();
        //Fem un bucle fins que l'usuari entri un text que coincideix amb l'expressió regular
        while (!text.matches(COMPROVAR_TEXT)) {
            //Si no el text no coincideix li diem el que pot contenir i li tornem a demanar
            System.out.println("Entra un email correcte");
            text = lector.nextLine();
        }
        //Retornem l'string
        return text;
    }
}
