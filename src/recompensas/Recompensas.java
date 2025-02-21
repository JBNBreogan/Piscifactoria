package recompensas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import comun.Monedero;
import helpers.ErrorHelper;
import helpers.InputHelper;
import piscifactoria.Piscifactoria;
import propiedades.CriaTipo;
import registros.Registros;
import simulador.Simulador;
import tanque.Tanque;

/**
 * La clase Recompensas permite la gestión de recompensas en formato XML.
 * Proporciona métodos para generar recompensas, modificar su cantidad,
 * listar las disponibles y realizar operaciones específicas según el tipo.
 *
 */
public class Recompensas {

    /**
     * Ruta donde se almacenan los archivos XML de recompensas.
     */
    private static String ruta = "rewards";

    /**
     * Documento XML en el que se trabaja durante las operaciones.
     */
    private static Document doc = null;

        /**
         * Crea la carpeta base donde se almacenarán los archivos XML de recompensas
         * si no existe.
         */
        public static void hacerCarpeta() {
            File carpeta = new File(ruta);
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas de tipo "alga".
         * 
         * @param nivel Nivel de la recompensa (1 a 5), que define los valores
         *              específicos.
         */
        public static void algaXml(int nivel) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
            switch (nivel) {
                case 1:
                    root.addElement("name")
                            .addText("Algas I");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("100 cápsulas de algas para alimentar peces filtradores y omnívoros.");
                    root.addElement("rarity")
                            .addText("0");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "algae")
                            .addText("100");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "algas_1.xml");
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Algas II");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("200 cápsulas de algas para alimentar peces filtradores y omnívoros.");
                    root.addElement("rarity")
                            .addText("1");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "algae")
                            .addText("200");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "algas_2.xml");
                    break;
                case 3:
                    root.addElement("name")
                            .addText("Algas III");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("500 cápsulas de algas para alimentar peces filtradores y omnívoros.");
                    root.addElement("rarity")
                            .addText("2");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "algae")
                            .addText("500");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "algas_3.xml");
                    break;
    
                case 4:
                    root.addElement("name")
                            .addText("Algas IV");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("1000 cápsulas de algas para alimentar peces filtradores y omnívoros.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "algae")
                            .addText("1000");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "algas_4.xml");
                    break;
                case 5:
                    root.addElement("name")
                            .addText("Algas V");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("2000 cápsulas de algas para alimentar peces filtradores y omnívoros.");
                    root.addElement("rarity")
                            .addText("4");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "algae")
                            .addText("2000");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "algas_5.xml");
                    break;
            }
    
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas relacionadas con
         * la construcción de un almacén central.
         * 
         * @param nivel Nivel de la recompensa, representando partes (A, B, C o D).
         */
        public static void almacenXml(int nivel) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
    
            switch (nivel) {
                case 1:
                    root.addElement("name")
                            .addText("Almacén central [A]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("building")
                            .addAttribute("code", "4")
                            .addText("Almacén central");
    
                    give.addElement("part")
                            .addText("A");
    
                    give.addElement("total")
                            .addText("ABCD");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "almacen_a.xml");
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Almacén central [B]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("building")
                            .addAttribute("code", "4")
                            .addText("Almacén central");
    
                    give.addElement("part")
                            .addText("B");
    
                    give.addElement("total")
                            .addText("ABCD");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "almacen_b.xml");
                    break;
                case 3:
                    root.addElement("name")
                            .addText("Almacén central [C]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("building")
                            .addAttribute("code", "4")
                            .addText("Almacén central");
    
                    give.addElement("part")
                            .addText("C");
    
                    give.addElement("total")
                            .addText("ABCD");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "almacen_c.xml");
                    break;
                case 4:
                    root.addElement("name")
                            .addText("Almacén central [D]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("building")
                            .addAttribute("code", "4")
                            .addText("Almacén central");
    
                    give.addElement("part")
                            .addText("D");
    
                    give.addElement("total")
                            .addText("ABCD");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "almacen_d.xml");
                    break;
            }
    
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas de comida general.
         * 
         * @param nivel Nivel de la recompensa (1 a 5), que define los valores
         *              específicos.
         */
        public static void comidaXml(int nivel) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
            switch (nivel) {
                case 1:
                    root.addElement("name")
                            .addText("Comida general I");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("50 unidades de pienso multipropósito para todo tipo de peces.");
                    root.addElement("rarity")
                            .addText("0");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "general")
                            .addText("50");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "comida_1.xml");
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Comida general II");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("100 unidades de pienso multipropósito para todo tipo de peces.");
                    root.addElement("rarity")
                            .addText("1");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "general")
                            .addText("100");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "comida_2.xml");
                    break;
                case 3:
                    root.addElement("name")
                            .addText("Comida general III");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("250 unidades de pienso multipropósito para todo tipo de peces.");
                    root.addElement("rarity")
                            .addText("2");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "general")
                            .addText("250");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "comida_3.xml");
                    break;
                case 4:
                    root.addElement("name")
                            .addText("Comida general IV");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("500 unidades de pienso multipropósito para todo tipo de peces.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "general")
                            .addText("500");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "comida_4.xml");
    
                    break;
                case 5:
                    root.addElement("name")
                            .addText("Comida general IV");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("1000 unidades de pienso multipropósito para todo tipo de peces.");
                    root.addElement("rarity")
                            .addText("4");
                    give = root.addElement("give");
    
                    give.addElement("food")
                            .addAttribute("type", "general")
                            .addText("1000");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "comida_5.xml");
                    break;
            }
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas de monedas.
         * 
         * @param nivel Nivel de la recompensa (1 a 5), que define los valores
         *              específicos.
         */
        public static void monedasXml(int nivel) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
    
            switch (nivel) {
                case 1:
                    root.addElement("name")
                            .addText("Monedas I");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("100 monedas");
                    root.addElement("rarity")
                            .addText("0");
                    give = root.addElement("give");
                    give.addElement("coins")
                            .addText("100");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "monedas_1.xml");
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Monedas II");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("300 monedas");
                    root.addElement("rarity")
                            .addText("1");
                    give = root.addElement("give");
                    give.addElement("coins")
                            .addText("300");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "monedas_2.xml");
                    break;
                case 3:
                    root.addElement("name")
                            .addText("Monedas III");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("500 monedas");
                    root.addElement("rarity")
                            .addText("2");
                    give = root.addElement("give");
                    give.addElement("coins")
                            .addText("500");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "monedas_3.xml");
    
                    break;
                case 4:
                    root.addElement("name")
                            .addText("Monedas IV");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("750 monedas");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
                    give.addElement("coins")
                            .addText("750");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "monedas_4.xml");
    
                    break;
                case 5:
                    root.addElement("name")
                            .addText("Monedas V");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText("1000 monedas");
                    root.addElement("rarity")
                            .addText("4");
                    give = root.addElement("give");
                    give.addElement("coins")
                            .addText("1000");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "monedas_5.xml");
    
                    break;
            }
    
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas de pienso animal.
         * 
         * @param nivel Nivel de la recompensa (1 a 5), que define los valores
         *              específicos.
         */
        public static void piensoXml(int nivel) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
            switch (nivel) {
                case 1:
                    root.addElement("name")
                            .addText("Pienso de peces I");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "100 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                    root.addElement("rarity")
                            .addText("0");
                    give = root.addElement("give");
                    give.addElement("food")
                            .addAttribute("type", "animal")
                            .addText("100");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pienso_1.xml");
    
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Pienso de peces II");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "200 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                    root.addElement("rarity")
                            .addText("1");
                    give = root.addElement("give");
                    give.addElement("food")
                            .addAttribute("type", "animal")
                            .addText("200");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pienso_2.xml");
    
                    break;
                case 3:
                    root.addElement("name")
                            .addText("Pienso de peces III");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "500 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                    root.addElement("rarity")
                            .addText("2");
                    give = root.addElement("give");
                    give.addElement("food")
                            .addAttribute("type", "animal")
                            .addText("500");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pienso_3.xml");
    
                    break;
                case 4:
                    root.addElement("name")
                            .addText("Pienso de peces IV");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "1000 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
                    give.addElement("food")
                            .addAttribute("type", "animal")
                            .addText("1000");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pienso_4.xml");
    
                    break;
                case 5:
                    root.addElement("name")
                            .addText("Pienso de peces V");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "2000 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                    root.addElement("rarity")
                            .addText("4");
                    give = root.addElement("give");
                    give.addElement("food")
                            .addAttribute("type", "animal")
                            .addText("2000");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pienso_5.xml");
    
                    break;
            }
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas para construir
         * piscifactorías de mar.
         * 
         * @param parte Parte de la recompensa (A o B).
         */
        public static void pisciMarXml(int parte) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
            switch (parte) {
                case 1:
                    root.addElement("name")
                            .addText("Piscifactoría de mar [A]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de una piscifactoría de mar. Con la parte A y B, puedes obtenerla de forma gratuita.");
                    root.addElement("rarity")
                            .addText("4");
                    give = root.addElement("give");
                    give.addElement("building")
                            .addAttribute("code", "1")
                            .addText("Piscifactoría de mar");
                    give.addElement("part")
                            .addText("A");
                    give.addElement("total")
                            .addText("AB");
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pisci_m_a.xml");
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Piscifactoría de mar [B]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de una piscifactoría de mar. Con la parte A y B, puedes obtenerla de forma gratuita.");
                    root.addElement("rarity")
                            .addText("4");
                    give = root.addElement("give");
    
                    give.addElement("building")
                            .addAttribute("code", "1")
                            .addText("Piscifactoría de mar");
    
                    give.addElement("part")
                            .addText("B");
    
                    give.addElement("total")
                            .addText("AB");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pisci_m_b.xml");
    
                    break;
    
            }
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas para construir
         * piscifactorías de río.
         * 
         * @param parte Parte de la recompensa (A o B).
         */
        public static void pisciRioXml(int parte) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
            switch (parte) {
                case 1:
                    root.addElement("name")
                            .addText("Piscifactoría de río [A]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de una piscifactoría de río. Con la parte A y B, puedes obtenerla de forma gratuita.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
                    give.addElement("building")
                            .addAttribute("code", "0")
                            .addText("Piscifactoría de río");
                    give.addElement("part")
                            .addText("A");
                    give.addElement("total")
                            .addText("AB");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pisci_r_a.xml");
    
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Piscifactoría de río [B]");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción de una piscifactoría de río. Con la parte A y B, puedes obtenerla de forma gratuita.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
    
                    give.addElement("building")
                            .addAttribute("code", "0")
                            .addText("Piscifactoría de río");
    
                    give.addElement("part")
                            .addText("B");
    
                    give.addElement("total")
                            .addText("AB");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "pisci_r_b.xml");
    
                    break;
    
            }
        }
    
        /**
         * Genera un archivo XML con información sobre recompensas para construir
         * tanques.
         * 
         * @param tipo Tipo del tanque: 1 para río, 2 para mar.
         */
        public static void tanqueXml(int tipo) {
            doc = DocumentHelper.createDocument();
            Element root = doc.addElement("reward");
            Element give = null;
            switch (tipo) {
                case 1:
                    root.addElement("name")
                            .addText("Tanque de río");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción, de forma gratuita, de un tanque de una piscifactoría de río.");
                    root.addElement("rarity")
                            .addText("2");
                    give = root.addElement("give");
                    give.addElement("building")
                            .addAttribute("code", "2")
                            .addText("Tanque de río");
                    give.addElement("part")
                            .addText("A");
                    give.addElement("total")
                            .addText("A");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "tanque_r.xml");
    
                    break;
                case 2:
                    root.addElement("name")
                            .addText("Tanque de mar");
                    root.addElement("origin")
                            .addText("Adrián");
                    root.addElement("desc")
                            .addText(
                                    "Materiales para la construcción, de forma gratuita, de un tanque de una piscifactoría de mar.");
                    root.addElement("rarity")
                            .addText("3");
                    give = root.addElement("give");
                    give.addElement("building")
                            .addAttribute("code", "3")
                            .addText("Tanque de mar");
                    give.addElement("part")
                            .addText("A");
                    give.addElement("total")
                            .addText("A");
    
                    root.addElement("quantity")
                            .addText("1");
                    save(doc, "tanque_m.xml");
    
                    break;
            }
        }

         /**
         * Genera un archivo XML que representa una recompensa para la construcción de un edificio.
         *
         * @param nombre         Nombre del edificio.
         * @param parte          Parte del edificio (A, B, C o D).
         * @param codigoEdificio Código identificador del edificio.
         * @param archivoSalida  Nombre del archivo donde se guardará el XML.
         */

        public static void granjasXml(String nombre, String parte, String codigoEdificio, String archivoSalida) {
                Document doc = DocumentHelper.createDocument();
                Element root = doc.addElement("reward");
        
                root.addElement("name").addText(nombre + " [" + parte + "]");
                root.addElement("origin").addText("Adrián");
                root.addElement("desc")
                        .addText("Materiales para la construcción de " + nombre.toLowerCase() + ". Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
                root.addElement("rarity").addText("3");
        
                Element give = root.addElement("give");
                give.addElement("building")
                        .addAttribute("code", codigoEdificio)
                        .addText(nombre);
                give.addElement("part").addText(parte);
                give.addElement("total").addText("ABCD");
        
                root.addElement("quantity").addText("1");
                save(doc, archivoSalida);
        }
    
        /**
         * Guarda el archivo XML actual en la ruta especificada.
         * 
         * @param nombreArchivo Nombre del archivo donde se guardará el documento.
         */
        public static void save(Document doc, String nombreArchivo) {
            XMLWriter writer = null;
            try {
                writer = new XMLWriter(new FileWriter("rewards/" + nombreArchivo), OutputFormat.createPrettyPrint());
                writer.write(doc);
                writer.flush();
            } catch (IOException e) {
                ErrorHelper.writeError("Fallo al crear el archivo XML " + nombreArchivo);
            } finally {
                try {
                    writer.close();
                } catch (Exception e2) {
                }
            }
        }
    
        /**
         * Incrementa la cantidad en el archivo XML especificado en 1.
         * 
         * @param nombreArchivo Nombre del archivo a modificar.
         */
        public static void addQuantity(String nombreArchivo) {
            try {
                SAXReader sr = new SAXReader();
                doc = sr.read(new File("rewards/" + nombreArchivo));
                Element root = doc.getRootElement();
                Element quant = root.element("quantity");
                int valor = Integer.parseInt(quant.getText());
                valor++;
                quant.setText(String.valueOf(valor));
                save(doc, nombreArchivo); // Guarda el archivo actualizado
            } catch (NumberFormatException | DocumentException e) {
                ErrorHelper.writeError("Error al acceder al archivo XML: " + e.getMessage());
            }
        }
    
        /**
         * Reduce la cantidad en el archivo XML especificado en 1. Si llega a 0,
         * el archivo se elimina.
         * 
         * @param nombreArchivo Nombre del archivo a modificar o eliminar.
         */
        public static void restQuantity(String nombreArchivo) {
            try {
                SAXReader sr = new SAXReader();
                doc = sr.read(new File("rewards/" + nombreArchivo));
                Element root = doc.getRootElement();
                int valor = Integer.parseInt(root.element("quantity").getText());
                valor--;
                if (valor == 0) {
                    File archivo = new File("rewards/" + nombreArchivo);
                    if (!archivo.delete()) {
                        ErrorHelper.writeError("No se puedo borrar el archivo " + nombreArchivo);
                    }
                } else {
                    // Actualizar el valor en el XML
                    root.element("quantity").setText(String.valueOf(valor));
                    save(doc, nombreArchivo); // Guarda el archivo actualizado
                }
            } catch (NumberFormatException | DocumentException e) {
                ErrorHelper.writeError("Error al acceder al archivo XML " + nombreArchivo);
            }
        }
    
        /**
         * Lista todas las recompensas disponibles leyendo los archivos en la carpeta
         * de recompensas.
         */
        public static void listRecompensas(Map<Integer, File> recompensaMap) {
                File folder = new File("rewards");
                File[] archivos = folder.listFiles();
                Map<String, List<File>> materialesEdificios = new HashMap<>(); // Cambio: Guardar los archivos de cada parte
                Map<String, String> descripciones = new HashMap<>();
                Map<String, String> totalPartes = new HashMap<>();
            
                if (archivos != null) {
                    System.out.println("==== Recompensas disponibles =====\n");
            
                    int rewardIndex = 1; // Índice para las recompensas no agrupadas
                    for (File archivo : archivos) {
                        try {
                            SAXReader reader = new SAXReader();
                            Document document = reader.read(archivo);
                            Element root = document.getRootElement();
            
                            String nombre = root.elementText("name");
                            String desc = root.elementText("desc");
                            Element giveElement = root.element("give");
            
                            if (giveElement != null && giveElement.element("building") != null) {
                                // Es una recompensa de edificio
                                String buildingName = giveElement.elementText("building");
                                String total = giveElement.elementText("total");
            
                                if (!materialesEdificios.containsKey(buildingName)) {
                                    materialesEdificios.put(buildingName, new ArrayList<>());
                                }
                                materialesEdificios.get(buildingName).add(archivo); // Guardar el archivo correspondiente
                                descripciones.put(buildingName, desc);
                                totalPartes.put(buildingName, total);
                            } else {
                                // Es una recompensa normal
                                System.out.println(rewardIndex + ".- " + nombre + " - " + desc);
                                recompensaMap.put(rewardIndex, archivo);
                                rewardIndex++;
                            }
                        } catch (DocumentException e) {
                            System.out.println("Error al leer el documento XML");
                        }
                    }
            
                    // Mostrar recompensas de edificios agrupadas
                    for (Map.Entry<String, List<File>> entry : materialesEdificios.entrySet()) {
                        String building = entry.getKey();
                        String total = totalPartes.get(building);
                        char[] partesArray = total.toCharArray();
                        Arrays.fill(partesArray, 'x');
            
                        for (File archivo : entry.getValue()) {
                            try {
                                SAXReader reader = new SAXReader();
                                Document document = reader.read(archivo);
                                Element root = document.getRootElement();
                                Element giveElement = root.element("give");
                                String part = giveElement.elementText("part");
            
                                int pos = total.indexOf(part);
                                if (pos != -1) {
                                    partesArray[pos] = part.charAt(0);
                                }
                            } catch (DocumentException e) {
                                System.out.println("Error al leer el documento XML");
                            }
                        }
                        String partesDisponibles = new String(partesArray);
            
                        System.out.println(rewardIndex + ".- " + building + " - " + descripciones.get(building) + " [Partes: "
                                + partesDisponibles + "]");
            
                        // Asignar el primer archivo de la lista de partes como representante de la recompensa agrupada
                        recompensaMap.put(rewardIndex, entry.getValue().get(0)); // Asignar el primer archivo de la lista
                        rewardIndex++;
                    }
                }
            }
    
        /**
         * Reclama una recompensa, aplicándola a un conjunto de piscifactorías,
         * y realiza las acciones necesarias según el tipo de recompensa.
         * 
         * @param registros      Objeto Registros para gestionar operaciones
         *                       relacionadas.
         * @param file           Archivo XML de la recompensa a reclamar.
         * @param piscifactorias Lista de piscifactorías para distribuir la recompensa.
         */
        public static void reclamar(Registros registros, File file, ArrayList<Piscifactoria> piscifactorias) {
    
            try {
                SAXReader reader = new SAXReader();
                Document doc = reader.read(file);
                Element root = doc.getRootElement();
    
                Element give = root.element("give");
                if (give == null) {
                    System.out.println("El elemento 'give' no existe en el archivo XML.");
                    return;
                }
                String nombreArchivo = file.getName();
                Iterator<Element> it = give.elementIterator();
                while (it.hasNext()) {
                    Element elem = it.next();
    
                    // Procesar recompensas de tipo "food"
                    if ("food".equals(elem.getName())) {
                        processFoodReward(elem, piscifactorias);
                        restQuantity(nombreArchivo);
                    }
                    // Procesar recompensas de tipo "building"
                    else if ("building".equals(elem.getName())) {
                        processBuildingsReward(elem, piscifactorias,nombreArchivo);
                      
                }
                    // Procesar recompensas de tipo "coins"
                    else if ("coins".equals(elem.getName())) {
                        processCoinsReward(elem);
                        restQuantity(nombreArchivo);
                    }
                }
    
            } catch (Exception e) {
                e.printStackTrace();
                ErrorHelper.writeError("Error al reclamar recompensas ");
            }
        }
    
        /**
         * Procesa las recompensas de tipo "food" del archivo XML y las distribuye
         * entre las piscifactorías según el tipo de comida.
         *
         * @param foodElement    Elemento XML que representa una recompensa de comida.
         * @param piscifactorias Lista de piscifactorías donde se distribuirá la
         *                       recompensa.
         */
        public static void processFoodReward(Element foodElement, ArrayList<Piscifactoria> piscifactorias) {
            try {
                String type = foodElement.attributeValue("type");
                Simulador sim = Simulador.getInstance();
                if (type == null) {
                    System.out.println("El atributo 'type' de 'food' no existe.");
                    return;
                } else {
                    int comidaRecompensa = Integer.parseInt(foodElement.getText().trim());
                    int repartoVegetal = comidaRecompensa / piscifactorias.size();
                    int repartoAnimal = comidaRecompensa / piscifactorias.size();
                    for (Piscifactoria piscifactoria : piscifactorias) {
                        switch (type) {
                            case "algae":
                                if (sim.getAlmacenCentral() != null) {
                                int capacidadDisponible = sim.getAlmacenCentral().getCapacidadComidaVegetal()
                                        - sim.getAlmacenCentral().getComidaVegetal();
                                if (comidaRecompensa > capacidadDisponible) {
                                    sim.getAlmacenCentral().addFood(capacidadDisponible, "Vegetal");
                                } else {
                                    sim.getAlmacenCentral().addFood(comidaRecompensa, "Vegetal");
                                }
                            } else {
                                piscifactoria.repartirPiscifactoriaRecompensa(0, repartoVegetal);
                            }
                            break;
                        case "general":
                            if (sim.getAlmacenCentral() != null) {
                                int capacidadDisponibleAnimal = sim.getAlmacenCentral().getCapacidadComidaAnimal()
                                        - sim.getAlmacenCentral().getComidaAnimal();
                                int capacidadDisponibleVegetal = sim.getAlmacenCentral().getCapacidadComidaVegetal()
                                        - sim.getAlmacenCentral().getComidaVegetal();

                                if (comidaRecompensa > capacidadDisponibleAnimal) {
                                    sim.getAlmacenCentral().addFood(capacidadDisponibleAnimal, "Animal");
                                } else {
                                    sim.getAlmacenCentral().addFood(comidaRecompensa, "Animal");
                                }
                                if (comidaRecompensa > capacidadDisponibleVegetal) {
                                    sim.getAlmacenCentral().addFood(capacidadDisponibleVegetal, "Vegetal");
                                } else {
                                    sim.getAlmacenCentral().addFood(comidaRecompensa, "Vegetal");
                                }
                            } else {
                                piscifactoria.repartirPiscifactoriaRecompensa(repartoAnimal, repartoVegetal);
                            }
                            break;
                        case "animal":
                            if (sim.getAlmacenCentral() != null) {
                                int capacidadDisponible = sim.getAlmacenCentral().getCapacidadComidaAnimal()
                                        - sim.getAlmacenCentral().getComidaAnimal();
                                if (comidaRecompensa > capacidadDisponible) {
                                    sim.getAlmacenCentral().addFood(capacidadDisponible, "Animal");
                                } else {
                                    sim.getAlmacenCentral().addFood(comidaRecompensa, "Animal");
                                }
                            } else {
                                piscifactoria.repartirPiscifactoriaRecompensa(repartoAnimal, 0);
                            }
                            break;
                        default:
                            System.out.println("Tipo de comida no reconocido: " + type);
                    }
                }
            }
        } catch (Exception e) {
            ErrorHelper.writeError("Error al procesar la recompensas de comida");
        }
    }

    /**
     * Procesa las recompensas de tipo "buildings" del archivo XML y realiza
     * las acciones correspondientes, como añadir nuevas piscifactorías o tanques.
     *
     * @param buildingElement Elemento XML que representa una recompensa de
     *                        construcción.
     * @param piscifactorias  Lista de piscifactorías donde se aplicarán las
     *                        recompensas.
     */
    public static void processBuildingsReward(Element buildingElement, ArrayList<Piscifactoria> piscifactorias, String nombreArchivo) {
        try {
            String code = buildingElement.attributeValue("code");
            Simulador sim = Simulador.getInstance();
            if (code == null) {
                System.out.println("El atributo 'code' de 'buildings' no existe.");
                return;
            }
            switch (code) {
                case "0":
                        File folderRio = new File("rewards");
                        File[] archivosRio = folderRio.listFiles();
                        Set<String> partesRioEncontradas = new HashSet<>();
                
                        if (archivosRio != null) {
                        for (File archivo : archivosRio) {
                                try {
                                SAXReader reader = new SAXReader();
                                Document document = reader.read(archivo);
                                Element root = document.getRootElement();
                                Element giveElement = root.element("give");
                
                                if (giveElement != null && giveElement.element("building") != null) {
                                        String buildingName = giveElement.elementText("building");
                                        String part = giveElement.elementText("part");
                
                                        if ("Piscifactoría de río".equals(buildingName)) {
                                        partesRioEncontradas.add(part);
                                        }
                                }
                                } catch (DocumentException e) {
                                System.out.println("Error al leer el documento XML");
                                }
                        }
                        }
                
                        if (partesRioEncontradas.contains("A") && partesRioEncontradas.contains("B")) {
                                System.out.println("Nombre de la piscifactoría: ");
                                String nombrePisc = InputHelper.readStringWithBuffRead();
                                piscifactorias.add(new Piscifactoria(nombrePisc, CriaTipo.RIO));
                                System.out.println("Piscifactoría de río creada correctamente.");
                                restQuantity("pisci_r_a.xml");
                                restQuantity("pisci_r_b.xml");
                        } else {
                        System.out.println("Recompensa incompleta: faltan partes para la piscifactoría de rio.");
                        }
                break;
                case "1":
                        File folderMar = new File("rewards");
                        File[] archivosMar = folderMar.listFiles();
                        Set<String> partesMarEncontradas = new HashSet<>();
                
                        if (archivosMar != null) {
                        for (File archivo : archivosMar) {
                                try {
                                SAXReader reader = new SAXReader();
                                Document document = reader.read(archivo);
                                Element root = document.getRootElement();
                                Element giveElement = root.element("give");
                
                                if (giveElement != null && giveElement.element("building") != null) {
                                        String buildingName = giveElement.elementText("building");
                                        String part = giveElement.elementText("part");
                
                                        if ("Piscifactoría de mar".equals(buildingName)) {
                                        partesMarEncontradas.add(part);
                                        }
                                }
                                } catch (DocumentException e) {
                                System.out.println("Error al leer el documento XML");
                                }
                        }
                        }
                
                        if (partesMarEncontradas.contains("A") && partesMarEncontradas.contains("B")) {
                                System.out.println("Nombre de la piscifactoría: ");
                                String nombrePisc = InputHelper.readStringWithBuffRead();
                                piscifactorias.add(new Piscifactoria(nombrePisc, CriaTipo.MAR));
                                System.out.println("Piscifactoría de mar creada correctamente.");
                                restQuantity("pisci_m_a.xml");
                                restQuantity("pisci_m_b.xml");
                        } else {
                        System.out.println("Recompensa incompleta: faltan partes para la piscifactoría de mar.");
                        }
                break;
                case "4": // Almacén central
                    File folder = new File("rewards");
                    File[] archivos = folder.listFiles();
                    Set<String> partesEncontradas = new HashSet<>();

                    if (archivos != null) {
                        for (File archivo : archivos) {
                            try {
                                SAXReader reader = new SAXReader();
                                Document document = reader.read(archivo);
                                Element root = document.getRootElement();
                                Element giveElement = root.element("give");

                                if (giveElement != null && giveElement.element("building") != null) {
                                    String buildingName = giveElement.elementText("building");
                                    String part = giveElement.elementText("part");
                                    if ("Almacén central".equals(buildingName)) {
                                        partesEncontradas.add(part);
                                    }
                                }
                            } catch (DocumentException e) {
                                System.out.println("Error al leer el documento XML");
                            }
                        }
                    }

                    if (partesEncontradas.contains("A") && partesEncontradas.contains("B")
                            && partesEncontradas.contains("C") && partesEncontradas.contains("D")) {
                        if (sim.getAlmacenCentral() == null) {
                            sim.crearAlmacen();
                            System.out.println("Almacén central reclamado correctamente.");
                            restQuantity("almacen_a.xml");
                            restQuantity("almacen_b.xml");
                            restQuantity("almacen_c.xml");
                            restQuantity("almacen_d.xml");
                        }
                    } else {
                        System.out.println("Recompensa incompleta: faltan partes del Almacén central.");
                    }
                    break;

                case "2": // Añadir tanque en piscifactoría de río
                Piscifactoria piscr =piscifactorias.get(sim.selectPisc());
                        if(piscr.getTipo() == CriaTipo.RIO){
                                piscr.getTanques().add(new Tanque(25, piscr.getTipo()));
                                restQuantity("tanque_r.xml");
                                System.out.println("Tanque de rio añadido.");
                        } else {
                                System.out.println("Esta piscifactoría no es de río.");
                        }

                break;
                case "3": // Añadir tanque en piscifactoría de mar
                        Piscifactoria piscm =piscifactorias.get(sim.selectPisc());
                        if(piscm.getTipo() == CriaTipo.MAR){
                                piscm.getTanques().add(new Tanque(100, piscm.getTipo()));
                                restQuantity("tanque_m.xml");
                                System.out.println("Tanque de mar añadido.");
                        } else {
                                System.out.println("Esta piscifactoría no es de mar.");
                        }
                break;
                default:
                    System.out.println("Código de building no reconocido: " + code);
            }
        } catch (Exception e) {
            ErrorHelper.writeError("Error al procesar la recompensas de edificio");

        }
    }

    /**
     * Procesa las recompensas de tipo "coins" del archivo XML y añade la cantidad
     * correspondiente al monedero del jugador.
     *
     * @param coinsElement Elemento XML que representa una recompensa de monedas.
     */
    public static void processCoinsReward(Element coinsElement) {
        try {
            Monedero monedero = Monedero.getInstance();
            int recompensaCoins = Integer.parseInt(coinsElement.getText().trim());
            monedero.setMonedas(monedero.getMonedas() + recompensaCoins);
        } catch (Exception e) {
            ErrorHelper.writeError("Error al procesar la recompensas de monedas");
        }
    }

 
    /**
     * Genera una recompensa aleatoria entre una de comida, monedas o tanques.
     */
    public static void generar(){
        Random random = new Random();

        int odds = random.nextInt(10)+1;

        if (odds <= 5){
                int odds2 = random.nextInt(10)+1;
                if (odds2 <= 6){
                        if (new File("rewards/" + "comida_1.xml").exists()) {
                                addQuantity("comida_1.xml");
                            } else {
                                comidaXml(1);}

                } else if (odds <= 9){
                        if (new File("rewards/" + "comida_2.xml").exists()) {
                                addQuantity("comida_1.xml");
                            } else {
                                comidaXml(2); }        
                } else {
                        if (new File("rewards/" + "comida_3.xml").exists()) {
                                addQuantity("comida_1.xml");
                            } else {
                                comidaXml(3);}
                }
        } else if (odds <= 9){
                int odds3 = random.nextInt(10)+1;
                if (odds3 <= 6){
                        if (new File("rewards/" + "monedas_1.xml").exists()) {
                                addQuantity("monedas_1.xml");
                            } else {
                                monedasXml(1);}
                } else if (odds <= 9){
                        if (new File("rewards/" + "monedas_2.xml").exists()) {
                                addQuantity("monedas_2.xml");
                            } else {
                                monedasXml(2);}
                } else {
                        if (new File("rewards/" + "monedas_3.xml").exists()) {
                                addQuantity("monedas_3.xml");
                            } else {
                                monedasXml(3);}
                }
        } else {
                int odds4 = random.nextInt(10)+1;
                if (odds4 <= 6){
                        if (new File("rewards/" + "tanque_r.xml").exists()) {
                                addQuantity("tanque_r.xml");
                            } else {
                                tanqueXml(1);}
                } else {
                        if (new File("rewards/" + "tanque_m.xml").exists()) {
                                addQuantity("tanque_m.xml");
                            } else {
                                tanqueXml(2);}
                }
        }
    }
}
