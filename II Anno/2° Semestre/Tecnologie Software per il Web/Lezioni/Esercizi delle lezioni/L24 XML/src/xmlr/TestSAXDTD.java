package xmlr;


import javax.xml.parsers.*;

import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAXDTD extends DefaultHandler {

	// Flag per ricordare dove siamo:
	private boolean InFirst = false;
	private boolean InLast = false;
	// Attributi per i valori da visualizzare
	private String FirstName, LastName, IdNum;

	public void startElement(String namespaceURI, String localName, String rawName, Attributes atts) {
		if (localName.equals("first"))
			InFirst = true;
		if (localName.equals("last"))
			InLast = true;
		if (localName.equals("person"))
			IdNum = atts.getValue("idnum");
	}

	public void characters(char ch[], int start, int length) {
		if (InFirst)
			FirstName = new String(ch, start, length);
		if (InLast)
			LastName = new String(ch, start, length);
	}

	public void endElement(String namespaceURI, String localName, String qName) {
		if (localName.equals("person"))
			System.out.println(FirstName + " " + LastName + " (" + IdNum + ")");
		if (localName.equals("first")) {
			InFirst = false;
		}
		if (localName.equals("last"))
			InLast = false;
	}

	public void startDocument() {
		System.out.println("Start parsing.");
	}
	
	public void endDocument() {
		System.out.println("End parsing.");
	}
	
	
	public static void main(String args[]) throws Exception {

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setValidating(true);
		spf.setNamespaceAware(true);
		
		try {
			SAXParser saxParser = spf.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setErrorHandler(new SimpleErrorHandler());
			
			ContentHandler handler = new TestSAXDTD();
			xmlReader.setContentHandler(handler);
			xmlReader.parse("provasaxdtd.xml");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

}
