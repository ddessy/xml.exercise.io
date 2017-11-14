package edu.xml.excersises.dom;

//import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import edu.xml.excersises.XMLPath;

public class DOM1 {
	private static boolean skipNL;
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		InputSource source = new InputSource(XMLPath.RSSXML.toString());
		//InputSource source = new InputSource(new StringReader("<rss><channel></channel></rss>"));
		Document document = builder.parse(source);
		System.out.println(printXML(document.getDocumentElement()));
	}
	
	private static String printXML(Node rootNode) {
	    String tab = "";
	    skipNL = false;
	    return(printXML(rootNode, tab));
	}
	private static String printXML(Node rootNode, String tab) {
	    String print = "";
	    if(rootNode.getNodeType()==Node.ELEMENT_NODE) {
	        print += "\n"+tab+"<"+rootNode.getNodeName();
	        NamedNodeMap attributes = rootNode.getAttributes();
        	for (int j = 0; j < attributes.getLength(); j++) {
        		Attr attr = (Attr) attributes.item(j);
        		if(attr !=  null) { 
        			print += " " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"";
        		}
        	}
        	print += ">";
	    }
	    NodeList nl = rootNode.getChildNodes();
	    if(nl.getLength()>0) {
	        for (int i = 0; i < nl.getLength(); i++) {
	            print += printXML(nl.item(i), tab + "  ");    // \t
	        }
	    } else {
	        if(rootNode.getNodeValue()!=null) {
	            print = rootNode.getNodeValue();
	        }
	        skipNL = true;
	    }
	    if(rootNode.getNodeType()==Node.ELEMENT_NODE) {
	        if(!skipNL) {
	            print += "\n"+tab;
	        }
	        skipNL = false;
	        print += "</"+rootNode.getNodeName()+">";
	    }
	    return(print);
	}
}
