package xmlr;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TextDOM {

	public static Document loadDocument(String fileName) {
		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			return db.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String argv[]) {
		Document document = loadDocument("provadom.xml");
		Element root = document.getDocumentElement();
		root.normalize();
		System.out.println("Root " + root.getNodeName());
		System.out.println("Informazioni sugli studenti");
		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node el = nodes.item(i);
			String elName = el.getNodeName();
			Node tx = el.getFirstChild();
			String elText = tx.getNodeValue();
			System.out.println(elName + "=" + elText);
		}
	}
}
