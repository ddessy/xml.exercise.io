package edu.xml.excersises.sax;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SAXHandler implements ContentHandler {
    Locator locator;
    Integer indent;
    OutputStreamWriter outputStreamWriter;
    private final Integer TAB_SIZE = 4;
    
    public SAXHandler(OutputStreamWriter outputStreamWriter) {
        this.outputStreamWriter = outputStreamWriter;
        indent = 0;
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }
    
    @Override
    public void startDocument() throws SAXException {
        printIndented("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", false, false);
    }
    
    @Override
    public void endDocument() throws SAXException {
        // ...
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        printIndented(String.format("<%s", qName), true, false);
        printAttributes(atts);
        printIndented(">\r\n", false, true);
        
        ++indent;
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        --indent;
        printIndented(String.format("</%s>", qName), true, false);
    }
    
    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String s = new String(chars, start, length).toUpperCase().trim();
        if (s.length() > 0) {
            printIndented(s, false, false);
        }
    }
    
    
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // ...
    }
    
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // ...
    }
    
    @Override
    public void ignorableWhitespace(char[] chars, int start, int length) throws SAXException {
        // ...
    }
    
    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        // ...
    }
    
    @Override
    public void skippedEntity(String name) throws SAXException {
        // ...
    }
    
    private void printIndented(String what, boolean isEndOfElement, boolean isElement) {
        try {
        	if(isEndOfElement) {
        		outputStreamWriter.write("\r\n");
        	}
            if (indent > 0 && !isElement) {
                outputStreamWriter.write(String.format("%1$" + (indent * TAB_SIZE) + "s", ""));
            }
            outputStreamWriter.write(what);
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void printAttributes(Attributes atts) {
        if (atts.getLength() > 0) {
            ++indent;
            for (int i = 0; i < atts.getLength(); ++i) {
                String name = atts.getQName(i);
                printIndented(String.format(" %s = \"%s\"", name, atts.getValue(i), name), false, true);
            }
            --indent;
        }
    }
}