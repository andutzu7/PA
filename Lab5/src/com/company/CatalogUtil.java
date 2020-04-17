package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static <IOException extends Throwable> void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        } catch (java.io.IOException e) {
            System.out.println("Exception:" + e.toString());
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
            Catalog c = new Catalog("loaded Object",path);
       try{
           FileInputStream file = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(file);

           c = (Catalog) in.readObject();
           in.close();
           file.close();
           String fileType = path.substring(path.length() - 3);//extragem ultimele 3 caractere
            if(!fileType.equals("ser")){
                throw new InvalidCatalogException(new Exception());
            }

       } catch (InvalidCatalogException | IOException | ClassNotFoundException exception){
           System.out.println( "Exception: " + exception.toString());
       }
       return c;

    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file=new File(doc.getLocation());
        try{
            if(!file.exists()){ //we try to see if its a link
                try {
                    desktop.browse(new URI(doc.getLocation()));
                }catch (IllegalArgumentException e){

                        throw new InvalidDocumentException(new Exception());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            else {
                desktop.open(file);
            }
        }catch (IOException | InvalidDocumentException e){
            System.out.println("Exception: " + e.toString());
        }
    }
}