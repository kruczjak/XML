package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by kruczjak on 02.06.2014.
 */
public class XMLSAXParser extends DefaultHandler {
    public int nodes = 0;

    public static int run(String input_file) {
        try{
            SAXParserFactory spfac = SAXParserFactory.newInstance();
            SAXParser sp = spfac.newSAXParser();
            XMLSAXParser handler = new XMLSAXParser();
            sp.parse(input_file, handler);
            return handler.nodes;
        }
        catch (ParserConfigurationException e) {
            System.out.println("Błąd konfiguracji SAX.");
        }
        catch (SAXException e) {
            System.out.println("Błąd SAX.");
        }
        catch (IOException e) {
            System.out.println("Błąd We/Wy.");
        }
        return 0;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.nodes++;
    }
}
