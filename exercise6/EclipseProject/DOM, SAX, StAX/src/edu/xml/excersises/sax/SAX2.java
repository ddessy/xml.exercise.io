package edu.xml.excersises.sax;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import edu.xml.excersises.XMLPath;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;


public class SAX2 {
	public static void main(String[] args) {       
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);      
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            InputSource source = new InputSource(XMLPath.RSSXML.toString());
            //InputSource source = new InputSource(new StringReader("<rss><channel></channel></rss>"));
            parser.setContentHandler(new SAXValidator(outputStreamWriter)
            );
            parser.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
