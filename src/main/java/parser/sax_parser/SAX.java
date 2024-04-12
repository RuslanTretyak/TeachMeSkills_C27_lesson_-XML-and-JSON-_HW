package parser.sax_parser;

import org.xml.sax.SAXException;
import util.ReportFileWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX {
    public static void parseFile(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(new File(fileName), handler);
            System.out.println(handler);
            ReportFileWriter.writeToFile("SAX", handler.getFirstName(), handler.getLastName(),
                    handler.getTitle(), handler.getLines());
        } catch (ParserConfigurationException e) {
            System.out.println("Parser Configuration Exception");
        } catch (SAXException e) {
            System.out.println("SAX Exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
