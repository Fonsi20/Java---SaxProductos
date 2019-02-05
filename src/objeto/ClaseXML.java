/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author a16davidgv
 */
public class ClaseXML extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Empezando el documento");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del documento");
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        System.out.println("Procesando la etiqueta...");
        if (uri.length() > 0) {
            System.out.println("Namespace  uri: " + uri);
        }
        System.out.println("Nombre " + localName);
        System.out.println("Nombre con prefijo " + name);

        if (attributes.getLength() > 0) {
            System.out.println("Vamos a procesar " + attributes.getLength() + " atributos");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + " " + attributes.getValue(i));
            }
            String valor = attributes.getValue("ID");

            if (valor != null) {
                System.out.println("\tId: " + valor);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        boolean texto=false;
        for(int i=start;i<start+length;i++){
            if(("" +ch[i]).matches("[A-z0-9]")){
                texto=true;
            }
        }
        if(texto){
            System.out.println("Estoy procesando el tecto dentro de la etiqueta");
            System.out.println("Texto : "+String.valueOf(ch,start,length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        System.out.println("Fin de la etiqueta");
        if(uri.length()>0){
                  System.out.println("\tNamespace uri: "+uri);
              }
	      System.out.println("\tNombre: "+localName);  
	      System.out.println("\tNombre con prefijo: "+name); 
    }
    
}
