package recompensas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import helpers.ErrorHelper;


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

    public static void addQuantity(String nombreArchivo){
        try {
            SAXReader sr = new SAXReader();
            doc = sr.read(new File("rewards/"+nombreArchivo));
            Element root = doc.getRootElement();
            int valor = Integer.parseInt(root.element("quantity").getText());
            valor++;
            root.element("quantity").setText(String.valueOf(valor));
            save(nombreArchivo);
        } catch (NumberFormatException | DocumentException e) {
            ErrorHelper.writeError("Error al acceder al archivo XML "+ruta);   
        }
    }

    public static void listRecompensas(){
        File folder = new File("rewards");
        File[] archivos = folder.listFiles();
        
        if(archivos != null){
            System.out.println("==== Recompensas disponibles =====");
            System.out.println("");
            for (File file : archivos) {

                // TODO cambiar a fori, poner descripcion y canjear recompensas
                try {
                    SAXReader reader = new SAXReader();
                    Document document = reader.read(file);
                    List<Element> elementos = document.getRootElement().elements("name");
                    for (Element elemento : elementos) {
                        System.out.println(elemento.getText());
                    }
                } catch (DocumentException e) {
                    ErrorHelper.writeError("No existen documentos.");
                }
            }
        } else {
            ErrorHelper.writeError("No hay documentos en el directorio");
        }
    }
}
