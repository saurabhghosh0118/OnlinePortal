package com.cybage.Demo;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainDemo {
	
	
	    public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {
	        TransformerFactory factory = TransformerFactory.newInstance();
	        Source xslt = new StreamSource(new File("C:/Users/saurabhgh/Desktop/XSLT With Java/AddXmlHeader.xsl"));
	        Transformer transformer = factory.newTransformer(xslt);

	        Source text = new StreamSource(new File("C:/Users/saurabhgh/Desktop/XSLT With Java/books.xml"));
	        transformer.transform(text, new StreamResult(new File("C:/Users/saurabhgh/Desktop/XSLT With Java/AddXmlHeaderOutput.xml")));
	    
	}

}
