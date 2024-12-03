package recompensas;

import java.io.File;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.*;
import org.dom4j.io.XMLWriter;


public class Recompensas {

    private static String ruta= "rewards";
    private static Document doc = null;

    public static void hacerCarpeta() {
        File carpeta= new File(ruta);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }  
    }


    public static void algaXml(int nivel){
        doc = DocumentHelper.createDocument();
        Element root = doc.addElement("reward");
        Element give = null;
        switch (nivel) {
            case 1:
                root.addElement("name")
                    .addText("alga I");
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
            break;
            case 2: 
                root.addElement("name")
                    .addText("alga II");
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
                break;
            case 3: 
                root.addElement("name")
                    .addText("alga III");
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
                break;

            case 4: 
                root.addElement("name")
                    .addText("alga IV");
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
                break;
            case 5: 
                root.addElement("name")
                    .addText("alga V");
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
                break;
        }
      
    }

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
                break;
        }
        
    }

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
            break;
    }
}

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
            break;
        }
        
    }

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
            break;
        }
    }

    public static void pisciMarXml(int nivel){
        doc = DocumentHelper.createDocument();
        Element root = doc.addElement("reward");
        Element give = null;
        switch (nivel) {
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
            break;

        }
    }

    public static void pisciRioXml(int nivel){
        doc = DocumentHelper.createDocument();
        Element root = doc.addElement("reward");
        Element give = null;
        switch (nivel) {
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
            break;

        }
    }

    public static void tanqueRioXml(int nivel){
        doc = DocumentHelper.createDocument();
        Element root = doc.addElement("reward");
        Element give = null;
        switch (nivel) {
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
            break;
        }
    }
}
