package edu.xml.excersises.dom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import edu.xml.excersises.XMLPath;

//import edu.xml.excersises.XMLPath;

public class DOM2 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		InputSource source = new InputSource(XMLPath.RSSXML.toString());
		//InputSource source = new InputSource(new StringReader("<rss><channel></channel></rss>"));
		Document document = builder.parse(source);
		processTree(document);
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer writer = tf.newTransformer();
        writer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        writer.transform(
            new DOMSource(document),
            new StreamResult(new File("resources/rss_new.xml"))
        );
	}
	
    private static void processTree(Document doc) {
    	 NodeList itemList = doc.getElementsByTagName("item");
    	 
    	 for (int i = itemList.getLength() - 1; i >= 10; --i) {
    		 Element item = (Element)itemList.item(i);
    		 item.getParentNode().removeChild(item);           
         }
         
    	 NodeList linkList = doc.getElementsByTagName("link");
         for (int i = linkList.getLength() - 1; i >= 0; --i) {
             Element link = (Element)linkList.item(i);
             Element item = (Element)link.getParentNode();
             
             if("item".equals(item.getNodeName())) {
            	 System.out.println(link.getTextContent().trim());
            	 item.setAttribute("link", link.getTextContent().trim());
            	 item.removeChild(link);
             }
         }
         
         Element sponsor = doc.createElement("sponsor");
         sponsor.setTextContent("IBM");
         doc.getElementsByTagName("channel").item(0).appendChild(sponsor);
    }

}
