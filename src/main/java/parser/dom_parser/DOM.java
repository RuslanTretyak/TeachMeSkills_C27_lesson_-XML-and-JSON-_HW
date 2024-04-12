package parser.dom_parser;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.ReportFileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {
    public static void parseFile(String fileName) {
        String firstName;
        String lastName;
        String title;
        StringBuilder lines = new StringBuilder();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(fileName));
            firstName = document.getElementsByTagName("firstName").item(0).getTextContent();
            lastName = document.getElementsByTagName("lastName").item(0).getTextContent();
            title = document.getElementsByTagName("title").item(0).getTextContent();
            NodeList nodeList = document.getElementsByTagName("line");
            for (int i = 0; i < nodeList.getLength(); i++) {
                lines.append(nodeList.item(i).getTextContent()).append("\n");
            }
            ReportFileWriter.writeToFile("DOM", firstName, lastName, title, lines);

        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException");
        } catch (SAXException e) {
            System.out.println("SAXException");
        } catch (IOException e) {
            System.out.println("IOException");
        }



    }

}
