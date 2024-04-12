package parser.sax_parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private String currentElement;
    private String firstName;
    private String lastName = "";
    private String title;
    private StringBuilder lines = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.currentElement != null){
            switch (this.currentElement) {
                case "lastName":
                    this.lastName = new String(ch, start,length).replace("\n", "");
                    break;
                case "firstName":
                    this.firstName = new String(ch, start,length);
                    break;
                case "title":
                    this.title = new String(ch, start,length);
                    break;
                case "line":
                    this.lines.append(new String(ch, start,length)).append("\n");
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.currentElement = null;
    }

    @Override
    public String toString() {
        return "XMLHandler{" +
                "currentElement='" + currentElement + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", lines=" + lines +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public StringBuilder getLines() {
        return lines;
    }
}
