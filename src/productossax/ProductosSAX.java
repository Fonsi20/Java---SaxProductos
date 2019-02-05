/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productossax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objeto.ClaseXML;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author a16davidgv
 */
public class ProductosSAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            XMLReader lee = XMLReaderFactory.createXMLReader();
            
            lee.setContentHandler(new ClaseXML());
            
           
                lee.parse(new InputSource(new FileInputStream("productos.xml")));
            
        
        
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ProductosSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
