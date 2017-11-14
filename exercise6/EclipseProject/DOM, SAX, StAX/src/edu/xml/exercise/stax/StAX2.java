package edu.xml.exercise.stax;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StAX2 {
	public static void main(String[] args) {

	      try {
	         StringWriter stringWriter = new StringWriter();

	         XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
	         XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);
	   
	         xMLStreamWriter.writeStartDocument();
	         xMLStreamWriter.writeStartElement("bookstore");
	   
	         xMLStreamWriter.writeStartElement("book");//book 1	
	         xMLStreamWriter.writeAttribute("category", "COOKING");
	         
	         createSimpleElement(xMLStreamWriter, "title", "lang", "en", "Everyday Italian");
	         createSimpleElement(xMLStreamWriter, "author", null, null, "Giada De Laurentiis");
	         createSimpleElement(xMLStreamWriter, "year", null, null, "2005");
	         createSimpleElement(xMLStreamWriter, "price", null, null, "30.00");

	         xMLStreamWriter.writeEndElement();//book 1
	         xMLStreamWriter.writeStartElement("book");	//book 2
	         xMLStreamWriter.writeAttribute("category", "CHILDREN");
	         
	         createSimpleElement(xMLStreamWriter, "title", "lang", "en", "Harry Potter");
	         createSimpleElement(xMLStreamWriter, "author", null, null, "J K. Rowling");
	         createSimpleElement(xMLStreamWriter, "year", null, null, "2005");
	         createSimpleElement(xMLStreamWriter, "price", null, null, "29.99");

	         xMLStreamWriter.writeEndElement();//book 2
	         xMLStreamWriter.writeStartElement("book");	//book 3
	         xMLStreamWriter.writeAttribute("category", "WEB");
	         
	         createSimpleElement(xMLStreamWriter, "title", "lang", "en", "Learning XML");
	         createSimpleElement(xMLStreamWriter, "author", null, null, "Erik T. Ray");
	         createSimpleElement(xMLStreamWriter, "year", null, null, "2003");
	         createSimpleElement(xMLStreamWriter, "price", null, null, "39.95");

	         xMLStreamWriter.writeEndElement();//book 3
	         xMLStreamWriter.writeEndDocument();

	         xMLStreamWriter.flush();
	         xMLStreamWriter.close();

	         String xmlString = stringWriter.getBuffer().toString();

	         stringWriter.close();

	         System.out.println(xmlString);

	      } catch (XMLStreamException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	
	public static void createSimpleElement(XMLStreamWriter xMLStreamWriter, String elementName, String attributeName, String attributeValue, String strValue) {
		 try {
			 if(xMLStreamWriter != null && elementName != null) {
				 xMLStreamWriter.writeStartElement(elementName);
				 if(attributeName != null) {
					 xMLStreamWriter.writeAttribute(attributeName, attributeValue);
				 }
				 if(strValue != null) {
					 xMLStreamWriter.writeCharacters(strValue);
				 }
				 xMLStreamWriter.writeEndElement();
			 }
				 

		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}