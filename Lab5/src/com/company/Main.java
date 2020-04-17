package com.company;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "G:/Facultate/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IOException {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("G:/Facultate/catalog.ser");
        } catch (InvalidCatalogException | IOException e) {
            System.out.println("Exception:" + e.toString());
        }
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }

}
