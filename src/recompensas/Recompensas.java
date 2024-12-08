package recompensas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ErrorManager;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import comun.AlmacenCentral;
import comun.Monedero;
import helpers.ErrorHelper;
import piscifactoria.Piscifactoria;
import propiedades.CriaTipo;
import registros.Registros;
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
    private static String ruta= "rewards";

    /**
    * Documento XML en el que se trabaja durante las operaciones.
    */
    private static Document doc = null;

    /**
     * Crea la carpeta base donde se almacenarán los archivos XML de recompensas
     * si no existe.
     */
    public static void hacerCarpeta() {
        File carpeta= new File(ruta);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }  
    }

    /**
     * Genera un archivo XML con información sobre recompensas de tipo "alga".
     * 
     * @param nivel Nivel de la recompensa (1 a 5), que define los valores específicos.
     */
    public static void algaXml(int nivel){
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
                save("algas_1.xml");
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
                save("algas_2.xml");
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
                    save("algas_3.xml");
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
                save("algas_4.xml");
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
                save("algas_5.xml");
                break;
        }
      
    }

    /**
    * Genera un archivo XML con información sobre recompensas relacionadas con 
    * la construcción de un almacén central.
    * 
    * @param nivel Nivel de la recompensa, representando partes (A, B, C o D).
    */
    public static void almacenXml(int nivel){
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
                    .addText("Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
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
                save("almacen_a.xml");                
                break;
            case 2: 
                root.addElement("name")
                .addText("Almacén central [B]");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
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
                save("almacen_b.xml");    
                break;            
            case 3: 
                root.addElement("name")
                .addText("Almacén central [C]");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
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
                save("almacen_c.xml");               
            break;
            case 4: 
                root.addElement("name")
                .addText("Almacén central [D]");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("Materiales para la construcción de un almacén central. Con la parte A, B, C y D, puedes obtenerlo de forma gratuita.");
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
                save("almacen_d.xml");                
                break;
        }
        
    }

    /**
    * Genera un archivo XML con información sobre recompensas de comida general.
    * 
    * @param nivel Nivel de la recompensa (1 a 5), que define los valores específicos.
    */
    public static void comidaXml(int nivel){
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
                save("comida_1.xml");                
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
                save("comida_2.xml");                
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
                save("comida_3.xml");                
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
                save("comida_4.xml");                

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
                save("comida_5.xml");                
            break;
    }
}

    /**
     * Genera un archivo XML con información sobre recompensas de monedas.
     * 
     * @param nivel Nivel de la recompensa (1 a 5), que define los valores específicos.
     */
    public static void monedasXml(int nivel){
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
                save("monedas_1.xml");
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
                save("monedas_2.xml");
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
                    save("monedas_3.xml");

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
                    save("monedas_4.xml");

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
                    save("monedas_5.xml");

            break;
        }
        
    }

     /**
     * Genera un archivo XML con información sobre recompensas de pienso animal.
     * 
     * @param nivel Nivel de la recompensa (1 a 5), que define los valores específicos.
     */
    public static void piensoXml(int nivel){
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
                    .addText("100 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                root.addElement("rarity")
                    .addText("0");
                give = root.addElement("give");
                give.addElement("food")
                    .addAttribute("type", "animal")
                    .addText("100");               
                root.addElement("quantity")
                    .addText("1");
                    save("pienso_1.xml");

            break;
            case 2:
                root.addElement("name")
                    .addText("Pienso de peces II");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("200 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                root.addElement("rarity")
                    .addText("1");
                give = root.addElement("give");
                give.addElement("food")
                    .addAttribute("type", "animal")
                    .addText("200");               
                root.addElement("quantity")
                    .addText("1");
                    save("pienso_2.xml");

            break;
            case 3:
                root.addElement("name")
                    .addText("Pienso de peces III");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("500 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                root.addElement("rarity")
                    .addText("2");
                give = root.addElement("give");
                give.addElement("food")
                    .addAttribute("type", "animal")
                    .addText("500");               
                root.addElement("quantity")
                    .addText("1");
                    save("pienso_3.xml");

            break;
            case 4:
                root.addElement("name")
                    .addText("Pienso de peces IV");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("1000 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                root.addElement("rarity")
                    .addText("3");
                give = root.addElement("give");
                give.addElement("food")
                    .addAttribute("type", "animal")
                    .addText("1000");               
                root.addElement("quantity")
                    .addText("1");
                    save("pienso_4.xml");

            break;
            case 5:
                root.addElement("name")
                    .addText("Pienso de peces V");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("2000 unidades de pienso hecho a partir de peces, moluscos y otros seres marinos para alimentar a peces carnívoros y omnívoros.");
                root.addElement("rarity")
                    .addText("4");
                give = root.addElement("give");
                give.addElement("food")
                    .addAttribute("type", "animal")
                    .addText("2000");               
                root.addElement("quantity")
                    .addText("1");
                    save("pienso_5.xml");

            break;
        }
    }

     /**
     * Genera un archivo XML con información sobre recompensas para construir 
     * piscifactorías de mar.
     * 
     * @param parte Parte de la recompensa (A o B).
     */
    public static void pisciMarXml(int parte){
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
                    .addText("Materiales para la construcción de una piscifactoría de mar. Con la parte A y B, puedes obtenerla de forma gratuita.");
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
                    save("pisci_m_a.xml");
            break;
            case 2:
                root.addElement("name")
                    .addText("Piscifactoría de mar [B]");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("Materiales para la construcción de una piscifactoría de mar. Con la parte A y B, puedes obtenerla de forma gratuita.");
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
                    save("pisci_m_b.xml");

            break;

        }
    }

    /**
    * Genera un archivo XML con información sobre recompensas para construir 
    * piscifactorías de río.
    * 
    * @param parte Parte de la recompensa (A o B).
    */
    public static void pisciRioXml(int parte){
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
                    .addText("Materiales para la construcción de una piscifactoría de río. Con la parte A y B, puedes obtenerla de forma gratuita.");
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
                    save("pisci_r_a.xml");

            break;
            case 2:
                root.addElement("name")
                    .addText("Piscifactoría de río [B]");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("Materiales para la construcción de una piscifactoría de río. Con la parte A y B, puedes obtenerla de forma gratuita.");
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
                    save("pisci_r_b.xml");

            break;

        }
    }

     /**
     * Genera un archivo XML con información sobre recompensas para construir tanques.
     * 
     * @param tipo Tipo del tanque: 1 para río, 2 para mar.
     */
    public static void tanqueXml(int tipo){
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
                    .addText("Materiales para la construcción, de forma gratuita, de un tanque de una piscifactoría de río.");
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
                    save("tanque_a.xml");

            break;
            case 2:
                root.addElement("name")
                    .addText("Tanque de mar");
                root.addElement("origin")
                    .addText("Adrián");
                root.addElement("desc")
                    .addText("Materiales para la construcción, de forma gratuita, de un tanque de una piscifactoría de mar.");
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
                    save("tanque_b.xml");

            break;
        }
    }

    /**
     * Guarda el archivo XML actual en la ruta especificada.
     * 
     * @param nombreArchivo Nombre del archivo donde se guardará el documento.
     */
    public static void save(String nombreArchivo){
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(new File("rewards/"+nombreArchivo)),OutputFormat.createPrettyPrint());
            writer.write(doc);
            writer.flush();
        } catch (IOException e) {
            ErrorHelper.writeError("Fallo al crear el archivo XML "+ nombreArchivo);
        } finally{
            try {
                writer.close();
            } catch (Exception e2) {}
        }
    }

     /**
     * Incrementa la cantidad en el archivo XML especificado en 1.
     * 
     * @param nombreArchivo Nombre del archivo a modificar.
     */
    public static void addQuantity(String nombreArchivo){
        try {
            SAXReader sr = new SAXReader();
            Document doc = sr.read(new File("rewards/"+nombreArchivo));
            Element root = doc.getRootElement();
            int valor = Integer.parseInt(root.element("quantity").getText());
            valor++;
            root.element("quantity").setText(String.valueOf(valor));
            save(nombreArchivo);
        } catch (NumberFormatException | DocumentException e) {
            ErrorHelper.writeError("Error al acceder al archivo XML "+ruta);   
        }
    }

     /**
     * Reduce la cantidad en el archivo XML especificado en 1. Si llega a 0, 
     * el archivo se elimina.
     * 
     * @param nombreArchivo Nombre del archivo a modificar o eliminar.
     */
    public static void restQuantity(String nombreArchivo){
        try {
            SAXReader sr = new SAXReader();
            Document doc = sr.read(new File("rewards/" + nombreArchivo));
            Element root = doc.getRootElement();
            int valor = Integer.parseInt(root.element("quantity").getText());
            valor--;
            if (valor == 0) {
                File archivo = new File("rewards/" + nombreArchivo);
                if (!archivo.delete()) {
                    ErrorHelper.writeError("No se puedo borrar el archivo "+nombreArchivo);
                } 
            } else {
                // Actualizar el valor en el XML
                root.element("quantity").setText(String.valueOf(valor));
                save(nombreArchivo);  // Guarda el archivo actualizado
            }
        } catch (NumberFormatException | DocumentException e) {
            ErrorHelper.writeError("Error al acceder al archivo XML " + nombreArchivo);
        }
    }

    /**
     * Lista todas las recompensas disponibles leyendo los archivos en la carpeta
     * de recompensas.
     */
    public static void listRecompensas(){
        File folder = new File("rewards");
        File[] archivos = folder.listFiles();
        
        if(archivos != null){
            System.out.println("==== Recompensas disponibles =====");
            System.out.println("");
            
            for (int i = 0; i < archivos.length; i++) {
                try {
                    SAXReader reader = new SAXReader();
                    Document document = reader.read(archivos[i]);
                    List<Element> elementos = document.getRootElement().elements("name");
                    
                    // Iterar sobre cada "name"
                    for (int j = 0; j < elementos.size(); j++) {
                        Element nombreElemento = elementos.get(j);
                        String nombre = nombreElemento.getText();
                        
                        // Obtener la etiqueta "desc"
                        Element descElemento = document.getRootElement().element("desc");
                        String desc = descElemento.getText();
            
                        // Mostrar nombre junto con la descripción
                        System.out.println(i + 1 + ".- " + nombre + " - " + desc);
                    }
                } catch (DocumentException e) {
                    ErrorHelper.writeError("Error al leer el documento XML");
                }
            }
        }
    }

    /**
     * Reclama una recompensa, aplicándola a un conjunto de piscifactorías, 
     * y realiza las acciones necesarias según el tipo de recompensa.
     * 
     * @param registros Objeto Registros para gestionar operaciones relacionadas.
     * @param file Archivo XML de la recompensa a reclamar.
     * @param piscifactorias Lista de piscifactorías para distribuir la recompensa.
     */
    public static void reclamar(Registros registros, File file, ArrayList<Piscifactoria> piscifactorias) { 
        Element root=null;
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(file);
            root = doc.getRootElement();
            Element give = root.element("give");
            Iterator<Element> it = give.elementIterator();
            while(it.hasNext()){
                Element elem =it.next();
                if(elem.getName().equals("food")){
                    if(elem.element("give").element("food").attributeValue("type").equals("algae")){
                        int comidaRecompensa=Integer.parseInt(elem.getText());
                        int repartoVegetal = comidaRecompensa/piscifactorias.size();
                        for (Piscifactoria piscifactoria : piscifactorias) {
                            piscifactoria.repartirPiscifactoriaRecompensa(0, repartoVegetal);
                        }
                        //Falta lo del registro (eso lo hago yo)
                    }else if(elem.element("give").element("food").attributeValue("type").equals("general")){
                        int comidaRecompensa=Integer.parseInt(elem.getText());
                        int repartoVegetal = comidaRecompensa/piscifactorias.size();
                        int repartoAnimal = comidaRecompensa/piscifactorias.size();
                        for (Piscifactoria piscifactoria : piscifactorias) {
                            piscifactoria.repartirPiscifactoriaRecompensa(repartoAnimal, repartoVegetal);
                        }
                    }else if(elem.element("give").element("food").attributeValue("type").equals("animal")){
                        int comidaRecompensa=Integer.parseInt(elem.getText());
                        int repartoAnimal = comidaRecompensa/piscifactorias.size();
                        for (Piscifactoria piscifactoria : piscifactorias) {
                            piscifactoria.repartirPiscifactoriaRecompensa(repartoAnimal, 0);
                        }
                    }
                }else if(elem.getName().equals("buildings")){
                    if(elem.element("give").element("buildings").attributeValue("code").equals("0")){
                        String partes="";
                        partes = partes + elem.element("part").getText();
                        if(partes.equals(elem.element("total").getText())){
                            //Añadir una piscifactoria de rio
                            System.out.println("Recompensa adquirida");
                        }else{
                            System.out.println("Recompensa incompleta");
                        }
                    }else if(elem.element("give").element("buildings").attributeValue("code").equals("1")){
                        String partes="";
                        partes = partes + elem.element("part").getText();
                        if(partes.equals(elem.element("total").getText())){
                            //Añadir una piscifactoria de mar
                            System.out.println("Recompensa adquirida");
                        }else{
                            System.out.println("Recompensa incompleta");
                        }
                    }else if(elem.element("give").element("buildings").attributeValue("code").equals("2")){
                        for (Piscifactoria piscifactoria : piscifactorias) {
                            if(piscifactoria.getTipo()==CriaTipo.RIO && piscifactoria.getTanques().size() <10){
                                piscifactoria.getTanques().add(new Tanque(25, piscifactoria.getTipo()));
                            }
                        }
                    }else if(elem.element("give").element("buildings").attributeValue("code").equals("3")){
                        for (Piscifactoria piscifactoria : piscifactorias) {
                            if(piscifactoria.getTipo()==CriaTipo.MAR && piscifactoria.getTanques().size() <10){
                                piscifactoria.getTanques().add(new Tanque(100, piscifactoria.getTipo()));
                            }
                        }
                    }else if(elem.element("give").element("buildings").attributeValue("code").equals("4")){
                        String partes="";
                        partes = partes + elem.element("part").getText();
                        if(partes.equals(elem.element("total").getText())){
                            System.out.println("Recompensa adquirida");
                            //AlmacenCentral almacenCentral = AlmacenCentral.getInstance();
                        }else{
                            System.out.println("Recompensa incompleta");
                        }
                    }

                }else if(elem.getName().equals("coins")){
                    Monedero monedero=Monedero.getInstance();
                    int recompensaCoins = Integer.parseInt(elem.getText());
                    monedero.setMonedas(monedero.getMonedas()+recompensaCoins);
                }
            }

            //No se como enviar el nombre del archivo embez del file para borrar el archivo de recompensa
            //Recompensas.restQuantity(file);





            /*if(give.element("food") != null){
                 String tipoComida = give.element("food").attributeValue("type");
                if(tipoComida == "algae"){
                    String cantidad = give.element("food").getText();
                //    return Integer.parseInt(cantidad);
                } else if (tipoComida == "animal"){

                } else if (tipoComida == "animal"){

                }
            }*/
            
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
        }

    /**
     * Comprueba si todas las partes de un almacén central están disponibles.
     * 
     * @param a Parte A disponible.
     * @param b Parte B disponible.
     * @param c Parte C disponible.
     * @param d Parte D disponible.
     * @return true si todas las partes están disponibles; de lo contrario, false.
     */
        private static boolean comprobarAlmacenCen(boolean a,boolean b, boolean c,boolean d){
            if (a==true && b==true && c==true && d==true) {
                return true;
            }else{
                return false;
            }
        }
}

